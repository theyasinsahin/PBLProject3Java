public class Erasing {
    public void eraseSelectedPiece(enigma.console.Console cn, Piece piece, Robot robot, int xIdxOnRobot, int yIdxOnRobot, int xCursorOnRobot, int yCursorOnRobot){
        Cube cube = new Cube();
        cube.createEmptyCube(); //Dolu parçaların yerini boş küplerle doldurabilmek için boş bir küp yaratıyorum.
        WriteMethods writeMethods = new WriteMethods();
        cn.getTextWindow().setCursorPosition(yCursorOnRobot, xCursorOnRobot);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(piece.getCubes()[i][j] != null){
                    robot.setCubesElement(cube, i+yIdxOnRobot, j+xIdxOnRobot);
                }
            }
        }

        /////Delete Inf Area
        for (int i = 36; i < 46; i++) {
            for (int j = 0; j < 27; j++){
                cn.getTextWindow().setCursorPosition(j,i);
                cn.getTextWindow().output(" ");
            }
        }

        writeMethods.writeToScreenRobot(robot,2,2);
        robot.powers();
        writeMethods.Inf_area(robot);
    }
}
