package gp.project.nodes;

import gp.project.Serialize;
import gp.project.Tree;
import gp.project.enums.NodeType;

public class ProgramNode extends Node {

    public ProgramNode(Tree tree) {
        super(tree, NodeType.PROGRAM, 0, 0);
    }

    public ProgramNode(Tree tree, Node another) {
        super(tree, another);
    }

    public void grow() {
        int growFurther = Tree.rd.nextInt(2);
        StatementNode stNode = addStatementChild();
        stNode.grow();
        if (growFurther == 1)
            grow();
    }

    public void mutate() {
        int rand = Tree.rd.nextInt(tree.nodesCount);
        Node nodeToMutate = getNodeByNumber(rand);
        if(nodeToMutate.type == NodeType.PROGRAM){
            clearChildren();
            grow();
            return;
        }

        nodeToMutate.mutate();
    }

    public void crossover(Node node) {
        int rand;
        if (tree.nodesCount <= 1){
            rand = 0;
        }
        else {
            rand = Tree.rd.nextInt(tree.nodesCount - 1) + 1;
        }
        crossoverFurther(node, rand);
    }

    @Override
    public void serialize(Serialize serialization){
        serialization.addToBuffer("(");
        for (var x: children) {
            x.serialize(serialization);
        }
        serialization.addToBuffer(")");
        serialization.addToBuffer(System.lineSeparator());
    }

    @Override
    public Serialize serializeToTree(Serialize serialization){
        serialization.addToBuffers("program{ ");
        for (var x: children) {
            x.serializeToTree(serialization);
        }
        serialization.addToBuffers("}");
        serialization.addToBuffers(System.lineSeparator());
        return serialization;
    }
}
