package com.sparta.booLeans.simulator;

public class Node<E> {

    private E element;
    private Node tail;

    public Node(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getTail() {
        return tail;
    }
}
