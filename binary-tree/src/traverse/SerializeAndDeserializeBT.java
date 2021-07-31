package traverse;

import common.BTCommon;
import common.CommonNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname SerializeAndDeserialize
 * @Description
 * @Date 2021/7/31 2:44 下午
 * @Created by sensu
 */
public class SerializeAndDeserializeBT {

    public static Queue<String> preSerial(CommonNode head) {
        Queue<String> queue = new LinkedList<>();

        pre(queue, head);
        return queue;
    }

    public static void pre(Queue<String> queue, CommonNode head) {
        if (head == null) {
            queue.add(null);
        } else {
            queue.add(String.valueOf(head.value));
            pre(queue, head.left);
            pre(queue, head.right);
        }
    }

    public static CommonNode deserializeByPreQueue(Queue<String> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }

        return preDeserialize(queue);
    }

    public static CommonNode preDeserialize(Queue<String> queue) {
        String cur = queue.poll();
        if (cur == null) {
            return null;
        }

        CommonNode node = new CommonNode(Integer.parseInt(cur));
        node.left = preDeserialize(queue);
        node.right = preDeserialize(queue);
        return node;
    }

    public static Queue<String> levelSerial(CommonNode head) {
        Queue<String> queue = new LinkedList<>();
        if (head == null) {
            queue.add(null);
            return queue;
        }

        queue.add(String.valueOf(head.value));
        Queue<CommonNode> traverseQueue = new LinkedList<>();
        traverseQueue.add(head);
        while (!traverseQueue.isEmpty()) {
            CommonNode cur = traverseQueue.poll();
            if (cur.left != null) {
                traverseQueue.add(cur.left);
                queue.add(String.valueOf(cur.left.value));
            } else {
                queue.add(null);
            }

            if (cur.right != null) {
                traverseQueue.add(cur.right);
                queue.add(String.valueOf(cur.right.value));
            } else {
                queue.add(null);
            }
        }

        return queue;
    }

    public static CommonNode deserializeByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        CommonNode head = BTCommon.generateCommonNode(levelList.poll());
        Queue<CommonNode> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        CommonNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = BTCommon.generateCommonNode(levelList.poll());
            node.right = BTCommon.generateCommonNode(levelList.poll());
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }


    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            CommonNode head = BTCommon.generateRandomBST(maxLevel, maxValue);
            Queue<String> pre = preSerial(head);
            Queue<String> level = levelSerial(head);
            CommonNode preBuild = deserializeByPreQueue(pre);
            CommonNode levelBuild = deserializeByLevelQueue(level);
            if (!BTCommon.isSameValueStructure(preBuild, levelBuild)) {
                System.out.println("error!");
            }
        }
    }
}
