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
        this.chessboard.set(4, 3);

        assertTrue(this.chessboard.isSet(4, 3));
        assertFalse(this.chessboard.isSet(3, 4));
    }

    @Test
    void columnHasPiece() {
        this.chessboard.set(4, 3);

        assertTrue(this.chessboard.columnHasPiece(3));
        assertFalse(this.chessboard.columnHasPiece(4));
    }

    @Test
    void diagonalHasPiece() {
        this.chessboard.set(2, 3);

        assertTrue(this.chessboard.diagonalHasPiece(1, 2));
        assertTrue(this.chessboard.diagonalHasPiece(4, 1));
        assertTrue(this.chessboard.diagonalHasPiece(7, 8));
        assertTrue(this.chessboard.diagonalHasPiece(2, 3));

        assertFalse(this.chessboard.diagonalHasPiece(1, 3));
        assertFalse(this.chessboard.diagonalHasPiece(6, 5));
        assertFalse(this.chessboard.diagonalHasPiece(2, 2));
    }


}