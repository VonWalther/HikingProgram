package Hike;


import java.util.HashMap;



public class TimeTable {

    private HashMap timeMap;

    public TimeTable() {
        HashMap<Character , Integer> timeMap = new HashMap<>();
        timeMap.put('T' , 3);
        timeMap.put('W' , 8);
        timeMap.put('O' , 12);
        timeMap.put('S' , 20);
        this.timeMap = timeMap;
    }

    public int getTime(char terrain) {
        if (timeMap.containsKey(Character.toUpperCase(terrain))) {
            return (int) timeMap.get(Character.toUpperCase(terrain));
        } else {
            return 100;
        }
    }
}
