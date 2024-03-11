public class PieceDepot {
    private Piece[] pieces = new Piece[20];


    //GETTERS AND SETTERS

    public Piece[] getPieces() {
        return pieces;
    }

    public void setPieces(Piece piece, int i) {
        this.pieces[i] = piece;
    }

}
