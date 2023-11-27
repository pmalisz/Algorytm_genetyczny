package gp.project.nodes;

import gp.project.Serialize;
import gp.project.Tree;
import gp.project.enums.NodeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Node {
    public Tree tree;
    public NodeType type;
    public String name;
    public int value;
    public int depth;
    public int number;
    public List<Node> children;

    public Node() {
        children = new ArrayList<>();
    }

    public Node(Tree tree, NodeType type) {
        this();
        this.tree = tree;
        this.type = type;
    }

    public Node(Tree tree, NodeType type, int depth, int number) {
        this();
        this.tree = tree;
        this.type = type;
        this.depth = depth;
        this.number = number;
    }

    public Node(Tree tree, Node another) {
        this(tree, another.type, another.depth, another.number);

        for(Node child : another.children) {
            switch(child.type) {
                case IN:
                case OUT:
                case IF:
                case WHILE:
                case ASSIGN:
                    this.children.add(new StatementNode(tree, child));
                    break;
                case ID:
                case INT:
                    this.children.add(new FactorNode(tree, child));
                    break;
                default:
                    this.children.add(new ExpressionNode(tree, child));
            }
        }
    }

    public List<Node> findByClass(Class<?> type) {
        List<Node> nodes = new ArrayList<>();
        for(Node child : children) {
            if (type.isInstance(child)) {
                nodes.add(child);
            }

            nodes.addAll(child.findByClass(type));
        }

        return nodes;
    }

    public void print() {
        System.out.println(getStringToPrint() + this);

        for(Node child : children) {
            child.print();
        }
    }

    public String toString() {
        return type.toString();
    }

    protected String getStringToPrint() {
        return "-".repeat(Math.max(0, depth)) + "\\";
    }

    protected StatementNode addStatementChild() {
        NodeType newType = depth < Tree.MAX_DEPTH - 2 ? NodeType.getRandomStatement() : NodeType.getRandomOneLineStatement();
        StatementNode stNode = new StatementNode(tree, newType, depth + 1, tree.nodesCount++);
        children.add(stNode);
        return stNode;
    }

    protected ExpressionNode addExpressionChild() {
        NodeType newType = NodeType.getRandomExpression();
        ExpressionNode expNode = new ExpressionNode(tree, newType, depth + 1, tree.nodesCount++);
        children.add(expNode);
        return expNode;
    }

    protected void addFactorChild() {
        NodeType intOrId = NodeType.getRandomFactor();
        if (intOrId == NodeType.ID) {
            addIdChild();
        } else {
            addIntChild();
        }
    }

    protected void addIdChild() {
        this.children.add(new FactorNode(tree, tree.getRandomVariable(), depth + 1, tree.nodesCount++));
    }

    protected void addIntChild() {
        int intIdx = Tree.rd.nextInt(Tree.numbers.size());
        this.children.add(new FactorNode(tree, Tree.numbers.get(intIdx), depth + 1, tree.nodesCount++));
    }

    public void mutate(){

    }

    public Optional<Node> crossover(Node node, int nodeNumber){
        return Optional.empty();
    }

    protected Optional<Node> crossoverFurther(Node node, int nodeNumber){
        for(int i=0; i<children.size(); i++){
            Optional<Node> toReplace = children.get(i).crossover(node, nodeNumber);
            if (toReplace.isPresent()) {
                children.set(i, toReplace.get());
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

    protected Optional<Node> crossoverBody(Node node) {
        List<Node> properNodes = node.findByClass(this.getClass());
        if (properNodes.isEmpty()) {
            return Optional.empty();
        } else {
            int rand = Tree.rd.nextInt(properNodes.size());
            return Optional.of(properNodes.get(rand));
        }
    }

    public void serialize(Serialize serialization) {
    }

    public int recountNodes(int childrenCount)
    {
        number = childrenCount;
        for(Node node : children)
        {
            node.recountNodes(++childrenCount);
        }
        return childrenCount;
    }

    public void clearChildren()
    {
        children.clear();
        tree.recountNodes();
    }

    public Node getNodeByNumber(int number)
    {
        if (this.number == number)
        {
            return this;
        }
        else
        {
            Node node = null;
            for (Node child : children)
            {
                node = child.getNodeByNumber(number);
                if (node != null)
                    break;
            }
            return node;
        }
    }

    public void addChild(Node child){
        child.depth = depth + 1;
        child.number = tree.nodesCount++;
        children.add(child);
    }

    public Serialize serializeToTree(Serialize serialization){
        return null;
    }

}
