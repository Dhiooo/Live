package com.example.modul6codelab;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {


        TextField usernameField = new TextField();
        usernameField.setPromptText("Usermame:");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password:");

        Button signInButton = new Button("Sign in");
        Label errorLabel = new Label();

        passwordField.setFont(Font.font("Times New Roman", 20));
        usernameField.setFont(Font.font("Times New Roman", 20));
        errorLabel.setFont(Font.font("Times New Roman", 14));
        signInButton.setFont(Font.font("Times New Roman", 20));


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);

       gridPane.add(new Label("Halaman Login") {{
           setFont(Font.font("Times New Roman", 20));
       }}, 0, 0, 2, 1);
        gridPane.add(usernameField, 0, 1, 2, 1);
        gridPane.add(passwordField, 0, 2, 2, 1);
        gridPane.add(signInButton, 0, 3);
        gridPane.add(errorLabel, 0, 4, 2, 1);

        signInButton.setOnAction(event -> {
            String inputUsername = usernameField.getText();
            String inputPassword = passwordField.getText();

            // Validasi username dan password
            if (inputUsername.equals("dhiocho") && inputPassword.equals("9012")) {
                System.out.println("Login berhasil!");
                newPage(stage, inputUsername);  // Pindah ke halaman baru jika login berhasil
            } else {
                errorLabel.setText("MUNDUR WIIIR"); // Password atau username salah
            }

        });

        Scene scene = new Scene(gridPane, 320, 240);
        stage.setTitle("Form Login");
        stage.setScene(scene);
        stage.show();
    }

    // Tampilan halaman baru (Form 2)
    private void newPage(Stage previousStage, String username) {
        previousStage.hide(); // Menyembunyikan stage 1

        Stage newStage = new Stage();
        GridPane newRoot = new GridPane();
        newRoot.setAlignment(Pos.CENTER);
        newRoot.setVgap(20);
        newRoot.setHgap(10);

        Label newLabel = new Label("Halo " + username);
        newLabel.setFont(Font.font("Times New Roman", 20));
        Button backButton = new Button("Kembali");
        backButton.setFont(Font.font("Times New Roman", 20));

        backButton.setOnAction(event -> {
            newStage.close();
            previousStage.show();

            newLabel.setFont(Font.font("Times New Roman", 24));
            backButton.setFont(Font.font("Times New Roman", 24));
        });

        newRoot.add(newLabel, 0, 0);
        newRoot.add(backButton, 0, 1);

        Scene newScene = new Scene(newRoot, 320, 240);
        newStage.setTitle("Form 2");
        newStage.setScene(newScene);
        newStage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}