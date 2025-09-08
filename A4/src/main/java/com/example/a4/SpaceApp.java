package com.example.a4;

//Talha Mansoor
//kgy284
//11346490
//Assignment 4


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// SpaceApp as the main application class
public class SpaceApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        SpaceModel model = new SpaceModel();
        InteractionModel interactionModel = new InteractionModel();
        SpaceView view = new SpaceView(model, 600); // Assume canvas size 600x600

        // Control panel

        // Miniature view
        SpaceView miniatureView = new SpaceView(model, 200); //  smaller size
        // Cursor view
        CursorView cursorView = new CursorView(model, 200); //  smaller size
        SpaceController controller = new SpaceController(model, view, interactionModel, cursorView,miniatureView);
        ControlPanelView controlPanelView = new ControlPanelView(controller);
        view.setOnMouseMoved(event -> {
            double x = event.getX() / view.getWidth();
            double y = event.getY() / view.getHeight();
            view.setCursorPosition(x, y);  // Update cursor position in the main view
            cursorView.setCursorPosition(x, y);  // Update cursor position in the cursor view
            // cursorView.draw();
        });


        MainUI mainUI = new MainUI(model, view,cursorView,miniatureView,controller);
        // Create 10 asteroids
        for (int i = 0; i < 10; i++) {
            model.createAsteroid();
        }
        VBox leftPanel = new VBox();
        leftPanel.getChildren().addAll(miniatureView, cursorView, controlPanelView);

        HBox root = new HBox();
        root.getChildren().addAll(leftPanel, view); // Add the left-side panel to the main view

        Scene scene = new Scene(root, 800, 600);
        //StackPane root = new StackPane();
       // root.getChildren().add(view);
        //Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Space MVC Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}