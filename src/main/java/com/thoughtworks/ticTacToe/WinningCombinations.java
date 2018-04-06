package com.thoughtworks.ticTacToe;

import java.util.HashSet;

public class WinningCombinations extends HashSet {
  public boolean addCombination(int...numbers) {
    Positions positions = new Positions();
    return this.add(positions.add(numbers));
  }
}