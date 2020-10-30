import java.util.Arrays;

public class Chessboard {
    private final static int size = 8;
    private final Position[] positions = new Position[size];

    public Chessboard() {
        reset();
    }

    public void reset() {
        Arrays.fill(positions, new NullPosition());
    }

    public boolean isSet(Position position) {
        return Arrays.asList(positions).contains(position);
    }

    public boolean isRowOutOfRange(int row) {
        return row > size - 1 || row < 0;
    }

    public boolean isQueenThreatened(Position position) {
        return isQueenInRow(position.getRow())
                || isQueenInColumn(position.getColumn())
                || isQueenInDiagonal(position);
    }

    public boolean isQueenInRow(int row) {
        return positions[row].isPlayed();
    }

    public boolean isQueenInColumn(int column) {
        return Arrays.stream(positions).anyMatch(p -> p.getColumn() == column);
    }

    public boolean isQueenInDiagonal(Position candidate) {
        return Arrays.stream(positions).anyMatch(p -> hasDiagonalInRow(p.getRow(), candidate));
    }

    private boolean hasDiagonalInRow(int row, Position position) {
        return isSet(position.getProportionalPositionLeft(row))
                || isSet(position.getProportionalPositionRight(row));
    }

    public void play(Position position) {
        positions[position.getRow()] = position;
    }

    public void unplay(Position position) {
        if (positions[position.getRow()].isPlayed()) {
            positions[position.getRow()] = new NullPosition();
        }
    }

    public int getBroadSize() {
        return size;
    }

    public Position[] getPositions() {
        return this.positions;
    }

    public void print() {
        new ChessboardPrinter(this).print();
    }
}
