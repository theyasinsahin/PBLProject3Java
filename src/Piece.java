import java.util.Random;

public class Piece {
    private int xCursorOnRobot;
    private int yCursorOnRobot;
    private int xIdxOnRobot;
    private int yIdxOnRobot;
    private boolean isSelected;
    private int xCoordinate;
    private int yCoordinate;
    Random random = new Random();
    public Cube[][] Cubes = new Cube[3][3];
    Cube cube1 = new Cube();
    Cube cube2 = new Cube();
    Cube cube3 = new Cube();
    Cube cube4 = new Cube();
    Cube cube5 = new Cube();
    Cube cube6 = new Cube();
    Cube cube7 = new Cube();
    Cube cube8 = new Cube();
    Cube cube9 = new Cube();

    public Piece(){
        isSelected = false;
        Cubes[0][0] = cube1;
        Cubes[0][1] = cube2;
        Cubes[0][2] = cube3;
        Cubes[1][0] = cube4;
        Cubes[1][1] = cube5;
        Cubes[1][2] = cube6;
        Cubes[2][0] = cube7;
        Cubes[2][1] = cube8;
        Cubes[2][2] = cube9;
    }


    int shape;


    public void fourCubePiece(){
        this.shape = random.nextInt(1,5);

        if(shape == 1){
            Cubes[0][0].createCube(24);
            Cubes[0][1] = null;
            Cubes[0][2] = null;
            Cubes[1][0].createCube(24);
            Cubes[1][1].createCube(24);
            Cubes[1][2].createCube(24);
            Cubes[2][0] = null;
            Cubes[2][1] = null;
            Cubes[2][2] = null;
        }
        else if(shape == 2){
            Cubes[0][0] = null;
            Cubes[0][1].createCube(24);
            Cubes[0][2] = null;
            Cubes[1][0].createCube(24);
            Cubes[1][1].createCube(24);
            Cubes[1][2].createCube(24);
            Cubes[2][0] = null;
            Cubes[2][1] = null;
            Cubes[2][2] = null;
        }
        else if(shape == 3){
            Cubes[0][0] =  null;
            Cubes[0][1].createCube(24);
            Cubes[0][2].createCube(24);
            Cubes[1][0].createCube(24);
            Cubes[1][1].createCube(24);
            Cubes[1][2] =  null;
            Cubes[2][0] =  null;
            Cubes[2][1] =  null;
            Cubes[2][2] =  null;
        }
        else if(shape == 4){
            Cubes[0][0].createCube(24);
            Cubes[0][1].createCube(24);
            Cubes[0][2] = null;
            Cubes[1][0].createCube(24);
            Cubes[1][1].createCube(24);
            Cubes[1][2] = null;
            Cubes[2][0] = null;
            Cubes[2][1] = null;
            Cubes[2][2] = null;
        }
    }

    public void threeCubePiece(){
        this.shape = random.nextInt(1,3);
        if(shape == 1){
            Cubes[0][0].createCube(12);
            Cubes[0][1] = null;
            Cubes[0][2] = null;
            Cubes[1][0].createCube(12);
            Cubes[1][1].createCube(12);
            Cubes[1][2] = null;
            Cubes[2][0] = null;
            Cubes[2][1] = null;
            Cubes[2][2] = null;
        }
        else if(shape == 2){
            Cubes[0][0].createCube(12);
            Cubes[0][1].createCube(12);
            Cubes[0][2].createCube(12);
            Cubes[1][0] = null;
            Cubes[1][1] = null;
            Cubes[1][2] = null;
            Cubes[2][0] = null;
            Cubes[2][1] = null;
            Cubes[2][2] = null;
        }
    }

    public void twoCubePiece(){
        Cubes[0][0].createCube(6);
        Cubes[0][1].createCube(6);
        Cubes[0][2] = null;
        Cubes[1][0] = null;
        Cubes[1][1] = null;
        Cubes[1][2] = null;
        Cubes[2][0] = null;
        Cubes[2][1] = null;
        Cubes[2][2] = null;
    }

    public void oneCubePiece(){

        cube1.createCube(0);
        Cubes[0][0].createCube(0);
        Cubes[0][1] = null;
        Cubes[0][2] = null;
        Cubes[1][0] = null;
        Cubes[1][1] = null;
        Cubes[1][2] = null;
        Cubes[2][0] = null;
        Cubes[2][1] = null;
        Cubes[2][2] = null;
    }

    //GETTERS AND SETTERS

    public  Cube[][] getCubes() {
        return Cubes;
    }

    public void setCubesElement(Cube cube, int i, int j) {
        Cubes[i][j] = cube;
    }
    public void setCubes(Cube[][] cubes) {
        Cubes = cubes;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getxIdxOnRobot() {
        return xIdxOnRobot;
    }

    public void setxIdxOnRobot(int xIdxOnRobot) {
        this.xIdxOnRobot = xIdxOnRobot;
    }

    public int getyIdxOnRobot() {
        return yIdxOnRobot;
    }

    public void setyIdxOnRobot(int yIdxOnRobot) {
        this.yIdxOnRobot = yIdxOnRobot;
    }

    public int getxCursorOnRobot() {
        return xCursorOnRobot;
    }

    public void setxCursorOnRobot(int xCursorOnRobot) {
        this.xCursorOnRobot = xCursorOnRobot;
    }

    public int getyCursorOnRobot() {
        return yCursorOnRobot;
    }

    public void setyCursorOnRobot(int yCursorOnRobot) {
        this.yCursorOnRobot = yCursorOnRobot;
    }
}
