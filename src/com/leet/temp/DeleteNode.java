package nl.ing.api.cash.order.temp;

import java.util.*;
class NodeD
{
    int data ;
    NodeD next;
    NodeD(int d)
    {
        data = d;
        next = null;
    }
}
class Delete_Node
{
    NodeD head;

    void printList(NodeD head)
    {
        NodeD tnode = head;
        while(tnode != null)
        {
            System.out.print(tnode.data+ " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    void addToTheLast(NodeD node)
    {

        if(head == null)
        {
            head = node;
        }else
        {
            NodeD temp = head;
            while(temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    NodeD search_Node(NodeD head, int k)
    {
        NodeD current = head;
        while(current != null)
        {
            if(current.data == k)
                break;
            current = current.next;
        }
        return current;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            Delete_Node llist = new Delete_Node();
            //int n=Integer.parseInt(br.readLine());
            int a1=sc.nextInt();
            NodeD head= new NodeD(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new NodeD(a));
            }

            int k = sc.nextInt();
            NodeD del = llist.search_Node(llist.head,k);

            GfG2 g = new GfG2();
            if(del != null && del.next != null)
            {
                g.deleteNode(del);
            }
            llist.printList(llist.head);
            t--;
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/

/*
class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/
// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
class GfG2
{
    void deleteNode(NodeD node)
    {
        node.data = node.next.data;
        node.next = node.next.next;

    }
}
