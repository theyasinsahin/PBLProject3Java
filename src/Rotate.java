public class Rotate {
    public Piece rotateToRight(Piece piece) {

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

        piece.setCubesElement(cube7Tmp, 0, 0);
        piece.setCubesElement(cube4Tmp, 0, 1);
        piece.setCubesElement(cube1Tmp, 0, 2);
        piece.setCubesElement(cube8Tmp, 1, 0);
        piece.setCubesElement(cube5Tmp, 1, 1);
        piece.setCubesElement(cube2Tmp, 1, 2);
        piece.setCubesElement(cube9Tmp, 2, 0);
        piece.setCubesElement(cube6Tmp, 2, 1);
        piece.setCubesElement(cube3Tmp, 2, 2);

        //KÜPLERDEKİ DEĞERLERİN DEĞİŞMESİ

        for(int i = 0; i<piece.getCubes().length; i++){
            for(int j = 0; j<piece.getCubes().length;j++){
                if(piece.getCubes()[i][j] != null){
                    piece.getCubes()[i][j].setCube_array(piece.getCubes()[i][j].createCubeOnDemand(piece.getCubes()[i][j].getY_force(), piece.getCubes()[i][j].getX_force()));
                }
            }
        }

        return piece;
    }
}


/*

-------------          -------------
- 1 - 2 - 3 -          - 7 - 4 - 1 -
- 4 - 5 - 6 -    -->   - 8 - 5 - 2 -
- 7 - 8 - 9 -          - 9 - 6 - 3 -
-------------          -------------

-------------          -----           -----
- 7 - 3 - 5 -          - 7 -           - 3 -
-3 5-5 7-4 3-    -->   -3 5-    -->    -7 2-
- 2 - 5 - 3 -          - 2 -           - 5 -
-------------          -----           -----
                       - 3 -
                       -5 7-
                       - 5 -
                       -----
                       - 5 -
                       -4 3-
                       - 3 -
                       -----
 */