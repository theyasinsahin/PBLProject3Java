import java.util.Random;

public class DoubleCube {
    int firstInt;
    int secondInt;
    int thirdInt;
    int fourthInt;
    public DoubleCube(int firstInt, int secondInt, int thirdInt, int fourthInt) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
        this.thirdInt = thirdInt;
        this.fourthInt = fourthInt;
    }
    public String[][] create() {

        String x1 = String.valueOf(this.firstInt / 10);
        String x2 = String.valueOf(this.firstInt % 10);
        String y1 = String.valueOf(this.secondInt / 10);
        String y2 = String.valueOf(this.secondInt % 10);
        String z1 = String.valueOf(this.thirdInt / 10);
        String z2 = String.valueOf(this.thirdInt % 10);
        String j1 = String.valueOf(this.fourthInt / 10);
        String j2 = String.valueOf(this.fourthInt % 10);

        String[][] cube = { {"+","+","+","+","+","+","+","+","+"},
                {"+"," ",y1," ","+"," ",z1," ","+"},
                {"+",x1," ",x2,"+",j1," ",j2,"+"},
                {"+"," ",y2," ","+"," ",z2," ","+"},
                {"+","+","+","+","+","+","+","+","+"},
                {"."," "," "," ","."," "," "," ","."},
                {"."," "," "," ","."," "," "," ","."},
                {"."," "," "," ","."," "," "," ","."},
                {".",".",".",".",".",".",".",".","."}
        };

        return cube;
    }
}
