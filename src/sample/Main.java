package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;

public class Main extends Application {

    private  double sceneHeight = 500;
    private double sceneWidth = 500;


    @Override
    //Create the stage with a borderpane as a base, and add an Hbox to the top to read
    //user input and title. Attach a gridpane in the center to act as the tile map of AU
    //Attach the CSS sheet and start the GUI
    public void start(Stage primaryStage) throws Exception{
        BorderPane border = new BorderPane();
        Gridplane gridplane = new Gridplane();
        border.setTop(addHBox());
        border.setCenter(gridplane.addGridPane());
        Scene scene = new Scene(border, sceneWidth, sceneHeight);
        scene.getStylesheets().add("/css/style.css");
        primaryStage.setTitle("A* Class Pathfinder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //Function that creates an Hbox
    private HBox addHBox(){
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getStyleClass().add("hbox"); //add CSS class as "hbox"
        Label from = new Label ("Where from?"); //add a label and box of choices to pick from
        ChoiceBox wherefrom = new ChoiceBox(FXCollections.observableArrayList("Katzen",
                "MGC", "Batelle", "Kogod", "SIS", "Ward", "Library",
                "Kay", "Hurst", "Anderson", "Letts", "McKinley", "Leonard", "Cassell"));
        Label to = new Label ("Where to?"); //add a label and box of choices to pick from
        ChoiceBox whereto = new ChoiceBox(FXCollections.observableArrayList("Katzen",
                "MGC", "Batelle", "Kogod", "SIS", "Ward", "Library",
                "Kay", "Hurst", "Anderson", "Letts", "McKinley", "Leonard", "Cassell"));
        Button runIt = new Button("LETS GOOOOO"); //Add a button
        runIt.setOnAction(new EventHandler<ActionEvent>(){ //when button is clicked
            @Override
            public void handle(ActionEvent event) {
                Remap remap = new Remap();
                List<Integer[]> returned = remap.test(10, 38, 5, 5);
                //Runs the function to generate the red path based on returned coordinate arraylist
                Gridplane gridplane = new Gridplane();
                //Repaints the gridpane based on the red path
                gridplane.redraw(returned);
                
            }
        });
        to.getStyleClass().add("goclass");
        from.getStyleClass().add("goclass");
        hbox.getChildren().add(from);
        hbox.getChildren().add(wherefrom);
        hbox.getChildren().add(to);
        hbox.getChildren().add(whereto);
        hbox.getChildren().add(runIt);
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }






    public static void main(String[] args) {
        launch(args);
    }

}

