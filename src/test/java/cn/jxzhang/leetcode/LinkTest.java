package cn.jxzhang.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * LinkTest
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class LinkTest {

    @Test
    public void test() {
        String str = "[()]{}{[()()]()}{";
        char[] chars = str.toCharArray();

        boolean parentheses = parentheses(chars);
        System.out.println(parentheses);

    }

    private boolean parentheses(char[] chars) {
        Stack<Character> characterStack = new Stack<>();

        String left = "[({";
        String right = "])}";

        for (char aChar : chars) {
            if (left.indexOf(aChar) != -1) {
                characterStack.push(aChar);
            }

            if (right.indexOf(aChar) != -1) {
                if (aChar == ')') {
                    if (characterStack.isEmpty()) return false;
                    if (characterStack.pop() != '(') return false;
                } else if (aChar == ']') {
                    if (characterStack.isEmpty()) return false;
                    if (characterStack.pop() != '[') return false;
                } else {
                    if (characterStack.isEmpty()) return false;
                    if (characterStack.pop() != '{') return false;
                }
            }
        }

        return characterStack.isEmpty();
    }

    private class Stack<T> {

        private Node<T> first;

        private int size = 0;

        public boolean isEmpty() {
            return first == null;
        }

        public void push(T t) {
            Node<T> oldFirst = first;
            first = new Node<>();
            first.t = t;
            first.next = oldFirst;
            size++;
        }

        public T pop() {
            Node<T> oldFirst = first;

            first = first.next;
            size--;
            return oldFirst.t;
        }

        public int size() {
            return size;
        }

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class Node<T> {
        private T t;

        private Node<T> next;
    }
}
