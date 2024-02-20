import java.util.Random;

public class TribleCube {
    static Random random = new Random();
    int firstInt;
    int secondInt;
    int thirdInt;
    int fourthInt;
    int fifthInt;
    int sixthInt;
    public TribleCube(int firstInt, int secondInt, int thirdInt, int fourthInt, int fifthInt, int sixthInt) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
        this.thirdInt = thirdInt;
        this.fourthInt = fourthInt;
        this.fifthInt = fifthInt;
        this.sixthInt = sixthInt;
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
        String l1 = String.valueOf(this.fifthInt / 10);
        String l2 = String.valueOf(this.fifthInt % 10);
        String k1 = String.valueOf(this.sixthInt / 10);
        String k2 = String.valueOf(this.sixthInt % 10);

        int shape = random.nextInt(2)+1;

        String[][] cube = new String[13][13];
        // SOLID
        if(shape == 1){
            cube = new String[][]{{"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {"+", " ", y1, " ", "+", " ", z1, " ", "+", " ", k1, " ", "+"},
                    {"+", x1, " ", x2, "+", j1, " ", j2, "+", l1, " ", l2, "+"},
                    {"+", " ", y2, " ", "+", " ", z2, " ", "+", " ", k2, " ", "+"},
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
        }
        else if(shape == 2){
            cube = new String[][]{{"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {"+", " ", y1, " ", "+", " ", z1, " ", "+", " ", " ", " ", "."},
                    {"+", x1, " ", x2, "+", j1, " ", j2, "+", " ", " ", " ", "."},
                    {"+", " ", y2, " ", "+", " ", z2, " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {".", " ", " ", " ", "+", " ", k1, " ", "+", " ", " ", " ", "."},
                    {".", " ", " ", " ", "+", l1, " ", l2, "+", " ", " ", " ", "."},
                    {".", " ", " ", " ", "+", " ", k2, " ", "+", " ", " ", " ", "."},
                    {".", ".", ".", ".", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
        }


        return cube;
    }
}
