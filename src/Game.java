import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enigma.console.TextAttributes;
import java.awt.Color;
import java.util.Random;

public class Game {
   public static enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard");
   public TextMouseListener tmlis; 
   public KeyListener klis; 

   // ------ Standard variables for mouse and keyboard ------
   public int mousepr;          // mouse pressed?
   public int mousex, mousey;   // mouse text coords.
   public int keypr;   // key pressed?
   public int rkey;    // key   (for press/release)
   // ----------------------------------------------------

   int rmcX = 2; int rmcY = 2;

   int pieceX = 28; int pieceY = 2;

   static Random random = new Random();

   static void write(String str){
      cn.getTextWindow().output(str);
   }

   static void setCursor(int x, int y) {
      cn.getTextWindow().setCursorPosition(x,y);
   }

   static void createOneCube(int cubeCX, int cubeCY) {
      SingleCube singleCube = new SingleCube(random.nextInt(75), random.nextInt(75));

      String[][] oneCube = singleCube.create();

      for(int i = 0; i< oneCube.length;i++){
         setCursor(cubeCX,cubeCY);
         for (int j = 0; j<oneCube.length;j++) {
            write(oneCube[i][j]);
         }
         cubeCY++;
      }
   }

   static void createTwoCube(int cubeCX, int cubeCY) {
      DoubleCube doubleCube = new DoubleCube(random.nextInt(75)+6, random.nextInt(75)+6,random.nextInt(75)+6, random.nextInt(75)+6);
      String[][] twoCube = doubleCube.create();

      for(int i = 0; i< twoCube.length;i++){
         setCursor(cubeCX,cubeCY);
         for (int j = 0; j< twoCube.length;j++) {
            write(twoCube[i][j]);
         }
         cubeCY++;
      }
   }

   static void createThreeCube(int cubeCX, int cubeCY) {
      TribleCube tribleCube = new TribleCube(random.nextInt(75)+12, random.nextInt(75)+12,random.nextInt(75)+12, random.nextInt(75)+12,random.nextInt(75)+12,random.nextInt(75)+12);
      String[][] threeCube = tribleCube.create();

      for(int i = 0; i< threeCube.length;i++){
         setCursor(cubeCX,cubeCY);
         for (int j = 0; j< threeCube.length;j++) {
            write(threeCube[i][j]);
         }
         cubeCY++;
      }
      setCursor(cubeCX+14, cubeCY-11);
      String firstRow = String.valueOf(tribleCube.getFirstRow());
      write(firstRow);

      setCursor(cubeCX+14, cubeCY-7);
      String secondRow = String.valueOf(tribleCube.getSecondRow());
      write(secondRow);

      setCursor(cubeCX+14, cubeCY-3);
      String thirdRow = String.valueOf(tribleCube.getThirdRow());
      write(thirdRow);
   }

   static void createFourCube(int cubeCX, int cubeCY) {
      QuadrupleCube quadrupleCube = new QuadrupleCube(random.nextInt(75)+24, random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24, random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24);
      String[][] fourCube = quadrupleCube.create();
      for(int i = 0; i< fourCube.length;i++){
         setCursor(cubeCX,cubeCY);
         for (int j = 0; j< fourCube.length;j++) {
            write(fourCube[i][j]);
         }
         cubeCY++;
      }
      setCursor(cubeCX+14, cubeCY-11);
      String firstRow = String.valueOf(quadrupleCube.getFirstRow());
      write(firstRow);

      setCursor(cubeCX+14, cubeCY-7);
      String secondRow = String.valueOf(quadrupleCube.getSecondRow());
      write(secondRow);

      setCursor(cubeCX+14, cubeCY-3);
      String thirdRow = String.valueOf(quadrupleCube.getThirdRow());
      write(thirdRow);
   }

   static void robotTemplate(){
      setCursor(10,2);
      write(".....");
      setCursor(10,3);
      write(".   .");
      setCursor(10,4);
      write(".   .");
      setCursor(10,5);
      write(".   .\n");

      setCursor(2, 6);
      write(".....................");
      setCursor(2, 7);
      write(".   .   .   .   .   .");
      setCursor(2, 8);
      write(".   .   .   .   .   .");
      setCursor(2, 9);
      write(".   .   .   .   .   .");
      setCursor(2, 10);
      write(".....................");

      setCursor(6,11);
      write(".   .   .   .");
      setCursor(6,12);
      write(".   .   .   .");
      setCursor(6,13);
      write(".   .   .   .");
      setCursor(6,14);
      write(".............");
      setCursor(6,15);
      write(".   .   .   .");
      setCursor(6,16);
      write(".   .   .   .");
      setCursor(6,17);
      write(".   .   .   .");
      setCursor(6,18);
      write(".............");
      setCursor(6,19);
      write(".   .   .   .");
      setCursor(6,20);
      write(".   .   .   .");
      setCursor(6,21);
      write(".   .   .   .");
      setCursor(6,22);
      write(".....   .....");
   }
   Game() throws Exception {

      setCursor(0,0);
      write(
              "+-1---2---3---4---5---> X\n" +
                      "|\n" + "1\n" + "+\n" + "+\n"+ "+\n" + "2\n" + "+\n" + "+\n" + "+\n" + "3\n" + "+\n" + "+\n" + "+\n" + "+\n" + "4\n" + "+\n" + "+\n" + ".\n" + "5\n" + ".\n" + ".\n" + "v\n" + "\n" + "Y");

      robotTemplate();

      setCursor(0,27);
      write("Current piece (#)");
      setCursor(2,28); write("X:1");
      setCursor(8,28); write("Y:1");
      setCursor(0,29); write("Used pieces (=/-)");


      //Küpleri oluşturma
      setCursor(29,3);
      write("01");
      createFourCube(31,3);

      setCursor(47,3);
      write("02");
      createFourCube(49,3);

      setCursor(65,3);
      write("03");
      createFourCube(67,3);


      setCursor(29,16);
      write("05");
      createThreeCube(31,16);


      setCursor(47,16);
      write("06");
      createThreeCube(49,16);

      setCursor(65,16);
      write("07");
      createThreeCube(67,16);



      setCursor(pieceX,pieceY); write("###");
      setCursor(pieceX,pieceY+1); write("#");
      setCursor(pieceX,pieceY+2); write("###");

      setCursor(rmcX,rmcY); write("#");
      // --- Contructor
                 
      // ------ Standard code for mouse and keyboard ------ Do not change
      tmlis=new TextMouseListener() {
         public void mouseClicked(TextMouseEvent arg0) {

         }
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

               // Yer Seçimi
               if(e.getKeyCode()== 'D' && (rmcX-2)/4+1 < 5) {
                  setCursor(rmcX, rmcY); write(" ");
                  rmcX += 4;
                  setCursor(rmcX, rmcY); write("#");
               }
               else if(e.getKeyCode()== 'A' && (rmcX-2)/4+1 > 1) {
                  setCursor(rmcX, rmcY); write(" ");
                  rmcX -= 4;
                  setCursor(rmcX, rmcY); write("#");
               }
               else if(e.getKeyCode()== 'W' && (rmcY-2)/4+1 > 1) {
                  setCursor(rmcX, rmcY); write(" ");
                  rmcY -= 4;
                  setCursor(rmcX, rmcY); write("#");
               }
               else if(e.getKeyCode()== 'S' && (rmcY-2)/4+1 < 5) {
                  setCursor(rmcX, rmcY); write(" ");
                  rmcY += 4;
                  setCursor(rmcX, rmcY); write("#");
               }
               
               //Küp Seçimi
               //başlangıç koordinatı 27ye 1
               //sol ok -> 37
               //yukarı ok -> 38
               //Sağ ok -> 39
               //Aşağı ok -> 40
               else if (e.getKeyCode() == 37 && pieceX>28) {
                  setCursor(pieceX,pieceY); write("   ");
                  setCursor(pieceX,pieceY+1); write(" ");
                  setCursor(pieceX,pieceY+2); write("   ");
                  pieceX -= 18;
                  setCursor(pieceX,pieceY); write("###");
                  setCursor(pieceX,pieceY+1); write("#");
                  setCursor(pieceX,pieceY+2); write("###");
               }
               else if (e.getKeyCode() == 39 && pieceX < 60) {
                  setCursor(pieceX,pieceY); write("   ");
                  setCursor(pieceX,pieceY+1); write(" ");
                  setCursor(pieceX,pieceY+2); write("   ");
                  pieceX += 18;
                  setCursor(pieceX,pieceY); write("###");
                  setCursor(pieceX,pieceY+1); write("#");
                  setCursor(pieceX,pieceY+2); write("###");
               }
               else if (e.getKeyCode() == 38 && pieceY>2) {
                  setCursor(pieceX,pieceY); write("   ");
                  setCursor(pieceX,pieceY+1); write(" ");
                  setCursor(pieceX,pieceY+2); write("   ");
                  pieceY -= 13;
                  setCursor(pieceX,pieceY); write("###");
                  setCursor(pieceX,pieceY+1); write("#");
                  setCursor(pieceX,pieceY+2); write("###");
               }
               else if (e.getKeyCode() == 40 && pieceY<13) {
                  setCursor(pieceX,pieceY); write("   ");
                  setCursor(pieceX,pieceY+1); write(" ");
                  setCursor(pieceX,pieceY+2); write("   ");
                  pieceY += 13;
                  setCursor(pieceX,pieceY); write("###");
                  setCursor(pieceX,pieceY+1); write("#");
                  setCursor(pieceX,pieceY+2); write("###");
               }

               String positionX = String.valueOf((rmcX-2)/4+1);
               String positionY = String.valueOf((rmcY-2)/4+1);
               setCursor(4,28); write(positionX);
               setCursor(10,28); write(positionY);
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
            if(rkey==KeyEvent.VK_LEFT) px--;   
            if(rkey==KeyEvent.VK_RIGHT) px++;
            if(rkey==KeyEvent.VK_UP) py--;
            if(rkey==KeyEvent.VK_DOWN) py++;
            
            char rckey=(char)rkey;
            //        left          right          up            down
            if(rckey=='%' || rckey=='\'' || rckey=='&' || rckey=='(')
               //cn.getTextWindow().output(px,py,'P'); // VK kullanmadan test teknigi
            //else
               //cn.getTextWindow().output(rckey);
            
            if(rkey==KeyEvent.VK_SPACE) {
               String str;         
               str=cn.readLine();     // keyboardlistener running and readline input by using enter 
               cn.getTextWindow().setCursorPosition(5, 20);
               cn.getTextWindow().output(str);
            }
            
            keypr=0;    // last action  
         }
         Thread.sleep(20);
      }
   }
}
