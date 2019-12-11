package Hike;

import java.util.HashMap;
import java.util.InputMismatchException;

public interface TimeTable {


    static HashMap<Character , Integer> getTimeMap() {

        HashMap<Character , Integer> timeMap = new HashMap<>();

        timeMap.put('T' , 3);
        timeMap.put('W' , 8);
        timeMap.put('O' , 12);
        timeMap.put('S' , 20);

        return timeMap;

    }


    static int getTime(char terrain) throws InputMismatchException {

        HashMap<Character , Integer> timeMap = getTimeMap();

        if (timeMap.containsKey(Character.toUpperCase(terrain))) {
            return timeMap.get(Character.toUpperCase(terrain));
        } else {
            throw new InputMismatchException("Input Was Not A Valid Terrain Type");
        }

    }

}
