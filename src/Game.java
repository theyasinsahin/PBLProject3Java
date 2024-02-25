import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enigma.console.TextAttributes;
import java.awt.Color;
import java.util.Random;

public class Game {
   public static enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard", 150, 50);
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

   SingleCube singleCube1 = new SingleCube(random.nextInt(75), random.nextInt(75));
   SingleCube singleCube2 = new SingleCube(random.nextInt(75), random.nextInt(75));
   SingleCube singleCube3 = new SingleCube(random.nextInt(75), random.nextInt(75));
   SingleCube singleCube4 = new SingleCube(random.nextInt(75), random.nextInt(75));
   SingleCube singleCube5 = new SingleCube(random.nextInt(75), random.nextInt(75));
   SingleCube singleCube6 = new SingleCube(random.nextInt(75), random.nextInt(75));
   SingleCube singleCube7 = new SingleCube(random.nextInt(75), random.nextInt(75));


   DoubleCube doubleCube1 = new DoubleCube(random.nextInt(75)+6, random.nextInt(75)+6,random.nextInt(75)+6, random.nextInt(75)+6);
   DoubleCube doubleCube2 = new DoubleCube(random.nextInt(75)+6, random.nextInt(75)+6,random.nextInt(75)+6, random.nextInt(75)+6);
   DoubleCube doubleCube3 = new DoubleCube(random.nextInt(75)+6, random.nextInt(75)+6,random.nextInt(75)+6, random.nextInt(75)+6);
   DoubleCube doubleCube4 = new DoubleCube(random.nextInt(75)+6, random.nextInt(75)+6,random.nextInt(75)+6, random.nextInt(75)+6);
   DoubleCube doubleCube5 = new DoubleCube(random.nextInt(75)+6, random.nextInt(75)+6,random.nextInt(75)+6, random.nextInt(75)+6);


   TribleCube tribleCube1 = new TribleCube(random.nextInt(75)+12, random.nextInt(75)+12,random.nextInt(75)+12, random.nextInt(75)+12,random.nextInt(75)+12,random.nextInt(75)+12);
   TribleCube tribleCube2 = new TribleCube(random.nextInt(75)+12, random.nextInt(75)+12,random.nextInt(75)+12, random.nextInt(75)+12,random.nextInt(75)+12,random.nextInt(75)+12);
   TribleCube tribleCube3 = new TribleCube(random.nextInt(75)+12, random.nextInt(75)+12,random.nextInt(75)+12, random.nextInt(75)+12,random.nextInt(75)+12,random.nextInt(75)+12);
   TribleCube tribleCube4 = new TribleCube(random.nextInt(75)+12, random.nextInt(75)+12,random.nextInt(75)+12, random.nextInt(75)+12,random.nextInt(75)+12,random.nextInt(75)+12);


   QuadrupleCube quadrupleCube1 = new QuadrupleCube(random.nextInt(75)+24, random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24, random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24);
   QuadrupleCube quadrupleCube2 = new QuadrupleCube(random.nextInt(75)+24, random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24, random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24);
   QuadrupleCube quadrupleCube3 = new QuadrupleCube(random.nextInt(75)+24, random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24, random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24);
   QuadrupleCube quadrupleCube4 = new QuadrupleCube(random.nextInt(75)+24, random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24, random.nextInt(75)+24,random.nextInt(75)+24,random.nextInt(75)+24);


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
      write("Current piece (#):");
      setCursor(2,28); write("X:1");
      setCursor(8,28); write("Y:1");
      setCursor(0,29); write("Used pieces (=/-)");


      //KÜPLERİ OLUŞTURMA

      //Dörtlü Küpler
      setCursor(29,3);
      write("01");
      String[][] fourCube1 = CreateCubes.createFourCube(31,3, quadrupleCube1);

      setCursor(49,3);
      write("02");
      CreateCubes.createFourCube(51,3, quadrupleCube2);

      setCursor(69,3);
      write("03");
      CreateCubes.createFourCube(71,3, quadrupleCube3);

      setCursor(89,3);
      write("04");
      CreateCubes.createFourCube(91,3, quadrupleCube4);

      //Üçlü Küpler
      setCursor(29,18);
      write("05");
      CreateCubes.createThreeCube(31,18, tribleCube1);


      setCursor(49,18);
      write("06");
      CreateCubes.createThreeCube(51,18, tribleCube2);

      setCursor(69,18);
      write("07");
      CreateCubes.createThreeCube(71,18, tribleCube3);

      setCursor(89,18);
      write("08");
      CreateCubes.createThreeCube(91,18, tribleCube4);

      //İkili küpler
      setCursor(29,33);
      write("09");
      CreateCubes.createTwoCube(31,33, doubleCube1);

      setCursor(44,33);
      write("10");
      CreateCubes.createTwoCube(46,33, doubleCube2);

      setCursor(59,33);
      write("11");
      CreateCubes.createTwoCube(61,33, doubleCube3);

      setCursor(74,33);
      write("12");
      CreateCubes.createTwoCube(76,33, doubleCube4);

      setCursor(89,33);
      write("13");
      CreateCubes.createTwoCube(91,33, doubleCube5);

      //Tek küpler
      setCursor(29,44);
      write("14");
      CreateCubes.createOneCube(31,44, singleCube1);

      setCursor(40,44);
      write("15");
      CreateCubes.createOneCube(42,44, singleCube2);

      setCursor(51,44);
      write("16");
      CreateCubes.createOneCube(53,44, singleCube3);

      setCursor(62,44);
      write("17");
      CreateCubes.createOneCube(64,44, singleCube4);

      setCursor(73,44);
      write("18");
      CreateCubes.createOneCube( 75,44, singleCube5);

      setCursor(84,44);
      write("19");
      CreateCubes.createOneCube(86,44, singleCube6);

      setCursor(95,44);
      write("20");
      CreateCubes.createOneCube(97,44, singleCube7);



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
                  robotTemplate();
                  rmcX += 4;
                  setCursor(rmcX, rmcY); write("#");
               }
               else if(e.getKeyCode()== 'A' && (rmcX-2)/4+1 > 1) {
                  setCursor(rmcX, rmcY); write(" ");
                  robotTemplate();
                  rmcX -= 4;
                  setCursor(rmcX, rmcY); write("#");
               }
               else if(e.getKeyCode()== 'W' && (rmcY-2)/4+1 > 1) {
                  setCursor(rmcX, rmcY); write(" ");
                  robotTemplate();
                  rmcY -= 4;
                  setCursor(rmcX, rmcY); write("#");
               }
               else if(e.getKeyCode()== 'S' && (rmcY-2)/4+1 < 5) {
                  setCursor(rmcX, rmcY); write(" ");
                  robotTemplate();
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



               /////////Robot Üzerinde Parçaları Gösterme
               /*
               if(pieceX == 28 && pieceY == 2) {
                  for(int i = 1; i<23;i++) {
                     for(int j = 1; j<23;j++){
                        setCursor(i,j);
                        write(" ");
                     }
                  }
                  robotTemplate();
                  CreateCubes.showJustCube(rmcX,rmcY, fourCube1);
               }
               */


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
