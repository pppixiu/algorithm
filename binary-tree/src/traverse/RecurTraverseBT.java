package traverse;

/**
 * @Classname recur
 * @Description non
 * @Date 2021/7/4 5:20 下午
 * @Created by apple
 */
public class RecurTraverseBT {
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

        System.out.println(cur.value);
        pre(cur.left);
        pre(cur.right);
    }

    public static void in(Node cur) {
        if (cur == null) {
            return;
        }
        in(cur.left);
        System.out.println(cur.value);
        in(cur.right);
    }

    public static void pos(Node cur) {
        if (cur == null) {
            return;
        }
        pos(cur.left);
        pos(cur.right);
        System.out.println(cur.value);
    }

}
