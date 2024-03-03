import java.util.Random;

public class ComputerRobot {
    static Random random = new Random();
    public  double[] create() {

        double[] powers = new double[3];
        //HEAD
        double In = 0; //Robot Intelligence
        for(int i = 0; i< 4; i++) {
            In += random.nextInt(70)+30;
        }

        //ARMS
        //Left Arm
        double La = 0;
        for(int i = 0; i<2;i++) {
            La += random.nextInt(70)+30;
        }

        //Right Arm
        double Ra = 0;
        for(int i = 0; i<2;i++) {
            Ra += random.nextInt(70)+30;
        }

        //Left leg
        double Ll = 0;
        for(int i = 0; i<3;i++) {
            Ll += random.nextInt(70)+30;
        }

        //Right leg
        double Rl = 0;
        for(int i = 0; i<3;i++) {
            Rl += random.nextInt(70)+30;
        }

        //Arm Power Calculate
        double armBalance = La / Ra;
        double Sk = (La + Ra) / armBalance; //Robot Skill

        //Leg Power Calculate
        double legBalance = Ll / Rl;
        double Sp = (Ll + Rl) / legBalance; //Robot Speed

        powers[0] = In;
        powers[1] = Sk;
        powers[2] = Sp;
        return powers;
    }

}
