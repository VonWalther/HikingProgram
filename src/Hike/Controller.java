package Hike;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button prevMapButton;

    @FXML
    private Button nextMapButton;

    @FXML
    private Button loadNew;

    @FXML
    private GridPane grid;

    @FXML
    void loadNext(ActionEvent event) {
        //load next map
    }

    @FXML
    void loadPrev(ActionEvent event) {
        //load last map
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

    @FXML
    void loadCurrentMap(MouseEvent event){
        //fill in map here
        grid.setGridLinesVisible(true);

        //dummy entry
        char[][] array = new char[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                array[i][j] = 'T';
            }
        }
        //end dummy entry

        for (int x = 0; x < array.length; x++){
            for (int y = 0; y < array[x].length; y++){
                Label label = new Label(Character.toString(array[x][y]));
                StackPane sp = new StackPane();
                sp.getChildren().add(label);
                grid.add(sp, x, y);
            }
        }
    }

}
