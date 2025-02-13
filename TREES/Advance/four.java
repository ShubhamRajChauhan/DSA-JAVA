//653. Two Sum IV - Input is a BST
//best question to understand recursion 

import java.util.*;

public class four {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    private boolean helper(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) {
            return false;
        }
        if (set.contains(k - node.val)) {
            return true;
        }

        set.add(node.val);
        return helper(node.left, k, set) || helper(node.right, k, set);
    }
}
