import com.thoughtworks.ticTacToe.*;

import java.util.Scanner;

public class Controller {
  public static void main(String[] args) throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
    Game game = new Game();
    assignPlayersToGame(game);
    assignWinningCombinationsToGame(game);
    playGame(game);
  }

  private static void assignPlayersToGame(Game game) throws PlayersAlreadyJoined {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter player1 name:");
    String player1Name = scanner.next();
    Player player1 = new Player(player1Name,"*");

    System.out.println("Enter player2 name:");
    String player2Name = scanner.next();
    Player player2 = new Player(player2Name,"#");

    game.addPlayer(player1);
    game.addPlayer(player2);
  }
  private static void assignWinningCombinationsToGame(Game game) {
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    winningCombinations.addCombination(7,8,9);
    game.setWinningCombinations(winningCombinations);
  }

  private static void playGame(Game game) throws gameAlreadyCompleted {
    Scanner scanner = new Scanner(System.in);
    //not working
    for(int index = 0;index < 10; index++) {
      printTurn(index);
      int move = scanner.nextInt();
      try {
        game.addMoveToCurrentPlayer(move);
      } catch (InvalidMove invalidMove) {
        System.out.println(invalidMove.getMessage());
        index--;
        continue;
      }
      game.updateStatus();
      String status = game.getStatus();
      if(status != "started") {
        System.out.println(status);
        break;
      }
    }
  }

  private static void printTurn(int index) {
    if(index % 2 == 0) {
      System.out.println("player1 turn");
    } else {
      System.out.println("player2 turn");
    }
  }
}