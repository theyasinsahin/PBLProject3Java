public class SelectedPieces {

    private Piece[] pieces = new Piece[20];
    Piece piece = new Piece();
    private int[] xCoordinates = new int[20];
    private int[] yCoordinates = new int[20];
    int top = 0;
    public SelectedPieces(){
        for(int i = 0; i<20; i++){
            pieces[i] = piece;
        }
    }

    public void addPiece(Piece piece, int x, int y){
        pieces[top] = piece;
        xCoordinates[top] = x;
        yCoordinates[top] = y;
        top++;
    }

}
