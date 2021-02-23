package com.hackerrank;

import java.util.*;

class DistanceFinderSourceAndDestination
{

    static class Point
    {
        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    };

    // A Data Structure for queue used in BFS
    static class Node
    {
        Point pt; // The cordinates of a cell
        int dist; // cell's distance of from the source

        public Node(Point pt, int dist)
        {
            this.pt = pt;
            this.dist = dist;
        }
    };


    boolean isValid(int row, int col, int height, int width, int[][] mat, boolean[][] checked)
    {
        if(!((row >= 0) && (row < height) &&
                (col >= 0) && (col < width))){
            return false;
        }if(mat[row][col]!=1){
            return false;
        }if(checked[row][col]){
            return false;
        }
        return true;
    }

    // These arrays are used to get row and column
// numbers of 4 neighbours of a given cell
    static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};

    // function to find the shortest path between
// a given source cell to a destination cell.
    int BFS(int mat[][], Point src,
                   Point dest)
    {
        // if sorce and destination are same return 0;
        if(src.x == dest.x && src.y == dest.y){
            return 0;
        }

        //if sorce and destination are anything other than 1 then its not valid input.
        if (mat[src.x][src.y] != 1 ||
                mat[dest.x][dest.y] != 1)
            return -1;

        // lets create a visited matrix to keep track of the
        int height = mat.length;
        int width = mat[0].length;
        boolean [][]checked = new boolean[height][width];

        // Mark the source cell as visited
        checked[src.x][src.y] = true;

        // Create a queue to do BFS
        Queue<Node> q = new LinkedList<>();

        // At the beginning distance of source cell is 0
        Node s = new Node(src, 0);
        q.add(s); // Enqueue source cell

        // Do a BFS starting from source cell
        while (!q.isEmpty())
        {
            Node curr = q.peek();
            Point pt = curr.pt;

            // check if we are done that is we reached destination
            if (pt.x == dest.x && pt.y == dest.y)
                return curr.dist;

            // else dequeue the front cell
            // in the queue and enqueue
            // its adjacent cells
            q.remove();

            for (int i = -1; i <=1; i++)
            {
                for(int j=-1; j<=1; j++){

                    int row = pt.x + i;
                    int col = pt.y + j;

                    checkAndAddToQueue(mat, height, width, checked, q, curr, row, col);
                }

            }
        }

        // destination unreachable
        return -1;
    }

    private void checkAndAddToQueue(int[][] mat, int height, int width, boolean[][] checked, Queue<Node> q, Node curr, int row, int col) {
        // if adjacent cell is valid, has path and not visited yet, enqueue it.
        if (isValid(row, col, height, width , mat, checked))
        {
            // mark cell as visited and enqueue it
            checked[row][col] = true;
            Node Adjcell = new Node
                    (new Point(row, col),
                            curr.dist + 1 );
            q.add(Adjcell);
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int maze[][] = {
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

        Point source = new Point(0, 0);
        Point dest = new Point(3, 4);
        DistanceFinderSourceAndDestination finder = new DistanceFinderSourceAndDestination();
        int dist = finder.BFS(maze, source, dest);

        if (dist != -1)
            System.out.println("Shortest Path is " + dist);
        else
            System.out.println("Shortest Path doesn't exist");
    }
}
