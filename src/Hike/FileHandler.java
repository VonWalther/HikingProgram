package Hike;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private File fileName;
    private String fileURL;
    private String fileType;    //type of file name (determines whether to use fileName or fileURL)
    private int mapNum;    //determines which map to load
    private int numOfLines;    //number of lines in file, to keep track for multimap reading
    private boolean numOfLinesNotRun = true;    //tells if counted numOfLines yet

    //Constructor variables
    private Integer startX;
    private Integer startY;
    private Integer endX;
    private Integer endY;
    private char[][] map = new char[5][5];

    private void input() {
        //fileReader variables (including variables for breaking down code)
        String line;    //hold the read in line
        String[] vars = new String[2];    //temp for coordinates
        String temp;    //temp variable for stringing line
        FileReader fileReader;
        Scanner scanner;

        try {
            //creates buffered Reader and scanner
            if (fileType.equals("String")) {    //converts string to file
                fileName = new File(fileURL);
            }
            fileReader = new FileReader(fileName);
            scanner = new Scanner(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //counts total number of lines in file
            if (numOfLinesNotRun) {
                while (scanner.hasNextLine()) {
                    numOfLines++;
                    System.out.println(scanner.nextLine());
                }
                numOfLinesNotRun = false;   //ensures file is only counted once
            }

            //skips to map you want to use
            for (int i = 0; i < (mapNum * 6); i++) {
                bufferedReader.readLine();
            }

            //coordinate reader
            line = bufferedReader.readLine();
            for (int k = 0; k < 2; k++) {    //loops for start and end coordinates
                int o = 1 + (k * 6);    //for first substring parameter
                int p = 4 + (k * 6);    //for second substring parameter
                temp = line.substring(1, line.length() - 1);    //removes curly brackets
                vars[k] = temp.substring(o, p);     //format [0,0]
            }
            startX = Integer.parseInt(vars[0].substring(0, 1));    //hardcoded assignment
            startY = Integer.parseInt(vars[0].substring(2, 3));    //hardcoded assignment
            endX = Integer.parseInt(vars[1].substring(0, 1));    //hardcoded assignment
            endY = Integer.parseInt(vars[1].substring(2, 3));    //hardcoded assignment

            //map Reader
            for (int x = 0; x < 5; x++) {   //for each line/row of map ex: [1,1,1,1,1]
                line = bufferedReader.readLine();
                for (int y1 = 0; y1 < 5; y1++) {    //for each char in the line/row
                    int y2 = y1 + 1;    //so it only substrings a single char
                    map[x][y1] = (line.substring(y1, y2)).charAt(0);    //takes a single char in
                }
            }

        } catch (
                FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (
                IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public TerrainMap createTerrainMap() {
        input();

        return new TerrainMap(startX, startY, endX, endY, map);
    }

    public ArrayList<TerrainMap> createTerrainMaps() {
        ArrayList terrainMaps = new ArrayList<TerrainMap>();

        input();
        terrainMaps.add(new TerrainMap(startX, startY, endX, endY, map));

        for (int run = 0; run < ((numOfLines / 6) - 1); run++) {    //runs for each map in file
            input();
            terrainMaps.add(new TerrainMap(startX, startY, endX, endY, map));
            mapNum++;
        }

        return terrainMaps;
    }

    /////////////////////Constructors///////////////////
    public FileHandler(File fileName, int mapNum) {
        this.mapNum = mapNum;
        this.fileName = fileName;
        this.fileType = "File";
    }

    public FileHandler(String fileURL, int mapNum) {
        this.mapNum = mapNum;
        this.fileURL = fileURL;
        this.fileType = "String";
    }

    public FileHandler(File fileName) {
        this.fileName = fileName;
        this.fileType = "File";
    }

    public FileHandler(String fileURL) {
        this.fileURL = fileURL;
        this.fileType = "String";
    }

    ////////////////////Getters and Setters////////////////////

    //map
    public void setMap(char[][] map) {
        this.map = map;
    }

    public char[][] getMap() {
        return map;
    }

    //mapNum
    public int getMapNum() {
        return mapNum;
    }

    public void setMapNum(int mapNum) {
        this.mapNum = mapNum;
    }

    //fileName
    public File getFileName() {
        return fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }

    //fileURL
    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    //fileType
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    //numOfLines
    public int getNumOfLines() {
        return numOfLines;
    }

    //no need for numOfLines setter

    //startX
    public Integer getStartX() {
        return startX;
    }

    public void setStartX(Integer startX) {
        this.startX = startX;
    }

    //startY
    public Integer getStartY() {
        return startY;
    }

    public void setStartY(Integer startY) {
        this.startY = startY;
    }

    //endX
    public Integer getEndX() {
        return endX;
    }

    public void setEndX(Integer endX) {
        this.endX = endX;
    }

    //endY
    public Integer getEndY() {
        return endY;
    }

    public void setEndY(Integer endY) {
        this.endY = endY;
    }
}
