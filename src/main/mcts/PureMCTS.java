package main.mcts;

import main.games.Game;
import main.games.Player;
import main.games.Status;
import main.utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class PureMCTS implements MCTS<Integer> {
    private Game game;
    private int maxStep = 512;

    public PureMCTS(Game game) {
        this.game = game;
    }

    @Override
    public Integer start() {
        Set<Integer> actions = game.availableActions();
        Map<Integer, Score> scoreMap = new HashMap<>();
        for (int action : actions) {
            Game newGame = game.applyAction(action);
            Score score = randomPlay(newGame);
            scoreMap.put(action, score);
        }
        // Find the maximum score
        int maxScore = Integer.MIN_VALUE;
        int maxAction = -1;
        for (int action : actions) {
            int calculatedScore = calculateScore(scoreMap.get(action));
            if (calculatedScore > maxScore) {
                maxScore = calculatedScore;
                maxAction = action;
            }
        }
        return maxAction;
    }

    /**
     *
     * @param game
     * @return the score of given action
     */
    private Score randomPlay(Game game) {
        Score score = new Score();
        for (int i = 0; i < maxStep; i++) {
            Game randomGame = game;
            while (randomGame.getStatus() == Status.IN_PROGRESS) {
                Set<Integer> actionsSet = randomGame.availableActions();
                int[] actions = Utils.setToArray(actionsSet);
                int randomInt = ThreadLocalRandom.current().nextInt(actions.length);
                int randomAction = actions[randomInt];
                randomGame = randomGame.applyAction(randomAction);
            }
            // Calculate scores
            if (randomGame.getStatus() == Status.END) {
                Player winner = randomGame.getWinner();
                if (winner == game.getNextTurnPlayer()) {
                    score.wins++;
                } else {
                    score.losses++;
                }
            } else if (randomGame.getStatus() == Status.END_TIE) {
                score.ties++;
            }
        }
        return score;
    }

    public void setMaxStep(int maxStep) {
        this.maxStep = maxStep;
    }

    private int calculateScore(Score score) {
        return score.wins + score.ties - score.losses;
    }

    private class Score {
        int wins;
        int losses;
        int ties;
    }
}
