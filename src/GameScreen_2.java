public class GameScreen_2 {
    Piece piece1 = new Piece();
    Piece piece2 = new Piece();
    Piece piece3 = new Piece();
    Piece piece4 = new Piece();
    Piece piece5 = new Piece();
    Piece piece6 = new Piece();
    Piece piece7 = new Piece();
    Piece piece8 = new Piece();
    Piece piece9 = new Piece();
    Piece piece10 = new Piece();
    Piece piece11 = new Piece();
    Piece piece12 = new Piece();
    Piece piece13 = new Piece();
    Piece piece14 = new Piece();
    Piece piece15 = new Piece();
    Piece piece16 = new Piece();
    Piece piece17 = new Piece();
    Piece piece18 = new Piece();
    Piece piece19 = new Piece();
    Piece piece20 = new Piece();

    int pieceX = 28; int pieceY = 2;

    static void write(String str){
        Game.cn.getTextWindow().output(str);
    }
    static void write(char ch){
       Game.cn.getTextWindow().output(ch);
    }

    static void setCursor(int x, int y) {
        Game.cn.getTextWindow().setCursorPosition(x,y);
    }

    public void flood1(int cubeCX, int cubeCY){
        char[][] shape = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.'},
                {'.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.'},
                {'.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.'},
                {'.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.'},
                {'.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.'},
                {'.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.'},
                {'.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.', ' ', ' ', ' ', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        for (int i = 0; i < shape.length; i++) {
            setCursor(cubeCX, cubeCY);
            for (int j = 0; j < shape.length; j++) {
                write(shape[i][j]);
            }
            cubeCY++;
        }
    }
    public void flood2(int cubeCX, int cubeCY){
        String[][] cube = { {".",".",".",".",".",".",".",".","."},
                {"."," "," "," ","."," "," "," ","."},
                {"."," "," "," ","."," "," "," ","."},
                {"."," "," "," ","."," "," "," ","."},
                {".",".",".",".",".",".",".",".","."},
                {"."," "," "," ","."," "," "," ","."},
                {"."," "," "," ","."," "," "," ","."},
                {"."," "," "," ","."," "," "," ","."},
                {".",".",".",".",".",".",".",".","."}
        };

        for (int i = 0; i < cube.length; i++) {
            setCursor(cubeCX, cubeCY);
            for (int j = 0; j < cube.length; j++) {
                write(cube[i][j]);
            }
            cubeCY++;
        }
    }

    public void screen_2(){
        setCursor(0,27);
        write("Current piece (#):");
        setCursor(2,28); write("X:1");
        setCursor(8,28); write("Y:1");
        setCursor(0,29); write("Used pieces (=/-)");
        setCursor(1,30);write("01  02  03  04");
        setCursor(1,31);write("05  06  07  08");
        setCursor(1,32);write("09  10  11  12");
        setCursor(1,33);write("13  14  15  16");
        setCursor(1,34);write("17  18  19  20");





        setCursor(0,0);
        write(
                "+-1---2---3---4---5---> X\n" +
                        "|\n" + "1\n" + "+\n" + "+\n"+ "+\n" + "2\n" + "+\n" + "+\n" + "+\n" + "3\n" + "+\n" + "+\n" + "+\n" + "4\n" + "+\n" + "+\n" + ".\n" + "5\n" + ".\n" + ".\n" + "v\n" + "\n" + "Y");


        Robot crobot2 = new Robot();
        Robot robot2=new Robot();
        WritePiece writePiece =new WritePiece();
        robot2.creatRobot();
        writePiece.writeToScreenRobot(robot2,2,2);
        robot2.powers();
        writePiece.Inf_area(robot2);

        //Seçili Parçayı gösterilir
        setCursor(pieceX,pieceY); write("###");
        setCursor(pieceX,pieceY+1); write("#");
        setCursor(pieceX,pieceY+2); write("###");


        //Quadruple Cubes were Created
        piece1.fourCubePiece();
        piece2.fourCubePiece();
        piece3.fourCubePiece();
        piece4.fourCubePiece();

        //Trible Cubes were Created
        piece5.threeCubePiece();
        piece6.threeCubePiece();
        piece7.threeCubePiece();
        piece8.threeCubePiece();

        //Double Cubes were Created
        piece9.twoCubePiece();
        piece10.twoCubePiece();
        piece11.twoCubePiece();
        piece12.twoCubePiece();
        piece13.twoCubePiece();

        //Single Cubes were Created
        piece14.oneCubePiece();
        piece15.oneCubePiece();
        piece16.oneCubePiece();
        piece17.oneCubePiece();
        piece18.oneCubePiece();
        piece19.oneCubePiece();
        piece20.oneCubePiece();

        //Quadruple Cubes were Wrote
        setCursor(29,3);
        write("01");
        flood1(31,3);
        writePiece.writeToScreen(piece1, 31,3);
        writePiece.avarageX(piece1,44,1, 3);
        writePiece.avarageY(piece1,28,16, 3);

        setCursor(49,3);
        write("02");
        flood1(51,3);
        writePiece.writeToScreen(piece2, 51,3);
        writePiece.avarageX(piece2, 64,1, 3);
        writePiece.avarageY(piece2, 48, 16, 3);

        setCursor(69,3);
        write("03");
        flood1(71,3);
        writePiece.writeToScreen(piece3, 71,3);
        writePiece.avarageX(piece3, 84, 1, 3 );
        writePiece.avarageY(piece3, 68, 16, 3);

        setCursor(89,3);
        write("04");
        flood1(91,3);
        writePiece.writeToScreen(piece4, 91,3);
        writePiece.avarageX(piece4, 104, 1, 3);
        writePiece.avarageY(piece4, 88, 16, 3);

        //Trible Cubes were Wrote
        setCursor(29,18);
        write("05");
        flood1(31,18);
        writePiece.writeToScreen(piece5, 31,18);
        writePiece.avarageX(piece5, 44, 16, 3);
        writePiece.avarageY(piece5, 28, 31, 3);

        setCursor(49,18);
        write("06");
        flood1(51,18);
        writePiece.writeToScreen(piece6, 51,18);
        writePiece.avarageX(piece6, 64, 16, 3);
        writePiece.avarageY(piece6, 48, 31, 3);

        setCursor(69,18);
        write("07");
        flood1(71,18);
        writePiece.writeToScreen(piece7, 71,18);
        writePiece.avarageX(piece7, 84, 16, 3);
        writePiece.avarageY(piece7, 68, 31, 3);

        setCursor(89,18);
        write("08");
        flood1(91,18);
        writePiece.writeToScreen(piece8, 91,18);
        writePiece.avarageX(piece8, 104, 16, 3);
        writePiece.avarageY(piece8, 88, 31, 3);

        //2 liler için
        setCursor(29,33);
        write("09");
        flood2(31,33);
        writePiece.writeToScreen(piece9, 31,33);
        writePiece.avarageX(piece9, 41, 31, 2);
        writePiece.avarageY(piece9, 29, 42, 2);

        setCursor(44,33);
        write("10");
        flood2(46,33);
        writePiece.writeToScreen(piece10, 46,33);
        writePiece.avarageX(piece10, 56, 31, 2);
        writePiece.avarageY(piece10, 44, 42, 2);

        setCursor(59,33);
        write("11");
        flood2(61,33);
        writePiece.writeToScreen(piece11, 61,33);
        writePiece.avarageX(piece11, 71, 31, 2);
        writePiece.avarageY(piece11, 59, 42, 2);


        setCursor(74,33);
        write("12");
        flood2(76,33);
        writePiece.writeToScreen(piece12, 76,33);
        writePiece.avarageX(piece12, 86, 31, 2);
        writePiece.avarageY(piece12, 74, 42, 2);


        setCursor(89,33);
        write("13");
        flood2(91,33);
        writePiece.writeToScreen(piece13, 91,33);
        writePiece.avarageX(piece13, 101, 31, 2);
        writePiece.avarageY(piece13, 89, 42, 2);


        //Single Cube were wrote
        setCursor(31,44);
        write("14");
        writePiece.writeToScreen(piece14, 33,44);
        writePiece.avarageX(piece14, 39, 42, 1);
        writePiece.avarageY(piece14, 31, 49, 1);

        setCursor(42,44);
        write("15");
        writePiece.writeToScreen(piece15, 44,44);
        writePiece.avarageX(piece15, 50, 42, 1);
        writePiece.avarageY(piece15, 41, 49, 1);

        setCursor(51,44);
        write("16");
        writePiece.writeToScreen(piece16, 53,44);
        writePiece.avarageX(piece16, 58, 42, 1);
        writePiece.avarageY(piece16, 51, 49, 1);

        setCursor(62,44);
        write("17");
        writePiece.writeToScreen(piece17, 64,44);
        writePiece.avarageX(piece17, 70, 42, 1);
        writePiece.avarageY(piece17, 62, 49, 1);

        setCursor(73,44);
        write("18");
        writePiece.writeToScreen(piece18, 75,44);
        writePiece.avarageX(piece18, 81, 42, 1);
        writePiece.avarageY(piece18, 73, 49, 1);

        setCursor(84,44);
        write("19");
        writePiece.writeToScreen(piece19, 86,44);
        writePiece.avarageX(piece19, 92, 42, 1);
        writePiece.avarageY(piece19, 84, 49, 1);

        setCursor(95,44);
        write("20");
        writePiece.writeToScreen(piece20, 97,44);
        writePiece.avarageX(piece20, 103, 42, 1);
        writePiece.avarageY(piece20, 95, 49, 1);


    }
}
