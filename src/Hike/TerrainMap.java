/*
        ////********************************\\
        ////** Written by Ashlyn Kwasnica **\\
        ////********************************\\
        ////********************************\\
 */

package Hike;

public class TerrainMap {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private char[][] map;

    public TerrainMap(int startX, int startY, int endX, int endY, char[][] map){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.map = map;
    }

    public char getMapPosition(int x, int y) {
        if(x > map.length || y > map.length){
            throw new IndexOutOfBoundsException("Request outside of the map");
        }
        else{
            return map[x][y];
        }
    }
        
    public int getMapSize(){
        int x = map.length;
        return x;
    }

    public int getStartingXPoint() {
        return startX;
    }

    public int getStartingYPoint() {
        return startY;
    }

    public int getEndingXPoint() {
        return endX;
    }

    public int getEndingYPoint() {
        return endY;
    }
}

