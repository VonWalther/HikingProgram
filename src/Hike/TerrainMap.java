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

    public char getMapPosition(int x, int y) throws IndexOutOfBoundsException{
        try {
            return( map[x][y]);
        } catch(IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Request outside of the Map");
        }
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

