package org.example.stack;

import java.util.EmptyStackException;

public class LinkedListStack<E> implements IStack<E> {
    private Node<E> top;

    @Override
    public void push(E e) {
        top = new Node<>(e, top);
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Node<E> popNode = top;
        top = popNode.getLink();

        return popNode.getData();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.getData();
    }

    @Override
    public int size() {
        int count = 0;

        for (Node<E> temp = top; temp != null; temp = temp.getLink()) {
            count += 1;
        }

        return count;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
