import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrdTra {

    // left line outputs left to right
    // even line outputs right to left
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null)
            return results;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean isOdd = true;
        while (!stack.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack2 = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                if (!isOdd) {
                    if (current.right != null)
                        stack2.push(current.right);
                    if (current.left != null)
                        stack2.push(current.left);
                } else {
                    if (current.left != null)
                        stack2.push(current.left);
                    if (current.right != null)
                        stack2.push(current.right);
                }
                result.add(current.val);
            }
            results.add(result);
            stack = stack2;
            isOdd = !isOdd;
        }
        return results;
    }

    public static void main(String[] args) {
        ZigZagLevelOrdTra zz = new ZigZagLevelOrdTra();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = null;
        root.left.right = null;
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zz.zigzagLevelOrder(root));
    }
}
