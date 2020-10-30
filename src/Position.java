import java.util.Objects;

public class Position {
    protected int column;
    protected int row;
    protected boolean isPlayed = false;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void play() {
        isPlayed = true;
    }

    public void unplay() {
        isPlayed = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return column == position.column && row == position.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
