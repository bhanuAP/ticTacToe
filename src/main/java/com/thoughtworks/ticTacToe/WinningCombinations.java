package com.thoughtworks.ticTacToe;

import java.util.HashSet;

public class WinningCombinations {
  private HashSet<Positions> list;

  public void addAsCombination(int...numbers) {
    Positions positions = new Positions();
    positions.addPositionItems(numbers);
  }
}