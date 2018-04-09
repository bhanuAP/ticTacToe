package com.thoughtworks.ticTacToe;

import java.util.HashSet;

public class WinningCombinations extends HashSet<Positions> {
  public WinningCombinations addCombination(int ...numbers) {
    Positions positions = new Positions();
    this.add(positions.add(numbers));
    return this;
  }
}