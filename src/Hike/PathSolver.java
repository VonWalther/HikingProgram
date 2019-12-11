package Hike;

import java.util.PriorityQueue;

//Created by Carl F. Walther
//For the Hikeing Problem 12/11/19
public class PathSolver {

    //Data Members
    private PriorityQueue<Integer> nextNode;
    private TerrainMap currentMap;
    private int[][] timeMap = new int[5][5];



    //Constructors
    public PathSolver(TerrainMap currentMap){
        this.currentMap = currentMap;
        this.nextNode = new PriorityQueue<Integer>();
        //Remove this next part after testing.
        nextNode.offer(4);
        nextNode.offer(6);
    }

    public int getFastestTime(){

        return(7);
    }
}
