package gp.project.nodes;

import gp.project.Serialize;
import gp.project.Tree;
import gp.project.enums.NodeType;
import java.util.Optional;

public class FactorNode extends Node {
    public FactorNode(Tree tree, int value, int depth, int number) {
        super(tree, NodeType.INT, depth, number);
        this.value = value;
    }

    public FactorNode(Tree tree, NodeType type, int value){
        super(tree, type);
        this.value = value;
    }

    public FactorNode(Tree tree, NodeType type, String ID){
        super(tree, type);
        this.name = ID;
    }

    public FactorNode(Tree tree, String name, int depth, int number) {
        super(tree, NodeType.ID, depth, number);
        this.name = name;
    }

    public FactorNode(Tree tree, Node another) {
        super(tree, another);
        switch(another.type) {
            case ID:
                this.name = another.name;
                break;
            case INT:
                this.value = another.value;
        }

    }

    @Override
    public void mutate() {
        NodeType intOrId = NodeType.getRandomFactor();
        if (intOrId == NodeType.ID) {
            this.type = NodeType.ID;
            this.name = tree.getRandomVariable();
        } else {
            this.type = NodeType.INT;
            this.value = Tree.numbers.get(Tree.rd.nextInt(Tree.numbers.size()));
        }
    }

    @Override
    public Optional<Node> crossover(Node node, int nodeNumber) {
        if (number != nodeNumber) {
            return Optional.empty();
        } else {
            return crossoverBody(node);
        }
    }

    @Override
    public void print() {
        if (type == NodeType.ID)
            System.out.println(getStringToPrint() + name);
        else
            System.out.println(getStringToPrint() + value);
    }

    @Override
    public void serialize(Serialize serialization){
        serialization.addToBuffer("(");
        if(type == NodeType.ID)

            serialization.addToBuffer(name);
        else {
            serialization.addToBuffer(Integer.toString(value));
        }
        serialization.addToBuffer(")");
    }

    @Override
    public Serialize serializeToTree(Serialize serialization){
        if(type == NodeType.ID)
            serialization.addToBuffers(name);
        else {
            serialization.addToBuffers(Integer.toString(value));
        }
        return null;
    }
}
