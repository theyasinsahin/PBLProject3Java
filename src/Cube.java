import java.util.Random;

public class Cube {
    Random random = new Random();
    private int x_force ;
    private int y_force ;
    private char x1_force ;
    private char x2_force ;
    private char y1_force ;
    private char y2_force ;
    private char[][] cube_array;
    private char[][] cube_array_on_demand;

    static void write(char str) {
        Game.cn.getTextWindow().output(str);
    }

    static void setCursor(int x, int y) {
        Game.cn.getTextWindow().setCursorPosition(x, y);
    }

    ///////////////////////////////Methods////////////////////////////////
    public void displayCube(char[][] cube_array,int cubeCX, int cubeCY) {
        for (int i = 0; i < cube_array.length; i++) {
            setCursor(cubeCX,cubeCY);
            for (int j = 0; j < cube_array[i].length; j++) {
                write(cube_array[i][j]);
            }
            cubeCY++;
        }
    }

    public char[][] createCubeOnDemand(int x_force, int y_force){
        this.x_force = x_force;
        this.x1_force =(char) ((this.x_force / 10) +48);
        this.x2_force = (char) ((this.x_force % 10) +48);

        this.y_force = y_force;
        this.y1_force = (char)((this.y_force / 10) +48);
        this.y2_force = (char)((this.y_force % 10) +48);

        cube_array_on_demand = new char[][]{
                {'+', '+', '+', '+', '+'},
                {'+', ' ', y1_force, ' ', '+'},
                {'+', x1_force, ' ', x2_force, '+'},
                {'+', ' ', y2_force, ' ', '+'},
                {'+', '+', '+', '+', '+'}
        };
        return cube_array_on_demand;
    }

    public char[][] createCube(int lower_bound){
        this.x_force = random.nextInt(76)+lower_bound;
        this.x1_force =(char) ((this.x_force / 10) +48);
        this.x2_force = (char) ((this.x_force % 10) +48);

        this.y_force = random.nextInt(76)+lower_bound;
        this.y1_force = (char)((this.y_force / 10) +48);
        this.y2_force = (char)((this.y_force % 10) +48);
        cube_array = new char[][]{
                {'+', '+', '+', '+', '+'},
                {'+', ' ', y1_force, ' ', '+'},
                {'+', x1_force, ' ', x2_force, '+'},
                {'+', ' ', y2_force, ' ', '+'},
                {'+', '+', '+', '+', '+'}
        };
        return cube_array;
    }

    public char[][] createCubeForComputer(){
        this.x_force = random.nextInt(70)+30;
        this.x1_force =(char) ((this.x_force / 10) +48);
        this.x2_force = (char) ((this.x_force % 10) +48);

        this.y_force = random.nextInt(70)+30;
        this.y1_force = (char)((this.y_force / 10) +48);
        this.y2_force = (char)((this.y_force % 10) +48);
        cube_array = new char[][]{
                {'+', '+', '+', '+', '+'},
                {'+', ' ', y1_force, ' ', '+'},
                {'+', x1_force, ' ', x2_force, '+'},
                {'+', ' ', y2_force, ' ', '+'},
                {'+', '+', '+', '+', '+'}
        };
        return cube_array;
    }

    public char[][] createEmptyCube() {
        this.x_force = 0;
        this.y_force = 0;
        cube_array = new char[][]{
                {'.','.','.','.','.'},
                {'.',' ',' ',' ','.'},
                {'.',' ',' ',' ','.'},
                {'.',' ',' ',' ','.'},
                {'.','.','.','.','.'}
        };
        return cube_array;
    }




    //////////////////////////////Getters/////////////////////////////////
    public char getX1_force() { return this.x1_force;}
    public char getX2_force() { return this.x2_force;}
    public char getY1_force() { return this.y1_force;}
    public char getY2_force() { return this.y2_force;}

    public int getX_force() {
        return x_force;
    }

    public int getY_force() {
        return y_force;
    }
    public char[][] getCube_array() { return this.cube_array;}


    ///////////////////////////////Setters////////////////////////////////

    public void setCube_array(char[][] cube_array) {
        this.cube_array = cube_array;
    }



}
