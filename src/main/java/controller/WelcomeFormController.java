package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class WelcomeFormController {
    public Button btnRegister;
    public Button btnLogin;
    public AnchorPane pneRoot;

    public void initialize(){


    }

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {

        URL resource = this.getClass().getResource("/view/RegisterForm.fxml");
        AnchorPane registerForm = FXMLLoader.load(resource);
        AnchorPane pneContainer = (AnchorPane) pneRoot.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(registerForm);
        AnchorPane.setBottomAnchor(registerForm,0.0);
        AnchorPane.setTopAnchor(registerForm,0.0);
        AnchorPane.setLeftAnchor(registerForm,0.0);
        AnchorPane.setRightAnchor(registerForm,0.0);


    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/LoginForm.fxml");
        AnchorPane loginForm = FXMLLoader.load(resource);
        AnchorPane pneContainer = (AnchorPane) pneRoot.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(loginForm);
        AnchorPane.setBottomAnchor(loginForm,0.0);
        AnchorPane.setTopAnchor(loginForm,0.0);
        AnchorPane.setLeftAnchor(loginForm,0.0);
        AnchorPane.setRightAnchor(loginForm,0.0);

    }
}
