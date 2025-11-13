package Board;

import java.util.Scanner;

public class TicTacToe{
    public static void main(String[] args) {

        System.out.println("Tic Tac Toe Game");

        char board[][] = new char[3][3];

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                board[row][col] = ' ';
            }
        }

        printBoard(board);

        Scanner sc = new Scanner(System.in);

        char currentPlayer = 'X';
        boolean gameOver = false;
        int noOfMoves = 0;

        while(!gameOver){
            if(noOfMoves == 9)
            {
                System.out.println("Draw....Play Again!");
                return;
            }
            System.out.print("Player " + currentPlayer + " enter the position in row: ");
            int row = sc.nextInt();

            System.out.print("Player " + currentPlayer + " enter the position in column: ");
            int col = sc.nextInt();

            if(board[row][col] == ' '){

                board[row][col] = currentPlayer;
                gameOver = isMatchOverOrNot(board, currentPlayer);

                if(gameOver)
                {
                    System.out.println("The Player " + currentPlayer + " has Won the Game!");
                }
                else{
                    currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                }
            }
            else{
                System.out.println("Please Enter the Valid Move");
            }
            noOfMoves++;
            printBoard(board);

            System.out.println();
        }
        
    }

    public static void printBoard(char board[][]){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean isMatchOverOrNot(char board[][], char currentPlayer){
        
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == currentPlayer 
               && board[row][1] == currentPlayer && 
               board[row][2] == currentPlayer)
                return true;
        }

        for(int col = 0; col < board[0].length; col++){
            if(board[0][col] == currentPlayer 
            && board[1][col] == currentPlayer 
            && board[2][col] == currentPlayer){
                return true;
            }
        }

        if(board[0][0] == currentPlayer 
        && board[1][1] == currentPlayer 
        && board[2][2] == currentPlayer){
            return true;
        }
        
        if(board[0][2] == currentPlayer 
        && board[1][1] == currentPlayer 
        && board[2][0] == currentPlayer){
            return true;
        }

        return false;
    }
}        