package Hike;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFS {

    @FXML
    private Button submit;

    @FXML
    private TextField filePath;

    @FXML
    void submitFile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mapDisplay.fxml"));
        Stage mainStage = new Stage();
        Stage currentStage = (Stage)submit.getScene().getWindow();
        mainStage.setTitle(filePath.getText());
        mainStage.setScene(new Scene(root, 300, 275));
        mainStage.setWidth(600);
        mainStage.setHeight(400);
        mainStage.setResizable(false);
        mainStage.show();
        currentStage.close(); //TODO: connect filePath to file handler to try and load entered file
    }

}

