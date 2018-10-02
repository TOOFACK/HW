package XO;


import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
    }
    int[][] gameBoard = new int[3][3];
    private String playerX = "X", playerY = "O", CurrentPlayer = playerX, previousPlayer=playerY;
    int str, col,x=0,y=0,x1=0,y1=0;
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
            if ((col > 2) || (str > 2) || (col < 0) || (str < 0)) {
                System.out.println("Вводимые значения больше поля или меньше");
                continue;
            }
            checkRewriting();
            gameBoard[str][col] = getCurrentPlayer().equalsIgnoreCase(playerX) ? 1 : 2;
            setCurrentPlayer(getCurrentPlayer().equals(playerX) ? playerY : playerX);
            if(x!=0){
                System.out.println("Свое не трожь");
                setCurrentPlayer(playerX);
                x=0;
            }
            if(y!=0){
                System.out.println("Свое не трожь");
                setCurrentPlayer(playerY);
                y=0;
            }
            if(x1!=0){
                System.out.println("Выберите другую клетку");
                setCurrentPlayer(playerX);
                gameBoard[str][col]=2;
                x1=0;
            }
            if(y1!=0){
                System.out.println("Выберите другую клетку");
                setCurrentPlayer(playerY);
                gameBoard[str][col]=1;
                y1=0;
            }
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
        if ((gameBoard[0][0] == 2) & (gameBoard[1][1] == 2) & (gameBoard[2][2] == 2)) {
            System.out.println("Победил игрок Y");
            createGameBoard();
        }
        if ((gameBoard[0][2] == 1) & (gameBoard[1][1] == 1) & (gameBoard[2][0] == 1)) {
            System.out.println("Победил игрок Х");
            createGameBoard();
        }
        if ((gameBoard[0][2] == 2) & (gameBoard[1][1] == 2) & (gameBoard[2][0] == 2)) {
            System.out.println("Победил игрок Y");
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

    private void checkRewriting() {

        if((gameBoard[str][col]==1)&&(getCurrentPlayer()==playerX)){
            gameBoard[str][col]=1;
            setCurrentPlayer(playerX);
            x++;
        }
        if ((gameBoard[str][col] == 2) && (getCurrentPlayer() == playerY)) {
            setCurrentPlayer(playerY);
            gameBoard[str][col] = 2;
            y++;
        }
        //new
        if((gameBoard[str][col]==1)&&(getCurrentPlayer()==playerY)){
            gameBoard[str][col]=1;
            setCurrentPlayer(playerY);
            y1++;
        }
        if((gameBoard[str][col]==2)&&(getCurrentPlayer()==playerX)){
            gameBoard[str][col]=2;
            setCurrentPlayer(playerX);
            x1++;
        }


    }

}




