package com.example.handman;
//Dev:Justin Fredericks
//Date:2/12/2022
//Class: 171
//Script: Hang Man w JavaFX
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    int count=1;
    @Override
    public void start(Stage stage) throws IOException {

        Pane pane = new Pane();

        //region set shape objects
        Line line1 = new Line(10, 10, 10, 10);
        line1.setStartX(100);
        line1.setStartY(800);
        line1.setEndX(400);
        line1.setEndY(800);
        line1.setStrokeWidth(5);
        line1.setStroke(Color.BLACK);
        pane.getChildren().add(line1);

        Line line2 = new Line(10, 10, 10, 10);
        line2.setStartX(200);
        line2.setStartY(800);
        line2.setEndX(200);
        line2.setEndY(200);
        line2.setStrokeWidth(5);
        line2.setStroke(Color.BLACK);
        pane.getChildren().add(line2);

        Line line3 = new Line(10, 10, 10, 10);
        line3.startXProperty().bind(line2.endXProperty());
        line3.startYProperty().bind(line2.endYProperty());
        line3.setEndX(600);
        line3.setEndY(200);
        line3.setStrokeWidth(5);
        line3.setStroke(Color.BLACK);
        pane.getChildren().add(line3);

        Line line4 = new Line(10, 10, 10, 10);
        line4.startXProperty().bind(line3.endXProperty());
        line4.startYProperty().bind(line3.endYProperty());
        line4.setEndX(600);
        line4.setEndY(250);
        line4.setStrokeWidth(5);
        line4.setStroke(Color.BLACK);
        pane.getChildren().add(line4);

        Circle head = new Circle();
        head.setRadius(40);
        head.centerXProperty().bind(line4.endXProperty());
        head.centerYProperty().bind(line4.endYProperty().add(40));
        head.setStroke(Color.BLACK);
        head.setStrokeWidth(4);
        head.setFill(Color.WHITE);
       // pane.getChildren().add(head);

        Line neck = new Line();
        neck.startXProperty().bind(head.centerXProperty());
        neck.startYProperty().bind(head.centerYProperty().add(40));
        neck.setEndX(600);
        neck.setEndY(450);
        neck.setStrokeWidth(4);
        neck.setStroke(Color.BLACK);
        //pane.getChildren().add(neck);

        Line armRight = new Line();
        armRight.startXProperty().bind(neck.endXProperty());
        armRight.startYProperty().bind(neck.endYProperty());
        armRight.setEndX(700);
        armRight.setEndY(350);
        armRight.setStrokeWidth(4);
        armRight.setStroke(Color.BLACK);
        //pane.getChildren().add(armRight);

        Line armLeft = new Line();
        armLeft.startXProperty().bind(neck.endXProperty());
        armLeft.startYProperty().bind(neck.endYProperty());
        armLeft.setEndX(500);
        armLeft.setEndY(350);
        armLeft.setStrokeWidth(4);
        armLeft.setStroke(Color.BLACK);
        //pane.getChildren().add(armLeft);

        Line body = new Line();
        body.startXProperty().bind(neck.endXProperty());
        body.startYProperty().bind(neck.endYProperty());
        body.setEndX(600);
        body.setEndY(600);
        body.setStrokeWidth(4);
        body.setStroke(Color.BLACK);
        //pane.getChildren().add(body);

        Line legRight = new Line();
        legRight.startXProperty().bind(body.endXProperty());
        legRight.startYProperty().bind(body.endYProperty());
        legRight.setEndX(500);
        legRight.setEndY(750);
        legRight.setStrokeWidth(4);
        legRight.setStroke(Color.BLACK);
        //pane.getChildren().add(legRight);

        Line lefLeft = new Line();
        lefLeft.startXProperty().bind(body.endXProperty());
        lefLeft.startYProperty().bind(body.endYProperty());
        lefLeft.setEndX(700);
        lefLeft.setEndY(750);
        lefLeft.setStrokeWidth(4);
        lefLeft.setStroke(Color.BLACK);
        //pane.getChildren().add(lefLeft);
        //endregion

        Button btn = new Button("Strike");
        btn.setLayoutX(500);
        btn.setLayoutY(900);
        pane.getChildren().add(btn);

        //set on click action for btn
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if(event.getSource()==btn) {//chek for specific node, in this case button
                    //switch used to control order of character creation incrementing var count
                    switch (count) {
                        case 1:
                            pane.getChildren().add(head);
                            break;
                        case 2:
                            pane.getChildren().add(neck);
                            break;
                        case 3:
                            pane.getChildren().add(armLeft);
                            break;
                        case 4:
                            pane.getChildren().add(armRight);
                            break;
                        case 5:
                            pane.getChildren().add(body);
                            break;
                        case 6:
                            pane.getChildren().add(legRight);
                            break;
                        case 7:
                            pane.getChildren().add(lefLeft);
                            break;
                        default:

                    }
                    count++;
                }

            }
        });

        Scene scene = new Scene(pane,1000,1000);
        stage.setTitle("ShowRectangle");
        stage.setScene(scene);
        stage.show();

    }//

    public static void main(String[] args) {
        launch();
    }
}