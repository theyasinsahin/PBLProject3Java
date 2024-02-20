import java.util.Random;

public class SingleCube {

    int firstInt;
    int secondInt;
    public SingleCube(int firstInt, int secondInt) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
    }

    public String[][] create() {

        String x1 = String.valueOf(this.firstInt / 10);
        String x2 = String.valueOf(this.firstInt % 10);
        String y1 = String.valueOf(this.secondInt / 10);
        String y2 = String.valueOf(this.secondInt % 10);

        String[][] cube = { {"+","+","+","+","+"},{"+"," ",y1," ","+"},{"+",x1," ",x2,"+"},
                {"+"," ",y2," ","+"},{"+","+","+","+","+"} };

        return cube;
    }
}
