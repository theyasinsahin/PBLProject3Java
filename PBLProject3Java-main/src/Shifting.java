public class Shifting {
    public Piece shiftToLeft(Piece piece){
        Cube cube1Tmp = piece.getCubes()[0][0];
        Cube cube2Tmp = piece.getCubes()[0][1];
        Cube cube3Tmp = piece.getCubes()[0][2];
        Cube cube4Tmp = piece.getCubes()[1][0];
        Cube cube5Tmp = piece.getCubes()[1][1];
        Cube cube6Tmp = piece.getCubes()[1][2];
        Cube cube7Tmp = piece.getCubes()[2][0];
        Cube cube8Tmp = piece.getCubes()[2][1];
        Cube cube9Tmp = piece.getCubes()[2][2];

        piece.setCubesElement(cube2Tmp, 0, 0);
        piece.setCubesElement(cube3Tmp, 0, 1);
        piece.setCubesElement(cube1Tmp, 0, 2);
        piece.setCubesElement(cube5Tmp, 1, 0);
        piece.setCubesElement(cube6Tmp, 1, 1);
        piece.setCubesElement(cube4Tmp, 1, 2);
        piece.setCubesElement(cube8Tmp, 2, 0);
        piece.setCubesElement(cube9Tmp, 2, 1);
        piece.setCubesElement(cube7Tmp, 2, 2);

        return piece;
    }

    public Piece shiftToUp(Piece piece){
        Cube cube1Tmp = piece.getCubes()[0][0];
        Cube cube2Tmp = piece.getCubes()[0][1];
        Cube cube3Tmp = piece.getCubes()[0][2];
        Cube cube4Tmp = piece.getCubes()[1][0];
        Cube cube5Tmp = piece.getCubes()[1][1];
        Cube cube6Tmp = piece.getCubes()[1][2];
        Cube cube7Tmp = piece.getCubes()[2][0];
        Cube cube8Tmp = piece.getCubes()[2][1];
        Cube cube9Tmp = piece.getCubes()[2][2];

        piece.setCubesElement(cube4Tmp, 0, 0);
        piece.setCubesElement(cube5Tmp, 0, 1);
        piece.setCubesElement(cube6Tmp, 0, 2);
        piece.setCubesElement(cube7Tmp, 1, 0);
        piece.setCubesElement(cube8Tmp, 1, 1);
        piece.setCubesElement(cube9Tmp, 1, 2);
        piece.setCubesElement(cube1Tmp, 2, 0);
        piece.setCubesElement(cube2Tmp, 2, 1);
        piece.setCubesElement(cube3Tmp, 2, 2);

        return piece;
    }
}
