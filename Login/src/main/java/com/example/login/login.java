package com.example.login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class login extends Application {
    public void start(Stage primaryStage){
        primaryStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25 ));

        Text scenetitle = new Text("Welcome");
        // scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle,0,0,2,1);

        Label userName = new Label("User Name: ");
        grid.add(userName,0,1);

        TextField userTextField = new TextField();
        grid.add(userTextField,1,1);

        Label pw = new Label("Password");
        grid.add(pw,0,2);

        PasswordField pwbox = new PasswordField();
        grid.add(pwbox,1,2);

        Scene scene = new Scene(grid, 300, 275);

        Button btn = new Button("Sign in");


        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,1,3);

        final Text actiontarger = new Text();
        grid.add(actiontarger,1,4);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                actiontarger.setFill(Color.FIREBRICK);
                actiontarger.setText("Sign in button pressed");
            }
        });
        Image icon = new Image("wallpaper.jpg");
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        grid.setStyle("-fx-background-image: url(background.jpg)");
        userName.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 )");
        pw.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 )");
        scenetitle.setStyle("-fx-font-size: 32px;\n" +
                "   -fx-font-family: \"Arial Black\";\n" +
                "   -fx-fill: #818181;\n" +
                "   -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        actiontarger.setStyle("-fx-fill: FIREBRICK;\n" +
                "  -fx-font-weight: bold;\n" +
                "  -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
        btn.setStyle("-fx-text-fill: white;\n" +
                "    -fx-font-family: \"Arial Narrow\";\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-background-color: linear-gradient(#61a2b1, #2A5058);\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
        btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btn.setStyle("-fx-text-fill: white;\n" +
                        "    -fx-font-family: \"Arial Narrow\";\n" +
                        "    -fx-font-weight: bold;\n" +
                        "-fx-background-color: linear-gradient(#2A5058, #61a2b1);\n" +
                        "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
            }
        });
        btn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btn.setStyle("-fx-text-fill: white;\n" +
                        "    -fx-font-family: \"Arial Narrow\";\n" +
                        "    -fx-font-weight: bold;\n" +
                        "    -fx-background-color: linear-gradient(#61a2b1, #2A5058);\n" +
                        "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
            }
        });
        primaryStage.show();

    }
}
