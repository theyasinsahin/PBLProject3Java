import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {

    boolean[][] isCubeFull = new boolean[5][5];
    int whichPieceIdx = 0;
    int rmcX = 2; int rmcY = 2;
    boolean[] isUsedPiece = new boolean[20];
    int control = 0;


    int pieceX = 28; int pieceY = 2;
    PieceDepot pieceDepot = new PieceDepot();
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



   Game() throws Exception {   // --- Contructor

       pieceDepot.setPieces(piece1,0);
       pieceDepot.setPieces(piece2,1);
       pieceDepot.setPieces(piece3,2);
       pieceDepot.setPieces(piece4,3);
       pieceDepot.setPieces(piece5,4);
       pieceDepot.setPieces(piece6,5);
       pieceDepot.setPieces(piece7,6);
       pieceDepot.setPieces(piece8,7);
       pieceDepot.setPieces(piece9,8);
       pieceDepot.setPieces(piece10,9);
       pieceDepot.setPieces(piece11,10);
       pieceDepot.setPieces(piece12,11);
       pieceDepot.setPieces(piece13,12);
       pieceDepot.setPieces(piece14,13);
       pieceDepot.setPieces(piece15,14);
       pieceDepot.setPieces(piece16,15);
       pieceDepot.setPieces(piece17,16);
       pieceDepot.setPieces(piece18,17);
       pieceDepot.setPieces(piece19,18);
       pieceDepot.setPieces(piece20,19);


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

       //coumputer robot powers area
       GameScreen_2 game2=new GameScreen_2();
/*
       Robot crobot1=new Robot();
       Robot crobot2=new Robot();
       double [] powers1=crobot1.create();
       double [] powers2= crobot2.create();
       setCursor(1,45);
       write("Computer Robot 1 (CR1)");
       setCursor(1,46);
       write("In: "+Math.floor(powers1[0])+"  Sk:"+Math.floor(powers1[1])+"  Sp:"+Math.floor(powers1[2]));
 */
//       setCursor(1,48);
//       write("Computer Robot 2 (CR2)");
//       setCursor(1,49);
//       write("In: "+Math.floor(powers2[0])+"  Sk:"+Math.floor(powers2[1])+"  Sp:"+Math.floor(powers2[2]));

       //Robotun ekrana yazılması
       Robot crobot1 = new Robot();
       Robot robot1=new Robot();
       WritePiece writePiece =new WritePiece();
       robot1.creatRobot();
       writePiece.writeToScreenRobot(robot1,2,2);
       robot1.powers();
       writePiece.Inf_area(robot1);


     //Seçili Parça gösterilir
       setCursor(pieceX,pieceY); write("###");
       setCursor(pieceX,pieceY+1); write("#");
       setCursor(pieceX,pieceY+2); write("###");

       //robot üzerindeki seçili yer gösterilir
       setCursor(rmcX,rmcY); write("#");


       Rotate rotate = new Rotate();
       Reverse reverse = new Reverse();

       //Cubes were Created
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

       //Quadruple Cubes were Wrote
       for(int i = 0; i<4;i++){
               setCursor(29+(20*i),3);
               pieceDepot.getPieces()[i].setxCoordinate(28+(20*i));
               pieceDepot.getPieces()[i].setyCoordinate(2);
               write("0"+String.valueOf(i+1));
               flood1(31+(20*i),3);
               writePiece.writeToScreen(pieceDepot.getPieces()[i], 31+(20*i),3);
               writePiece.avarageX(pieceDepot.getPieces()[i],44+(20*i),1, 3);
               writePiece.avarageY(pieceDepot.getPieces()[i],28+(20*i),16, 3);
        }

       //Trible Cubes were Wrote
       for(int i = 0; i<4; i++){
           setCursor(29+(20*i),18);
           pieceDepot.getPieces()[i+4].setxCoordinate(28+(20*i));
           pieceDepot.getPieces()[i+4].setyCoordinate(17);
           write("0"+String.valueOf(i+5));
           flood1(31+(20*i),18);
           writePiece.writeToScreen(pieceDepot.getPieces()[i+4], 31+(20*i),18);
           writePiece.avarageX(pieceDepot.getPieces()[i+4], 44+(20*i), 16, 3);
           writePiece.avarageY(pieceDepot.getPieces()[i+4], 28+(20*i), 31, 3);
       }


       //Double Cubes Were Wrote
       for(int i = 0; i<5; i++){
           setCursor(29+(15*i),33);
           pieceDepot.getPieces()[i+8].setxCoordinate(28+(15*i));
           pieceDepot.getPieces()[i+8].setyCoordinate(32);
           if(i == 0){
               write("0"+String.valueOf(i+9));
           }else{
               write(String.valueOf(i+9));
           }
           flood2(31+(15*i),33);
           writePiece.writeToScreen(pieceDepot.getPieces()[i+8], 31+(15*i),33);
           writePiece.avarageX(pieceDepot.getPieces()[i+8], 41+(15*i), 31, 2);
           writePiece.avarageY(pieceDepot.getPieces()[i+8], 29+(15*i), 42, 2);
       }

       //Single Cubes were wrote
       for(int i = 0; i<7; i++){
           setCursor(29+(10*i),44);
           pieceDepot.getPieces()[i+13].setxCoordinate(28+(10*i));
           pieceDepot.getPieces()[i+13].setyCoordinate(43);
           write(String.valueOf(i+14));
           writePiece.writeToScreen(pieceDepot.getPieces()[i+13], 31+(10*i),44);
           writePiece.avarageX(pieceDepot.getPieces()[i+13], 37+(10*i), 42, 1);
           writePiece.avarageY(pieceDepot.getPieces()[i+13], 29+(10*i), 49, 1);
       }




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

               if(control == 0){
                   if(e.getKeyCode()== 'D' && (rmcX-2)/4+1 < 5) {
                       setCursor(rmcX, rmcY); write(" ");
                       writePiece.writeToScreenRobot(robot1,2,2);
                       rmcX += 4;
                       setCursor(rmcX, rmcY); write("#");
                   }
                   else if(e.getKeyCode()== 'A' && (rmcX-2)/4+1 > 1) {
                       setCursor(rmcX, rmcY); write(" ");
                       writePiece.writeToScreenRobot(robot1,2,2);
                       rmcX -= 4;
                       setCursor(rmcX, rmcY); write("#");
                   }
                   else if(e.getKeyCode()== 'W' && (rmcY-2)/4+1 > 1) {
                       setCursor(rmcX, rmcY); write(" ");
                       writePiece.writeToScreenRobot(robot1,2,2);
                       rmcY -= 4;
                       setCursor(rmcX, rmcY); write("#");
                   }
                   else if(e.getKeyCode()== 'S' && (rmcY-2)/4+1 < 5) {
                       setCursor(rmcX, rmcY); write(" ");
                       writePiece.writeToScreenRobot(robot1,2,2);
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
                       }else{
                           pieceY += 11;
                       }

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

                if(e.getKeyCode()=='9' && control==0){

                    for (int i = 0; i < 60; i++) {
                        for (int j = 0; j < 300; j++) {
                            cn.getTextWindow().output("  ");
                        }
                    }

                    crobot1.creatComputerRobot();
                    writePiece.writeToScreenRobot(crobot1, 2, 2);
                    crobot1.powers();
                    setCursor(1, 45);
                    write("Computer Robot 1 (CR1)");
                    setCursor(1, 46);
                    write("In:" + Math.floor(crobot1.getIntelligence()) + "  Sk:" + Math.floor(crobot1.getSkill()) + "  Sp:" + Math.floor(crobot1.getSpeed()));
                    control = 1;


                }

                if(e.getKeyCode()=='0' && control==1){
                    game2.screen_2();
                    control = 0;
                }


if(control == 0){
    /////////////// ROTATE AND REVERSE //////////////////////
    if(e.getKeyCode()=='2'){
        pieceDepot.setPieces(rotate.rotateToRight(pieceDepot.getPieces()[whichPieceIdx]),whichPieceIdx);
        if(whichPieceIdx>= 0 && whichPieceIdx <= 3){
            flood1(31+((whichPieceIdx)*20),3);
            writePiece.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+(whichPieceIdx*20),3);
            writePiece.avarageX(pieceDepot.getPieces()[whichPieceIdx],44+(whichPieceIdx*20),1, 3);
            writePiece.avarageY(pieceDepot.getPieces()[whichPieceIdx],28+(whichPieceIdx*20),16, 3);
        }else if(whichPieceIdx >= 4 && whichPieceIdx <= 7){
            flood1(31+((whichPieceIdx-4)*20),18);
            writePiece.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+((whichPieceIdx-4)*20),18);
            writePiece.avarageX(pieceDepot.getPieces()[whichPieceIdx],44+((whichPieceIdx-4)*20),16, 3);
            writePiece.avarageY(pieceDepot.getPieces()[whichPieceIdx],28+((whichPieceIdx-4)*20),31, 3);
        }else if(whichPieceIdx >= 8 && whichPieceIdx <= 12){
            flood2(31+((whichPieceIdx-8)*15),33);
            writePiece.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+((whichPieceIdx-8)*15),33);
            writePiece.avarageX(pieceDepot.getPieces()[whichPieceIdx],41+((whichPieceIdx-8)*15),31, 2);
            writePiece.avarageY(pieceDepot.getPieces()[whichPieceIdx],29+((whichPieceIdx-8)*15),42, 2);
        }else if(whichPieceIdx >= 13 && whichPieceIdx <= 19){
            writePiece.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 27+((whichPieceIdx-13)*10),44);
            writePiece.avarageX(pieceDepot.getPieces()[whichPieceIdx],33+((whichPieceIdx-13)*10),45, 1);
            writePiece.avarageY(pieceDepot.getPieces()[whichPieceIdx],33+((whichPieceIdx-13)*10),46, 1);
        }
    }

    if(e.getKeyCode()=='3'){
        pieceDepot.setPieces(reverse.takeTheReverse(pieceDepot.getPieces()[whichPieceIdx]), whichPieceIdx);
        if(whichPieceIdx>= 0 && whichPieceIdx <= 3){
            flood1(31+((whichPieceIdx)*20),3);
            writePiece.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+(whichPieceIdx*20),3);
            writePiece.avarageX(pieceDepot.getPieces()[whichPieceIdx],44+(whichPieceIdx*20),1, 3);
            writePiece.avarageY(pieceDepot.getPieces()[whichPieceIdx],28+(whichPieceIdx*20),16, 3);
        }else if(whichPieceIdx >= 4 && whichPieceIdx <= 7){
            flood1(31+((whichPieceIdx-4)*20),18);
            writePiece.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31+((whichPieceIdx-4)*20),18);
            writePiece.avarageX(pieceDepot.getPieces()[whichPieceIdx],44+((whichPieceIdx-4)*20),16, 3);
            writePiece.avarageY(pieceDepot.getPieces()[whichPieceIdx],28+((whichPieceIdx-4)*20),31, 3);
        }else if(whichPieceIdx >= 8 && whichPieceIdx <= 12) {
            flood2(31 + ((whichPieceIdx - 8) * 15), 33);
            writePiece.writeToScreen(pieceDepot.getPieces()[whichPieceIdx], 31 + ((whichPieceIdx - 8) * 15), 33);
            writePiece.avarageX(pieceDepot.getPieces()[whichPieceIdx], 41 + ((whichPieceIdx - 8) * 15), 31, 2);
            writePiece.avarageY(pieceDepot.getPieces()[whichPieceIdx], 29 + ((whichPieceIdx - 8) * 15), 42, 2);
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
        if (!isUsedPiece[whichPieceIdx]) {
            int robotCX = (rmcX - 2) / 4 + 1;
            int robotCY = (rmcY - 2) / 4 + 1;
            boolean isAvailable = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (pieceDepot.getPieces()[whichPieceIdx].getCubes()[i][j] != null) {
                        if (robot1.getCubes()[robotCY + i - 1][robotCX + j - 1] == null || robot1.getCubes()[robotCY + i - 1][robotCX + j - 1].getCube_array() == cube.getCube_array() || isCubeFull[robotCY + i - 1][robotCX + j - 1]) {
                            isAvailable = false;
                        }
                    }
                }
            }
            if (isAvailable) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (pieceDepot.getPieces()[whichPieceIdx].getCubes()[i][j] != null) {
                            robot1.setCubesElement(pieceDepot.getPieces()[whichPieceIdx].getCubes()[i][j], robotCY + i - 1, robotCX + j - 1);
                            isCubeFull[robotCY + i - 1][robotCX + j - 1] = true;
                        }
                    }
                }
                writePiece.writeToScreenRobot(robot1, 2, 2);
                robot1.powers();
                writePiece.Inf_area(robot1);

                isUsedPiece[whichPieceIdx] = true;
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


      int px=5,py=5;
      //cn.getTextWindow().output(px,py,'P');
      while(true) {
         if(mousepr==1) {  // if mouse button pressed
            //cn.getTextWindow().output(mousex,mousey,'#');  // write a char to x,y position without changing cursor position
            px=mousex; py=mousey;
            
            mousepr=0;     // last action  
         }

         if(keypr==1) {    // if keyboard button pressed
/*
            if(rkey==KeyEvent.VK_LEFT) px--;   
            if(rkey==KeyEvent.VK_RIGHT) px++;
            if(rkey==KeyEvent.VK_UP) py--;
            if(rkey==KeyEvent.VK_DOWN) py++;

            char rckey=(char)rkey;
            //        left          right          up            down
            if(rckey=='%' || rckey=='\'' || rckey=='&' || rckey=='(') cn.getTextWindow().output(px,py,'P'); // VK kullanmadan test teknigi
            else cn.getTextWindow().output(rckey);
            
            if(rkey==KeyEvent.VK_SPACE) {
               String str;         
               str=cn.readLine();     // keyboardlistener running and readline input by using enter 
               cn.getTextWindow().setCursorPosition(5, 20);
               cn.getTextWindow().output(str);
            }
             */
            keypr=0;    // last action  
         }


         Thread.sleep(20);
      }
   }
}
