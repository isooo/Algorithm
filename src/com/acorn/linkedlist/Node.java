package com.acorn.linkedlist;

public class Node {
    private String value;
    private Node next;

    public void setValue(String value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
