package XO;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
    }
    int[][] gameBoard = new int[3][3];
    private String playerX = "X", playerY = "O", CurrentPlayer = playerX, previousPlayer=playerY;
    int str, col;
    Scanner in = new Scanner(System.in);

    Game() {
        createGameBoard();
        while (true) {
            drawGameBoard();
            System.out.println();
            System.out.println("Сейчас ходит" + getCurrentPlayer());
            System.out.println("Выбери строку: ");
            str = in.nextInt();
            System.out.println("Выбери столбик: ");
            col = in.nextInt();
            if(gameBoard[str][col]!=0){
                System.out.println("Эта клетка занята, выберите другую");
                setCurrentPlayer(getPreviousPlayer());
                gameBoard[str][col] = getPreviousPlayer().equalsIgnoreCase(playerX) ? 2 : 1;
                setPreviousPlayer(getPreviousPlayer().equals(playerX) ? playerX : playerY);
            }
            else{
            setPreviousPlayer(getPreviousPlayer().equals(playerX) ? playerX : playerY);
            gameBoard[str][col] = getCurrentPlayer().equalsIgnoreCase(playerX) ? 1 : 2;
            setCurrentPlayer(getCurrentPlayer().equals(playerX) ? playerY : playerX);}
            chekWin();
            checkTie();
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
                switch (gameBoard[str][col]) {
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case 2:
                        System.out.print("O");
                        break;
                }
                System.out.print("|  ");
            }
            if (str == 2) {
                break;
            }
            System.out.println();
            System.out.println("===========");
        }

    }

    public String getCurrentPlayer() {
        return CurrentPlayer;
    }

    public void setCurrentPlayer(String CurrentPlayer) {
        this.CurrentPlayer = CurrentPlayer;
    }

    private void chekWin() {
        for (int str = 0; str < gameBoard.length; str++) {
            for (int col = 0; col < gameBoard[str].length; col++) {
                if ((gameBoard[0][col] == 1) & (gameBoard[1][col] == 1) & (gameBoard[2][col] == 1)) {
                    System.out.println("Победил игрок Х");
                    createGameBoard();
                }
                if ((gameBoard[0][col] == 2) & (gameBoard[1][col] == 2) & (gameBoard[2][col] == 2)) {
                    System.out.println("Победил игрок Y");
                    createGameBoard();
                }
            }
        }
        for (int str = 0; str < gameBoard.length; str++) {
            for (int col = 0; col < gameBoard[str].length; col++) {
                if ((gameBoard[str][0] == 1) & (gameBoard[str][1] == 1) & (gameBoard[str][2] == 1)) {
                    System.out.println("Победил игрок Х");
                    createGameBoard();
                }
                if ((gameBoard[str][0] == 2) & (gameBoard[str][1] == 2) & (gameBoard[str][2] == 2)) {
                    System.out.println("Победил игрок Y");
                    createGameBoard();
                }
            }
        }
        if ((gameBoard[0][0] == 1) & (gameBoard[1][1] == 1) & (gameBoard[2][2] == 1)) {
            System.out.println("Победил игрок Х");
            createGameBoard();
        }
        if ((gameBoard[0][0] == 1) & (gameBoard[1][1] == 1) & (gameBoard[2][2] == 1)) {
            System.out.println("Победил игрок Х");
            createGameBoard();
        }
        if ((gameBoard[0][2] == 1) & (gameBoard[1][1] == 1) & (gameBoard[2][0] == 1)) {
            System.out.println("Победил игрок Х");
            createGameBoard();
        }
        if ((gameBoard[0][2] == 1) & (gameBoard[1][1] == 1) & (gameBoard[2][0] == 1)) {
            System.out.println("Победил игрок Х");
            createGameBoard();
        }
    }

    private void checkTie() {
        int temporaryval=0;
       for (int str = 0; str < gameBoard.length; str++) {
            for (int col = 0; col < gameBoard[str].length; col++) {
                if (gameBoard[str][col] != 0) {
                    temporaryval++;
                }
            }
            if(temporaryval==9){
                System.out.println("Ничья");
                createGameBoard();
            }
        }
    }

    public String getPreviousPlayer() {
        return previousPlayer;
    }

    public void setPreviousPlayer(String previousPlayer) {
        this.previousPlayer = previousPlayer;
    }
}




