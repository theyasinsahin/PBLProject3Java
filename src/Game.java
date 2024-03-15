import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {

    boolean[][] isCubeFull = new boolean[5][5];
    int whichPieceIdx = 0;
    int rmcX = 2; int rmcY = 2;
    public static int control = 0;


    int pieceX = 28; int pieceY = 2;
    public PieceDepot[] pieceDepots = new PieceDepot[2];

    public static enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard",300,55);
    public TextMouseListener tmlis;
    public KeyListener klis;

    // ------ Standard variables for mouse and keyboard ------
    public int mousepr;          // mouse pressed?
    public int mousex, mousey;   // mouse text coords.
    public int keypr;   // key pressed?
    public int rkey;    // key   (for press/release)
    // ----------------------------------------------------

    static void write(String str){
        cn.getTextWindow().output(str);
    }
    static void write(char ch){
        cn.getTextWindow().output(ch);
    }

    static void setCursor(int x, int y) {
        cn.getTextWindow().setCursorPosition(x,y);
    }

    static void flood1(int cubeCX, int cubeCY){
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
    static void flood2(int cubeCX, int cubeCY){
        char[][] cube = { {'.','.','.','.','.','.','.','.','.'},
                {'.',' ',' ',' ','.',' ',' ',' ','.'},
                {'.',' ',' ',' ','.',' ',' ',' ','.'},
                {'.',' ',' ',' ','.',' ',' ',' ','.'},
                {'.',' ',' ',' ','.',' ',' ',' ','.'},
                {'.',' ',' ',' ','.',' ',' ',' ','.'},
                {'.',' ',' ',' ','.',' ',' ',' ','.'},
                {'.',' ',' ',' ','.',' ',' ',' ','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };

        for (int i = 0; i < cube.length; i++) {
            setCursor(cubeCX, cubeCY);
            for (int j = 0; j < cube.length; j++) {
                write(cube[i][j]);
            }
            cubeCY++;
        }
    }


    int indexOfComputerRobot = 0;
    int indexOfHumanRobot = 0;

    Game() throws Exception {   // --- Contructor

        pieceDepots[0] = new PieceDepot();
        pieceDepots[1] = new PieceDepot();

        //Initiliaze the piece depots
        for(int i=0;i<20;i++){
            pieceDepots[0].setPieces(new Piece(),i);
        }

        for(int i=0;i<20;i++){
            pieceDepots[1].setPieces(new Piece(),i);
        }

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
        Robot[] computerRobots = new Robot[2];
        computerRobots[0] = new Robot();
        computerRobots[1] = new Robot();

        Robot[] humanRobots = new Robot[2];
        humanRobots[0] = new Robot();
        humanRobots[1] = new Robot();

        WritePiece writePiece =new WritePiece();
        humanRobots[0].creatRobot();
        writePiece.writeToScreenRobot(humanRobots[0],2,2);
        humanRobots[0].powers();
        writePiece.Inf_area(humanRobots[0]);

        //Seçili Parça gösterilir
        setCursor(pieceX,pieceY); write("###");
        setCursor(pieceX,pieceY+1); write("#");
        setCursor(pieceX,pieceY+2); write("###");

        //robot üzerindeki seçili yer gösterilir
        setCursor(rmcX,rmcY); write("#");


        Rotate rotate = new Rotate();
        Reverse reverse = new Reverse();

        //Cubes were Created for Human Robot 1
        for(int i = 0; i<20; i++){
            if(i<4){
                pieceDepots[0].getPieces()[i].fourCubePiece();
            }else if(i<8){
                pieceDepots[0].getPieces()[i].threeCubePiece();
            }else if(i<13){
                pieceDepots[0].getPieces()[i].twoCubePiece();
            }else{
                pieceDepots[0].getPieces()[i].oneCubePiece();
            }
        }

        //Cubes were Created for Human Robot 2
        for(int i = 0; i<20; i++){
            if(i<4){
                pieceDepots[1].getPieces()[i].fourCubePiece();
            }else if(i<8){
                pieceDepots[1].getPieces()[i].threeCubePiece();
            }else if(i<13){
                pieceDepots[1].getPieces()[i].twoCubePiece();
            }else{
                pieceDepots[1].getPieces()[i].oneCubePiece();
            }
        }

        writePiece.writeAllPieces(pieceDepots[indexOfHumanRobot], cn);




        // ------ Standard code for mouse and keyboard ------ Do not change
        tmlis=new TextMouseListener() {
            public void mouseClicked(TextMouseEvent arg0) {}
            public void mousePressed(TextMouseEvent arg0) {
                if(mousepr==0) {
                    mousepr=1;
                    mousex=arg0.getX();
                    mousey=arg0.getY();
                }
            }
            public void mouseReleased(TextMouseEvent arg0) {}
        };
        cn.getTextWindow().addTextMouseListener(tmlis);

        klis=new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                if(keypr==0) {
                    keypr=1;

                    if(control == 0 || control == 2){
                        if(e.getKeyCode()== 'D' && (rmcX-2)/4+1 < 5) {
                            setCursor(rmcX, rmcY); write(" ");
                            writePiece.writeToScreenRobot(humanRobots[indexOfHumanRobot],2,2);
                            rmcX += 4;
                            setCursor(rmcX, rmcY); write("#");
                        }
                        else if(e.getKeyCode()== 'A' && (rmcX-2)/4+1 > 1) {
                            setCursor(rmcX, rmcY); write(" ");
                            writePiece.writeToScreenRobot(humanRobots[indexOfHumanRobot],2,2);
                            rmcX -= 4;
                            setCursor(rmcX, rmcY); write("#");
                        }
                        else if(e.getKeyCode()== 'W' && (rmcY-2)/4+1 > 1) {
                            setCursor(rmcX, rmcY); write(" ");
                            writePiece.writeToScreenRobot(humanRobots[indexOfHumanRobot],2,2);
                            rmcY -= 4;
                            setCursor(rmcX, rmcY); write("#");
                        }
                        else if(e.getKeyCode()== 'S' && (rmcY-2)/4+1 < 5) {
                            setCursor(rmcX, rmcY); write(" ");
                            writePiece.writeToScreenRobot(humanRobots[indexOfHumanRobot],2,2);
                            rmcY += 4;
                            setCursor(rmcX, rmcY); write("#");
                        }


                        //Küp Seçimi
                        //başlangıç koordinatı 27ye 1
                        //sol ok -> 37
                        //yukarı ok -> 38
                        //Sağ ok -> 39
                        //Aşağı ok -> 40
                        //(19,27) current piece yazdır
                        else if (e.getKeyCode() == 37 && pieceX>28) { //LEFT
                            setCursor(pieceX,pieceY); write("   ");
                            setCursor(pieceX,pieceY+1); write(" ");
                            setCursor(pieceX,pieceY+2); write("   ");
                            if(whichPieceIdx >= 0 && whichPieceIdx <= 7){
                                pieceX -= 20;
                            }else if (whichPieceIdx >= 8 && whichPieceIdx <= 12){
                                pieceX -= 15;
                            }else{
                                pieceX -= 10;
                            }

                            setCursor(pieceX,pieceY); write("###");
                            setCursor(pieceX,pieceY+1); write("#");
                            setCursor(pieceX,pieceY+2); write("###");
                        }
                        else if (e.getKeyCode() == 39 && pieceX < 80) { //RIGHT
                            setCursor(pieceX,pieceY); write("   ");
                            setCursor(pieceX,pieceY+1); write(" ");
                            setCursor(pieceX,pieceY+2); write("   ");
                            if(whichPieceIdx >= 0 && whichPieceIdx <= 7){
                                pieceX += 20;
                            }else if (whichPieceIdx >= 8 && whichPieceIdx <= 12){
                                pieceX += 15;
                            }else{
                                pieceX += 10;
                            }
                            setCursor(pieceX,pieceY); write("###");
                            setCursor(pieceX,pieceY+1); write("#");
                            setCursor(pieceX,pieceY+2); write("###");
                        }
                        else if (e.getKeyCode() == 38 && pieceY>2) { //UP
                            setCursor(pieceX,pieceY); write("   ");
                            setCursor(pieceX,pieceY+1); write(" ");
                            setCursor(pieceX,pieceY+2); write("   ");
                            if(whichPieceIdx == 9 || whichPieceIdx == 14 || whichPieceIdx == 17){pieceX+=5;}
                            else if(whichPieceIdx == 10){pieceX += 10;}
                            else if(whichPieceIdx == 11 || whichPieceIdx == 15 || whichPieceIdx == 18){pieceX -= 5;}

                            if(whichPieceIdx >= 4 && whichPieceIdx <= 12)
                            {
                                pieceY -= 15;
                            }else{
                                pieceY -= 11;
                            }

                            setCursor(pieceX,pieceY); write("###");
                            setCursor(pieceX,pieceY+1); write("#");
                            setCursor(pieceX,pieceY+2); write("###");
                        }
                        else if (e.getKeyCode() == 40 && pieceY<45) { //DOWN
                            setCursor(pieceX,pieceY); write("   ");
                            setCursor(pieceX,pieceY+1); write(" ");
                            setCursor(pieceX,pieceY+2); write("   ");

                            if(whichPieceIdx == 5 || whichPieceIdx == 9 || whichPieceIdx == 11){pieceX-=5;}
                            else if(whichPieceIdx == 6){pieceX -= 10;}

                            if(whichPieceIdx >= 0 && whichPieceIdx <= 7)
                            {
                                pieceY += 15;
                            }else if(whichPieceIdx>= 8 && whichPieceIdx <= 12){
                                pieceY += 11;
                            }

                            setCursor(pieceX,pieceY); write("###");
                            setCursor(pieceX,pieceY+1); write("#");
                            setCursor(pieceX,pieceY+2); write("###");
                        }

                        ////// Hangi parçanın seçili olduğunu ekrana yazan kısım
                        setCursor(19,27);
                        for(int i = 0; i<20; i++){
                            if(pieceX == pieceDepots[indexOfHumanRobot].getPieces()[i].getxCoordinate() && pieceY == pieceDepots[indexOfHumanRobot].getPieces()[i].getyCoordinate()){
                                write(String.valueOf(i+1)+" ");
                                whichPieceIdx = i;
                            }
                        }
                    }




                    if(e.getKeyCode()=='9' && (control==0 || control==2)){

                        for (int i = 0; i < 60; i++) {
                            for (int j = 0; j < 300; j++) {
                                cn.getTextWindow().output("  ");
                            }
                        }
                        computerRobots[indexOfComputerRobot].creatComputerRobot();
                        writePiece.writeToScreenRobot(computerRobots[indexOfComputerRobot], 2, 2);
                        computerRobots[indexOfComputerRobot].powers();
                        writePiece.Inf_area(computerRobots[indexOfComputerRobot]);
                        setCursor(1,36);
                        write("Computer Robot "+(indexOfComputerRobot+1));
                        setCursor(1, 45);
                        write("Computer Robot "+(indexOfComputerRobot+1) +"(CR"+(indexOfComputerRobot+1)+")");
                        setCursor(1, 46);
                        write("In:" + Math.floor(computerRobots[indexOfComputerRobot].getIntelligence()) + "  Sk:" + Math.floor(computerRobots[indexOfComputerRobot].getSkill()) + "  Sp:" + Math.floor(computerRobots[indexOfComputerRobot].getSpeed()));
                        control ++;
                    }


                    if(e.getKeyCode()=='0' && control==1){
                        for (int i = 0; i < 60; i++) {
                            for (int j = 0; j < 300; j++) {
                                cn.getTextWindow().output("  ");
                            }
                        }
                        whichPieceIdx = 1;
                        /////Bütün ekranı tekrar yaz
                        indexOfHumanRobot++;

                        //Parça yerleştirmede hata olmaması için tekrardan isCubeFull kontrol flag'inin her elemanını false yapıyoruz
                        for (int i = 0; i < isCubeFull.length; i++) {
                            for (int j = 0; j < isCubeFull.length; j++) {
                                isCubeFull[i][j] = false;
                            }
                        }

                        pieceX = 28;
                        pieceY = 2;
                        writePiece.writeScreen(pieceX, pieceY);
                        writePiece.writeAllPieces(pieceDepots[indexOfHumanRobot], cn);

                        humanRobots[indexOfHumanRobot].creatRobot();
                        writePiece.writeToScreenRobot(humanRobots[indexOfHumanRobot],2,2);
                        humanRobots[indexOfHumanRobot].powers();
                        writePiece.Inf_area(humanRobots[indexOfHumanRobot]);


                        control ++;
                        setCursor(1, 45);
                        write("Computer Robot 1 (CR1)");
                        setCursor(1, 46);
                        write("In:" + Math.floor(computerRobots[indexOfComputerRobot].getIntelligence()) + "  Sk:" + Math.floor(computerRobots[indexOfComputerRobot].getSkill()) + "  Sp:" + Math.floor(computerRobots[indexOfComputerRobot].getSpeed()));
                        indexOfComputerRobot++;

                    }


                    ResultScreen resultScreen = new ResultScreen(humanRobots[0],humanRobots[1],computerRobots[0],computerRobots[1]);
                    if(e.getKeyCode()=='0'&& control ==3){
                        for (int i = 0; i < 60; i++) {
                            for (int j = 0; j < 300; j++) {
                                cn.getTextWindow().output("  ");
                            }
                        }
                        resultScreen.screen();
                        resultScreen.gameInitializer(0);
                        resultScreen.gameInitializer(1);
                        resultScreen.gameInitializer(2);
                        control++;
                    }



                    /////////////// ROTATE AND REVERSE //////////////////////
                    if(e.getKeyCode()=='2' && !(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].isSelected())){
                        pieceDepots[indexOfHumanRobot].setPieces(rotate.rotateToRight(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx]),whichPieceIdx);
                        if(whichPieceIdx>= 0 && whichPieceIdx <= 3){
                            flood1(31+((whichPieceIdx)*20),3);
                            writePiece.writeToScreen(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx], 31+(whichPieceIdx*20),3);
                            writePiece.avarageX(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],44+(whichPieceIdx*20),1, 3);
                            writePiece.avarageY(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],28+(whichPieceIdx*20),16, 3);
                        }else if(whichPieceIdx >= 4 && whichPieceIdx <= 7){
                            flood1(31+((whichPieceIdx-4)*20),18);
                            writePiece.writeToScreen(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx], 31+((whichPieceIdx-4)*20),18);
                            writePiece.avarageX(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],44+((whichPieceIdx-4)*20),16, 3);
                            writePiece.avarageY(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],28+((whichPieceIdx-4)*20),31, 3);
                        }else if(whichPieceIdx >= 8 && whichPieceIdx <= 12){
                            flood2(31+((whichPieceIdx-8)*15),33);
                            writePiece.writeToScreen(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx], 31+((whichPieceIdx-8)*15),33);
                            writePiece.avarageX(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],41+((whichPieceIdx-8)*15),31, 2);
                            writePiece.avarageY(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],29+((whichPieceIdx-8)*15),42, 2);
                        }else if(whichPieceIdx >= 13 && whichPieceIdx <= 19){
                            writePiece.writeToScreen(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx], 31+((whichPieceIdx-13)*10),44);
                            writePiece.avarageX(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],33+((whichPieceIdx-13)*10),45, 1);
                            writePiece.avarageY(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],33+((whichPieceIdx-13)*10),46, 1);
                        }
                    }

                    if(e.getKeyCode()=='3' && pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].isSelected() == false){
                        pieceDepots[indexOfHumanRobot].setPieces(reverse.takeTheReverse(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx]), whichPieceIdx);
                        if(whichPieceIdx>= 0 && whichPieceIdx <= 3){
                            flood1(31+((whichPieceIdx)*20),3);
                            writePiece.writeToScreen(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx], 31+(whichPieceIdx*20),3);
                            writePiece.avarageX(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],44+(whichPieceIdx*20),1, 3);
                            writePiece.avarageY(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],28+(whichPieceIdx*20),16, 3);
                        }else if(whichPieceIdx >= 4 && whichPieceIdx <= 7){
                            flood1(31+((whichPieceIdx-4)*20),18);
                            writePiece.writeToScreen(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx], 31+((whichPieceIdx-4)*20),18);
                            writePiece.avarageX(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],44+((whichPieceIdx-4)*20),16, 3);
                            writePiece.avarageY(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx],28+((whichPieceIdx-4)*20),31, 3);
                        }else if(whichPieceIdx >= 8 && whichPieceIdx <= 12) {
                            flood2(31 + ((whichPieceIdx - 8) * 15), 33);
                            writePiece.writeToScreen(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx], 31 + ((whichPieceIdx - 8) * 15), 33);
                            writePiece.avarageX(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx], 41 + ((whichPieceIdx - 8) * 15), 31, 2);
                            writePiece.avarageY(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx], 29 + ((whichPieceIdx - 8) * 15), 42, 2);
                        }

                    }

                    ////////////////ROBOT ÜZERİNDE HANGİ KOORDİNATI GÖSTERDİĞİMİZ
                    String positionX = String.valueOf((rmcX-2)/4+1);
                    String positionY = String.valueOf((rmcY-2)/4+1);
                    setCursor(4,28); write(positionX);
                    setCursor(10,28); write(positionY);



                    ///////////SELECT THE PIECE
                    //Was created the cube which is show us the empty cube because of control the non-empty cubes
                    Cube cube = new Cube();
                    cube.createEmptyCube();
                    if(e.getKeyCode()=='1') {
                        try {
                            if (!pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].isSelected()) {
                                int robotCX = (rmcX - 2) / 4 + 1;
                                int robotCY = (rmcY - 2) / 4 + 1;
                                boolean isAvailable = true;
                                for (int i = 0; i < 3; i++) {
                                    for (int j = 0; j < 3; j++) {
                                        if (pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].getCubes()[i][j] != null) {
                                            if (humanRobots[indexOfHumanRobot].getCubes()[robotCY + i - 1][robotCX + j - 1] == null || humanRobots[indexOfHumanRobot].getCubes()[robotCY + i - 1][robotCX + j - 1].getCube_array() == cube.getCube_array() || isCubeFull[robotCY + i - 1][robotCX + j - 1]) {
                                                isAvailable = false;
                                            }
                                        }
                                    }
                                }
                                if (isAvailable) {
                                    for (int i = 0; i < 3; i++) {
                                        for (int j = 0; j < 3; j++) {
                                            if (pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].getCubes()[i][j] != null) {
                                                humanRobots[indexOfHumanRobot].setCubesElement(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].getCubes()[i][j], robotCY + i - 1, robotCX + j - 1);
                                                isCubeFull[robotCY + i - 1][robotCX + j - 1] = true;
                                            }
                                        }
                                    }
                                    writePiece.writeToScreenRobot(humanRobots[indexOfHumanRobot], 2, 2);
                                    humanRobots[indexOfHumanRobot].powers();
                                    writePiece.Inf_area(humanRobots[indexOfHumanRobot]);

                                    pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].setSelected(true);
                                    pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].setxIdxOnRobot((rmcX-2)/4);
                                    pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].setyIdxOnRobot((rmcY-2)/4);
                                    pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].setxCursorOnRobot(rmcX);
                                    pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].setyCursorOnRobot(rmcY);
                                }
                            }
                        } catch (Exception exception){

                        }

                    }

                    ///////////ERASING////////
                    Erasing erasing = new Erasing();
                    if(e.getKeyCode() == '4'){
                        if(pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].isSelected()){//Eğer daha önce seçilmişse bu işlemi yap
                            erasing.eraseSelectedPiece(cn, pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx], humanRobots[indexOfHumanRobot], pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].getxIdxOnRobot(), pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].getyIdxOnRobot(), pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].getxCursorOnRobot(), pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].getyCursorOnRobot());
                            pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].setSelected(false);

                            //Robotun üzerindeki seçilen parçanın denk geldiği küplere silme işlemi yapıldığı için boşaldığını söylüyoruz.
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    if (pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].getCubes()[i][j] != null) {
                                        isCubeFull[pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].getyIdxOnRobot() + i][pieceDepots[indexOfHumanRobot].getPieces()[whichPieceIdx].getxIdxOnRobot() + j] = false;
                                    }
                                }
                            }

                        }
                    }

                }
            }
            public void keyReleased(KeyEvent e) {}
        };

        cn.getTextWindow().addKeyListener(klis);
        // ----------------------------------------------------

        while(true) {
            if(mousepr==1) {  // if mouse button pressed

                mousepr=0;     // last action
            }

            if(keypr==1) {    // if keyboard button pressed

                keypr=0;    // last action
            }


            Thread.sleep(20);
        }
    }
}
