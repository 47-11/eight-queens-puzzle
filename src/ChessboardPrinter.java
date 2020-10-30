public class ChessboardPrinter {
    private final Chessboard chessboard;

    public ChessboardPrinter(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void print() {
        printHeader();

        for (int row = 0; row < chessboard.getQueens().length; row++) {
            printRow(row);
        }
    }

    private void printHeader() {
        System.out.print("  ");

        for (int row = 0; row < chessboard.getQueens().length; row++) {
            System.out.print(" " + (row + 1) + " ");
        }

        System.out.println();
    }

    private void printRow(int row) {
        System.out.print((row + 1) + " ");

        for (int column = 0; column < chessboard.getQueens().length; column++) {
            printCell(row, column);
        }

        System.out.println();
    }

    private void printCell(int row, int column) {
        if (chessboard.isSet(row, column)) {
            System.out.print(" x ");
        } else {
            System.out.print(" - ");
        }
    }
}
