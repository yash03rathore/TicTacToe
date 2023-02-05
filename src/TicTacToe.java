/*
Project: Tic Tac Toe Game.
Description: The program is a tictactoe game that declars a winner at the end of the game.
Name: Yashwardhan Rathore
 */

//importing scanner
import java.util.Scanner;
//Creating class
public class TicTacToe {
    //Creating a main method
    public static void main(String[] args){
        // create scanner to read user input
        // create char[] array to store board values
        // set positions of board from 1 to 9
        // 2 players: 'X' and 'O', start with 'X'
        Scanner input = new Scanner(System.in);
        //declaring a character array
        char board[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        //declaring a character variable and assigning the default value as X
        char player = 'X';
        int nums = 0;

        // display the playing board in 3x3 layout
        display(board);





        // play game until gameOver is true
        boolean gameOver = false;
        while (!gameOver) {

            // switch player 'X' -> 'O' or 'O' -> 'X'
            player = (player == 'X') ? 'O' : 'X';

            // get current player choice, and update board value
            receiveUserChoice(player, input, board);
            // display the updated board
            display(board);

            // check for winner, draw or game is not over yet
            gameOver = isGameOver(board);
            nums++;
            if (nums == 9) {
                break;
            }
            // ** important ** remove the following statement
            // I added it to avoid infinite loop
            // gameOver value should return from isGameOver() method as above
        }
            if (gameOver){
                System.out.println("*****"+player+" Wins! *****");
            }
            else if (!gameOver){
                System.out.println("The Game is Draw!");
            }


    }


    // display board in 3x3 layout
    // note that array indices from 0 to 8 = positions from 1 to 9
    public static void display(char[] board) {
        System.out.println("");
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println("");
    }


    // get current player choice, and update board value
    public static void receiveUserChoice(char player, Scanner input, char[] board) {
        // Step 1: get user input, a position from 1 to 9
        // Step 2: make sure it is a valid position, and the position is not taken yet
        //    2.1: if it is valid input, mark the board position with the current player
        //    2.2: if it is not valid, print message repeat Step 1. until a valid input is obtained
        System.out.println(player+" turn (Enter position number): ");
        while(true){
        int userchoice = input.nextInt();
        if (userchoice<10 && userchoice>=0 && board[userchoice-1] == '0' + userchoice){
            board[userchoice-1] = player;
            break;
        }
        System.out.println("Invalid position. Enter a valid position. ");
        }


    }


    // check for winner, draw or game is not over yet
    public static boolean isGameOver(char[] board) {
        // Step 1: if there is a winner, print winner message, return true
        // Step 2: if it is a draw, print draw message, return true
        // Step 3: else the game is not over yet, return false

       for(int i = 0; i<9; i = i+3){
           if (board[i] == board[i+1] && board[i] == board[i+2]){
               return true;
           }
       }
       for (int i = 0; i<3; i = i+1){
           if (board[i] == board[i+3] && board[i+3] == board[i+6]){
               return true;
           }
       }
       if (board[2] == board[4] && board[4] == board[6]){
           return true;
       }
       if (board[0] == board[4] && board[4] == board[8]){
           return true;
       }

        return false;

    }
}




