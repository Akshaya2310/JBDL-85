package org.gfg.collections;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(23);
        stack.push(44);
        stack.push(55);
        stack.push(76);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
/*
Thread Execution.
Browser=> Go Back
Syntax Stack
Evaluate Expression.
Valid Parenthisis.
 */