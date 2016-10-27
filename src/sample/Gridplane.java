package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GB on 10/24/16.
 */
public class Gridplane {
    static GridPane mGridpane;

    GridPane redraw(List<Integer[]> list){
        for(Integer[] coordinates: list){
            Rectangle rec = new Rectangle(7,7);
            rec.setFill(Color.RED);
            mGridpane.add(rec, coordinates[1]+1, coordinates[0]+1);
        }
        return mGridpane;
    }

    GridPane addGridPane() {
        int height = 50;
        int width = 40;
        GridPane grid = new GridPane();
        grid.setHgap(.2);
        grid.setVgap(.2);




        for (int i = 2; i < 20; i++) { //first bit of sidewalk after katzen vertical
            for (int j = 19; j < 21; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 19; i < 30; i++) { // second bit of sidewalk
            for (int j = 18; j < 20; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 30; i < 35; i++) { // third bit of sidewalk
            for (int j = 17; j < 19; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 34; i < 50; i++) { //last bit of sidewalk behind dorms
            for (int j = 15; j < 17; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 0; i < 2; i++) { //katzen
            for (int j = 10; j < 30; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 0; i < 3; i++) { //grass around katzen
            for (int j = 0; j < 10; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 0; i < 3; i++) { //grass around katzen
            for (int j = 30; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 6; i < 15; i++) { //kogod
            for (int j = 21; j < 27; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 4; i < 6; i++) { //walkway above kogod
            for (int j = 21; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 3; i < 4; i++) { //grass above kogod
            for (int j = 21; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 2; i < 3; i++) { //road 1
            for (int j = 0; j < 19; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#5e5c53"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 2; i < 3; i++) { //road 2
            for (int j = 21; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#5e5c53"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 1; i < 2; i++) { //sidewlak below Katzen
            for (int j = 0; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }


        for (int i = 4; i < 35; i++) { //left quad walk
            for (int j = 27; j < 28; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 4; i < 35; i++) { //right quad walk
            for (int j = 32; j < 33; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 6; i < 15; i++) { //ward building
            for (int j = 33; j < 39; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }


        for (int i = 6; i < 8; i++) { //Kay
            for (int j = 28; j < 32; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 8; i < 15; i++) { //grass below Kay
            for (int j = 28; j < 32; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 15; i < 16; i++) { //walkway betwween kogod and batelle
            for (int j = 21; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 16; i < 19; i++) { //batelle
            for (int j = 21; j < 27; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 19; i < 20; i++) { // sidewalk below batelle
            for (int j = 19; j < 32; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 16; i < 19; i++) { //grass in front of batelle
            for (int j = 28; j < 32; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 16; i < 21; i++) { //hurst
            for (int j = 33; j < 38; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 16; i < 21; i++) { //grass next to hurst
            for (int j = 38; j < 39; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 21; i < 22; i++) { // sidewalk below hurst
            for (int j = 33; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 20; i < 29; i++) { // MGC
            for (int j = 20; j < 27; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 20; i < 30; i++) { // grass in front of MGC
            for (int j = 28; j < 32; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 30; i < 31; i++) { // sidewalk below MGC (add more gcost later)
            for (int j = 19; j < 27; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 23; i < 29; i++) { // EQB
            for (int j = 33; j < 38; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 22; i < 30; i++) { // grass next to EQB
            for (int j = 38; j < 39; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 21; i < 23; i++) { // grass above to EQB
            for (int j = 33; j < 39; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 29; i < 30; i++) { // sidewalk below EQB
            for (int j = 33; j < 39; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 29; i < 30; i++) { // sidewalk below MGC
            for (int j = 20; j < 27; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }


        for (int i = 31; i < 35; i++) { // mckinley
            for (int j = 23; j < 27; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 31; i < 35; i++) { // sidewalk next to mckinley
            for (int j = 22; j < 23; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 31; i < 35; i++) { // grass next to mckinley
            for (int j = 19; j < 22; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 35; i < 36; i++) { // sidewalk below mckiney, library, to road
            for (int j = 5; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 30; i < 31; i++) { // sidewalk in front of lib
            for (int j = 27; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 31; i < 35; i++) { //library
            for (int j = 28; j < 32; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 31; i < 35; i++) { //SIS building
            for (int j = 33; j < 39; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 36; i < 39; i++) { //roper
            for (int j = 34; j < 39; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 40; i < 45; i++) { //gray
            for (int j = 34; j < 37; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 42; i < 45; i++) { //mccabe
            for (int j = 28; j < 33; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 36; i < 39; i++) { //clark
            for (int j = 28; j < 33; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 3; i < 50; i++) { // very right main sidewalk
            for (int j = 39; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 45; i < 46; i++) { // sidewalk below dorms to road
            for (int j = 5; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 39; i < 40; i++) { // sidewalk between small dorms horizontal
            for (int j = 27; j < 40; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 36; i < 46; i++) { // sidewalk between small dorms vertical
            for (int j = 33; j < 34; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 40; i < 42; i++) { // grass between small dorms
            for (int j = 28; j < 33; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 36; i < 46; i++) { // sidewalk between small dorms vertical
            for (int j = 26; j < 28; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 36; i < 45; i++) { // Letts
            for (int j = 23; j < 26; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 36; i < 45; i++) { // sidewalk between big dorms
            for (int j = 20; j < 23; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);
            }
        }

        for (int i = 36; i < 45; i++) { // Anderson
            for (int j = 17; j < 20; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 39; i < 42; i++) { // Centennial 1
            for (int j = 13; j < 16; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 36; i < 45; i++) { // Centennial 2
            for (int j = 10; j < 13; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }


        for (int i = 36; i < 39; i++) { // sidewalk around Centennial
            for (int j = 13; j < 15; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 42; i < 45; i++) { // sidewalk around Centennial
            for (int j = 13; j < 15; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 35; i < 46; i++) { // sidewalk behind Centennial (this needs to be fixed)
            for (int j = 4; j < 10; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }


        for (int i = 7; i < 15; i++) { //Hughes
            for (int j = 16; j < 19; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 6; i < 7; i++) { //road Hughes
            for (int j = 0; j < 19; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 3; i < 6; i++) { //Cassell
            for (int j = 0; j < 4; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 3; i < 6; i++) { //grass by Cassell
            for (int j = 4; j < 19; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 7; i < 13; i++) { //Leonard
            for (int j = 0; j < 4; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 7; i < 16; i++) { //sidewalk next to Leonard
            for (int j = 4; j < 5; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 13; i < 16; i++) { //sidewalk below to Leonard
            for (int j = 0; j < 4; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 16; i < 24; i++) { //sidewalk behind SCAN
            for (int j = 0; j < 1; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 15; i < 16; i++) { //sidewalk abover sports center
            for (int j = 0; j < 19; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 7; i < 10; i++) { //mcdowell
            for (int j = 5; j < 12; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 7; i < 10; i++) { //grass around mcdowell
            for (int j = 12; j < 16; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 10; i < 15; i++) { //grass around mcdowell
            for (int j = 5; j < 16; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 16; i < 19; i++) { //sports building 1
            for (int j = 1; j < 19; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 19; i < 24; i++) { //sports building 2
            for (int j = 1; j < 18; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 24; i < 25; i++) { //sidewalk between asbury and sports
            for (int j = 0; j < 18; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 25; i < 30; i++) { //Asbury
            for (int j = 6; j < 18; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 25; i < 30; i++) { //Building behind Asbury (Osborn)
            for (int j = 0; j < 2; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 25; i < 30; i++) { //Parking lot behind Asbury
            for (int j = 2; j < 6; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 30; i < 32; i++) { //More parking lot by Asbury
            for (int j = 0; j < 17; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 32; i < 34; i++) { //Grassy area in front of Beegly
            for (int j = 4; j < 17; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 34; i < 35; i++) { // more grassy area in front of Beegly
            for (int j = 4; j < 15; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 32; i < 37; i++) { // Beegly
            for (int j = 0; j < 4; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 37; i < 39; i++) { //sidewalk below Beegly
            for (int j = 0; j < 4; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.getStyleClass().add(String.format("a%d%d",i,j));
                rec.setFill(Color.web("#959EA8"));
                grid.add(rec, j+1, i+1);            }
        }

        for (int i = 39; i < 43; i++) { // media production center
            for (int j = 0; j < 4; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#794628"));
                grid.add(rec, j+1, i+1);              }
        }

        for (int i = 43; i < 46; i++) { // grass below media production center
            for (int j = 0; j < 4; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 46; i < 50; i++) { // bottom finishing grass 1
            for (int j = 0; j < 15; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 46; i < 50; i++) { // bottom finishing grass 2
            for (int j = 17; j < 39; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }

        for (int i = 40; i < 45; i++) { // grass behind gray
            for (int j = 37; j < 39; j++) {
                Rectangle rec = new Rectangle(7,7);
                rec.setFill(Color.web("#30e849"));
                grid.add(rec, j+1, i+1);             }
        }


        grid.setAlignment(Pos.CENTER);
        mGridpane = grid;
        return grid;
    }
}
