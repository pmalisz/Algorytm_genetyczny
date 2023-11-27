package gp.project;

import gp.project.gen.GrammarBaseVisitor;
import gp.project.gen.GrammarParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GrammarCustomVisitor extends GrammarBaseVisitor<Integer> {
    private final int MAX_OPERATIONS = 100;
    private int operations = 0;
    private final HashMap<String, Integer> variables;
    private final List<Integer> inputs;
    private final List<Integer> outputs;

    public GrammarCustomVisitor(List<Integer> inputs){
        this.variables = new HashMap<>();
        this.outputs = new ArrayList<>();
        this.inputs = inputs;
    }

    public List<Integer> getOutputs() {
        return outputs;
    }

    @Override public Integer visitSimple_statement(GrammarParser.Simple_statementContext ctx) {
        if(operations++ >= MAX_OPERATIONS)
            return 0;

        return visitChildren(ctx);
    }

    @Override public Integer visitVariable_declaration(GrammarParser.Variable_declarationContext ctx) {
        String variable = ctx.ID().getText();
        variables.put(variable, visit(ctx.expression()));

        return 0;
    }

    @Override public Integer visitIo_functions(GrammarParser.Io_functionsContext ctx) {
        if(ctx.IN() != null)
            handleIn(ctx);

        if(ctx.OUT() != null)
            handleOut(ctx);

        return 0;
    }

    private void handleIn(GrammarParser.Io_functionsContext ctx){
        String variable = ctx.ID().getText();
        int value = inputs.size() > 0 ? inputs.remove(0) : 0;
        variables.put(variable, value);
    }

    private void handleOut(GrammarParser.Io_functionsContext ctx){
        outputs.add(visit(ctx.factor()));
    }

    @Override public Integer visitConditional_statement(GrammarParser.Conditional_statementContext ctx) {
        if(visit(ctx.expression()) != 0)
            return visit(ctx.statement(0));
        else if(ctx.statement(1) != null)
            return visit(ctx.statement(1));
        else if(ctx.conditional_statement() != null)
            return visit(ctx.conditional_statement());

        return 0;
    }

    @Override public Integer visitIteration_statement(GrammarParser.Iteration_statementContext ctx) {
        while(visit(ctx.expression()) != 0 && operations < MAX_OPERATIONS)
            visit(ctx.statement());

        return 0;
    }

    @Override public Integer visitExpression(GrammarParser.ExpressionContext ctx) {
        int divider;

        if(operations++ >= MAX_OPERATIONS){
            if(ctx.factor() != null)
                return ctx.MINUS(0) != null ? -1 * visit(ctx.factor()) : visit(ctx.factor());
            else
                return visit(ctx.expression(0));
        }

        if(ctx.OR() != null)
            return (visit(ctx.expression(0)) != 0) || (visit(ctx.expression(1)) != 0) ? 1 : 0;
        else if (ctx.AND() != null)
            return (visit(ctx.expression(0)) != 0) && (visit(ctx.expression(1)) != 0) ? 1 : 0;
        else if (ctx.GREATER_THEN() != null)
            return visit(ctx.expression(0)) > visit(ctx.expression(1)) ? 1 : 0;
        else if (ctx.LESS_THEN() != null)
            return visit(ctx.expression(0)) < visit(ctx.expression(1)) ? 1 : 0;
        else if (ctx.EQUAL() != null)
            return visit(ctx.expression(0)).equals(visit(ctx.expression(1))) ? 1 : 0;
        else if (ctx.NOT_EQUAL() != null)
            return !visit(ctx.expression(0)).equals(visit(ctx.expression(1))) ? 1 : 0;
        else if (ctx.LEFT_PAREN() != null)
            return visit(ctx.expression(0));
        else if (ctx.NOT() != null)
            return visit(ctx.expression(0)) == 0 ? 1 : 0;
        else if(ctx.factor() != null)
            return ctx.MINUS(0) != null ? -1 * visit(ctx.factor()) : visit(ctx.factor());
        else if(ctx.TIMES() != null)
            return visit(ctx.expression(0)) * visit(ctx.expression(1));
        else if (ctx.DIV() != null) {
            divider = visit(ctx.expression(1));
            if (divider < 1.0e-10)
                return visit(ctx.expression(0));
            else
                return visit(ctx.expression(0)) / divider;
        }
        else if (ctx.PLUS(0) != null)
            return visit(ctx.expression(0)) + visit(ctx.expression(1));
        else if (ctx.MINUS(0) != null)
            return visit(ctx.expression(0)) - visit(ctx.expression(1));
        else
            return visit(ctx.expression(0));
    }

    @Override public Integer visitFactor(GrammarParser.FactorContext ctx) {
        if(ctx.ID() != null){
            String variable = ctx.getText();
            if(!variables.containsKey(variable))
                variables.put(variable, 0);

            return variables.get(variable);
        }else{
            return Integer.parseInt(ctx.getText());
        }
    }
}
