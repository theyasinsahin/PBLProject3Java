import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enigma.console.TextAttributes;
import java.awt.Color;

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

   static void write(String str, enigma.console.Console cn){
      cn.getTextWindow().output(str);
   }

   static void setCursor(int x, int y, enigma.console.Console cn) {
      cn.getTextWindow().setCursorPosition(x,y);
   }

   static void createOneCube() {
      SingleCube singleCube = new SingleCube(35,42);
      int cubeCX = 25;
      int cubeCY = 20;
      String[][] oneCube = singleCube.create();

      for(int i = 0; i< oneCube.length;i++){
         setCursor(cubeCX,cubeCY, cn);
         for (int j = 0; j<oneCube.length;j++) {
            write(oneCube[i][j], cn);
         }
         cubeCY++;
      }
   }

   static void createTwoCube() {
      DoubleCube doubleCube = new DoubleCube(45,27,35,55);
      String[][] twoCube = doubleCube.create();

      int cubeCX = 25;
      int cubeCY = 5;
      for(int i = 0; i< twoCube.length;i++){
         setCursor(cubeCX,cubeCY, cn);
         for (int j = 0; j< twoCube.length;j++) {
            write(twoCube[i][j], cn);
         }
         cubeCY++;
      }
   }

   static void createThreeCube(int cubeCX, int cubeCY) {
      TribleCube tribleCube = new TribleCube(10,11,12,13,14,15);
      String[][] threeCube = tribleCube.create();

      for(int i = 0; i< threeCube.length;i++){
         setCursor(cubeCX,cubeCY, cn);
         for (int j = 0; j< threeCube.length;j++) {
            write(threeCube[i][j], cn);
         }
         cubeCY++;
      }
   }

   static void createFourCube(int cubeCX, int cubeCY) {
      QuadrupleCube quadrupleCube = new QuadrupleCube(14,17,19,21,23,25,27,29);
      String[][] fourCube = quadrupleCube.create();
      for(int i = 0; i< fourCube.length;i++){
         setCursor(cubeCX,cubeCY, cn);
         for (int j = 0; j< fourCube.length;j++) {
            write(fourCube[i][j], cn);
         }
         cubeCY++;
      }
   }
   Game() throws Exception {

      setCursor(0,0,cn);
      write(
              "+-1---2---3---4---5---> X\n" +
                      "|\n" + "1\n" + "+\n" + "+\n"+ "+\n" + "2\n" + "+\n" + "+\n" + "+\n" + "3\n" + "+\n" + "+\n" + "+\n" + "+\n" + "4\n" + "+\n" + "+\n" + ".\n" + "5\n" + ".\n" + ".\n" + "v\n" + "\n" + "Y", cn);

      setCursor(10,2, cn);
      write(".....",cn);
      setCursor(10,3,cn);
      write(".   .",cn);
      setCursor(10,4,cn);
      write(".   .", cn);
      setCursor(10,5,cn);
      write(".   .\n", cn);

      setCursor(2, 6, cn);
      write(".....................", cn);
      setCursor(2, 7, cn);
      write(".   .   .   .   .   .", cn);
      setCursor(2, 8, cn);
      write(".   .   .   .   .   .", cn);
      setCursor(2, 9, cn);
      write(".   .   .   .   .   .", cn);
      setCursor(2, 10, cn);
      write(".....................", cn);

      setCursor(6,11,cn);
      write(".   .   .   .", cn);
      setCursor(6,12,cn);
      write(".   .   .   .", cn);
      setCursor(6,13,cn);
      write(".   .   .   .", cn);
      setCursor(6,14,cn);
      write(".............", cn);
      setCursor(6,15,cn);
      write(".   .   .   .", cn);
      setCursor(6,16,cn);
      write(".   .   .   .", cn);
      setCursor(6,17,cn);
      write(".   .   .   .", cn);
      setCursor(6,18,cn);
      write(".............", cn);
      setCursor(6,19,cn);
      write(".   .   .   .", cn);
      setCursor(6,20,cn);
      write(".   .   .   .", cn);
      setCursor(6,21,cn);
      write(".   .   .   .", cn);
      setCursor(6,22,cn);
      write(".....   .....", cn);


      setCursor(29,3,cn);
      write("01",cn);
      createFourCube(31,3);

      setCursor(47,3, cn);
      write("02",cn);
      createFourCube(49,3);

      setCursor(65,3, cn);
      write("03",cn);
      createFourCube(67,3);

      setCursor(83,3, cn);
      write("04",cn);
      createFourCube(85,3);



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

               if(e.getKeyCode()== 68) {
                  //x += 10;
                  //cn.getTextWindow().setCursorPosition(x,y);
                  //cn.getTextWindow().output("*");
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
