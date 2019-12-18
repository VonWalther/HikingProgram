package Hike;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    private static ArrayList<TerrainMap> allMaps;
    private static int mapIndex = 0;

    @FXML
    private Button prevMapButton;

    @FXML
    private Button nextMapButton;

    @FXML
    private Button loadNew;

    @FXML
    private TextField endPointBox;

    @FXML
    private GridPane grid;

    @FXML
    private TextField startPointBox;

    @FXML
    private TextField bestTimeBox;

    @FXML
    void loadNext(ActionEvent event) {
        if (!(mapIndex >= allMaps.size() - 1)){
            mapIndex++;
            loadCurrentMap();
        }
    }

    @FXML
    void loadPrev(ActionEvent event) {
        if (!(mapIndex <= 0)){
            mapIndex--;
            loadCurrentMap();
        }
    }

    @FXML
    void loadNewFile(ActionEvent event) throws IOException {
        //close window and open file select
        Parent root = FXMLLoader.load(getClass().getResource("fileSelect.fxml"));
        Stage inputStage = new Stage();
        Stage currentStage = (Stage)loadNew.getScene().getWindow();
        inputStage.setTitle("Enter a .dat file");
        inputStage.setScene(new Scene(root, 300, 275));
        inputStage.setWidth(275);
        inputStage.setHeight(200);
        inputStage.setResizable(false);
        inputStage.show();
        currentStage.close();
    }

    //FXML version of function, used when window is initially drawn
    @FXML
    void loadCurrentMap(MouseEvent event){
        //fill in map here
        grid.setGridLinesVisible(true);

        char[][] array = new char[5][5];
        TerrainMap currentMap = allMaps.get(mapIndex);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                array[i][j] = currentMap.getMapPosition(i,j);
            }
        }

        startPointBox.setText("( " + currentMap.getStartingXPoint() + " , " + currentMap.getStartingYPoint() + " )");
        endPointBox.setText("( " + currentMap.getEndingXPoint() + " , " + currentMap.getEndingYPoint() + " )");
        bestTimeBox.setText("-----");

        for (int x = 0; x < array.length; x++){
            for (int y = 0; y < array[x].length; y++){
                Label label;
                StackPane sp = new StackPane();
                switch (array[x][y]){
                    case 'T':
                        sp.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                        label = new Label("Trail");
                        break;
                    case 'W':
                        sp.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
                        label = new Label("Wooded");
                        break;
                    case 'O':
                        sp.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                        label = new Label("Overgrown");
                        break;
                    case 'S':
                        sp.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, CornerRadii.EMPTY, Insets.EMPTY)));
                        label = new Label("Steep");
                        break;
                    default:
                        label = new Label("N/A");
                        break;
                }
                sp.getChildren().add(label);
                grid.add(sp, x, y);
            }
        }
    }

    //used whenever loadNext() or loadPrev() event is triggered
    void loadCurrentMap(){
        //fill in map here
        grid.setGridLinesVisible(true);

        char[][] array = new char[5][5];
        TerrainMap currentMap = allMaps.get(mapIndex);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                array[i][j] = currentMap.getMapPosition(i,j);
            }
        }

        startPointBox.setText("( " + currentMap.getStartingXPoint() + " , " + currentMap.getStartingYPoint() + " )");
        endPointBox.setText("( " + currentMap.getEndingXPoint() + " , " + currentMap.getEndingYPoint() + " )");
        bestTimeBox.setText("-----");

        for (int x = 0; x < array.length; x++){
            for (int y = 0; y < array[x].length; y++){
                Label label;
                StackPane sp = new StackPane();
                switch (array[x][y]){
                    case 'T':
                        sp.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                        label = new Label("Trail");
                        break;
                    case 'W':
                        sp.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
                        label = new Label("Wooded");
                        break;
                    case 'O':
                        sp.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                        label = new Label("Overgrown");
                        break;
                    case 'S':
                        sp.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, CornerRadii.EMPTY, Insets.EMPTY)));
                        label = new Label("Steep");
                        break;
                    default:
                        label = new Label("N/A");
                        break;
                }
                sp.getChildren().add(label);
                grid.add(sp, x, y);
            }
        }
    }

    public static void setAllMaps(ArrayList<TerrainMap> maps) {
        allMaps = maps;
    }
}
