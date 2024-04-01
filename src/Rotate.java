public class Rotate {
    public Piece rotateToRight(Piece piece) {

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



        piece.setCubesElement(cube7Tmp, 0, 0);
        piece.setCubesElement(cube4Tmp, 0, 1);
        piece.setCubesElement(cube1Tmp, 0, 2);
        piece.setCubesElement(cube8Tmp, 1, 0);
        piece.setCubesElement(cube5Tmp, 1, 1);
        piece.setCubesElement(cube2Tmp, 1, 2);
        piece.setCubesElement(cube9Tmp, 2, 0);
        piece.setCubesElement(cube6Tmp, 2, 1);
        piece.setCubesElement(cube3Tmp, 2, 2);
/*
        if(piece.getCubes()[0][1] == null && piece.getCubes()[1][1] == null && piece.getCubes()[2][1] == null){
            piece = shifting.shiftToLeft(piece);
        }

 */
        while(piece.getCubes()[0][0] == null && piece.getCubes()[1][0] == null && piece.getCubes()[2][0] == null){
            piece = shifting.shiftToLeft(piece);
        }
        while(piece.getCubes()[0][0] == null && piece.getCubes()[0][1] == null && piece.getCubes()[0][2] == null){
            piece = shifting.shiftToUp(piece);
        }
        //KÜPLERDEKİ X ve Y DEĞERLERİNİN DEĞİŞMESİ
        for(int i = 0; i<piece.getCubes().length; i++){
            for(int j = 0; j<piece.getCubes().length;j++){
                if(piece.getCubes()[i][j] != null){
                    piece.getCubes()[i][j].setCube_array(piece.getCubes()[i][j].createCubeOnDemand(piece.getCubes()[i][j].getY_force(), piece.getCubes()[i][j].getX_force()));
                }
            }
        }

        return piece;
    }

    public Piece rotateToLeft(Piece piece) {

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
        piece.setCubesElement(cube6Tmp, 0, 1);
        piece.setCubesElement(cube9Tmp, 0, 2);
        piece.setCubesElement(cube2Tmp, 1, 0);
        piece.setCubesElement(cube5Tmp, 1, 1);
        piece.setCubesElement(cube8Tmp, 1, 2);
        piece.setCubesElement(cube1Tmp, 2, 0);
        piece.setCubesElement(cube4Tmp, 2, 1);
        piece.setCubesElement(cube7Tmp, 2, 2);
/*
        if(piece.getCubes()[0][1] == null && piece.getCubes()[1][1] == null && piece.getCubes()[2][1] == null && !(piece.getCubes()[0][0] == null && piece.getCubes()[1][0] == null && piece.getCubes()[2][0] == null)){
            piece = shifting.shiftToLeft(piece);
        }

 */
        while(piece.getCubes()[0][0] == null && piece.getCubes()[1][0] == null && piece.getCubes()[2][0] == null){
            piece = shifting.shiftToLeft(piece);
        }
        /*
        if(piece.getCubes()[1][0] == null && piece.getCubes()[1][1] == null && piece.getCubes()[1][2] == null){
            piece = shifting.shiftToUp(piece);
        }

         */
        while(piece.getCubes()[0][0] == null && piece.getCubes()[0][1] == null && piece.getCubes()[0][2] == null){
            piece = shifting.shiftToUp(piece);
        }
        //KÜPLERDEKİ X ve Y DEĞERLERİNİN DEĞİŞMESİ
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
rotate to right
-------------          -------------
- 1 - 2 - 3 -          - 7 - 4 - 1 -
- 4 - 5 - 6 -    -->   - 8 - 5 - 2 -
- 7 - 8 - 9 -          - 9 - 6 - 3 -
-------------          -------------

rotate to left
-------------          -------------
- 1 - 2 - 3 -          - 3 - 6 - 9 -
- 4 - 5 - 6 -    -->   - 2 - 5 - 8 -
- 7 - 8 - 9 -          - 1 - 4 - 7 -
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


null 2  3     2  3  null
null 5  6  -> 5  6  null
null 8  9     8  9  null

null null null      4    5    6
4     5    6     -> 7    8    9
7     8    9        null null null
 */
