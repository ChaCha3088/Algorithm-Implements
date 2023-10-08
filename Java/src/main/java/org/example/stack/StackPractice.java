package org.example.stack;

import java.io.*;
import java.util.Stack;

public class StackPractice {
    public StackPractice() throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<String> backwardStack = new Stack();
        Stack<String> forwardStack = new Stack();

        String currentPage = "";
        while (true) {
            String[] split = br.readLine().split(" ");

            if (split[0].equals("Q")) {
                break;
            }
            else if (split[0].equals("V")) {
                if (forwardStack.size() > 0) {
                    forwardStack.clear();
                }

                if (!currentPage.equals("")) {
                    backwardStack.push(currentPage);
                }
                currentPage = split[1];
                System.out.println(split[1]);
            }
            else if (split[0].equals("B")) {
                if (backwardStack.size() > 0) {
                    forwardStack.push(currentPage);
                    String pop = backwardStack.pop();
                    currentPage = pop;
                    System.out.println(pop);
                }
                else {
                    System.out.println("뒤로 갈 페이지가 없습니다.");
                }
            }
            else if (split[0].equals("F")) {
                if (forwardStack.size() > 0) {
                    String pop = forwardStack.pop();
                    backwardStack.push(currentPage);
                    currentPage = pop;
                    System.out.println(pop);
                }
                else {
                    System.out.println("앞으로 갈 페이지가 없습니다.");
                }
            }
        }

        System.out.println(sb);
    }
}
