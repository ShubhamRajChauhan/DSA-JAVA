//how many path exists

import java.util.*;

public class nineteen {
    int countPaths(Node node, int sum) {
        List<Integer> path = new ArrayList<>();
        return helper(node, sum, path);
    }
    int helper(Node node, int sum, List<Integer> path) {
        if(node == null) {
            return 0;
        }

        path.add(node.val);
        int count = 0;
        int s = 0;
        //how many paths I can make
        ListIterator<Integer> itr = path.listIterator(path.size());
        while(itr.hasPrevious()) {
            s += itr.previous();

            if(s == sum) {
                count++;
            }
        }

        count += helper(node.left, sum, path) + helper(node.right, sum, path);

        //backtrack
        path.remove(path.size() - 1);

        return count;
    }
}
//----------------------------------------------------------------------------------------------------------
//want to put all path in a list


public class nineteen {
    List<List<Integer>> findPaths(Node node, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(node, sum, path);
        return paths;
    }
    void helper(Node node, int sum, List<Integer> path, List<List<Integer>> paths) {
        if(node == null) {
            return 0;
        }

        path.add(node.val);

        if(node.val == sum && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            helper(node.left, sum-node.val, path, paths);
            helper(node.right, sum-node.val, path, paths);
        }

        //backtrack
        path.remove(path.size() - 1);
    }
}
