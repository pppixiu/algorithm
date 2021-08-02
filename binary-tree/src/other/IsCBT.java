package other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname IsCBT
 * @Description
 * @Date 2021/7/31 9:04 下午
 * @Created by sensu
 */
public class IsCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }

        boolean allLeaf = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Node l = cur.left;
            Node r = cur.right;

            if (
                    // 有一个是不双全的节点后，如果当前节点不是叶节点 返false
                    (allLeaf && (l != null || r != null))
                            || (l == null && r != null)) {
                return false;
            }

            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                allLeaf = true;
            }
        }
        return true;
    }
}
