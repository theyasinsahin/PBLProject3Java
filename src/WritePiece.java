public class WritePiece {
    static void write(String str){
        Game.cn.getTextWindow().output(str);
    }
    static void setCursor(int x, int y) {
        Game.cn.getTextWindow().setCursorPosition(x,y);
    }
    int x=0;
    int y=0;
    Cube cube = new Cube();
    public void writeToScreen(Piece piece, int cursorX, int cursorY){
        int firstSituationX = cursorX;
        for(int k = 0; k<piece.getCubes().length;k++){
            for(int l = 0; l<piece.getCubes().length;l++){
                if(l == 0 && k != 0){
                    cursorY+=4;
                    cursorX = firstSituationX;
                }

                if(piece.getCubes()[k][l] != null){

                    cube.displayCube(piece.getCubes()[k][l].getCube_array(), cursorX, cursorY);

                }
                cursorX+=4;
            }
        }
    }
    public void writeToScreenRobot(Robot piece, int cursorX, int cursorY){
        int firstSituationX = cursorX;
        for(int k = 0; k<piece.getCubes().length;k++){
            for(int l = 0; l<piece.getCubes().length;l++){
                if(l == 0 && k != 0){
                    cursorY+=4;
                    cursorX = firstSituationX;
                }
                if(piece.getCubes()[k][l]!= null){
                    cube.displayCube(piece.getCubes()[k][l].getCube_array(), cursorX, cursorY);
                }
                cursorX += 4;
            }
        }
    }

    public void avarageY(Piece piece,int curX,int curY, int length){
        for(int k = 0; k<length;k++){
            int count=0;
            int temp=0;
            y=0;
            curX+=4;
            for(int l = 0; l<length;l++){
                if(piece.getCubes()[l][k] != null ){
                    count++;
                    y += piece.getCubes()[l][k].getY_force() ;
                    setCursor(curX,curY);
                    write(String.valueOf(y/count));
                }
                if (piece.getCubes()[l][k]==null){
                    temp++;
                }
                if(temp==length && length != 1){
                    setCursor(curX,curY);
                    write("00");
                }

            }
        }

    }

    public void avarageX(Piece piece,int curX,int curY, int length){
        for(int k = 0; k<length;k++){
            int count =0;
            int temp=0;
            x=0;

            curY+=4;
            for(int l = 0; l<length;l++){
                if(piece.getCubes()[k][l] != null ){
                    count++;
                    x += piece.getCubes()[k][l].getX_force() ;
                    setCursor(curX,curY);
                    write(String.valueOf(x/count));

                }
                if (piece.getCubes()[k][l]==null){
                    temp++;
                }
                if(temp==length && length != 1){
                    setCursor(curX,curY);
                    write("00");
                }

            }
        }
    }
    public void Inf_area(double [] array){
        setCursor(1,33);
        write("Human Robot");
        setCursor(1,34);
        write("Intelligence : "+array[0]);
        setCursor(1,35);
        write("Skill : "+array[1]);
        setCursor(3,36);
        write("Left arm: "+array[2]);
        setCursor(3,37);
        write("Right arm: "+array[3]);
        setCursor(1,38);
        write("Speed: "+array[4]);
        setCursor(3,39);
        write("Left leg: "+array[5]);
        setCursor(3,40);
        write("Right leg: "+array[6]);

    }
    public void Inf_area(Robot robot){
        setCursor(1,36);
        write("Human Robot");
        setCursor(1,37);
        write("Intelligence : "+robot.getIntelligence());
        setCursor(1,38);
        write("Skill : "+robot.getSkill());
        setCursor(3,39);
        write("Left arm: "+robot.getLA());
        setCursor(3,40);
        write("Right arm: "+robot.getRA());
        setCursor(1,41);
        write("Speed: "+robot.getSpeed());
        setCursor(3,42);
        write("Left leg: "+robot.getLL());
        setCursor(3,43);
        write("Right leg: "+robot.getRL());

    }
}
