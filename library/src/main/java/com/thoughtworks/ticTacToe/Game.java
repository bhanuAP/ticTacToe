package com.thoughtworks.ticTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Game {
  private ArrayList<Player> players;
  private Player currentPlayer;
  private HashSet<Integer> moves;
  private String status;

  public Game() {
    this.players = new ArrayList();
    this.moves = new HashSet(Arrays.asList(1,2,3,4,5,6,7,8,9));
    this.status = "started";
  }

  public String getStatus() {
    return status;
  }

//  public Player getCurrentPlayer() {
//    return currentPlayer;
//  }

  private Player changeCurrentPlayer() {
    return currentPlayer = players.get(1-players.indexOf(currentPlayer));
  }

  public boolean player1HasWon() {
    return players.get(0).hasWon();
  }

  public boolean player2HasWon() {
    return players.get(1).hasWon();
  }

  public boolean isDrawn() {
    return this.moves.size() == 0;
  }

  public void updateStatus() {
    if(this.player1HasWon()) {
      this.status = "player1 has won";
    }
    if(this.player2HasWon()) {
     this.status = "player2 has won";
    }
    if(this.isDrawn()) {
      this.status = "game drawn";
    }
  }

  public boolean addPlayer(Player player) throws PlayersAlreadyJoined {
    if (players.size() < 2){
      this.currentPlayer = player;
      return players.add(player);
    }
    throw new PlayersAlreadyJoined();
  }

  public boolean setWinningCombinations(WinningCombinations winningCombinations) {
    if (players.size() == 2) {
      players.get(0).setWinningCombinationsAs(winningCombinations);
      players.get(1).setWinningCombinationsAs(winningCombinations);
      return true;
    }
    return false;
  }

  public Positions addMoveToCurrentPlayer(int number) throws InvalidMove, gameAlreadyCompleted {
    this.changeCurrentPlayer();
    if(status != "started") throw new gameAlreadyCompleted();
    if(!this.moves.contains(number)) throw new InvalidMove();
    this.moves.remove(number);
    return this.currentPlayer.addMove(number);
  }
}
