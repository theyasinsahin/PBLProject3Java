import java.text.DecimalFormat;
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

        DecimalFormat df = new DecimalFormat("#.##");

        setCursor(cubeCX+6, cubeCY-3);
        String firstRow = df.format(singleCube.getFirstRow());
        write(firstRow);

        setCursor(cubeCX-1, cubeCY);
        String firstColumn = df.format(singleCube.getFirstColumn());
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

        DecimalFormat df = new DecimalFormat("#.##");

        setCursor(cubeCX+10, cubeCY-7);
        String firstRow = df.format(doubleCube.getFirstRow());
        write(firstRow);

        setCursor(cubeCX+10, cubeCY-3);
        String secondRow = df.format(doubleCube.getSecondRow());
        write(secondRow);


        setCursor(cubeCX-1, cubeCY);
        String firstColumn = df.format(doubleCube.getFirstColumn());
        write(firstColumn);

        setCursor(cubeCX+5, cubeCY);
        String secondColumn = df.format(doubleCube.getSecondColumn());
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
        DecimalFormat df = new DecimalFormat("#.##");

        setCursor(cubeCX + 14, cubeCY - 11);
        String firstRow = df.format(tribleCube.getFirstRow());
        write(firstRow);

        setCursor(cubeCX + 14, cubeCY - 7);
        String secondRow = df.format(tribleCube.getSecondRow());
        write(secondRow);

        setCursor(cubeCX + 14, cubeCY - 3);
        String thirdRow = df.format(tribleCube.getThirdRow());
        write(thirdRow);

        setCursor(cubeCX-1, cubeCY);
        String firstColumn = df.format(tribleCube.getFirstColumn());
        write(firstColumn);

        setCursor(cubeCX+5, cubeCY);
        String secondColumn = df.format(tribleCube.getSecondColumn());
        write(secondColumn);

        setCursor(cubeCX+11, cubeCY);
        String thirdColumn = df.format(tribleCube.getThirdColumn());
        write(thirdColumn);
    }

    static String[][] createFourCube(int cubeCX, int cubeCY, QuadrupleCube quadrupleCube) {
        String[][] fourCube = quadrupleCube.create();
        for(int i = 0; i< fourCube.length;i++){
            setCursor(cubeCX,cubeCY);
            for (int j = 0; j< fourCube.length;j++) {
                write(fourCube[i][j]);
            }
            cubeCY++;
        }
        DecimalFormat df = new DecimalFormat("#.##");

        setCursor(cubeCX+14, cubeCY-11);
        String firstRow = df.format(quadrupleCube.getFirstRow());
        write(firstRow);

        setCursor(cubeCX+14, cubeCY-7);
        String secondRow = df.format(quadrupleCube.getSecondRow());
        write(secondRow);

        setCursor(cubeCX+14, cubeCY-3);
        String thirdRow = df.format(quadrupleCube.getThirdRow());
        write(thirdRow);

        setCursor(cubeCX-1, cubeCY);
        String firstColumn = df.format(quadrupleCube.getFirstColumn());
        write(firstColumn);

        setCursor(cubeCX+5, cubeCY);
        String secondColumn = df.format(quadrupleCube.getSecondColumn());
        write(secondColumn);

        setCursor(cubeCX+11, cubeCY);
        String thirdColumn = df.format(quadrupleCube.getThirdColumn());
        write(thirdColumn);

        return fourCube;
    }

    static void showJustCube(int cubeCX, int cubeCY, String[][] fourCube){
        for(int i = 0; i< fourCube.length;i++){
            setCursor(cubeCX,cubeCY);
            for (int j = 0; j< fourCube.length;j++) {
                if(fourCube[i][j].equals(".")){
                    continue;
                } else {
                    write(fourCube[i][j]);
                }
            }
            cubeCY++;
        }
    }
}