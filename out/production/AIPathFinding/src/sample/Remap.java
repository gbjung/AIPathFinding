package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Remap{

    static class tile{
        private String type;
        private int x; // Coordinates
        private int y;

        double hcost; //Heuristic cost
        double gcost; //Greedy cost
        double fcost; //Final cost

        tile parent;
        tile(int x, int y, String type, double gcost){ //Tile class for composing map
            this.x = x;
            this.y = y;
            this.type = type;
            this.gcost = gcost;
        }
    }


    static int startx, starty; //Start tile
    static int endx, endy; //End tile

    static void setstart(int x,int y){ //Setter
        startx = x;
        starty = y;
    }

    static void setend(int x, int y){ //Setter
        endx = x;
        endy = y;
    }


    static tile[][] grid = new tile[40][50];
    static PriorityQueue<tile> open; //Open list for A* implementation
    static boolean [][] closed; //Closed list for A* implementation

    public static void updatecost(tile curr, tile comp, double cost){ //Function for updating tile cost used in algorithm
        if(comp == null || closed[comp.x][comp.y])
            return;

        double compfinalcost = comp.hcost + comp.gcost;

        boolean inopen = open.contains(comp);
        if(!inopen || compfinalcost < comp.fcost)
            comp.fcost = compfinalcost;
        comp.parent = curr;
        if(!inopen)
            open.add(comp);
    }


    public static void astar(){ //Algorithm implementation, based on code from http://www.codebytes.in/2015/02/a-shortest-path-finding-algorithm.html
        open.add(grid[startx][starty]);

        tile current;

        while(true) {
            current = open.poll();
            closed[current.x][current.y] = true;

            if (current.equals(grid[endx][endy])) {
                return;
            }

            tile comp;

            if (current.x - 1 >= 0) {
                comp = grid[current.x - 1][current.y];
                updatecost(current, comp, current.fcost);

                if (current.y - 1 >= 0) {
                    comp = grid[current.x - 1][current.y - 1];
                    updatecost(current, comp, current.fcost);
                }

                if (current.y + 1 < grid[0].length) {
                    comp = grid[current.x - 1][current.y + 1];
                    updatecost(current, comp, current.fcost);
                }
            }

            if (current.y - 1 >= 0) {
                comp = grid[current.x][current.y - 1];
                updatecost(current, comp, current.fcost);
            }

            if (current.y + 1 < grid[0].length) {
                comp = grid[current.x][current.y + 1];
                updatecost(current, comp, current.fcost);

            }

            if (current.x + 1 < grid.length) {
                comp = grid[current.x + 1][current.y];
                updatecost(current, comp, current.fcost);

                if (current.y - 1 >= 0) {
                    comp = grid[current.x + 1][current.y - 1];
                    updatecost(current, comp, current.fcost);
                }

                if (current.y + 1 < grid[0].length) {
                    comp = grid[current.x + 1][current.y + 1];
                    updatecost(current,comp, current.fcost);

                }

            }
        }
    }

    public List<Integer[]> pathfind(int si, int sj, int ei, int ej){ //Implementation of algorithm on campus map

        grid = new tile[50][40]; //Map build starts here. Decided that cost of 1 for sidewalk, 3 for building, 4 for grass created most accurate paths.

        for (int i = 2; i < 20; i++) { //First bit of sidewalk after Katzen
            for (int j = 19; j < 21; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 19; i < 30; i++) { //Second bit of sidewalk
            for (int j = 18; j < 20; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 30; i < 35; i++) { //Third bit of sidewalk
            for (int j = 17; j < 19; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 34; i < 50; i++) { //Last bit of sidewalk behind dorms
            for (int j = 15; j < 17; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 0; i < 2; i++) { //Katzen
            for (int j = 10; j < 30; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 0; i < 3; i++) { //Grass around Katzen
            for (int j = 0; j < 10; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 0; i < 3; i++) { //Grass around Katzen
            for (int j = 30; j < 40; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 6; i < 15; i++) { //Kogod
            for (int j = 21; j < 27; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 4; i < 6; i++) { //Walkway above Kogod
            for (int j = 21; j < 40; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 3; i < 4; i++) { //Grass above Kogod
            for (int j = 21; j < 40; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 2; i < 3; i++) { //Road 1
            for (int j = 0; j < 19; j++) {
                grid[i][j] = new tile(i, j, "road", 20);
            }
        }

        for (int i = 2; i < 3; i++) { //Road 2
            for (int j = 21; j < 40; j++) {
                grid[i][j] = new tile(i, j, "road", 20);
            }
        }

        for (int i = 1; i < 2; i++) { //Sidewalk below Katzen
            for (int j = 0; j < 40; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }


        for (int i = 4; i < 35; i++) { //Left quad walk
            for (int j = 27; j < 28; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 4; i < 35; i++) { //Right quad walk
            for (int j = 32; j < 33; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 6; i < 15; i++) { //Ward building
            for (int j = 33; j < 39; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }


        for (int i = 6; i < 8; i++) { //Kay
            for (int j = 28; j < 32; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 8; i < 15; i++) { //Grass below Kay
            for (int j = 28; j < 32; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 15; i < 16; i++) { //Walkway between Kogod and Batelle
            for (int j = 21; j < 40; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 16; i < 19; i++) { //Batelle
            for (int j = 21; j < 27; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 19; i < 20; i++) { //Sidewalk below Batelle
            for (int j = 19; j < 32; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 16; i < 19; i++) { //Grass in front of Batelle
            for (int j = 28; j < 32; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 16; i < 21; i++) { //Hurst
            for (int j = 33; j < 38; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 16; i < 21; i++) { //Grass next to Hurst
            for (int j = 38; j < 39; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 21; i < 22; i++) { //Sidewalk below Hurst
            for (int j = 33; j < 40; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 20; i < 29; i++) { //MGC
            for (int j = 20; j < 27; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 20; i < 30; i++) { //Grass in front of MGC
            for (int j = 28; j < 32; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 30; i < 31; i++) { //Sidewalk below MGC
            for (int j = 19; j < 27; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 23; i < 29; i++) { //EQB
            for (int j = 33; j < 38; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 22; i < 30; i++) { //Grass next to EQB
            for (int j = 38; j < 39; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 21; i < 23; i++) { //Grass above to EQB
            for (int j = 33; j < 39; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 29; i < 30; i++) { //Sidewalk below EQB
            for (int j = 33; j < 39; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 29; i < 30; i++) { //Sidewalk below MGC
            for (int j = 20; j < 27; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }


        for (int i = 31; i < 35; i++) { //Mckinley
            for (int j = 23; j < 27; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 31; i < 35; i++) { //Sidewalk next to Mckinley
            for (int j = 22; j < 23; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 31; i < 35; i++) { //Grass next to Mckinley
            for (int j = 19; j < 22; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 35; i < 36; i++) { //Sidewalk below Mckinley, library, to road
            for (int j = 5; j < 40; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 30; i < 31; i++) { //Sidewalk in front of library
            for (int j = 27; j < 40; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 31; i < 35; i++) { //Library
            for (int j = 28; j < 32; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 31; i < 35; i++) { //SIS building
            for (int j = 33; j < 39; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 36; i < 39; i++) { //Roper
            for (int j = 34; j < 39; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 40; i < 45; i++) { //Gray
            for (int j = 34; j < 37; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 42; i < 45; i++) { //Mccabe
            for (int j = 28; j < 33; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 36; i < 39; i++) { //Clark
            for (int j = 28; j < 33; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 3; i < 50; i++) { //Very right main sidewalk
            for (int j = 39; j < 40; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 45; i < 46; i++) { //Sidewalk below dorms to road
            for (int j = 5; j < 40; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 39; i < 40; i++) { //Sidewalk between small dorms horizontal
            for (int j = 27; j < 40; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 36; i < 46; i++) { //Sidewalk between small dorms vertical
            for (int j = 33; j < 34; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 40; i < 42; i++) { //Grass between small dorms
            for (int j = 28; j < 33; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 36; i < 46; i++) { //Sidewalk between small dorms vertical
            for (int j = 26; j < 28; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 36; i < 45; i++) { //Letts
            for (int j = 23; j < 26; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 36; i < 45; i++) { // Sidewalk between big dorms
            for (int j = 20; j < 23; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 36; i < 45; i++) { // Anderson
            for (int j = 17; j < 20; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 39; i < 42; i++) { //Centennial 1
            for (int j = 13; j < 16; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 36; i < 45; i++) { // Centennial 2
            for (int j = 10; j < 13; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }


        for (int i = 36; i < 39; i++) { // Sidewalk around Centennial
            for (int j = 13; j < 15; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 42; i < 45; i++) { // Sidewalk around Centennial
            for (int j = 13; j < 15; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 35; i < 46; i++) { // Sidewalk behind Centennial
            for (int j = 4; j < 10; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }


        for (int i = 7; i < 15; i++) { //Hughes
            for (int j = 16; j < 19; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 6; i < 7; i++) { //Hughes Road
            for (int j = 0; j < 19; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 3; i < 6; i++) { //Cassell
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 3; i < 6; i++) { //Grass by Cassell
            for (int j = 4; j < 19; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 7; i < 13; i++) { //Leonard
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 7; i < 16; i++) { //Sidewalk next to Leonard
            for (int j = 4; j < 5; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 13; i < 16; i++) { //Sidewalk below to Leonard
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 16; i < 24; i++) { //Sidewalk behind SCAN
            for (int j = 0; j < 1; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 15; i < 16; i++) { //Sidewalk above sports center
            for (int j = 0; j < 19; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 7; i < 10; i++) { //Mcdowell
            for (int j = 5; j < 12; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 7; i < 10; i++) { //Grass around Mcdowell
            for (int j = 12; j < 16; j++) {
                grid[i][j] = new tile(i, j, "grass", 3);
            }
        }

        for (int i = 10; i < 15; i++) { //Grass around Mcdowell
            for (int j = 5; j < 16; j++) {
                grid[i][j] = new tile(i, j, "grass", 3);
            }
        }

        for (int i = 16; i < 19; i++) { //Sports building 1
            for (int j = 1; j < 19; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 19; i < 24; i++) { //Sports building 2
            for (int j = 1; j < 18; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 24; i < 25; i++) { //Sidewalk between Asbury and sports
            for (int j = 0; j < 18; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 25; i < 30; i++) { //Asbury
            for (int j = 6; j < 18; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 25; i < 30; i++) { //Building behind Asbury (Osborn)
            for (int j = 0; j < 2; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 25; i < 30; i++) { //Parking lot behind Asbury
            for (int j = 2; j < 6; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 30; i < 32; i++) { //More parking lot by Asbury
            for (int j = 0; j < 17; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 32; i < 34; i++) { //Grassy area in front of Beegly
            for (int j = 4; j < 17; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 34; i < 35; i++) { // More grassy area in front of Beegly
            for (int j = 4; j < 15; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 32; i < 37; i++) { // Beegly
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 37; i < 39; i++) { //Sidewalk below Beegly
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new tile(i, j, "sidewalk", 1);
            }
        }

        for (int i = 39; i < 43; i++) { // Media production center
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new tile(i, j, "building", 3);
            }
        }

        for (int i = 43; i < 46; i++) { // Grass below media production center
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 46; i < 50; i++) { // Bottom finishing grass 1
            for (int j = 0; j < 15; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 46; i < 50; i++) { // Bottom finishing grass 2
            for (int j = 17; j < 39; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }

        for (int i = 40; i < 45; i++) { // Grass behind gray
            for (int j = 37; j < 39; j++) {
                grid[i][j] = new tile(i, j, "grass", 4);
            }
        }


        closed = new boolean[50][40]; // Create closed list

        open = new PriorityQueue<>((Object o1, Object o2) -> { //Set up priority queue for our purposes
            tile c1 = (tile)o1;
            tile c2 = (tile)o2;

            return c1.fcost<c2.fcost?-1:
                    c1.fcost>c2.fcost?1:0;
        });

        setstart(si, sj);
        setend(ei, ej);

        for(int i=0;i<50;++i){ //Generate heuristic cost with using start and end coordinates
            for(int j=0;j<40;++j){
                grid[i][j].hcost = Math.abs(i-endx)+Math.abs(j-endy);
            }
        }
        grid[si][sj].fcost = 0;

        astar();//Use algorithm on map

        List<Integer[]> thepath = new ArrayList<Integer[]>(); //After calling the algorithm on the map with the start and end
        if(closed[endx][endy]){                       //coords this creates the best path to be printed
            tile current = grid[endx][endy];
            while(current.parent!=null){
                Integer[] point = {current.parent.x, current.parent.y};
                thepath.add(point);
                grid[current.parent.x][current.parent.y] = new tile(current.parent.x,current.parent.y,"best path!",22);
                current = current.parent;
            }
            System.out.println();
        }

        return thepath;

    }

}