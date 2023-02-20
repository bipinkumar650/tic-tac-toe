package com.bipin.model;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Game {
  private final Board board;
  private final List<Player> players;
  private int currentPlayerIndex;
  /* This is needed to calculate the winner in O(N) time. It maintains each player's move count in
     each row, col & diagonal
  */
  private GameState gameState;

  public Game(Board board, List<Player> players) {
    this.board = board;
    this.players = players;
    this.currentPlayerIndex = 0;
    initGameState();
  }

  public void setCurrentPlayerIndex(int index) {
    this.currentPlayerIndex = index;
  }

  @Data
  @Accessors(chain = true)
  public static class GameState {
    boolean gameOver = false;
    // playerIndex, pieceCount. ie what's the distribution of piece for each player
    private Map<Integer, Integer> diagonal;
    private Map<Integer, Integer> reverseDiagonal;
    // row/col, playerIndex, pieceCount
    private Map<Integer, Map<Integer, Integer>> row;
    private Map<Integer, Map<Integer, Integer>> col;
  }

  private void initGameState() {
    this.gameState = new GameState();
    gameState.diagonal = new HashMap<>();
    gameState.reverseDiagonal = new HashMap<>();
    gameState.row = new HashMap<>();
    for (int i = 0; i < this.board.getSize(); i++) {
      gameState.row.put(i, new HashMap<>());
    }
    gameState.col = new HashMap<>();
    for (int i = 0; i < this.board.getSize(); i++) {
      gameState.col.put(i, new HashMap<>());
    }
  }
}
