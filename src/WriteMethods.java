public class WriteMethods {
    static void write(String str){
        Game.cn.getTextWindow().output(str);
    }
    static void write(char chr){
        Game.cn.getTextWindow().output(chr);
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

    public void Inf_area(Robot robot){
        setCursor(1,36);
        write("Human Robot ");

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

    public void writeAllPieces(PieceDepot pieceDepot, enigma.console.Console cn){
        //Quadruple Cubes were Wrote
        for(int i = 0; i<4;i++){
            setCursor(29+(20*i),3);
            pieceDepot.getPieces()[i].setxCoordinate(28+(20*i));
            pieceDepot.getPieces()[i].setyCoordinate(2);
            write("0"+String.valueOf(i+1));
            Game.flood1(31+(20*i),3);
            writeToScreen(pieceDepot.getPieces()[i], 31+(20*i),3);
            avarageX(pieceDepot.getPieces()[i],44+(20*i),1, 3);
            avarageY(pieceDepot.getPieces()[i],28+(20*i),16, 3);
        }

        //Trible Cubes were Wrote
        for(int i = 0; i<4; i++){
            setCursor(29+(20*i),18);
            pieceDepot.getPieces()[i+4].setxCoordinate(28+(20*i));
            pieceDepot.getPieces()[i+4].setyCoordinate(17);
            write("0"+String.valueOf(i+5));
            Game.flood1(31+(20*i),18);
            writeToScreen(pieceDepot.getPieces()[i+4], 31+(20*i),18);
            avarageX(pieceDepot.getPieces()[i+4], 44+(20*i), 16, 3);
            avarageY(pieceDepot.getPieces()[i+4], 28+(20*i), 31, 3);
        }


        //Double Cubes Were Wrote
        for(int i = 0; i<5; i++){
            setCursor(29+(15*i),33);
            pieceDepot.getPieces()[i+8].setxCoordinate(28+(15*i));
            pieceDepot.getPieces()[i+8].setyCoordinate(32);
            if(i == 0){
                write("0"+String.valueOf(i+9));
            }else{
                write(String.valueOf(i+9));
            }
            Game.flood2(31+(15*i),33);
            writeToScreen(pieceDepot.getPieces()[i+8], 31+(15*i),33);
            avarageX(pieceDepot.getPieces()[i+8], 41+(15*i), 31, 2);
            avarageY(pieceDepot.getPieces()[i+8], 29+(15*i), 42, 2);
        }

        //Single Cubes were wrote
        for(int i = 0; i<7; i++){
            setCursor(29+(10*i),44);
            pieceDepot.getPieces()[i+13].setxCoordinate(28+(10*i));
            pieceDepot.getPieces()[i+13].setyCoordinate(43);
            write(String.valueOf(i+14));
            writeToScreen(pieceDepot.getPieces()[i+13], 31+(10*i),44);
            avarageX(pieceDepot.getPieces()[i+13], 37+(10*i), 42, 1);
            avarageY(pieceDepot.getPieces()[i+13], 29+(10*i), 49, 1);
        }
    }

    public void writeScreen(int pieceX, int pieceY){
        setCursor(0,27);
        write("Current piece (#):");
        setCursor(2,28); write("X:1");
        setCursor(8,28); write("Y:1");
        setCursor(0,29); write("Used pieces (=/-)");
        setCursor(1,30);write(" 01  02  03  04");
        setCursor(1,31);write(" 05  06  07  08");
        setCursor(1,32);write(" 09  10  11  12");
        setCursor(1,33);write(" 13  14  15  16");
        setCursor(1,34);write(" 17  18  19  20");



        setCursor(0,0);
        write(
                "+-1---2---3---4---5---> X\n" +
                        "|\n" + "1\n" + "+\n" + "+\n"+ "+\n" + "2\n" + "+\n" + "+\n" + "+\n" + "3\n" + "+\n" + "+\n" + "+\n" + "4\n" + "+\n" + "+\n" + ".\n" + "5\n" + ".\n" + ".\n" + "v\n" + "\n" + "Y");


        //Seçili Parça gösterilir
        setCursor(pieceX,pieceY); write("###");
        setCursor(pieceX,pieceY+1); write("#");
        setCursor(pieceX,pieceY+2); write("###");

    }

    public void showSelectedPieces(PieceDepot pieceDepot, int control){
        for (int i = 0; i < 20; i++) {
            if(pieceDepot.getPieces()[i].isSelected()){
                setCursor(pieceDepot.getPieces()[i].getxCoordinate(),pieceDepot.getPieces()[i].getyCoordinate()); write("===");
                setCursor(pieceDepot.getPieces()[i].getxCoordinate(),pieceDepot.getPieces()[i].getyCoordinate()+1); write("=");
                setCursor(pieceDepot.getPieces()[i].getxCoordinate(),pieceDepot.getPieces()[i].getyCoordinate()+2); write("===");

                setCursor(pieceDepot.getPieces()[i].getxCursorOnInfArea(), pieceDepot.getPieces()[i].getyCursorOnInfArea()); write("=");
            }
            else{
                setCursor(pieceDepot.getPieces()[i].getxCursorOnInfArea(), pieceDepot.getPieces()[i].getyCursorOnInfArea()); write(" ");
            }
            if(control == 2){
                if(pieceDepot.getPieces()[i].isPreIsSelected()){
                    setCursor(pieceDepot.getPieces()[i].getxCoordinate(),pieceDepot.getPieces()[i].getyCoordinate()); write("---");
                    setCursor(pieceDepot.getPieces()[i].getxCoordinate(),pieceDepot.getPieces()[i].getyCoordinate()+1); write("-");
                    setCursor(pieceDepot.getPieces()[i].getxCoordinate(),pieceDepot.getPieces()[i].getyCoordinate()+2); write("---");

                    setCursor(pieceDepot.getPieces()[i].getxCursorOnInfArea(), pieceDepot.getPieces()[i].getyCursorOnInfArea()); write("-");
                }
            }
        }
    }
}
