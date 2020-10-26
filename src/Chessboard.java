import java.util.Arrays;

public class Chessboard {
    private final int[] board = new int[8];

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
        return row > 7 || column > 7 || column < 0 || row < 0;
    }

    public boolean notThreatened(int row, int column) {
        return !rowHasPiece(row)
                && !columnHasPiece(column)
                && !diagonalHasPiece(row, column);
    }

    public boolean rowHasPiece(int row) {
        return board[row] != -1;
    }

    public boolean columnHasPiece(int column) {
        return Arrays.stream(this.board).anyMatch(cell -> cell == column);
    }

    public boolean diagonalHasPiece(int row, int column) {
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

    public void set(int row, int column) {
        board[row] = column;
    }

    public void unset(int row) {
        board[row] = -1;
    }

    public void finishRow(int row) {
        for (int column = 0; column < 8; column++) {
            if (notThreatened(row, column)) {
                set(row, column);

                if(row < 7) {
                    finishRow(row + 1);
                }
            }
        }
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
