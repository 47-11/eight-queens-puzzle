import java.util.Arrays;

public class Chessboard {
    private final static int size = 8;
    private final Position[] queenPositions = new Position[size];

    public Chessboard() {
        reset();
    }

    public void reset() {
        Arrays.fill(queenPositions, new NullPosition());
    }

    public boolean isSet(Position position) {
        return Arrays.asList(queenPositions).contains(position);
    }

    public boolean isRowOutOfRange(int row) {
        return row > size - 1 || row < 0;
    }

    public boolean isThreatened(Position position) {
        return isQueenInRow(position.getRow())
                || isQueenInColumn(position.getColumn())
                || isQueenInDiagonal(position);
    }

    public boolean isQueenInRow(int row) {
        return queenPositions[row].isPlayed();
    }

    public boolean isQueenInColumn(int column) {
        for (Position position : queenPositions) {
            if (position.getColumn() == column) {
                return true;
            }
        }

        return false;
    }

    public boolean isQueenInDiagonal(Position position) {
        for (int candidateRow = 0; candidateRow < queenPositions.length; candidateRow++) {
            int diff = Math.abs(position.getRow() - candidateRow);

            if (isSet(new Position(candidateRow, position.getColumn() - diff))) {
                return true;
            }

            if (isSet(new Position(candidateRow, position.getColumn() + diff))) {
                return true;
            }
        }

        return false;
    }

    public void play(Position position) {
        position.play();
        queenPositions[position.getRow()] = position;
    }

    public void unplay(Position position) {
        if (queenPositions[position.getRow()].isPlayed()) {
            position.unplay();
            queenPositions[position.getRow()] = new NullPosition();
        }
    }

    public int getBroadSize() {
        return size;
    }

    public Position[] getQueenPositions() {
        return this.queenPositions;
    }

    public void print() {
        new ChessboardPrinter(this).print();
    }
}
