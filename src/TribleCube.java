import java.util.Random;

public class TribleCube {
    static Random random = new Random();
    private int firstInt;
    private int secondInt;
    private int thirdInt;
    private int fourthInt;
    private int fifthInt;
    private int sixthInt;

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
    public TribleCube(int firstInt, int secondInt, int thirdInt, int fourthInt, int fifthInt, int sixthInt) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
        this.thirdInt = thirdInt;
        this.fourthInt = fourthInt;
        this.fifthInt = fifthInt;
        this.sixthInt = sixthInt;
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

        int shape = random.nextInt(2)+1;

        String[][] cube = new String[13][13];
        // SOLID
        if(shape == 1){
            cube = new String[][]{{"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {"+", " ", b1, " ", "+", " ", d1, " ", "+", " ", f1, " ", "+"},
                    {"+", a1, " ", a2, "+", c1, " ", c2, "+", e1, " ", e2, "+"},
                    {"+", " ", b2, " ", "+", " ", d2, " ", "+", " ", f2, " ", "+"},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
            this.firstColumn = this.secondInt;
            this.secondColumn = this.fourthInt;
            this.thirdColumn = this.sixthInt;
            this.firstRow = (this.firstInt+this.thirdInt+this.fifthInt) / 3;
            this.secondRow = 0;
            this.thirdRow = 0;
        }
        else if(shape == 2){
            cube = new String[][]{{"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {"+", " ", b1, " ", "+", " ", d1, " ", "+", " ", " ", " ", "."},
                    {"+", a1, " ", a2, "+", c1, " ", c2, "+", " ", " ", " ", "."},
                    {"+", " ", b2, " ", "+", " ", d2, " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {".", " ", " ", " ", "+", " ", f1, " ", "+", " ", " ", " ", "."},
                    {".", " ", " ", " ", "+", e1, " ", e2, "+", " ", " ", " ", "."},
                    {".", " ", " ", " ", "+", " ", f2, " ", "+", " ", " ", " ", "."},
                    {".", ".", ".", ".", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
            this.firstColumn = this.secondInt;
            this.secondColumn = (this.fourthInt + this.sixthInt)/2;
            this.thirdColumn = 0;
            this.firstRow = (this.firstInt+this.thirdInt) / 2;
            this.secondRow = this.fifthInt;
            this.thirdRow = 0;
        }


        return cube;
    }
}
