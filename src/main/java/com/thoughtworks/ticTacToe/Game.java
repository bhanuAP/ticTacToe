package com.thoughtworks.ticTacToe;

import java.util.ArrayList;

public class Game {
  private ArrayList<Player> players;
  private Player currentPlayer;

  public Game() {
    this.players = new ArrayList();
  }

  public boolean addPlayer(Player player) throws PlayersAlreadyJoined {
    if (players.size() < 2)
    return players.add(player);
    throw new PlayersAlreadyJoined();
  }

  public Player initializeGameSetup() {
    return this.currentPlayer = players.get(0);
  }

  public boolean setWinningCombinations(WinningCombinations winningCombinations) {
    if (players.size() == 2) {
      players.get(0).setWinningCombinationsAs(winningCombinations);
      players.get(1).setWinningCombinationsAs(winningCombinations);
      return true;
    }
    return false;
  }

  public boolean addMoveToCurrentPlayer(int number) {
    this.currentPlayer.addMove(number);
    this.changeCurrentPlayer();
    return true;
  }

  private Player changeCurrentPlayer() {
    return currentPlayer = players.get(1-players.indexOf(currentPlayer));
  }

  public Player getCurrentPlayer() {
    return this.currentPlayer;
  }
}