public class NullPosition extends Position {
    public NullPosition() {
        super(-1, -1);
    }

    @Override
    public boolean isPlayed() {
        return false;
    }
}
