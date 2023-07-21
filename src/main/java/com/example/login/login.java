package com.example.login;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;


public class login extends Application {

    public static Scene Populating_view_students(ArrayList<String> result, Scene scene2,
                                                 Stage primaryStage){
        GridPane view_students = new GridPane();
        view_students.setPadding(new Insets(0,0,25,25));
        Label f_name = new Label("    First Name    ");
        view_students.add(f_name,0,0);
        Label l_name = new Label("    Last Name    ");
        view_students.add(l_name,1,0);
        Label age = new Label("  Age  ");
        view_students.add(age,2,0);
        Label S_N = new Label("    Student Number    ");
        view_students.add(S_N, 3, 0);

        Button backbtn2= new Button();
        Image image2 = new Image("back.png");
        ImageView back2 = new ImageView(image2);
        back2.setFitHeight(20);
        back2.setFitWidth(20);
        backbtn2.setGraphic(back2);
        backbtn2.setShape(new Circle());
        view_students.add(backbtn2,0,0);
        view_students.setGridLinesVisible(true);
        VBox backbox = new VBox();
        view_students.setAlignment(Pos.CENTER);
        backbox.getChildren().addAll(backbtn2, view_students);
        Integer count = 0;
        Integer length = (result.size() / 4);
        for (Integer row = 1; row <= length; row++) {
            for (Integer column = 0; column < 4; column++) {
                TextField data = new TextField();
                data.setText(result.get(count));
                view_students.add(data, column, row);
                count++;
            }
        }
        backbtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene2);
            }
        });

        Scene final_scene = new Scene(backbox,400,275);
        return final_scene;
    }

    public static void switch_scene(Scene scene, Stage stage){
        stage.setScene(scene);
    }
    public void start(Stage primaryStage){

        ObservableList<String> options = FXCollections.observableArrayList(
                "Add Student",
                "View Student",
                "Delete Student"
        );
        final ComboBox comboBox = new ComboBox(options);
        comboBox.setValue("Options");

        // view student scene

        // StackPane rootpane = new StackPane();




        // Scene view_scene = new Scene(backbox,400 , 275);



        VBox box = new VBox();
        box.setAlignment(Pos.TOP_LEFT);
        box.getChildren().add(comboBox);
        Scene scene2 = new Scene(box,400,275);


        // Add student scene

        Button backbtn = new Button();

        Image image = new Image("back.png");
        ImageView back = new ImageView(image);
        back.setFitHeight(20);
        back.setFitWidth(20);
        backbtn.setGraphic(back);
        backbtn.setShape(new Circle());
        //backbtn.setStyle("-fx-background-color: transparent;");


        GridPane student_info = new GridPane();
        student_info.add(backbtn,0,0);
        student_info.setHgap(10);
        // student_info.setPadding(new Insets(0,0,25,25));
        student_info.setVgap(10);

        // student_info.add(comboBox,0,0);

        Text title = new Text("Enter Student info");
        title.setStyle("-fx-font-family: \"Arial Black\";");
        student_info.add(title,1,2);

        Label FirstName = new Label("First name:");
        student_info.add(FirstName, 1,3);

        TextField f_n = new TextField();
        student_info.add(f_n, 2,3);

        Label LastName = new Label("Last Name:");
        student_info.add(LastName,1,4);

        TextField l_n = new TextField();
        student_info.add(l_n,2,4);

        Label Age = new Label("Age:");
        student_info.add(Age,1,5);

        TextField age_view = new TextField();
        student_info.add(age_view,2,5);

        Label Studen_number = new Label("Student Number:");
        student_info.add(Studen_number,1,6);

        TextField s_n = new TextField();
        student_info.add(s_n,2,6);

        Button add_button = new Button();
        add_button.setText("Add");
        HBox abox = new HBox();
        abox.getChildren().add(add_button);
        abox.setAlignment(Pos.BOTTOM_RIGHT);
        student_info.add(abox,2,7);

        add_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String FIRST_NAME = f_n.getText();
                String LAST_NAME = l_n.getText();
                String AGE = age_view.getText();
                String STUDENT_NUMBER = s_n.getText();
                try {
                    gettingconnection.add_values(FIRST_NAME,LAST_NAME,Integer.parseInt(AGE), Integer.parseInt(STUDENT_NUMBER));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Scene add_student_scene = new Scene(student_info,400,275);

        // delete student scene
        VBox delete_student = new VBox();
        GridPane entername = new GridPane();
        entername.setPadding(new Insets(25,25,25,25));
        entername.setHgap(25);
        entername.setVgap(25);
        Label e_student_number = new Label("Enter Student Number to delete:");
        entername.add(e_student_number,0,0);
        TextField entered_student = new TextField();
        entername.add(entered_student,1,0);
        // back btn
        Button backbtn3= new Button();
        Image image3 = new Image("back.png");
        ImageView back3 = new ImageView(image3);
        back3.setFitHeight(20);
        back3.setFitWidth(20);
        backbtn3.setGraphic(back3);
        backbtn3.setShape(new Circle());
        VBox delete = new VBox();
        Button delete_btn = new Button();
        delete_btn.setText("Delete");
        delete.getChildren().add(delete_btn);
        delete.setAlignment(Pos.BOTTOM_RIGHT);
        final Text deleted = new Text();
        entername.add(delete,1,1);
        delete_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String data = entered_student.getText();
                Integer int_data = Integer.parseInt(data);
                Boolean flag = null;
                try {
                    flag = gettingconnection.delete_student(int_data);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (flag.equals(true)) {
                    deleted.setText("Student has been deleted");
                }
                else{deleted.setText("no matching Student found");}
                entername.add(deleted,1,2);
            }
        });

        VBox delete_back_box = new VBox();
        delete_back_box.setAlignment(Pos.TOP_LEFT);
        delete_back_box.getChildren().add(backbtn3);
        backbtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene2);
            }
        });
        delete_back_box.setAlignment(Pos.TOP_LEFT);
        delete_student.getChildren().addAll(delete_back_box, entername);

        Scene scene_delete = new Scene(delete_student, 400,275);





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
                String username = userTextField.getText();
                String password = pwbox.getText();

                if (username.equals("Haris") && password.equals("Faisal")) {
                    primaryStage.setScene(scene2);
                }
                else{
                    actiontarger.setFill(Color.FIREBRICK);
                    actiontarger.setText("Incorrect user name or password try again");
                }
            }
        });

        backbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene2);
            }
        });

        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent){
                String selected = comboBox.getSelectionModel().getSelectedItem().toString();
                if (selected.equals("Add Student")){
                    primaryStage.setScene(add_student_scene);
                } else if (selected.equals("View Student")){
                    Scene view_scene = Populating_view_students(gettingconnection.get_result(),scene2,
                            primaryStage);
                    primaryStage.setScene(view_scene);
                } else if (selected.equals("Delete Student")) {
                    primaryStage.setScene(scene_delete);
                }

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
