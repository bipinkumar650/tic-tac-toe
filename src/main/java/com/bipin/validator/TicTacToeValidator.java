package com.bipin.validator;

import com.bipin.exception.InvalidMoveException;
import com.bipin.model.Game;
import com.bipin.model.Piece;

import java.util.concurrent.atomic.AtomicBoolean;

public class TicTacToeValidator {
  public static void validateMove(int row, int col, Game game) {
    if (row > game.getBoard().getSize() || col > game.getBoard().getSize())
      throw new InvalidMoveException("The position is out of board, please provide valid position");
    if (!game.getBoard().getCells()[row][col].equals(Piece.DEFAULT))
      throw new InvalidMoveException("This position is already occupied");
  }

  public static boolean isGameOver(Game game) {
    // if there are only one players piece on any row, col or diagonal then game is not over
    AtomicBoolean gameOver = new AtomicBoolean(true);
    if (game.getGameState().getDiagonal().size() <= 1
        || game.getGameState().getReverseDiagonal().size() <= 1) gameOver.set(false);
    game.getGameState()
        .getRow()
        .forEach(
            (key, value) -> {
              if (value.size() <= 1) gameOver.set(false);
            });
    game.getGameState()
        .getCol()
        .forEach(
            (key, value) -> {
              if (value.size() <= 1) gameOver.set(false);
            });
    return gameOver.get();
  }
}
