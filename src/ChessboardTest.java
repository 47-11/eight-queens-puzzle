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
        this.chessboard.play(4, 3);

        assertTrue(this.chessboard.isSet(4, 3));
        assertFalse(this.chessboard.isSet(3, 4));
    }

    @Test
    void columnHasPiece() {
        this.chessboard.play(4, 3);

        assertTrue(this.chessboard.isQueenInColumn(3));
        assertFalse(this.chessboard.isQueenInColumn(4));
    }

    @Test
    void diagonalHasPiece() {
        this.chessboard.play(2, 3);

        assertTrue(this.chessboard.isQueenInDiagonal(1, 2));
        assertTrue(this.chessboard.isQueenInDiagonal(4, 1));
        assertTrue(this.chessboard.isQueenInDiagonal(7, 8));
        assertTrue(this.chessboard.isQueenInDiagonal(2, 3));

        assertFalse(this.chessboard.isQueenInDiagonal(1, 3));
        assertFalse(this.chessboard.isQueenInDiagonal(6, 5));
        assertFalse(this.chessboard.isQueenInDiagonal(2, 2));
    }


}