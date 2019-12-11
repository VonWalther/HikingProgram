package Hike;

import java.util.PriorityQueue;

//Created by Carl F. Walther
//For the Hikeing Problem 12/11/19
public class PathSolver implements TimeTable{

    //Data Members
    private PriorityQueue<HNode> nextNode;
    private TerrainMap currentMap;
    private int[][] timeMap = new int[5][5];



    //Constructors
    public PathSolver(TerrainMap currentMap){
        this.currentMap = currentMap;
        this.nextNode = new PriorityQueue<HNode>();
    }

    public int getFastestTime(){

        return(7);
    }
    //To hold the list of evaluated positions in the map and rank on shortest time.
    class HNode implements Comparable<HNode>{
        private int[] position = new int[2];
        private int rank;

        //Used to creat a new node for the priority code.
        public void Node(int[] position, int rank){
            this.position = position;
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }

        public int[] getPosition() {
            return position;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        //If Priority Ques is in wrong order fix here.
        @Override
        public int compareTo(HNode otherNode) {
            if(otherNode.getRank() < this.getRank()) {
                return(-1);
            } else if(otherNode.getRank() == this.getRank()){
                return(0);
            } else {
                return (1);
            }
        }
    }
}
