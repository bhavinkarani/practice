package nl.ing.api.cash.order.temp;

     import java.util.*;
        import java.lang.*;
        import java.io.*;
// A Binary Tree node
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
public class TreeTraversal
{

    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);


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
            Tree g = new Tree();
            g.preorder(root);
            System.out.print("");
                    t--;
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/* A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}

Example input and output
For Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R
Your Output is:
1 3 2
10 20 40 60 30

*/
class Tree
{
    void preorder(Node root)
    {
        System.out.print(root.data+" ");
        if(root.left!=null){
            preorder(root.left);
        }
        if(root.right!=null){
            preorder(root.right);
        }
    }

    void postOrder(Node root)
    {
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
}
