package common;

/**
 * @Classname Commo
 * @Description
 * @Date 2021/7/31 3:55 下午
 * @Created by sensu
 */
public class BTCommon {
    // for test
    public static CommonNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static CommonNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        CommonNode head = new CommonNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    // for test
    public static boolean isSameValueStructure(CommonNode head1, CommonNode head2) {
        if (head1 == null && head2 != null) {
            return false;
        }
        if (head1 != null && head2 == null) {
            return false;
        }
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1.value != head2.value) {
            return false;
        }
        return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
    }

    public static CommonNode generateCommonNode(String value) {
        if (value == null) {
            return null;
        }

        return new CommonNode(Integer.parseInt(value));
    }

}
