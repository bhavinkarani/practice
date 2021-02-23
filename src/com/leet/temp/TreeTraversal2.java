/*
package nl.ing.api.cash.order.temp;

import java.util.*;
import java.io.*;
import java.io.IOException;
import java.lang.*;

public class TreeTraversal2
{

    static void printSpecial(Node root)
    {
        if (root == null)
            return;
        Node node = root;
        while (node != null)
        {
            System.out.print(node.data+" ");
            node = node.nextRight;
        }
        if (root.left != null)
            printSpecial(root.left);
        else
            printSpecial(root.right);


    }

    static void inorder(Node root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = Integer.parseInt(br.readLine());

            Node root = null;

            String nums[] = br.readLine().split(" ");
            int mm = n;
            for( int idx = 0; idx < mm; idx++)
            {

                int n1 = Integer.parseInt(nums[idx*3]);
                int n2 = Integer.parseInt(nums[idx*3+1]);

                String lr = nums[idx*3+2];
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr.equals("L"))
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
            }
            new Level().connect(root);
            printSpecial(root);
            System.out.println();
            inorder(root);
            System.out.println();

        }

    }


}

}
*/
/*This is a function problem.You only need to complete the function given below*//*

//User function Template for Java
*/
/*class Node
{
    int data;
    Node left, right, nextRight;
    Node(int x)
    {
        this.data = x;
        left = right = nextRight = null;
    }


}*//*

class Level
{
    static void connect(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node node2 = q.remove();
            System.out.print(node2.data+" ");
            if(node2.left!=null) q.add(node2.left);
            if(node2.right!=null) q.add(node2.right);
        }
        System.out.println();
        printInOrder(node);
    }
    static void printInOrder(Node node) {
        if(node==null) return;
        printInOrder(node.left);
        System.out.print(node.data+" ");
        printInOrder(node.right);
    }

    */
/*static void printLevelOrder(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node node2 = q.remove();
            System.out.print(node2.data+" ");
            if(node2.left!=null) q.add(node2.left);
            if(node2.right!=null) q.add(node2.right);
        }
    }*//*



}
*/
