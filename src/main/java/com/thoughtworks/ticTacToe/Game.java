package com.thoughtworks.ticTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Game {
  private ArrayList<Player> players;
  private Player currentPlayer;
  private HashSet<Integer> moves;

  public Game() {
    this.players = new ArrayList();
    this.moves = new HashSet(Arrays.asList(1,2,3,4,5,6,7,8,9));
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

  public Positions addMoveToCurrentPlayer(int number) throws moveAlreadyPlayed {
    this.changeCurrentPlayer();
    if(this.moves.contains(number)) {
      this.moves.remove(number);
      return this.currentPlayer.addMove(number);
    }
    throw new moveAlreadyPlayed();
  }

  private Player changeCurrentPlayer() {
    return currentPlayer = players.get(1-players.indexOf(currentPlayer));
  }

  public Player getCurrentPlayer() {
    return this.currentPlayer;
  }
}