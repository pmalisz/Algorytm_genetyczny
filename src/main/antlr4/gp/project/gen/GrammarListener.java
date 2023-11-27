// Generated from java-escape by ANTLR 4.11.1
package gp.project.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statement()}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statement()}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#simple_statement}.
	 * @param ctx the parse tree
	 */
	void enterSimple_statement(GrammarParser.Simple_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#simple_statement}.
	 * @param ctx the parse tree
	 */
	void exitSimple_statement(GrammarParser.Simple_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(GrammarParser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(GrammarParser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#io_functions}.
	 * @param ctx the parse tree
	 */
	void enterIo_functions(GrammarParser.Io_functionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#io_functions}.
	 * @param ctx the parse tree
	 */
	void exitIo_functions(GrammarParser.Io_functionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#conditional_statement}.
	 * @param ctx the parse tree
	 */
	void enterConditional_statement(GrammarParser.Conditional_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#conditional_statement}.
	 * @param ctx the parse tree
	 */
	void exitConditional_statement(GrammarParser.Conditional_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void enterIteration_statement(GrammarParser.Iteration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void exitIteration_statement(GrammarParser.Iteration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression()}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression()}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(GrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(GrammarParser.FactorContext ctx);
}