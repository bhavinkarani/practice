package com.leet.temp.Leet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */
class TreeNode2 {
      int val;
      TreeNode2 left;
      TreeNode2 right;
      TreeNode2(int x) { val = x; }
  }


/**
 * Definition for a binary tree node.
 * public class TreeNode2 {
 *     int val;
 *     TreeNode2 left;
 *     TreeNode2 right;
 *     TreeNode2(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode2 insertIntoBST(TreeNode2 root, int val) {
        TreeNode2 node= root;
        while(true){
            if(node.val > val){
                if(node.left!=null){
                    node = node.left;
                }else{
                    TreeNode2 tn = new TreeNode2(val);
                    node.left=tn;
                    break;
                }
            }else if (node.val < val ){
                if(node.right!=null){
                    node = node.right;
                }else{
                    TreeNode2 tn = new TreeNode2(val);
                    node.left=tn;
                    break;
                }
            }
        }
        return root;
    }
}

public class MainClass {
    public static TreeNode2 stringToTreeNode2(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode2 root = new TreeNode2(Integer.parseInt(item));
        Queue<TreeNode2> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode2 node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode2(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode2(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String TreeNode2ToString(TreeNode2 root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode2> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode2 node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode2 root = stringToTreeNode2(line);
            line = in.readLine();
            int val = Integer.parseInt(line);

            TreeNode2 ret = new Solution().insertIntoBST(root, val);

            String out = TreeNode2ToString(ret);

            System.out.print(out);
        }
    }
}