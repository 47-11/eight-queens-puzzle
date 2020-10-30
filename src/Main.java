public class Main {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        EightQueensPuzzle.with(chessboard).solve();

        chessboard.print();
    }
}
