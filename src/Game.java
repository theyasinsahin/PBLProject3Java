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
    public PieceDepot pieceDepot = new PieceDepot();

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


        for (int i = 0; i < 20; i++) {
            pieceDepot.setPieces(new Piece(), i);
        }

        //Parçaların Inf Areadaki koordinatları
        for (int i = 0; i < 20; i++) {
            int y = 30;
            int x = 1;
            if(i<=3){
                pieceDepot.getPieces()[i].setxCursorOnInfArea(x+(4*i));
                pieceDepot.getPieces()[i].setyCursorOnInfArea(y);
            }
            else if(i<=7){
                pieceDepot.getPieces()[i].setxCursorOnInfArea(x+(4*(i-4)));
                pieceDepot.getPieces()[i].setyCursorOnInfArea(y+1);
            }
            else if(i<=11){
                pieceDepot.getPieces()[i].setxCursorOnInfArea(x+(4*(i-7)));
                pieceDepot.getPieces()[i].setyCursorOnInfArea(y+2);
            }
            else if(i<=15){
                pieceDepot.getPieces()[i].setxCursorOnInfArea(x+(4*(i-10)));
                pieceDepot.getPieces()[i].setyCursorOnInfArea(y+3);
            }
            else if(i<=19){
                pieceDepot.getPieces()[i].setxCursorOnInfArea(x+(4*(i-13)));
                pieceDepot.getPieces()[i].setyCursorOnInfArea(y+4);
            }
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

        WriteMethods writeMethods =new WriteMethods();
        humanRobots[0].creatRobot();
        writeMethods.writeToScreenRobot(humanRobots[0],2,2);
        humanRobots[0].powers();
        writeMethods.Inf_area(humanRobots[0]);

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
                pieceDepot.getPieces()[i].fourCubePiece();
            }else if(i<8){
                pieceDepot.getPieces()[i].threeCubePiece();
            }else if(i<13){
                pieceDepot.getPieces()[i].twoCubePiece();
            }else{
                pieceDepot.getPieces()[i].oneCubePiece();
            }
        }

        writeMethods.writeAllPieces(this.pieceDepot, cn);




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
                            writeMethods.writeToScreenRobot(humanRobots[indexOfHumanRobot],2,2);
                            rmcX += 4;
                            setCursor(rmcX, rmcY); write("#");
                        }
                        else if(e.getKeyCode()== 'A' && (rmcX-2)/4+1 > 1) {
                            setCursor(rmcX, rmcY); write(" ");
                            writeMethods.writeToScreenRobot(humanRobots[indexOfHumanRobot],2,2);
                            rmcX -= 4;
                            setCursor(rmcX, rmcY); write("#");
                        }
                        else if(e.getKeyCode()== 'W' && (rmcY-2)/4+1 > 1) {
                            setCursor(rmcX, rmcY); write(" ");
                            writeMethods.writeToScreenRobot(humanRobots[indexOfHumanRobot],2,2);
                            rmcY -= 4;
                            setCursor(rmcX, rmcY); write("#");
                        }
                        else if(e.getKeyCode()== 'S' && (rmcY-2)/4+1 < 5) {
                            setCursor(rmcX, rmcY); write(" ");
                            writeMethods.writeToScreenRobot(humanRobots[indexOfHumanRobot],2,2);
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
                            writeMethods.showSelectedPieces(pieceDepot, control);

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
                            writeMethods.showSelectedPieces(pieceDepot, control);

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
                            writeMethods.showSelectedPieces(pieceDepot, control);

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
                            writeMethods.showSelectedPieces(pieceDepot, control);

                            setCursor(pieceX,pieceY); write("###");
                            setCursor(pieceX,pieceY+1); write("#");
                            setCursor(pieceX,pieceY+2); write("###");
                        }

                        ////// Hangi parçanın seçili olduğunu ekrana yazan kısım
                        setCursor(19,27);
                        for(int i = 0; i<20; i++){
                            if(pieceX == pieceDepot.getPieces()[i].getxCoordinate() && pieceY == pieceDepot.getPieces()[i].getyCoordinate()){
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
                        writeMethods.writeToScreenRobot(computerRobots[indexOfComputerRobot], 2, 2);
                        computerRobots[indexOfComputerRobot].powers();
                        writeMethods.Inf_area(computerRobots[indexOfComputerRobot]);
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
                        writeMethods.writeScreen(pieceX, pieceY);
                        writeMethods.writeAllPieces(pieceDepot, cn);

                        humanRobots[indexOfHumanRobot].creatRobot();
                        writeMethods.writeToScreenRobot(humanRobots[indexOfHumanRobot],2,2);
                        humanRobots[indexOfHumanRobot].powers();
                        writeMethods.Inf_area(humanRobots[indexOfHumanRobot]);


                        control ++;
                        setCursor(1, 45);
                        write("Computer Robot 1 (CR1)");
                        setCursor(1, 46);
                        write("In:" + Math.floor(computerRobots[indexOfComputerRobot].getIntelligence()) + "  Sk:" + Math.floor(computerRobots[indexOfComputerRobot].getSkill()) + "  Sp:" + Math.floor(computerRobots[indexOfComputerRobot].getSpeed()));
                        indexOfComputerRobot++;

                        writeMethods.showSelectedPieces(pieceDepot, control);

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
                    if(e.getKeyCode()=='2' && !(pieceDepot.getPieces()[whichPieceIdx].isSelected())){
                        pieceDepot.setPieces(rotate.rotateToRight(pieceDepot.getPieces()[whichPieceIdx]),whichPieceIdx);
                        if(whichPieceIdx>= 0 && whichPieceIdx <= 3){
                            flood1(31+((whichPieceIdx)*20),3);
                            writeMethods.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+(whichPieceIdx*20),3);
                            writeMethods.avarageX(pieceDepot.getPieces()[whichPieceIdx],44+(whichPieceIdx*20),1, 3);
                            writeMethods.avarageY(pieceDepot.getPieces()[whichPieceIdx],28+(whichPieceIdx*20),16, 3);
                        }else if(whichPieceIdx >= 4 && whichPieceIdx <= 7){
                            flood1(31+((whichPieceIdx-4)*20),18);
                            writeMethods.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+((whichPieceIdx-4)*20),18);
                            writeMethods.avarageX(pieceDepot.getPieces()[whichPieceIdx],44+((whichPieceIdx-4)*20),16, 3);
                            writeMethods.avarageY(pieceDepot.getPieces()[whichPieceIdx],28+((whichPieceIdx-4)*20),31, 3);
                        }else if(whichPieceIdx >= 8 && whichPieceIdx <= 12){
                            flood2(31+((whichPieceIdx-8)*15),33);
                            writeMethods.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+((whichPieceIdx-8)*15),33);
                            writeMethods.avarageX(pieceDepot.getPieces()[whichPieceIdx],41+((whichPieceIdx-8)*15),31, 2);
                            writeMethods.avarageY(pieceDepot.getPieces()[whichPieceIdx],29+((whichPieceIdx-8)*15),42, 2);
                        }else if(whichPieceIdx >= 13 && whichPieceIdx <= 19){
                            writeMethods.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+((whichPieceIdx-13)*10),44);
                            writeMethods.avarageX(pieceDepot.getPieces()[whichPieceIdx],33+((whichPieceIdx-13)*10),45, 1);
                            writeMethods.avarageY(pieceDepot.getPieces()[whichPieceIdx],33+((whichPieceIdx-13)*10),46, 1);
                        }
                    }

                    if(e.getKeyCode()=='3' && pieceDepot.getPieces()[whichPieceIdx].isSelected() == false){
                        pieceDepot.setPieces(reverse.takeTheReverse(pieceDepot.getPieces()[whichPieceIdx]), whichPieceIdx);
                        if(whichPieceIdx>= 0 && whichPieceIdx <= 3){
                            flood1(31+((whichPieceIdx)*20),3);
                            writeMethods.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+(whichPieceIdx*20),3);
                            writeMethods.avarageX(pieceDepot.getPieces()[whichPieceIdx],44+(whichPieceIdx*20),1, 3);
                            writeMethods.avarageY(pieceDepot.getPieces()[whichPieceIdx],28+(whichPieceIdx*20),16, 3);
                        }else if(whichPieceIdx >= 4 && whichPieceIdx <= 7){
                            flood1(31+((whichPieceIdx-4)*20),18);
                            writeMethods.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+((whichPieceIdx-4)*20),18);
                            writeMethods.avarageX(pieceDepot.getPieces()[whichPieceIdx],44+((whichPieceIdx-4)*20),16, 3);
                            writeMethods.avarageY(pieceDepot.getPieces()[whichPieceIdx],28+((whichPieceIdx-4)*20),31, 3);
                        }else if(whichPieceIdx >= 8 && whichPieceIdx <= 12) {
                            flood2(31 + ((whichPieceIdx - 8) * 15), 33);
                            writeMethods.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31 + ((whichPieceIdx - 8) * 15), 33);
                            writeMethods.avarageX(pieceDepot.getPieces()[whichPieceIdx], 41 + ((whichPieceIdx - 8) * 15), 31, 2);
                            writeMethods.avarageY(pieceDepot.getPieces()[whichPieceIdx], 29 + ((whichPieceIdx - 8) * 15), 42, 2);
                        }

                    }

                    ////////////////ROBOT ÜZERİNDE HANGİ KOORDİNATI GÖSTERDİĞİMİZ
                    if(control == 0 || control == 2){
                        String positionX = String.valueOf((rmcX-2)/4+1);
                        String positionY = String.valueOf((rmcY-2)/4+1);
                        setCursor(4,28); write(positionX);
                        setCursor(10,28); write(positionY);
                    }




                    ///////////SELECT THE PIECE
                    //Was created the cube which is show us the empty cube because of control the non-empty cubes
                    Cube cube = new Cube();
                    cube.createEmptyCube();
                    if(e.getKeyCode()=='1') {
                        try {
                            if (!pieceDepot.getPieces()[whichPieceIdx].isSelected()) {
                                int robotCX = (rmcX - 2) / 4 + 1;
                                int robotCY = (rmcY - 2) / 4 + 1;
                                boolean isAvailable = true;
                                for (int i = 0; i < 3; i++) {
                                    for (int j = 0; j < 3; j++) {
                                        if (pieceDepot.getPieces()[whichPieceIdx].getCubes()[i][j] != null) {
                                            if (humanRobots[indexOfHumanRobot].getCubes()[robotCY + i - 1][robotCX + j - 1] == null || humanRobots[indexOfHumanRobot].getCubes()[robotCY + i - 1][robotCX + j - 1].getCube_array() == cube.getCube_array() || isCubeFull[robotCY + i - 1][robotCX + j - 1]) {
                                                isAvailable = false;
                                            }
                                        }
                                    }
                                }
                                if (isAvailable) {
                                    for (int i = 0; i < 3; i++) {
                                        for (int j = 0; j < 3; j++) {
                                            if (pieceDepot.getPieces()[whichPieceIdx].getCubes()[i][j] != null) {
                                                humanRobots[indexOfHumanRobot].setCubesElement(pieceDepot.getPieces()[whichPieceIdx].getCubes()[i][j], robotCY + i - 1, robotCX + j - 1);
                                                isCubeFull[robotCY + i - 1][robotCX + j - 1] = true;
                                            }
                                        }
                                    }
                                    writeMethods.writeToScreenRobot(humanRobots[indexOfHumanRobot], 2, 2);
                                    humanRobots[indexOfHumanRobot].powers();
                                    writeMethods.Inf_area(humanRobots[indexOfHumanRobot]);

                                    pieceDepot.getPieces()[whichPieceIdx].setSelected(true);
                                    if(control == 0){
                                        pieceDepot.getPieces()[whichPieceIdx].setPreIsSelected(true);
                                    }
                                    pieceDepot.getPieces()[whichPieceIdx].setxIdxOnRobot((rmcX-2)/4);
                                    pieceDepot.getPieces()[whichPieceIdx].setyIdxOnRobot((rmcY-2)/4);
                                    pieceDepot.getPieces()[whichPieceIdx].setxCursorOnRobot(rmcX);
                                    pieceDepot.getPieces()[whichPieceIdx].setyCursorOnRobot(rmcY);

                                    writeMethods.showSelectedPieces(pieceDepot, control);
                                }
                            }
                        } catch (Exception exception){

                        }

                    }

                    ///////////ERASING////////
                    Erasing erasing = new Erasing();
                    if(e.getKeyCode() == '4'){
                        if(pieceDepot.getPieces()[whichPieceIdx].isSelected()){//Eğer daha önce seçilmişse bu işlemi yap
                            if(!(control == 2 && pieceDepot.getPieces()[whichPieceIdx].isPreIsSelected()))
                            {
                                writeMethods.showSelectedPieces(pieceDepot, control);

                                erasing.eraseSelectedPiece(cn, pieceDepot.getPieces()[whichPieceIdx], humanRobots[indexOfHumanRobot], pieceDepot.getPieces()[whichPieceIdx].getxIdxOnRobot(), pieceDepot.getPieces()[whichPieceIdx].getyIdxOnRobot(), pieceDepot.getPieces()[whichPieceIdx].getxCursorOnRobot(), pieceDepot.getPieces()[whichPieceIdx].getyCursorOnRobot());
                                pieceDepot.getPieces()[whichPieceIdx].setSelected(false);

                                //Robotun üzerindeki seçilen parçanın denk geldiği küplere silme işlemi yapıldığı için boşaldığını söylüyoruz.
                                for (int i = 0; i < 3; i++) {
                                    for (int j = 0; j < 3; j++) {
                                        if (pieceDepot.getPieces()[whichPieceIdx].getCubes()[i][j] != null) {
                                            isCubeFull[pieceDepot.getPieces()[whichPieceIdx].getyIdxOnRobot() + i][pieceDepot.getPieces()[whichPieceIdx].getxIdxOnRobot() + j] = false;
                                        }
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
