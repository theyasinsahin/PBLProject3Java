import java.util.Random;

public class DoubleCube {
    int firstInt;
    int secondInt;
    int thirdInt;
    int fourthInt;

    private double firstColumn;
    private double secondColumn;
    private double firstRow;
    private double secondRow;

    public double getFirstColumn(){
        return this.firstColumn;
    }
    public double getSecondColumn(){
        return this.secondColumn;
    }
    public double getFirstRow(){
        return this.firstRow;
    }public double getSecondRow() {
        return this.secondRow;
    }
    public DoubleCube(int firstInt, int secondInt, int thirdInt, int fourthInt) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
        this.thirdInt = thirdInt;
        this.fourthInt = fourthInt;
    }
    public String[][] create() {

        String a1 = String.valueOf(this.firstInt / 10);
        String a2 = String.valueOf(this.firstInt % 10);
        String b1 = String.valueOf(this.secondInt / 10);
        String b2 = String.valueOf(this.secondInt % 10);
        String c1 = String.valueOf(this.thirdInt / 10);
        String c2 = String.valueOf(this.thirdInt % 10);
        String d1 = String.valueOf(this.fourthInt / 10);
        String d2 = String.valueOf(this.fourthInt % 10);

        String[][] cube = { {"+","+","+","+","+","+","+","+","+"},
                {"+"," ",b1," ","+"," ",d1," ","+"},
                {"+",a1," ",a2,"+",c1," ",c2,"+"},
                {"+"," ",b2," ","+"," ",d2," ","+"},
                {"+","+","+","+","+","+","+","+","+"},
                {"."," "," "," ","."," "," "," ","."},
                {"."," "," "," ","."," "," "," ","."},
                {"."," "," "," ","."," "," "," ","."},
                {".",".",".",".",".",".",".",".","."}
        };
        this.firstRow = (this.firstInt+this.thirdInt) /2;
        this.secondRow = 0;
        this.firstColumn = this.secondColumn;
        this.secondColumn = this.fourthInt;

        return cube;
    }
}
