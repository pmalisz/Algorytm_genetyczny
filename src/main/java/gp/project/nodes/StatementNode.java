package gp.project.nodes;

import gp.project.Serialize;
import gp.project.Tree;
import gp.project.enums.NodeType;

import java.util.Optional;

public class StatementNode extends Node {
    public StatementNode(Tree tree, NodeType type, int depth, int number) {
        super(tree, type, depth, number);
    }

    public  StatementNode(Tree tree, NodeType type){super(tree, type);}

    public StatementNode(Tree tree, Node another) {
        super(tree, another);
    }

    public void grow() {
        switch(this.type) {
            case IN:
                this.addIdChild();
                break;
            case OUT:
                this.addFactorChild();
                break;
            case IF:
                this.growIfAndWhileBase();
                int isElse = Tree.rd.nextInt(2);
                if (isElse == 1) {
                    StatementNode falseNode = addStatementChild();
                    falseNode.grow();
                }
                break;
            case WHILE:
                this.growIfAndWhileBase();
                break;
            case ASSIGN:
                this.addIdChild();
                int rand = Tree.rd.nextInt(2);
                if(rand == 0 || depth >= Tree.MAX_DEPTH - 1)
                    addFactorChild();
                else {
                    ExpressionNode expNode = addExpressionChild();
                    expNode.grow();
                }
        }

    }

    private void growIfAndWhileBase() {
        ExpressionNode expNode = addExpressionChild();
        expNode.grow();
        StatementNode trueNode = addStatementChild();
        trueNode.grow();
    }

    @Override
    public void mutate() {
        clearChildren();
        type = NodeType.getRandomStatement();
        grow();
    }

    @Override
    public Optional<Node> crossover(Node node, int nodeNumber) {
        if (number != nodeNumber) {
            return crossoverFurther(node, nodeNumber);
        } else {
            return crossoverBody(node);
        }
    }

    public void serialize(Serialize serialization){
        switch(this.type) {
            case IN:
            case ASSIGN:
            case OUT:
                if (children.size() == 1) {
                    serialization.addToBuffer("(");
                    serialization.addToBuffer(this.type.toString());
                    children.get(0).serialize(serialization);
                    serialization.addToBuffer(")");

                }
                else{
                    serialization.addToBuffer("(");
                    children.get(0).serialize(serialization);
                    serialization.addToBuffer(this.type.toString());
                    children.get(1).serialize(serialization);
                    serialization.addToBuffer(")");

                }
                break;
            case IF:
                serialization.addToBuffer("(");
                serialization.addToBuffer("if");
                for (var x : children) {
                    x.serialize(serialization);
                }
                serialization.addToBuffer(")");
                break;
            case WHILE:
                serialization.addToBuffer("(");
                serialization.addToBuffer("while");
                for (var x : children) {
                    x.serialize(serialization);
                }
                serialization.addToBuffer(")");
                break;
            }
        }


    public Serialize serializeToTree(Serialize serialization){
        switch(this.type) {

            case ASSIGN:
                if (children.size() == 1) {
                    serialization.addToBuffers(this.type.toString());
                    children.get(0).serializeToTree(serialization);
                }
                else{
                    children.get(0).serializeToTree(serialization);
                    serialization.addToBuffers(this.type.toString());
                    children.get(1).serializeToTree(serialization);
                }
                serialization.addToBuffers("; ");
                break;
            case OUT:
            case IN:
                if (children.size() == 1) {
                    serialization.addToBuffers(this.type.toString());
                    serialization.addToBuffers("(");
                    children.get(0).serializeToTree(serialization);
                }
                else{
                    children.get(0).serializeToTree(serialization);
                    serialization.addToBuffers(this.type.toString());
                    serialization.addToBuffers("(");
                    children.get(1).serializeToTree(serialization);
                }
                serialization.addToBuffers("); ");
                break;
            case IF:
                serialization.addToBuffers("if(");
                children.get(0).serializeToTree(serialization);
                serialization.addToBuffers(")");
                serialization.addToBuffers("{ ");
                for (int i = 1; i < children.size(); i++) {
                    children.get(i).serializeToTree(serialization);
                }
                serialization.addToBuffers("}");
                break;
            case WHILE:
                serialization.addToBuffers("while(");
                children.get(0).serializeToTree(serialization);
                serialization.addToBuffers(")");
                serialization.addToBuffers("{ ");
                for (int i = 1; i < children.size(); i++) {
                    children.get(i).serializeToTree(serialization);
                }
                serialization.addToBuffers("}");
                break;
        }
        return null;
    }
}