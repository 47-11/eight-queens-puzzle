import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {
    private Chessboard chessboard;

    @BeforeEach
    void setUp() {
        this.chessboard = new Chessboard();
    }

    @Test
    void isSet() {
        this.chessboard.play(new Position(4, 3));

        assertTrue(this.chessboard.isSet(new Position(4, 3)));
        assertFalse(this.chessboard.isSet(new Position(3, 4)));
    }

    @Test
    void columnHasPiece() {
        this.chessboard.play(new Position(4, 3));

        assertTrue(this.chessboard.isQueenInColumn(3));
        assertFalse(this.chessboard.isQueenInColumn(4));
    }

    @Test
    void diagonalHasPiece() {
        this.chessboard.play(new Position(4, 3));

        assertTrue(this.chessboard.isQueenInDiagonal(new Position(1, 2)));
        assertTrue(this.chessboard.isQueenInDiagonal(new Position(4, 1)));
        assertTrue(this.chessboard.isQueenInDiagonal(new Position(7, 8)));
        assertTrue(this.chessboard.isQueenInDiagonal(new Position(2, 3)));

        assertFalse(this.chessboard.isQueenInDiagonal(new Position(1, 3)));
        assertFalse(this.chessboard.isQueenInDiagonal(new Position(6, 5)));
        assertFalse(this.chessboard.isQueenInDiagonal(new Position(2, 2)));
    }


}