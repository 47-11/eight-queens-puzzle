import java.util.Arrays;

public class Chessboard {
    private static int size = 8;
    private final int[] board = new int[size];

    public Chessboard() {
        reset();
    }

    public void reset() {
        Arrays.fill(board, -1);
    }

    public boolean isSet(int row, int column) {
        if(outOfBoard(row, column)) {
            return false;
        }

        return board[row] == column;
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
        return isThreatenendInRow(row)
                || isThreatenendInColumn(column)
                || isThreatenedDiagonal(row, column);
    }

    public boolean isThreatenendInRow(int row) {
        return board[row] != -1;
    }

    public boolean isThreatenendInColumn(int column) {
        return Arrays.stream(this.board).anyMatch(cell -> cell == column);
    }

    public boolean isThreatenedDiagonal(int row, int column) {
        for(int candidateRow = 0; candidateRow < board.length; candidateRow++) {
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
        board[row] = column;
    }

    public void unplay(int row, int column) {
        if(board[row] == column) {
            board[row] = -1;
        }
    }

    public int getBroadSize() {
        return size;
    }


    public void print() {
        printHeader();

        for (int row = 0; row < board.length; row++) {
            printRow(row);
        }
    }

    private void printHeader() {
        System.out.print("  ");

        for (int row = 0; row < board.length; row++) {
            System.out.print(" " + (row + 1) + " ");
        }

        System.out.println();
    }

    private void printRow(int row) {
        System.out.print((row + 1) + " ");

        for (int column = 0; column < board.length; column++) {
            printCell(row, column);
        }

        System.out.println();
    }

    private void printCell(int row, int column) {
        if (isSet(row, column)) {
            System.out.print(" x ");
        } else {
            System.out.print(" - ");
        }
    }
}
