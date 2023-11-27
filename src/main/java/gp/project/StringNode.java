package gp.project;

import java.util.ArrayList;
import java.util.List;

public class StringNode {
    String value;
    ArrayList<StringNode> list;

    StringNode(String node) {
        this.value = node;
        this.list = new ArrayList<>();
    }

}