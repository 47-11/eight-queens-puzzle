public class Computer {
    private final Chessboard chessboard;

    public Computer(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void solveEightQueensPuzzle() {
        chessboard.solve(0);
    }
}
