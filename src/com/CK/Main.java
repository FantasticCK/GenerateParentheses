package com.CK;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(4).toString());
    }
}

class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n == 0) return res;
        TreeNode root = new TreeNode('(');
        int maxChar = n * 2 - 1;
        StringBuilder sb = new StringBuilder(String.valueOf(root.val));
        bfs(root, maxChar, 1, sb);
        return res;
    }

    private void bfs(TreeNode root, int maxChar, int op, StringBuilder sb) {
        if (maxChar > 0) {
            if (op > 0) {
                root.right = new TreeNode(')');
                StringBuilder rightSb = new StringBuilder(sb);
                rightSb.append(')');
                bfs(root.right, maxChar - 1, op - 1, rightSb);
                if (root.right.left == null && root.right.right == null) res.add(rightSb.toString());
            }
            if (maxChar > op) {
                root.left = new TreeNode('(');
                StringBuilder leftSb = new StringBuilder(sb);
                leftSb.append('(');
                bfs(root.left, maxChar - 1, op + 1, leftSb);
                if (root.left.left == null && root.left.right == null) res.add(leftSb.toString());
            }
        }
    }

    class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char c) {
            this.val = c;
            left = null;
            right = null;
        }
    }
}
