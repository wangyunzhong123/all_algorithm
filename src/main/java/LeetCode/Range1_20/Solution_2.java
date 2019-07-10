package LeetCode.Range1_20;

/**
 * Created by yzwang on 2019/3/30.
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class Solution_2 {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode zero = new ListNode(0);
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode t = temp;// 记录次高位
        while (l1 != null || l2 != null) {
            t = temp;
            l1 = l1 != null ? l1 : zero;
            l2 = l2 != null ? l2 : zero;
            temp.next = new ListNode((temp.val + l1.val + l2.val) / 10);
            temp.val = (temp.val + l1.val + l2.val) % 10;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (t.next.val == 0) {
            t.next = null;// 删掉最高位的0
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
