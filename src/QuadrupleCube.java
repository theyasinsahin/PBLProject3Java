import java.util.Random;

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
        String a1 = String.valueOf(this.fifthInt / 10);
        String a2 = String.valueOf(this.fifthInt % 10);
        String b1 = String.valueOf(this.sixthInt / 10);
        String b2 = String.valueOf(this.sixthInt % 10);

        int shape = random.nextInt(4)+1;

        String[][] cube = new String[13][13];
        // L
        if (shape == 1) {
            cube = new String[][]{{"+", "+", "+", "+", "+", ".", ".", ".", ".", ".", ".", ".", "."},
                    {"+", " ", a1, " ", "+", " ", " ", " ", "+", " ", " ", " ", "."},
                    {"+", b1, " ", b2, "+", " ", " ", " ", "+", " ", " ", " ", "."},
                    {"+", " ", a2, " ", "+", " ", " ", " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {"+", " ", y1, " ", "+", " ", z1, " ", "+", " ", k1, " ", "+"},
                    {"+", x1, " ", x2, "+", j1, " ", j2, "+", l1, " ", l2, "+"},
                    {"+", " ", y2, " ", "+", " ", z2, " ", "+", " ", k2, " ", "+"},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
        }
        //
        else if (shape == 2) {
            cube = new String[][]{{".", ".", ".", ".", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {".", " ", " ", " ", "+", " ", z1, " ", "+", " ", " ", " ", "."},
                    {".", " ", " ", " ", "+", j1, " ", j2, "+", " ", " ", " ", "."},
                    {".", " ", " ", " ", "+", " ", z2, " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {"+", " ", y1, " ", "+", " ", k1, " ", "+", " ", a1, " ", "+"},
                    {"+", x1, " ", x2, "+", l1, " ", l2, "+", b1, " ", b2, "+"},
                    {"+", " ", y2, " ", "+", " ", k2, " ", "+", " ", a2, " ", "+"},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
        }
        else if (shape == 3) {
            cube = new String[][]{{".", ".", ".", ".", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {".", " ", " ", " ", "+", " ", z1, " ", "+", " ", a1, " ", "+"},
                    {".", " ", " ", " ", "+", j1, " ", j2, "+", b1, " ", b2, "+"},
                    {".", " ", " ", " ", "+", " ", z2, " ", "+", " ", a2, " ", "+"},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+", "+"},
                    {"+", " ", y1, " ", "+", " ", k1, " ", "+", " ", " ", " ", "."},
                    {"+", x1, " ", x2, "+", l1, " ", l2, "+", " ", " ", " ", "."},
                    {"+", " ", y2, " ", "+", " ", k2, " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
        }
        else if (shape == 4) {
            cube = new String[][]{{"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {"+", " ", a1, " ", "+", " ", z1, " ", "+", " ", " ", " ", "."},
                    {"+", b1, " ", b2, "+", j1, " ", j2, "+", " ", " ", " ", "."},
                    {"+", " ", a2, " ", "+", " ", z2, " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {"+", " ", y1, " ", "+", " ", k1, " ", "+", " ", " ", " ", "."},
                    {"+", x1, " ", x2, "+", l1, " ", l2, "+", " ", " ", " ", "."},
                    {"+", " ", y2, " ", "+", " ", k2, " ", "+", " ", " ", " ", "."},
                    {"+", "+", "+", "+", "+", "+", "+", "+", "+", ".", ".", ".", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", " ", " ", " ", ".", " ", " ", " ", ".", " ", " ", " ", "."},
                    {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
            };
        }
        return cube;
    }
}