package com.thoughtworks.ticTacToe;

import java.util.HashSet;
import java.util.function.Predicate;

public class Positions extends HashSet<Position> {

  public Positions add(int ...numbers) {
    for (int number : numbers) {
      this.add(new Position(number));
    }
    return this;
  }

  @Override
  public boolean removeIf(Predicate<? super Position> filter) {
    return false;
  }

  public boolean isSubset(WinningCombinations combinations) {
    for (Positions combination : combinations) {
      if(combination.containsAll(this)) {
        return true;
      }
    }
    return false;
  }
}
