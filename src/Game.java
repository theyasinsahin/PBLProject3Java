import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {

    int rmcX = 2; int rmcY = 2;

    int pieceX = 28; int pieceY = 2;

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
   public static enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard",150,55);
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

       setCursor(0,27);
       write("Current piece (#):");
       setCursor(2,28); write("X:1");
       setCursor(8,28); write("Y:1");
       setCursor(0,29); write("Used pieces (=/-)");

      setCursor(0,0);
      write(
              "+-1---2---3---4---5---> X\n" +
                      "|\n" + "1\n" + "+\n" + "+\n"+ "+\n" + "2\n" + "+\n" + "+\n" + "+\n" + "3\n" + "+\n" + "+\n" + "+\n" + "4\n" + "+\n" + "+\n" + ".\n" + "5\n" + ".\n" + ".\n" + "v\n" + "\n" + "Y");


      //Robotun ekrana yazılması
     Robot robot1=new Robot();
     WritePiece writePiece =new WritePiece();
     robot1.creatRobot();
     writePiece.writeToScreenRobot(robot1,2,2);


     //Seçili Parçayı gösterilir
       setCursor(pieceX,pieceY); write("###");
       setCursor(pieceX,pieceY+1); write("#");
       setCursor(pieceX,pieceY+2); write("###");

       //robot üzerindeki seçili yer gösterilir
       setCursor(rmcX,rmcY); write("#");


       Rotate rotate = new Rotate();
       Reverse reverse = new Reverse();

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
       setCursor(29,44);
       write("14");
       writePiece.writeToScreen(piece14, 31,44);
       writePiece.avarageX(piece14, 37, 42, 1);
       writePiece.avarageY(piece14, 29, 49, 1);

       setCursor(40,44);
       write("15");
       writePiece.writeToScreen(piece15, 42,44);
       writePiece.avarageX(piece15, 48, 42, 1);
       writePiece.avarageY(piece15, 39, 49, 1);

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
                else if (e.getKeyCode() == 37 && pieceX>28) {
                    setCursor(pieceX,pieceY); write("   ");
                    setCursor(pieceX,pieceY+1); write(" ");
                    setCursor(pieceX,pieceY+2); write("   ");
                    pieceX -= 20;
                    setCursor(pieceX,pieceY); write("###");
                    setCursor(pieceX,pieceY+1); write("#");
                    setCursor(pieceX,pieceY+2); write("###");
                }
                else if (e.getKeyCode() == 39 && pieceX < 70) {
                    setCursor(pieceX,pieceY); write("   ");
                    setCursor(pieceX,pieceY+1); write(" ");
                    setCursor(pieceX,pieceY+2); write("   ");
                    pieceX += 20;
                    setCursor(pieceX,pieceY); write("###");
                    setCursor(pieceX,pieceY+1); write("#");
                    setCursor(pieceX,pieceY+2); write("###");
                }
                else if (e.getKeyCode() == 38 && pieceY>2) {
                    setCursor(pieceX,pieceY); write("   ");
                    setCursor(pieceX,pieceY+1); write(" ");
                    setCursor(pieceX,pieceY+2); write("   ");
                    pieceY -= 15;
                    setCursor(pieceX,pieceY); write("###");
                    setCursor(pieceX,pieceY+1); write("#");
                    setCursor(pieceX,pieceY+2); write("###");
                }
                else if (e.getKeyCode() == 40 && pieceY<13) {
                    setCursor(pieceX,pieceY); write("   ");
                    setCursor(pieceX,pieceY+1); write(" ");
                    setCursor(pieceX,pieceY+2); write("   ");
                    pieceY += 15;
                    setCursor(pieceX,pieceY); write("###");
                    setCursor(pieceX,pieceY+1); write("#");
                    setCursor(pieceX,pieceY+2); write("###");
                }

                setCursor(19,27);
                switch (pieceX){
                    case 28:
                        switch (pieceY){
                            case 2:
                                write("1");
                                break;
                            case 17:
                                write("5");
                                break;
                        }
                        break;
                    case 48:
                        switch (pieceY){
                            case 2:
                                write("2");
                                break;
                            case 17:
                                write("6");
                                break;
                        }
                        break;
                    case 68:
                        switch (pieceY){
                            case 2:
                                write("3");
                                break;
                            case 17:
                                write("7");
                                break;
                        }
                        break;
                    case 88:
                        switch (pieceY){
                            case 2:
                                write("4");
                                break;
                            case 17:
                                write("8");
                                break;
                        }
                }

                /////////////// ROTATE AND REVERSE //////////////////////
               if(e.getKeyCode()=='2' && pieceX == 28 && pieceY == 2){
                  piece1= rotate.rotateToRight(piece1);
                   flood1(31,3);
                   writePiece.writeToScreen(piece1,31,3);
                   writePiece.avarageX(piece1,44,1, 3);
                   writePiece.avarageY(piece1,28,16, 3);
               }

               if(e.getKeyCode()=='3'  && pieceX == 28 && pieceY == 2){
                   piece1 = reverse.takeTheReverse(piece1);
                   flood1(31,3);
                   writePiece.writeToScreen(piece1,31,3);
                   writePiece.avarageX(piece1,44,1, 3);
                   writePiece.avarageY(piece1,28,16, 3);
               }

                if(e.getKeyCode()=='2' && pieceX == 48 && pieceY == 2){
                    piece2= rotate.rotateToRight(piece2);
                    flood1(51,3);
                    writePiece.writeToScreen(piece2,51,3);
                    writePiece.avarageX(piece2,64,1, 3);
                    writePiece.avarageY(piece2,48,16, 3);
                }

                if(e.getKeyCode()=='3'  && pieceX == 48 && pieceY == 2){
                    piece2 = reverse.takeTheReverse(piece2);
                    flood1(51,3);
                    writePiece.writeToScreen(piece2,51,3);
                    writePiece.avarageX(piece2,64,1, 3);
                    writePiece.avarageY(piece2,48,16, 3);
                }
            }


             ////////////////ROBOT ÜZERİNDE HANGİ KOORDİNATI GÖSTERDİĞİMİZ
             String positionX = String.valueOf((rmcX-2)/4+1);
             String positionY = String.valueOf((rmcY-2)/4+1);
             setCursor(4,28); write(positionX);
             setCursor(10,28); write(positionY);


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
