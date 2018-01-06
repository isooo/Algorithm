package com.acorn.linkedlist;

public class Main {

    public static void main( String[] args ){

        LinkeList list = new LinkeList();

        list.addFirst(new Node(3));
        list.addFirst(new Node(1));
        list.addFirst(new Node(2));

        list.addLast(new Node(5));
        list.addLast(new Node(4));
        list.addLast(new Node(6));

        list.insert(3, new Node(9));
        list.insert(1, new Node(8));
®
        list.size();

        list.get(2);

        list.removeFirst();
        list.removeLast();
        list.remove(2);

        list.size();

        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
    }
}
