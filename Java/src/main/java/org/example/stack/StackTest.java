package org.example.stack;

public class StackTest {
    private IStack stack;
    public void main(String[] args) {
        stack = new MyLinkedListStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.size());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
