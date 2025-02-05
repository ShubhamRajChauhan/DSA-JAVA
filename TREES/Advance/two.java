//987. Vertical Order Traversal of a Binary Tree

import java.util.*;

public class two {
    public List<List<Integer>> verticalTraversal(TreeNode node) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if (node == null) {
            return ans;
        }

        int col = 0;

        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        queue.offer(new AbstractMap.SimpleEntry<>(node, col));

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> removed = queue.poll();
            node = removed.getKey();
            col = removed.getValue();

            if (node != null) {
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(node.val);

                queue.offer(new AbstractMap.SimpleEntry<>(node.left, col - 1));
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, col + 1));
            }
        }

        for (List<Integer> list : map.values()) {
            Collections.sort(list);
            ans.add(list);
        }

        return ans;
    }
}
