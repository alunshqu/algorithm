package com.aaron.algorithm.binarytree;

import java.util.*;

public class TraversalTree {

    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (null != root) {
            queue.offer(root);
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.value);
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfsByInorder(root, result);
        return result;
    }

    public void dfsByInorder(TreeNode root, List<Integer> nodes) {
        if (null != root) {
            dfsByInorder(root.left, nodes);
            nodes.add(root.value);
            dfsByInorder(root.right, nodes);
        }
    }

    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.value);
            cur = cur.right;

        }
        return result;
    }

    public void dfsByPreorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.value);
            if (root.left != null) {
                dfsByPreorder(root.right, result);
            }
            if (root.right != null) {
                dfsByPreorder(root.left, result);
            }
        }
    }

    public List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.value);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return result;
    }

    public void dfsByPostorder(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            if (root.left != null) {
                dfsByPostorder(root.left, nodes);
            }
            if (root.right != null) {
                dfsByPostorder(root.right, nodes);
            }
            nodes.add(root.value);
        }
    }

    public List<Integer> postorderTraversalIteration(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != prev) {
                cur = cur.right;
            } else {
                stack.pop();
                result.add(cur.value);
                prev = cur;
                cur = null;
            }
        }

        return result;
    }
}


