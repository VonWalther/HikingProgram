package Hike;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private File fileName;
    private String fileURL;
    private String fileType;    //type of file name (determines whether to use fileName or fileURL)
    private int mapNum;    //determines which map to load
    private int numOfLines;    //number of lines in file, to keep track for multimap reading
    private String[][] data;    //2D Array of all data in file  format: [mapNum][line]

    /////////////////////Constructors///////////////////
    public FileHandler(File fileName, int mapNum) {
        this.mapNum = mapNum;
        this.fileName = fileName;
        this.fileType = "File";

        input();
    }

    public FileHandler(String fileURL, int mapNum) {
        this.mapNum = mapNum;
        this.fileURL = fileURL;
        this.fileType = "String";

        input();
    }

    public FileHandler(File fileName) {
        this.fileName = fileName;
        this.fileType = "File";

        input();
    }

    public FileHandler(String fileURL) {
        this.fileURL = fileURL;
        this.fileType = "String";

        input();
    }

    //TerrainMap Makers
    public TerrainMap createTerrainMap() {    //return a single map
        return mapMaker();
    }

    public ArrayList<TerrainMap> createTerrainMaps() {    //return ArrayList of Maps
        ArrayList terrainMaps = new ArrayList<TerrainMap>();

        //terrainMaps.add(mapMaker());

        for (int run = 0; run < ((numOfLines / 6)/* - 1*/); run++) {    //runs for each map in file
            terrainMaps.add(mapMaker());
            mapNum++;
        }

        return terrainMaps;
    }

    //data Interpreter and TerrainMap maker (returns a single TerrainMap)
    @NotNull
    @Contract(" -> new")
    private TerrainMap mapMaker() {
        //Constructor variables
        int startX;
        int startY;
        int endX;
        int endY;
        char[][] map = new char[5][5];    //Format: [row][column]

        //Start and end coordinates (hardCoded)
        startX = Integer.parseInt(data[mapNum][0].substring(2, 3));
        startY = Integer.parseInt(data[mapNum][0].substring(4, 5));
        endX = Integer.parseInt(data[mapNum][0].substring(8, 9));
        endY = Integer.parseInt(data[mapNum][0].substring(10, 11));

        //map maker (format: map[x][y])
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                map[x][y] = data[mapNum][(x + 1)].substring(y, (y + 1)).charAt(0);
            }
        }

        return new TerrainMap(startX, startY, endX, endY, map);
    }

    //Reader function
    private void input() {
        String line;    //hold the read in line
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
            while (scanner.hasNextLine()) {
                numOfLines++;
                scanner.nextLine();
            }
            data = new String[numOfLines / 6][6];

            //reads the file into data(the string[][])
            int x = 0;    //for first [] of data
            int y = 0;    //for second [] of data
            while ((line = bufferedReader.readLine()) != null) {
                if (y < 6) {
                    data[x][y] = line;
                    y++;
                } else {
                    x++;
                    y = 0;
                    data[x][y] = line;
                    y++;
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

    ////////////////////Getters and Setters////////////////////

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

    //no reason to set numOfLines
}
