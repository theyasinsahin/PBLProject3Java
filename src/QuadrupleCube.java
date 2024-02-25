import java.util.Random;
import java.util.function.DoublePredicate;

public class QuadrupleCube {

    int firstInt;
    int secondInt;
    int thirdInt;
    int fourthInt;
    int fifthInt;
    int sixthInt;
    int seventhInt;
    int eighthInt;
    Random random = new Random();

    private double firstColumn;
    private double secondColumn;
    private double thirdColumn;
    private double firstRow;
    private double secondRow;
    private double thirdRow;
    public double getFirstColumn(){
        return this.firstColumn;
    }
    public double getSecondColumn(){
        return this.secondColumn;
    }public double getThirdColumn(){
        return this.thirdColumn;
    }public double getFirstRow(){
        return this.firstRow;
    }public double getSecondRow(){
        return this.secondRow;
    }public double getThirdRow(){
        return this.thirdRow;
    }

    public String getA1(){
        return String.valueOf(firstInt/10);
    }
    public QuadrupleCube(int firstInt, int secondInt, int thirdInt, int fourthInt, int fifthInt, int sixthInt, int seventhInt, int eighthInt) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
        this.thirdInt = thirdInt;
        this.fourthInt = fourthInt;
        this.fifthInt = fifthInt;
        this.sixthInt = sixthInt;
        this.seventhInt = seventhInt;
        this.eighthInt = eighthInt;
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
        String e1 = String.valueOf(this.fifthInt / 10);
        String e2 = String.valueOf(this.fifthInt % 10);
        String f1 = String.valueOf(this.sixthInt / 10);
        String f2 = String.valueOf(this.sixthInt % 10);
        String g1 = String.valueOf(this.seventhInt / 10);
        String g2 = String.valueOf(this.seventhInt % 10);
        String h1 = String.valueOf(this.eighthInt / 10);
        String h2 = String.valueOf(this.eighthInt % 10);

        int shape = random.nextInt(4)+1;

        String[][] cube = new String[13][13];
        // L
        if (shape == 1) {
            cube = new String[][]{{"+", "+", "+", "+", "+", ".", ".", ".", ".", ".", ".", ".", "."},
                    {"+", " ", b1, " ", "+", " ", " ", " ", ".", " ", " ", " ", "."},
                    {"+", a1, " ", a2, "+", " ", " ", " ", ".", " ", " ", " ", "."},
                    {"+", " ", b2, " ", "+", " ", " ", " ", ".", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {"+", " ", d1, " ", "+", " ", f1, " ", "+", " ", h1, " ", "+"},
                    {"+", c1, " ", c2, "+", e1, " ", e2, "+", g1, " ", g2, "+"},
                    {"+", " ", d2, " ", "+", " ", f2, " ", "+", " ", h2, " ", "+"},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
            this.firstColumn = (Double.valueOf(this.secondInt) + Double.valueOf(this.fourthInt)) / 2;
            this.secondColumn = this.sixthInt;
            this.thirdColumn = this.eighthInt;
            this.firstRow = this.firstInt;
            this.secondRow = (Double.valueOf(this.thirdInt) + Double.valueOf(this.fifthInt) + Double.valueOf(this.seventhInt)) / 3;
            this.thirdRow = 0;
        }
        //
        else if (shape == 2) {
            cube = new String[][]{{".", ".", ".", ".", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {".", " ", " ", " ", "+", " ", b1, " ", "+", " ", " ", " ", "."},
                    {".", " ", " ", " ", "+", a1, " ", a2, "+", " ", " ", " ", "."},
                    {".", " ", " ", " ", "+", " ", b2, " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {"+", " ", d1, " ", "+", " ", f1, " ", "+", " ", h1, " ", "+"},
                    {"+", c1, " ", c2, "+", e1, " ", e2, "+", g1, " ", g2, "+"},
                    {"+", " ", d2, " ", "+", " ", f2, " ", "+", " ", h2, " ", "+"},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
            this.firstColumn = this.fourthInt;
            this.secondColumn = (Double.valueOf(this.secondInt) + Double.valueOf(this.sixthInt)) / 2;
            this.thirdColumn = this.eighthInt;
            this.firstRow = this.firstInt;
            this.secondRow = (Double.valueOf(this.thirdInt) + Double.valueOf(this.fifthInt) + Double.valueOf(this.seventhInt)) / 3;
            this.thirdRow = 0;
        }
        else if (shape == 3) {
            cube = new String[][]{{".", ".", ".", ".", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {".", " ", " ", " ", "+", " ", b1, " ", "+", " ", d1, " ", "+"},
                    {".", " ", " ", " ", "+", a1, " ", a2, "+", c1, " ", c2, "+"},
                    {".", " ", " ", " ", "+", " ", b2, " ", "+", " ", d2, " ", "+"},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {"+", " ", f1, " ", "+", " ", h1, " ", "+", " ", " ", " ", "."},
                    {"+", e1, " ", e2, "+", g1, " ", g2, "+", " ", " ", " ", "."},
                    {"+", " ", f2, " ", "+", " ", h2, " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
            this.firstColumn = this.sixthInt;
            this.secondColumn = (Double.valueOf(this.secondInt) + Double.valueOf(eighthInt)) / 2;
            this.thirdColumn = this.fourthInt;
            this.firstRow = (Double.valueOf(this.firstInt) + Double.valueOf(this.thirdInt)) / 2;
            this.secondRow = (Double.valueOf(this.fifthInt) + Double.valueOf(this.seventhInt)) / 2;
            this.thirdRow = 0;
        }
        else if (shape == 4) {
            cube = new String[][]{{"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {"+", " ", b1, " ", "+", " ", d1, " ", "+", " ", " ", " ", "."},
                    {"+", a1, " ", a2, "+", c1, " ", c2, "+", " ", " ", " ", "."},
                    {"+", " ", b2, " ", "+", " ", d2, " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {"+", " ", f1, " ", "+", " ", h1, " ", "+", " ", " ", " ", "."},
                    {"+", e1, " ", e2, "+", g1, " ", g2, "+", " ", " ", " ", "."},
                    {"+", " ", f2, " ", "+", " ", h2, " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
            this.firstColumn = (Double.valueOf(this.secondInt) + Double.valueOf(this.sixthInt)) / 2;
            this.secondColumn = (Double.valueOf(this.fourthInt) + Double.valueOf(this.eighthInt)) / 2;
            this.thirdColumn = 0;
            this.firstRow = (Double.valueOf(this.firstInt) + Double.valueOf(this.thirdInt)) / 2;
            this.secondRow = (Double.valueOf(this.fifthInt) + Double.valueOf(this.seventhInt)) / 2;
            this.thirdRow = 0;
        }
        return cube;
    }
}