public class ChessboardPrinter {
    private final Chessboard chessboard;

    public ChessboardPrinter(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void print() {
        printHeader();

        for (int row = 0; row < chessboard.getPositions().length; row++) {
            printRow(row);
        }
    }

    private void printHeader() {
        System.out.print("  ");

        for (int row = 0; row < chessboard.getPositions().length; row++) {
            System.out.print(" " + (row + 1) + " ");
        }

        System.out.println();
    }

    private void printRow(int row) {
        System.out.print((row + 1) + " ");

        for (int column = 0; column < chessboard.getPositions().length; column++) {
            printCell(new Position(row, column));
        }

        System.out.println();
    }

    private void printCell(Position position) {
        if (chessboard.isSet(position)) {
            System.out.print(" x ");
        } else {
            System.out.print(" - ");
        }
    }
}
