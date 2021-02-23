package nl.ing.api.cash.order.temp;


        import java.util.Scanner;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Stack;
        import java.util.HashMap;
        import java.util.*;
        import java.lang.*;
        import java.io.*;

class LevelOrderTraversal
{


    // driver function to test the above functions
    public static void main(String args[])
    {

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //Node root=null;
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }

            Level_order_traversal g = new Level_order_traversal();
            g.levelOrder(root);
            System.out.println();
            t--;

        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
/*
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Level_order_traversal
{
    //You are required to complete this method
    static void levelOrder_old(Node node)
    {
        //vanila level order printing
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(q.size()>0){
            node = q.remove();
            System.out.print(node.data+" ");
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
        }
    }
    static void levelOrder2(Node node) {
        //printing every level separated by $
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (q.size() > 0) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                node = q.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            System.out.print("$ ");
        }
    }
    static void levelOrder_reverse(Node node) {
        //Reverse printing with queue and stack
        Queue<Node> q = new LinkedList<>();
        Stack<Node> st = new Stack<>();
        q.add(node);
        while(q.size()>0){
            node = q.remove();
            st.push(node);
            if(node.right!=null){
                q.add(node.right);
            }
            if(node.left!=null){
                q.add(node.left);
            }
        }
        System.out.println(st.size());
        while(!st.isEmpty()){
            node = st.pop();
            System.out.print(node.data+" ");
        }
    }
    static void levelOrder_spiral(Node node) {
        //spiral order printing
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int level = 1;
        while(q.size()>0){
            int levelnodes = q.size();
            String levelNodesData = "";
            for(int i=0;i<levelnodes;i++){
                node = q.remove();
                if(level%2==0){
                    levelNodesData = levelNodesData+node.data+" ";
                }else{
                    levelNodesData = node.data+" "+levelNodesData;
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            System.out.print(levelNodesData);
            level++;
        }
    }
    static void levelOrder(Node node){
        printLevelOrder(node);
        System.out.println();
        printInOrder(node);
    }

    private static void printInOrder(Node node) {
        if(node==null) return;
        printInOrder(node.left);
        System.out.print(node.data+" ");
        printInOrder(node.right);
    }

    private static void printLevelOrder(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int levelSize = q.size();

            Node node2 = q.remove();
            System.out.print(node2.data+" ");
            if(node2.left!=null) q.add(node2.left);
            if(node2.right!=null) q.add(node2.right);
        }
    }
}