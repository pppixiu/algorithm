package traverse;

import com.sun.xml.internal.bind.util.Which;

import java.util.Stack;

/**
 * @Classname NormalTraverseBt
 * @Description non
 * @Date 2021/7/4 7:22 下午
 * @Created by apple
 */
public class NormalTraverseBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos(head);
        System.out.println("========");
    }

    public static void pre(Node cur) {
        if (cur == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.print(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }
        System.out.println();
    }

    public static void in(Node cur) {
        if (cur == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.value);
                cur = cur.right;
            }
        }
        System.out.println();
    }


    public static void pos(Node cur) {
        if (cur == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Stack<Node> help = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            help.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        while (!help.isEmpty()) {
            System.out.print(help.pop().value);
        }
        System.out.println();
    }

    public static void pos1(Node cur) {
        if (cur == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(cur);
        Node c = null;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && cur != c.left && cur != c.right) {
                stack.push(c.left);
            } else if (c.right != null && cur != c.right) {
                stack.push(c.right);
            } else {
                System.out.print(stack.pop().value + " ");
                cur = c;
            }
        }

        System.out.println();
    }


}
