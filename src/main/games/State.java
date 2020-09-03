package main.games;

public interface State {
    Player getPositionAt(int index);
    Player[] getStateCopy();
    int getStateLength();
}
