public class EightQueensPuzzle {
    private final Chessboard chessboard;

    public EightQueensPuzzle(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public static EightQueensPuzzle with(Chessboard chessboard) {
        return new EightQueensPuzzle(chessboard);
    }

    public void solve() {
        execute(0);
    }

    public boolean execute(int row) {
        if (chessboard.isRowOutOfRange(row)) {
            return true;
        }

        for (int column = 0; column < chessboard.getBroadSize(); column++) {
            if(chessboard.isThreatened(row, column)) {
                continue;
            }

            chessboard.play(row, column);

            if(execute(row + 1)) {
                return true;
            }

            chessboard.unplay(row, column);
        }

        return false;
    }
}
