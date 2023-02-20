package com.bipin;

import com.bipin.model.Board;
import com.bipin.model.Game;
import com.bipin.model.Piece;
import com.bipin.model.Player;
import com.bipin.service.TicTacToeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeApplication {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    // Initialize board with input size
    System.out.println("Provide the board size");
    int boardSize = 0;
    while (!(boardSize > 0)) {
      try {
        boardSize = Integer.parseInt(bf.readLine());
      } catch (Exception ex) {
        System.out.println("Board size must be an integer greater than 0");
      }
    }
    Board board = new Board(boardSize);

    // Create players
    List<Player> players = new ArrayList<>();
    System.out.println("Provide number of players");
    int playerCount = 0;
    while (!(playerCount > 0)) {
      try {
        playerCount = Integer.parseInt(bf.readLine());
      } catch (Exception exception) {
        System.out.println("Player count must be an integer greater than 0");
      }
    }
    for (int i = 0; i < playerCount; i++) {
      boolean validPlayer = false;
      System.out.println("Provide detail for player" + (i + 1));
      while (!validPlayer) {
        try {
          String playerInput = bf.readLine();
          String[] command = playerInput.split("\\s+");
          Player player = new Player().setName(command[0]).setPiece(Piece.valueOf(command[1]));
          validPlayer = true;
          players.add(player);
        } catch (Exception ex) {
          System.out.println("provide name piece. eg: Bipin X");
        }
      }
    }
    // Initialize game
    Game game = new Game(board, players);
    TicTacToeService ticTacToeService = new TicTacToeService(game);
    ticTacToeService.printBoard();

    String inputLine;
    while ((inputLine = bf.readLine()) != null) {
      try {
        String[] command = inputLine.split("\\s+");
        ticTacToeService.play(Integer.parseInt(command[0]) - 1, Integer.parseInt(command[1]) - 1);
      } catch (Exception exception) {
        System.out.println("provide row column. eg: 3 1");
      }
    }
  }
}
