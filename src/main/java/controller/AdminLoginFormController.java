package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AdminLoginFormController {

    private static int attempts = 3;
    public PasswordField txtPassword;

    private static final String ADMIN_PASSWORD ="dep9@ADMIN";
    public AnchorPane pneAdminLoginForm;

    public void initialize(){
        Platform.runLater(txtPassword::requestFocus);
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) throws IOException {

        if (!txtPassword.getText().equals(ADMIN_PASSWORD)){

            if (attempts==0){
                new Alert(Alert.AlertType.ERROR,"System Shut Down!").showAndWait();
                Platform.exit();
                return;
            }

            attempts--;

            URL resource = this.getClass().getResource("/audio/NQ5WY6X-security-breach-alarm.mp3");
            Media media = new Media(resource.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();


            Alert alert = new Alert(Alert.AlertType.ERROR,"Invalid Admin Password."+attempts+" more attempts left!");
            InputStream resourceAsStream = this.getClass().getResourceAsStream("/image/Lock.png");
            Image image = new Image(resourceAsStream);
            ImageView imageView =new ImageView(image);
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);

            alert.setHeaderText("Invalid Login Credentials");
            alert.setTitle("Access Denied");
            alert.showAndWait();
            mediaPlayer.dispose();




            txtPassword.requestFocus();
            return;
        }
        URL resource = this.getClass().getResource("/view/ControlCenterForm.fxml");
        AnchorPane controlCenter = FXMLLoader.load(resource);
        AnchorPane pneContainer =(AnchorPane) pneAdminLoginForm.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(controlCenter);
        AnchorPane.setBottomAnchor(controlCenter,0.0);
        AnchorPane.setRightAnchor(controlCenter,0.0);
        AnchorPane.setTopAnchor(controlCenter,0.0);
        AnchorPane.setLeftAnchor(controlCenter,0.0);


    }
}
