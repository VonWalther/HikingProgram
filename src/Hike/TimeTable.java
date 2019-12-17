package Hike;

import java.util.HashMap;
import java.util.InputMismatchException;

public class TimeTable {

    private HashMap<Character , Integer> timeMap;
    private int max;
    private int min;

     public TimeTable() {

        new HashMap<>(); HashMap<Character , Integer> timeMap = new HashMap<>();
        
        timeMap.put('T' , 3);
        timeMap.put('W' , 8);
        timeMap.put('O' , 12);
        timeMap.put('S' , 20);

        this.max = 20;
        this.min = 3;
        this.timeMap = timeMap;

    }

    public TimeTable(HashMap<Character , Integer> newHashMap , int newMax , int newMin) {

        this.max = newMax;
        this.min = newMin;
        this.timeMap = newHashMap;

    }


    public  HashMap<Character, Integer> getTimeMap() {
        return timeMap;
    }

    public int getTime(char terrain) throws InputMismatchException {

        if (timeMap.containsKey(Character.toUpperCase(terrain))) {
            return timeMap.get(Character.toUpperCase(terrain));
        } else {
            throw new InputMismatchException("Input Was Not A Valid Terrain Type");
        }

    }

    public int getLargestKeyValue() {

        return max;
        
    }


    public int getSmallestKeyValue() {

        return min;

    }


}
