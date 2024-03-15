package com.example.first;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    public Object Loginbtn;
    @FXML
    private AnchorPane pnLogin, pnLogout;
    @FXML
    private TextField UsernameField;

    @FXML
    private TextField PasswordField;

    private Map<String, String> users = new HashMap<>();

    public HelloController() {
        users.put("zed", "zed123");
        users.put("zak", "zak123");
        users.put("fel", "fel123");
    }
    @FXML
    protected void onHelloButtonClick() throws IOException {
        String username = UsernameField.getText();
        String password = PasswordField.getText();

        if (users.containsKey(username) && users.get(username).equals(password)) {

            Parent scene = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("home-view.fxml")));
            pnLogin.getChildren().clear();
            pnLogin.getChildren().add(scene);

            UsernameField.clear();
            PasswordField.clear();
        } else {
            welcomeText.setText("Incorrect credentials.");
        }
    }

    protected void onLogoutButtonClick() throws IOException {
        Parent scene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        pnLogout.getChildren().clear();
        pnLogout.getChildren().add(scene);
    }
}
