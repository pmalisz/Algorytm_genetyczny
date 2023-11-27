package gp.project.enums;

import gp.project.Tree;
import java.util.Arrays;
import java.util.Optional;

public enum NodeType {
    PROGRAM("program", 0),
    IN("in", 1),
    OUT("out", 2),
    ASSIGN("=", 3),
    IF("if", 4),
    WHILE("while", 5),
    PLUS("+", 6),
    MINUS("-", 7),
    TIMES("*", 8),
    DIV("/", 9),
    GREATER(">", 10),
    LESS("<", 11),
    AND("&&", 12),
    OR("||", 13),
    NOT("!", 14),
    EQUAL("==", 15),
    NOT_EQUAL("!=", 16),
    ID("id", 17),
    INT("int", 18);

    String name;
    int value;

    NodeType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static NodeType getRandomStatement() {
        int exp = Tree.rd.nextInt(WHILE.value - IN.value + 1) + IN.value;
        Optional<NodeType> nodeType = valueOf(exp);
        return nodeType.orElse(IN);
    }

    public static NodeType getRandomOneLineStatement() {
        int exp = Tree.rd.nextInt(ASSIGN.value - IN.value + 1) + IN.value;
        Optional<NodeType> nodeType = valueOf(exp);
        return nodeType.orElse(IN);
    }

    public static NodeType getRandomExpression() {
        int exp = Tree.rd.nextInt(NOT_EQUAL.value - PLUS.value + 1) + PLUS.value;
        Optional<NodeType> nodeType = valueOf(exp);
        return nodeType.orElse(PLUS);
    }

    public static NodeType getRandomFactor() {
        int exp = Tree.rd.nextInt(INT.value - ID.value + 1) + ID.value;
        Optional<NodeType> nodeType = valueOf(exp);
        return nodeType.orElse(ID);
    }

    private static Optional<NodeType> valueOf(int value) {
        return Arrays.stream(values())
                .filter(NodeType -> NodeType.value == value)
                .findFirst();
    }
    @Override
    public String toString() {
        return this.name;
    }
}
