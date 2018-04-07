package com.thoughtworks.ticTacToe;

import java.util.ArrayList;

public class Game {
  private ArrayList<Player> players;
  private Player currentPlayer;

  public Game() {
    this.players = new ArrayList();
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

  public Positions addMoveToCurrentPlayer(int number) {
    this.changeCurrentPlayer();
    return this.currentPlayer.addMove(number);
  }

  private Player changeCurrentPlayer() {
    return currentPlayer = players.get(1-players.indexOf(currentPlayer));
  }

  public Player getCurrentPlayer() {
    return this.currentPlayer;
  }
}