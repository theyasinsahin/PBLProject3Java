
import java.util.Random;
import java.util.Set;

public class ResultScreen {

    public ResultScreen(Robot humanR1,Robot humanR2,Robot compR1,Robot compR2){
        hr1 = humanR1;
        hr2 = humanR2;
        cr1 = compR1;
        cr2 = compR2;
    }
    private final Robot hr1;
    private final Robot hr2;
    private final Robot cr1;
    private final Robot cr2;

    static void write(String str) {Game.cn.getTextWindow().output(str);}
    static void setCursor(int x, int y) {Game.cn.getTextWindow().setCursorPosition(x,y);}
    private int cX;
    private int cY;

    private double[][] robotPoints = new double[4][3];
    private String[] winner = new String[3];
    private int point = 0;

    public void screen(){




        robotPoints[0][0] = 0 + Math.floor(hr1.getIntelligence());
        robotPoints[0][1] = 0 + Math.floor(hr1.getSkill());
        robotPoints[0][2] = 0 + Math.floor(hr1.getSpeed());
        robotPoints[1][0] = 0 + Math.floor(hr2.getIntelligence());
        robotPoints[1][1] = 0 + Math.floor(hr2.getSkill());
        robotPoints[1][2] = 0 + Math.floor(hr2.getSpeed());
        robotPoints[2][0] = 0 + Math.floor(cr1.getIntelligence());
        robotPoints[2][1] = 0 + Math.floor(cr1.getSkill());
        robotPoints[2][2] = 0 + Math.floor(cr1.getSpeed());
        robotPoints[3][0] = 0 + Math.floor(cr2.getIntelligence());
        robotPoints[3][1] = 0 + Math.floor(cr2.getSkill());
        robotPoints[3][2] = 0 + Math.floor(cr2.getSpeed());

        for(int i=0; i<4; i++){
            for(int j = 0;j<3;j++){
                if(Double.isNaN(robotPoints[i][j])) {
                    robotPoints[i][j] = 0d;
                }
            }

        }




        setCursor(0,0);write("=== RoboChess ==============================================");
        setCursor(36,1);write("0    5    10   15   20");
        setCursor(36,2);write("+----+----+----+----+");
        setCursor(0,3);write("HR1 - In:"+robotPoints[0][0]+"  Sk:"+robotPoints[0][1]+"  Sp:"+robotPoints[0][2]+"  |");
        setCursor(36,4);write("+----+----+----+----+");
        setCursor(0,5);write("HR2 - In:"+robotPoints[1][0]+"  Sk:"+robotPoints[1][1]+"  Sp:"+robotPoints[1][2]+"  |");
        setCursor(36,6);write("+----+----+----+----+");
        setCursor(0,7);write("CR1 - In:"+robotPoints[2][0]+"  Sk:"+robotPoints[2][1]+"  Sp:"+robotPoints[2][2]+"  |");
        setCursor(36,8);write("+----+----+----+----+");
        setCursor(0,9);write("CR2 - In:"+robotPoints[3][0]+"  Sk:"+robotPoints[3][1]+"  Sp:"+robotPoints[3][2]+"  |");
        setCursor(36,10);write("+----+----+----+----+");
        setCursor(0,11);write("Winner:" + winner[0]);
        setCursor(0,13);write("=== RoboPingPong ===========================================");
        setCursor(36,14);write("0    5    10   15   20");
        setCursor(36,15);write("+----+----+----+----+");
        setCursor(0,16);write("HR1 - In:"+robotPoints[0][0]+"  Sk:"+robotPoints[0][1]+"  Sp:"+robotPoints[0][2]+"  |");
        setCursor(36,17);write("+----+----+----+----+");
        setCursor(0,18);write("HR2 - In:"+robotPoints[1][0]+"  Sk:"+robotPoints[1][1]+"  Sp:"+robotPoints[1][2]+"  |");
        setCursor(36,19);write("+----+----+----+----+");
        setCursor(0,20);write("CR1 - In:"+robotPoints[2][0]+"  Sk:"+robotPoints[2][1]+"  Sp:"+robotPoints[2][2]+"  |");
        setCursor(36,21);write("+----+----+----+----+");
        setCursor(0,22);write("CR2 - In:"+robotPoints[3][0]+"  Sk:"+robotPoints[3][1]+"  Sp:"+robotPoints[3][2]+"  |");
        setCursor(36,23);write("+----+----+----+----+");
        setCursor(0,24);write("Winner:" + winner[1]);
        setCursor(0,26);write("=== RoboRun ================================================");
        setCursor(36,27);write("0    5    10   15   20");
        setCursor(36,28);write("+----+----+----+----+");
        setCursor(0,29);write("HR1 - In:"+robotPoints[0][0]+"  Sk:"+robotPoints[0][1]+"  Sp:"+robotPoints[0][2]+"  |");
        setCursor(36,30);write("+----+----+----+----+");
        setCursor(0,31);write("HR2 - In:"+robotPoints[1][0]+"  Sk:"+robotPoints[1][1]+"  Sp:"+robotPoints[1][2]+"  |");
        setCursor(36,32);write("+----+----+----+----+");
        setCursor(0,33);write("CR1 - In:"+robotPoints[2][0]+"  Sk:"+robotPoints[2][1]+"  Sp:"+robotPoints[2][2]+"  |");
        setCursor(36,34);write("+----+----+----+----+");
        setCursor(0,35);write("CR2 - In:"+robotPoints[3][0]+"  Sk:"+robotPoints[3][1]+"  Sp:"+robotPoints[3][2]+"  |");
        setCursor(36,36);write("+----+----+----+----+");
        setCursor(0,37);write("Winner:" + winner[1]);
        setCursor(0,39);write("Total winner of the RoboOlympics: ____ team");


    }

    // chess = game 1
    // ping pong = game 2
    // run = game 3
    public void gameInitializer(int whichGame){
        int[] roboScore = new int[4];
        int whichRobot = 0;

        int y;
        int y1 = 0;
        Random random = new Random();
        double total = (robotPoints[0][whichGame] + robotPoints[1][whichGame] + robotPoints[2][whichGame] + robotPoints[3][whichGame]);
        while((roboScore[0]<20)&&(roboScore[1]<20)&&(roboScore[2]<20)&&(roboScore[3]<20)){

            double randomNum =  random.nextDouble(1,total+1);
            if(randomNum <= robotPoints[0][whichGame]){
                roboScore[0]++;
                whichRobot = 0;
            }else if(randomNum <=(robotPoints[0][whichGame]+robotPoints[1][whichGame])){
                roboScore[1]++;
                whichRobot = 1;
            } else if(randomNum <= robotPoints[0][whichGame]+robotPoints[1][whichGame]+robotPoints[2][whichGame]) {
                roboScore[2]++;
                whichRobot = 2;
            }else if(randomNum<=total) {
                roboScore[3]++;
                whichRobot = 3;
            }
            if(whichGame==0){
                y = 3;
                y1 = 11;

            }else if(whichGame==1){
                y = 16;
                y1 = 24;
            }else{
                y1 = 37;
                y = 29;
            }

            for(int j = 0;j<roboScore[whichRobot];j++){

                setCursor(37+j,y+(whichRobot*2));write("X");
            }


        }
        setCursor(7,y1);
        if((roboScore[0]==20)||(roboScore[1]==20)){
            winner[whichGame] = "Blue Team";
            point += 2;

        }else {
            winner[whichGame] = "Red Team";
            point++;
        }
        write(winner[whichGame]);

        if(whichGame == 2){
            setCursor(33,39);write("                     ");
            if(point <= 4){
                setCursor(33,39);write(" Red Team!!!");
            }else{
                setCursor(33,39);write(" Blue Team!!!");
            }

        }

    }

}
