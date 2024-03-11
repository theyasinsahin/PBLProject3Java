
public class GameScreen_2 {
    PieceDepot pieceDepot = new PieceDepot();

//    Piece piece1 = new Piece();
//    Piece piece2 = new Piece();
//    Piece piece3 = new Piece();
//    Piece piece4 = new Piece();
//    Piece piece5 = new Piece();
//    Piece piece6 = new Piece();
//    Piece piece7 = new Piece();
//    Piece piece8 = new Piece();
//    Piece piece9 = new Piece();
//    Piece piece10 = new Piece();
//    Piece piece11 = new Piece();
//    Piece piece12 = new Piece();
//    Piece piece13 = new Piece();
//    Piece piece14 = new Piece();
//    Piece piece15 = new Piece();
//    Piece piece16 = new Piece();
//    Piece piece17 = new Piece();
//    Piece piece18 = new Piece();
//    Piece piece19 = new Piece();
//    Piece piece20 = new Piece();


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
//    Robot robot2=new Robot();
    WritePiece writePiece =new WritePiece();
    public void screen_2(){
        for (int i = 0; i <20 ; i++) {
            Piece pieces = new Piece();
            Game.pieceDepot.setPieces(pieces,i);
        }
//        Game.pieceDepot.setPieces(piece1,0);
//        pieceDepot.setPieces(piece2,1);
//        pieceDepot.setPieces(piece3,2);
//        pieceDepot.setPieces(piece4,3);
//        pieceDepot.setPieces(piece5,4);
//        pieceDepot.setPieces(piece6,5);
//        pieceDepot.setPieces(piece7,6);
//        pieceDepot.setPieces(piece8,7);
//        pieceDepot.setPieces(piece9,8);
//        pieceDepot.setPieces(piece10,9);
//        pieceDepot.setPieces(piece11,10);
//        pieceDepot.setPieces(piece12,11);
//        pieceDepot.setPieces(piece13,12);
//        pieceDepot.setPieces(piece14,13);
//        pieceDepot.setPieces(piece15,14);
//        pieceDepot.setPieces(piece16,15);
//        pieceDepot.setPieces(piece17,16);
//        pieceDepot.setPieces(piece18,17);
//        pieceDepot.setPieces(piece19,18);
//        pieceDepot.setPieces(piece20,19);


        setCursor(0,27);
        write("Current piece (#):");
        setCursor(2,28); write("X:1");
        setCursor(8,28); write("Y:1");
        setCursor(0,29); write("Used pieces (=/-)");
        setCursor(1,30);write(" 01  02  03  04");
        setCursor(1,31);write(" 05  06  07  08");
        setCursor(1,32);write(" 09  10  11  12");
        setCursor(1,33);write(" 13  14  15  16");
        setCursor(1,34);write(" 17  18  19  20");



        setCursor(0,0);
        write(
                "+-1---2---3---4---5---> X\n" +
                        "|\n" + "1\n" + "+\n" + "+\n"+ "+\n" + "2\n" + "+\n" + "+\n" + "+\n" + "3\n" + "+\n" + "+\n" + "+\n" + "4\n" + "+\n" + "+\n" + ".\n" + "5\n" + ".\n" + ".\n" + "v\n" + "\n" + "Y");


        //Robotun ekrana yazılması
        Game.robots[1]=Game.robot2;

        Game.robots[1].creatRobot();
        writePiece.writeToScreenRobot(Game.robots[1],2,2);
        Game.robots[1].powers();
        writePiece.Inf_area(Game.robots[1]);


        //Seçili Parça gösterilir
        setCursor(pieceX,pieceY); write("###");
        setCursor(pieceX,pieceY+1); write("#");
        setCursor(pieceX,pieceY+2); write("###");

        //Cubes were Created
        for(int i = 0; i<20; i++){
            if(i<4){
                Game.pieceDepot.getPieces()[i].fourCubePiece();
            }else if(i<8){
                Game.pieceDepot.getPieces()[i].threeCubePiece();
            }else if(i<13){
                Game.pieceDepot.getPieces()[i].twoCubePiece();
            }else{
                Game.pieceDepot.getPieces()[i].oneCubePiece();
            }
        }

        //Quadruple Cubes were Wrote
        for(int i = 0; i<4;i++){
            setCursor(29+(20*i),3);
            Game.pieceDepot.getPieces()[i].setxCoordinate(28+(20*i));
            Game.pieceDepot.getPieces()[i].setyCoordinate(2);
            write("0"+String.valueOf(i+1));
            flood1(31+(20*i),3);
            writePiece.writeToScreen(Game.pieceDepot.getPieces()[i], 31+(20*i),3);
            writePiece.avarageX(Game.pieceDepot.getPieces()[i],44+(20*i),1, 3);
            writePiece.avarageY(Game.pieceDepot.getPieces()[i],28+(20*i),16, 3);
        }

        //Trible Cubes were Wrote
        for(int i = 0; i<4; i++){
            setCursor(29+(20*i),18);
            Game.pieceDepot.getPieces()[i+4].setxCoordinate(28+(20*i));
            Game.pieceDepot.getPieces()[i+4].setyCoordinate(17);
            write("0"+String.valueOf(i+5));
            flood1(31+(20*i),18);
            writePiece.writeToScreen(Game.pieceDepot.getPieces()[i+4], 31+(20*i),18);
            writePiece.avarageX(Game.pieceDepot.getPieces()[i+4], 44+(20*i), 16, 3);
            writePiece.avarageY(Game.pieceDepot.getPieces()[i+4], 28+(20*i), 31, 3);
        }


        //Double Cubes Were Wrote
        for(int i = 0; i<5; i++){
            setCursor(29+(15*i),33);
            Game.pieceDepot.getPieces()[i+8].setxCoordinate(28+(15*i));
            Game.pieceDepot.getPieces()[i+8].setyCoordinate(32);
            if(i == 0){
                write("0"+String.valueOf(i+9));
            }else{
                write(String.valueOf(i+9));
            }
            flood2(31+(15*i),33);
            writePiece.writeToScreen(Game.pieceDepot.getPieces()[i+8], 31+(15*i),33);
            writePiece.avarageX(Game.pieceDepot.getPieces()[i+8], 41+(15*i), 31, 2);
            writePiece.avarageY(Game.pieceDepot.getPieces()[i+8], 29+(15*i), 42, 2);
        }

        //Single Cubes were wrote
        for(int i = 0; i<7; i++){
            setCursor(29+(10*i),44);
            Game.pieceDepot.getPieces()[i+13].setxCoordinate(28+(10*i));
            Game.pieceDepot.getPieces()[i+13].setyCoordinate(43);
            write(String.valueOf(i+14));
            writePiece.writeToScreen(Game.pieceDepot.getPieces()[i+13], 31+(10*i),44);
            writePiece.avarageX(Game.pieceDepot.getPieces()[i+13], 37+(10*i), 42, 1);
            writePiece.avarageY(Game.pieceDepot.getPieces()[i+13], 29+(10*i), 49, 1);


        }
    }
}
