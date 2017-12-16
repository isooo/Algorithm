package com.acorn.linkedlist;

public class LinkeList {
    private Node head;
    private int size = 0;

    public LinkeList(){

        this.head = new Node();

    }

    public void addFirst(Node input) {

        if(isEmpty()){

            this.head.setNext(input);

        } else{

            Node tmp = this.head.getNext();
            input.setNext(tmp);
            this.head.setNext(input);

        }
        this.size++;

        System.out.println("Success::::Add first data - " + input.getValue());
        printList();
    }

    public void addLast(Node input){

        Node tmp = this.head;

        while(tmp.getNext() != null){

            tmp = tmp.getNext();
        }

        tmp.setNext(input);
        this.size++;

        System.out.println("Success::::Add last data - " + input.getValue());
        printList();
    }

    public void insert(int index, Node input){

        if(size < index || index < 0){

            System.out.println("Error::::Cannot process insert Operation - Index not available");
            return ;

        } else if(this.size == 0){

            System.out.println("Error::::Cannot process insert Operation - list is empty");
            return ;

        } else {

            Node prev = this.head;
            Node tmp = prev.getNext();
            int cur = 0;

            while(tmp.getNext() != null){

                prev = prev.getNext();
                tmp = tmp.getNext();
                cur++;
                if(index == cur) break;

            }

            input.setNext(prev.getNext());
            prev.setNext(input);

            this.size++;

            System.out.println("Success::::Insert data - " + input.getValue() + ", Index - " + index);
            printList();
        }
    }

    public Node removeFirst(){

        Node tmp = null;

        if(isEmpty()) {

            System.out.println("Error::::List is empty");

        } else {

            tmp = this.head.getNext();
            this.head.setNext(tmp.getNext());
            this.size--;

            System.out.println("Success::::Remove first data - " + tmp.getValue());
            printList();
        }

        return tmp;
    }

    public Node removeLast(){

        Node tmp = null;

        if(isEmpty()){

            System.out.println("Error::::List is empty");

        } else{

            Node prev = this.head;
            tmp = prev.getNext();

            while(tmp.getNext() != null){
                prev = prev.getNext();
                tmp = tmp.getNext();
            }

            prev.setNext(null);
            this.size--;

            System.out.println("Success::::Remove last data - " + tmp.getValue());
            printList();
        }

        return tmp;
    }

    public Node remove(int index){

        Node tmp = null;

        if(size < index || index < 0){

            System.out.println("Error::::Cannot process insert Operation - Index not available");

        } else if(isEmpty()){

            System.out.println("Error::::Cannot process insert Operation - list is empty");

        } else {

            Node prev = this.head;
            tmp = prev.getNext();
            int cur = 0;

            while(tmp.getNext() != null){

                prev = prev.getNext();
                tmp = tmp.getNext();
                cur++;
                if(index == cur) break;

            }

            prev.setNext(tmp.getNext());

            this.size--;

            System.out.println("Success::::Remove index " + index + " data " + tmp.getValue());
            printList();
        }

        return tmp;
    }

    public Node get(int index){

        Node tmp = null;

        if(size < index || index < 0){

            System.out.println("Error::::Cannot process insert Operation - Index not available");

        } else if(isEmpty()){

            System.out.println("Error::::Cannot process insert Operation - list is empty");

        } else {

            tmp = this.head.getNext();
            int cur = 0;

            while(tmp.getNext() != null){

                tmp = tmp.getNext();
                cur++;
                if(index == cur) break;

                System.out.println("Success::::Get index " + index + " data " + tmp.getValue());
                printList();
            }
        }

        return tmp;
    }

    public int size(){

        System.out.println("Success::::List size - " + this.size);

        return this.size;

    }


    public boolean isEmpty(){
        if(this.size == 0)
            return true;
        else
            return false;
    }

    public void printList(){

        if(isEmpty()){
            System.out.println("List is Empty");
        }else {

            Node tmp = this.head;

            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
                System.out.print(tmp.getValue() + " ");
            }
            System.out.println();

        }
    }
}
