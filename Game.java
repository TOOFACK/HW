package XO;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Game game=new Game();
    }
    int[][] gameBoard = new int[3][3];
    private String playerX = "X", playerY = "O", CurrentPlayer = playerX;
    int str,col;
    Scanner in = new Scanner(System.in);

    Game() {
        createGameBoard();
        while(true) {
            drawGameBoard();
            System.out.println("Сейчас ходит"+getCurrentPlayer());
            System.out.println("Выбери строку: ");
            str = in.nextInt();
            System.out.println("Выбери столбик: ");
            col=in.nextInt();
            gameBoard[str][col]=getCurrentPlayer().equalsIgnoreCase(playerX)?1:2;
            setCurrentPlayer(getCurrentPlayer().equals(playerX)?playerY:playerX);


        }

    }

    private void createGameBoard() {
        for (int str = 0; str < gameBoard.length; str++) {
            for (int col = 0; col < gameBoard[str].length; col++) {
                gameBoard[str][col] = 0;

            }
        }
    }

    private void drawGameBoard() {

        for (int str = 0; str < gameBoard.length; str++) {
            for (int col = 0; col < gameBoard[str].length; col++) {
                switch(col){
                    case 0:
                        System.out.println(" ");
                        break;
                    case 1:
                        System.out.println("X");
                        break;
                    case 2:
                        System.out.println("O");
                        break;
                }
                System.out.print("  |  ");
            }
            System.out.println();
            System.out.println("=========");
        }

    }

    public String getCurrentPlayer() {
        return CurrentPlayer;
    }

    public void setCurrentPlayer(String CurrentPlayer) {
        this.CurrentPlayer = CurrentPlayer;
    }
}
