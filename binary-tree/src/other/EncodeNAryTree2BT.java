package other;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree
 *
 * @Classname EncodeNAryTree2BT
 * @Description
 * @Date 2021/7/31 6:35 下午
 * @Created by sensu
 */
public class EncodeNAryTree2BT {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // 提交时不要提交这个类
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = en(root.children);
        return head;
    }

    public static TreeNode en(List<Node> children){
        TreeNode head = null;
        TreeNode cur = null;
        for (Node node  : children){
            TreeNode temp = new TreeNode(node.val);
            if (head == null){
                head = temp;
            }else {
                cur.right = temp;
            }

            cur = temp;
            cur.left = en(node.children);
        }
        return head;
    }

    public static Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        return new Node(root.val, de(root.left));
    }

    public static List<Node> de(TreeNode root) {
        List<Node> children = new ArrayList<>();
        while (root != null){
            Node cur = new Node(root.val, de(root.left));
            children.add(cur);
            root = root.right;
        }

        return children;
    }

}


