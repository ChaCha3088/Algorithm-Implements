package org.example.stack;

import java.util.EmptyStackException;

public class MyLinkedListStack<E> implements IStack<E> {
    private Node<E> top;

    @Override
    public void push(E e) {
        top = new Node<>(e, top);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Node<E> popped = top;
        top = top.getLink();

        return popped.getData();
    }

    @Override
    public E peek() {
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