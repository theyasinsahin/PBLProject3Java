public class Reverse {

    public Piece takeTheReverse(Piece piece){
        Shifting shifting = new Shifting();

        // KÜPLERİN YERİNİN DEĞİŞMESİ
        Cube cube1Tmp = piece.getCubes()[0][0];
        Cube cube2Tmp = piece.getCubes()[0][1];
        Cube cube3Tmp = piece.getCubes()[0][2];
        Cube cube4Tmp = piece.getCubes()[1][0];
        Cube cube5Tmp = piece.getCubes()[1][1];
        Cube cube6Tmp = piece.getCubes()[1][2];
        Cube cube7Tmp = piece.getCubes()[2][0];
        Cube cube8Tmp = piece.getCubes()[2][1];
        Cube cube9Tmp = piece.getCubes()[2][2];

        piece.setCubesElement(cube3Tmp, 0, 0);
        piece.setCubesElement(cube2Tmp, 0, 1);
        piece.setCubesElement(cube1Tmp, 0, 2);
        piece.setCubesElement(cube6Tmp, 1, 0);
        piece.setCubesElement(cube5Tmp, 1, 1);
        piece.setCubesElement(cube4Tmp, 1, 2);
        piece.setCubesElement(cube9Tmp, 2, 0);
        piece.setCubesElement(cube8Tmp, 2, 1);
        piece.setCubesElement(cube7Tmp, 2, 2);

        if(piece.getCubes()[0][0] == null && piece.getCubes()[1][0] == null && piece.getCubes()[2][0] == null){
            piece = shifting.shiftToLeft(piece);
        }
        if(piece.getCubes()[0][0] == null && piece.getCubes()[0][1] == null && piece.getCubes()[0][2] == null){
            piece = shifting.shiftToUp(piece);
        }

        return piece;
    }
}

/*

1  2  3       3  2  1
4  5  6   --> 6  5  4
7  8  9       9  8  7

 */
