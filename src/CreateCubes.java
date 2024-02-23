import java.util.Random;

public class CreateCubes {

    static Random random = new Random();

    static void write(String str) {
        Game.cn.getTextWindow().output(str);
    }

    static void setCursor(int x, int y) {
        Game.cn.getTextWindow().setCursorPosition(x, y);
    }

    static void createOneCube(int cubeCX, int cubeCY, SingleCube singleCube) {
        String[][] oneCube = singleCube.create();

        for(int i = 0; i< oneCube.length;i++){
            setCursor(cubeCX,cubeCY);
            for (int j = 0; j<oneCube.length;j++) {
                write(oneCube[i][j]);
            }
            cubeCY++;
        }

        setCursor(cubeCX+5, cubeCY-3);
        String firstRow = String.valueOf(singleCube.getFirstRow());
        write(firstRow);

        setCursor(cubeCX-1, cubeCY);
        String firstColumn = String.valueOf(singleCube.getFirstColumn());
        write(firstColumn);
    }

    static void createTwoCube(int cubeCX, int cubeCY, DoubleCube doubleCube) {
        String[][] twoCube = doubleCube.create();

        for(int i = 0; i< twoCube.length;i++){
            setCursor(cubeCX,cubeCY);
            for (int j = 0; j< twoCube.length;j++) {
                write(twoCube[i][j]);
            }
            cubeCY++;
        }

        setCursor(cubeCX+8, cubeCY-7);
        String firstRow = String.valueOf(doubleCube.getFirstRow());
        write(firstRow);

        setCursor(cubeCX+8, cubeCY-3);
        String secondRow = String.valueOf(doubleCube.getSecondRow());
        write(secondRow);


        setCursor(cubeCX-1, cubeCY);
        String firstColumn = String.valueOf(doubleCube.getFirstColumn());
        write(firstColumn);

        setCursor(cubeCX+5, cubeCY);
        String secondColumn = String.valueOf(doubleCube.getSecondColumn());
        write(secondColumn);

    }

    static void createThreeCube(int cubeCX, int cubeCY, TribleCube tribleCube) {
        String[][] threeCube = tribleCube.create();

        for (int i = 0; i < threeCube.length; i++) {
            setCursor(cubeCX, cubeCY);
            for (int j = 0; j < threeCube.length; j++) {
                write(threeCube[i][j]);
            }
            cubeCY++;
        }
        setCursor(cubeCX + 14, cubeCY - 11);
        String firstRow = String.valueOf(tribleCube.getFirstRow());
        write(firstRow);

        setCursor(cubeCX + 14, cubeCY - 7);
        String secondRow = String.valueOf(tribleCube.getSecondRow());
        write(secondRow);

        setCursor(cubeCX + 14, cubeCY - 3);
        String thirdRow = String.valueOf(tribleCube.getThirdRow());
        write(thirdRow);

        setCursor(cubeCX-1, cubeCY);
        String firstColumn = String.valueOf(tribleCube.getFirstColumn());
        write(firstColumn);

        setCursor(cubeCX+5, cubeCY);
        String secondColumn = String.valueOf(tribleCube.getSecondColumn());
        write(secondColumn);

        setCursor(cubeCX+11, cubeCY);
        String thirdColumn = String.valueOf(tribleCube.getThirdColumn());
        write(thirdColumn);
    }

    static void createFourCube(int cubeCX, int cubeCY, QuadrupleCube quadrupleCube) {
        String[][] fourCube = quadrupleCube.create();
        for(int i = 0; i< fourCube.length;i++){
            setCursor(cubeCX,cubeCY);
            for (int j = 0; j< fourCube.length;j++) {
                write(fourCube[i][j]);
            }
            cubeCY++;
        }
        setCursor(cubeCX+14, cubeCY-11);
        String firstRow = String.valueOf(quadrupleCube.getFirstRow());
        write(firstRow);

        setCursor(cubeCX+14, cubeCY-7);
        String secondRow = String.valueOf(quadrupleCube.getSecondRow());
        write(secondRow);

        setCursor(cubeCX+14, cubeCY-3);
        String thirdRow = String.valueOf(quadrupleCube.getThirdRow());
        write(thirdRow);

        setCursor(cubeCX-1, cubeCY);
        String firstColumn = String.valueOf(quadrupleCube.getFirstColumn());
        write(firstColumn);

        setCursor(cubeCX+5, cubeCY);
        String secondColumn = String.valueOf(quadrupleCube.getSecondColumn());
        write(secondColumn);

        setCursor(cubeCX+11, cubeCY);
        String thirdColumn = String.valueOf(quadrupleCube.getThirdColumn());
        write(thirdColumn);
    }

}