import java.util.Random;

public class SingleCube {

    int firstInt;
    int secondInt;

    double firstColumn;
    double firstRow;
    public double getFirstColumn(){
        return this.firstColumn;
    }
    public double getFirstRow(){
        return this.firstRow;
    }
    public SingleCube(int firstInt, int secondInt) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
    }

    public String[][] create() {

        String a1 = String.valueOf(this.firstInt / 10);
        String a2 = String.valueOf(this.firstInt % 10);
        String b1 = String.valueOf(this.secondInt / 10);
        String b2 = String.valueOf(this.secondInt % 10);

        String[][] cube = { {"+","+","+","+","+"},{"+"," ",b1," ","+"},{"+",a1," ",a2,"+"},
                {"+"," ",b2," ","+"},{"+","+","+","+","+"} };

        this.firstRow = this.firstInt;
        this.firstColumn = this.secondInt;
        return cube;
    }
}
