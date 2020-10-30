import java.util.Arrays;

public class Chessboard {
    private final static int size = 8;
    private final int[] queens = new int[size];

    public Chessboard() {
        reset();
    }

    public void reset() {
        Arrays.fill(queens, -1);
    }

    public boolean isSet(int row, int column) {
        if(outOfBoard(row, column)) {
            return false;
        }

        return queens[row] == column;
    }

    private boolean outOfBoard(int row, int column) {
        return isRowOutOfRange(row) || isColumnOutOfRange(column);
    }

    public boolean isRowOutOfRange(int row) {
        return row > size - 1 || row < 0;
    }

    public boolean isColumnOutOfRange(int column) {
        return column > size - 1 || column < 0 ;
    }

    public boolean isThreatened(int row, int column) {
        return isQueenInRow(row)
                || isQueenInColumn(column)
                || isQueenInDiagonal(row, column);
    }

    public boolean isQueenInRow(int row) {
        return queens[row] != -1;
    }

    public boolean isQueenInColumn(int column) {
        return Arrays.stream(this.queens).anyMatch(cell -> cell == column);
    }

    public boolean isQueenInDiagonal(int row, int column) {
        for(int candidateRow = 0; candidateRow < queens.length; candidateRow++) {
            int diff = Math.abs(row - candidateRow);

            if(isSet(candidateRow, column - diff)) {
                return true;
            }

            if(isSet(candidateRow, column + diff)) {
                return true;
            }
        }

        return false;
    }

    public void play(int row, int column) {
        queens[row] = column;
    }

    public void unplay(int row, int column) {
        if(queens[row] == column) {
            queens[row] = -1;
        }
    }

    public int getBroadSize() {
        return size;
    }

    public int[] getQueens() {
        return this.queens;
    }

    public void print() {
        new ChessboardPrinter(this).print();
    }
}
