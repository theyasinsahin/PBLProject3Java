public class Robot {
    Cube [][] cubes=new Cube[5][5];
    Cube cube1 = new Cube();
    Cube cube2 = new Cube();
    Cube cube3 = new Cube();
    Cube cube4 = new Cube();
    Cube cube5 = new Cube();
    Cube cube6 = new Cube();
    Cube cube7 = new Cube();
    Cube cube8 = new Cube();
    Cube cube9 = new Cube();
    Cube cube10 = new Cube();
    Cube cube11 = new Cube();
    Cube cube12 = new Cube();
    Cube cube13= new Cube();
    Cube cube14 = new Cube();

    public Robot(Cube[][] cubes) {
        this.cubes = cubes;
    }
    public Robot(){

        cubes[0][2]=cube1;
        cubes[1][0]=cube2;
        cubes[1][1]=cube3;
        cubes[1][2]=cube4;
        cubes[1][3]=cube5;
        cubes[1][4]=cube6;
        cubes[2][1]=cube7;
        cubes[2][2]=cube8;
        cubes[2][3]=cube9;
        cubes[3][1]=cube10;
        cubes[3][2]=cube11;
        cubes[3][3]=cube12;
        cubes[4][1]=cube13;
        cubes[4][3]=cube14;

    }

    public void creatRobot(){
        cubes[0][0]=null;
        cubes[0][1]=null;
        cubes[0][2].createEmptyCube();
        cubes[0][3]=null;
        cubes[0][4]=null;
        cubes[1][0].createEmptyCube();
        cubes[1][1].createEmptyCube();
        cubes[1][2].createEmptyCube();
        cubes[1][3].createEmptyCube();
        cubes[1][4].createEmptyCube();
        cubes[2][0]=null;
        cubes[2][1].createEmptyCube();
        cubes[2][2].createEmptyCube();
        cubes[2][3].createEmptyCube();
        cubes[2][4]=null;
        cubes[3][0]=null;
        cubes[3][1].createEmptyCube();
        cubes[3][2].createEmptyCube();
        cubes[3][3].createEmptyCube();
        cubes[3][4]=null;
        cubes[4][0]=null;
        cubes[4][1].createEmptyCube();
        cubes[4][3].createEmptyCube();
        cubes[4][2]=null;
        cubes[4][4]=null;


    }

    public Cube[][] getCubes() {
        return cubes;
    }
}
