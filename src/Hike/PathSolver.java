package Hike;

import java.util.PriorityQueue;

//Created by Carl F. Walther
//For the Hiking Problem 12/11/19
public class PathSolver {

    //Data Members
    private PriorityQueue<HNode> nodeQueue;
    private TerrainMap currentMap;
    private int[][] timeMap = new int[5][5];  //Change if map size changes.
    private TimeTable timeTable = new TimeTable();

    //Constructors
    public PathSolver(TerrainMap currentMap){
        //Load in the current
        this.currentMap = currentMap;

        //Place the starting position as the first node to check (first in priQue).
        this.nodeQueue = new PriorityQueue<HNode>();
        HNode firstNode = createFirstNode();
        nodeQueue.add(firstNode);

        //Fill Time Map with Sudo-Infinities
        for(int i = 0; i < timeMap.length; i++){
            for(int j = 0; j < timeMap[i].length; j++){
                timeMap[i][j] = defineInfinty();
            }
        }
        int[] sPoint = nodeQueue.peek().getPosition();
        timeMap[sPoint[0]][sPoint[1]] = timeTable.getTime(currentMap.getMapPosition(sPoint[0],sPoint[1]));

    }

    public String getFastestTime(){
        HNode currentNode;

        //Some Sort of Loop
        do {
            //Pull Next Node to be evaluate.
            currentNode = nodeQueue.poll();
            //Create New Nodes on the Priority Queue
            updateTimeMap(currentNode);
        }while( checkIfDone(nodeQueue.peek()));

        //Return the time found in the end position.
        int[] end = {currentMap.getEndingXPoint(),currentMap.getEndingYPoint()};
        Integer fastestTime = timeMap[end[0]][end[1]];
        return(fastestTime.toString());
    }

    private boolean checkIfDone(HNode peek) {
        //Return true if the time in the end position is larger then the time of the next node.
        return(false);
    }

    //This retunrs the largest possible time that a cell could hold.
    private int defineInfinty(){
        final int L_TIME = 20; //Need function to give largest value.
        int inf = timeMap.length * timeMap[0].length * L_TIME + 1;
        return(inf);
    }

    private HNode createFirstNode(){
        int[] sPoint = {this.currentMap.getStartingXPoint() , this.currentMap.getStartingYPoint()};
        int sRank = timeTable.getTime(currentMap.getMapPosition(sPoint[0],sPoint[1]));
        HNode firstNode = new HNode(sPoint, sRank);
        return(firstNode);
    }


    //Returns the Time Map as a full array for testing purposes.
    public int[][] getTimeMap(){
        return (timeMap);
    }

    //Update all the cells around the current cell on timeMap
    private void updateTimeMap(HNode currentNode){

        //evaluateNeighbors(???)
        //If neighbor is
          //Larger update time map and create new node
          //Smaller or Equal or Edge Do Nothing

    }






    //*******************************NODE CLASS*********************************************
    //A node that holds the position and rank of the next node to be used.

    //To hold the list of evaluated positions in the map and rank on shortest time.
    class HNode implements Comparable<HNode>{
        private int[] position = new int[2];
        private int rank;


        //Used to creat a new node for the priority code.
        public HNode(int[] position, int rank){
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
