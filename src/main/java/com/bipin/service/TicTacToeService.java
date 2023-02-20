package com.bipin.service;

import com.bipin.model.Game;
import com.bipin.validator.TicTacToeValidator;

import java.util.Map;
import java.util.Objects;

public class TicTacToeService {
  private final Game game;

  public TicTacToeService(Game game) {
    this.game = game;
  }

  public void play(int row, int col) {
    try {
      // validate if move is valid
      TicTacToeValidator.validateMove(row, col, game);
      // update board with current move
      int currentPlayerIndex = game.getCurrentPlayerIndex();
      game.getBoard().getCells()[row][col] = game.getPlayers().get(currentPlayerIndex).getPiece();
      int nextPlayerIndex =
          (game.getCurrentPlayerIndex() == game.getPlayers().size() - 1)
              ? 0
              : game.getCurrentPlayerIndex() + 1;
      game.setCurrentPlayerIndex(nextPlayerIndex);
      // update game state
      updateGameState(row, col, currentPlayerIndex);
      if (TicTacToeValidator.isGameOver(game)) {
        game.getGameState().setGameOver(true);
        printBoard();
        System.out.println("Game over");
        System.exit(0);
      }
      printBoard();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }

  private void updateGameState(int row, int col, int currentPlayerIndex) {
    updateDiagonalState(row, col, currentPlayerIndex);
    updateReverseDiagonalState(row, col, currentPlayerIndex);
    updateRowState(row, currentPlayerIndex);
    updateColState(col, currentPlayerIndex);
  }

  private void updateRowState(int row, int currentPlayerIndex) {
    Map<Integer, Map<Integer, Integer>> rowStates = game.getGameState().getRow();
    Map<Integer, Integer> rowState = rowStates.get(row);
    int moveCount = rowState.getOrDefault(currentPlayerIndex, 0) + 1;
    rowState.put(currentPlayerIndex, moveCount);
    rowStates.put(row, rowState);
    if (moveCount == game.getBoard().getSize()) {
      System.out.println(game.getPlayers().get(currentPlayerIndex).getName() + " won the game");
      game.getGameState().setGameOver(true);
      printBoard();
      System.exit(0);
    }
  }

  private void updateColState(int col, int currentPlayerIndex) {
    Map<Integer, Map<Integer, Integer>> colStates = game.getGameState().getCol();
    Map<Integer, Integer> colState = colStates.get(col);
    int moveCount = colState.getOrDefault(currentPlayerIndex, 0) + 1;
    colState.put(currentPlayerIndex, moveCount);
    if (moveCount == game.getBoard().getSize()) {
      System.out.println(game.getPlayers().get(currentPlayerIndex).getName() + " won the game");
      game.getGameState().setGameOver(true);
      printBoard();
      System.exit(0);
    }
  }

  private void updateReverseDiagonalState(int row, int col, int currentPlayerIndex) {
    if (row + col == game.getBoard().getSize() - 1) {
      Map<Integer, Integer> revDiagonal = game.getGameState().getReverseDiagonal();
      int moveCount = revDiagonal.getOrDefault(currentPlayerIndex, 0) + 1;
      revDiagonal.put(currentPlayerIndex, moveCount);
      if (moveCount == game.getBoard().getSize()) {
        System.out.println(game.getPlayers().get(currentPlayerIndex).getName() + " won the game");
        game.getGameState().setGameOver(true);
        printBoard();
        System.exit(0);
      }
    }
  }

  private void updateDiagonalState(int row, int col, int currentPlayerIndex) {
    if (row == col) { // if diagonal position
      Map<Integer, Integer> diagonal = game.getGameState().getDiagonal();
      int moveCount = diagonal.getOrDefault(currentPlayerIndex, 0) + 1;
      diagonal.put(currentPlayerIndex, moveCount);
      if (moveCount == game.getBoard().getSize()) {
        System.out.println(game.getPlayers().get(currentPlayerIndex).getName() + " won the game");
        game.getGameState().setGameOver(true);
        printBoard();
        System.exit(0);
      }
    }
  }

  public void printBoard() {
    for (int i = 0; i < game.getBoard().getSize(); i++) {
      for (int j = 0; j < game.getBoard().getSize(); j++) {
        System.out.print(game.getBoard().getCells()[i][j].getLabel() + " ");
      }
      System.out.println();
    }
    if (Objects.isNull(game.getGameState()) || !game.getGameState().isGameOver()) {
      System.out.println(game.getPlayers().get(game.getCurrentPlayerIndex()).getName() + "'s turn");
    }
  }
}
