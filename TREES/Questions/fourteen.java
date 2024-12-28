//297. Serialize and Deserialize Binary Tree

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class fourteen {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeHelper(root, list);
        return String.join(",", list);
    }

    private void serializeHelper(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        serializeHelper(node.left, list);
        serializeHelper(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(List<String> list) {
        String val = list.remove(0);
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);
        return node;
    }
}

