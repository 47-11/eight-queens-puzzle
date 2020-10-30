import java.util.Objects;

public class Position {
    protected int column;
    protected int row;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return column == position.column && row == position.row;
    }

    public Position getProportionalPositionLeft(int row) {
        int diff = Math.abs(this.row - row);
        return new Position(row, this.column - diff);
    }

    public Position getProportionalPositionRight(int row) {
        int diff = Math.abs(this.row - row);
        return new Position(row, this.column + diff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    public boolean isPlayed() {
        return true;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
