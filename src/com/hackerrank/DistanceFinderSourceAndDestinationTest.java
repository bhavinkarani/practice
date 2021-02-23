package com.hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class DistanceFinderSourceAndDestinationTest {

    @Test
    public void calculateDistance(){
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

        DistanceFinderSourceAndDestination.Point source = new DistanceFinderSourceAndDestination.Point(0, 0);
        DistanceFinderSourceAndDestination.Point dest = new DistanceFinderSourceAndDestination.Point(3, 4);
        DistanceFinderSourceAndDestination finder = new DistanceFinderSourceAndDestination();

        //valid test 1
        int dist = finder.BFS(maze, source, dest);
        Assert.assertEquals(7, dist);

        //valid test 2
        source = new DistanceFinderSourceAndDestination.Point(0, 0);
        dest = new DistanceFinderSourceAndDestination.Point(5, 0);
        Assert.assertEquals(12, finder.BFS(maze, source, dest));

        //same source and destination
        Assert.assertEquals(0, finder.BFS(maze, source, source));

        //invalid source
        source = new DistanceFinderSourceAndDestination.Point(0, 1);
        Assert.assertEquals(-1, finder.BFS(maze, source, dest));

        // invaid destination
        source = new DistanceFinderSourceAndDestination.Point(0, 0);
        dest = new DistanceFinderSourceAndDestination.Point(3, 0);
        Assert.assertEquals(-1, finder.BFS(maze, source, dest));

    }
    @Test
    public void calculateDistance2(){
        //unrechable test
        int maze[][] = {
                { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 1, 1 }};

        DistanceFinderSourceAndDestination.Point source = new DistanceFinderSourceAndDestination.Point(0, 0);
        DistanceFinderSourceAndDestination.Point dest = new DistanceFinderSourceAndDestination.Point(0, 8);
        DistanceFinderSourceAndDestination finder = new DistanceFinderSourceAndDestination();


        Assert.assertEquals(-1, finder.BFS(maze, source, dest));

        dest = new DistanceFinderSourceAndDestination.Point(6, 9);
        Assert.assertEquals(-1, finder.BFS(maze, source, dest));

    }

}