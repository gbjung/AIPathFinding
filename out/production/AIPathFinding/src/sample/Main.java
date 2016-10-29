package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.util.Observable;

public class Main extends Application {

    private  double sceneHeight = 500;
    private double sceneWidth = 500;

    int xchoice1 = 0;
    int ychoice1 = 0;
    int xchoice2 = 20;
    int ychoice2 = 20;
    String start = "Kogod";
    String end = "Batelle";

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
        final String [] movechoices = new String []{"Katzen", //part of attempt at improving interface (route choice)
                "MGC", "Batelle", "Kogod", "SIS", "Ward", "Library",
                "Kay", "Hurst", "Anderson", "Letts", "McKinley", "Leonard", "Cassell"};

        Label from = new Label ("Where from?"); //add a label and box of choices to pick from\
        ChoiceBox wherefrom = new ChoiceBox(FXCollections.observableArrayList("Katzen",
                "MGC", "Batelle", "Kogod", "SIS", "Ward", "Library",
                "Kay", "Hurst", "Anderson", "Letts", "McKinley", "Leonard", "Cassell"));

        wherefrom.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() { //Attempt at setting start coords
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                start = movechoices[newValue.intValue()];
            }
        });

        Label to = new Label ("Where to?"); //add a label and box of choices to pick from
        ChoiceBox whereto = new ChoiceBox(FXCollections.observableArrayList("Katzen",
                "MGC", "Batelle", "Kogod", "SIS", "Ward", "Library",
                "Kay", "Hurst", "Anderson", "Letts", "McKinley", "Leonard", "Cassell"));
        wherefrom.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() { //Attempt at setting end coords
            @Override                                                                                    //Something went wrong with this
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                end = movechoices[newValue.intValue()];
            }
        });

        Button runIt = new Button("LETS GOOOOO"); //Add a button
        runIt.setOnAction(new EventHandler<ActionEvent>(){ //when button is clicked
            @Override
            public void handle(ActionEvent event) {
                if(start.equals("Katzen")){
                    xchoice1 = 0;
                    ychoice1 = 10;
                }

                if(end.equals("SIS")){ //Couldn't get this to work. Was part of attempt at improving interface
                    xchoice2 = 39;     //Left this in just to show we worked on it
                    ychoice2 = 39;     //If we got it working we would have entered coords for all buildings
                }

                Remap remap = new Remap();
                List<Integer[]> returned = remap.pathfind(xchoice1,ychoice1,xchoice2,ychoice2);
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

