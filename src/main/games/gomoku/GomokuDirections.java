package main.games.gomoku;

/**
 * Example usage:
 * If we want to get the index of top left position,
 * we can do currentPosition + GomokuDirections.TOP_LEFT.
 */
public class GomokuDirections {
    public static final int TOP = -GomokuState.getBoardWidth();
    public static final int BOTTOM = GomokuState.getBoardWidth();
    public static final int LEFT = -1;
    public static final int RIGHT = 1;

    public static final int TOP_LEFT = TOP + LEFT;
    public static final int TOP_RIGHT = TOP + RIGHT;
    public static final int BOTTOM_LEFT = BOTTOM + LEFT;
    public static final int BOTTOM_RIGHT = BOTTOM + RIGHT;
}
