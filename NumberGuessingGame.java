import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
  public static void main(String[]args){
    Scanner scanner=new
Scanner(System.in);
    Random random=new Random();
    boolean playAgain=true;
    int totalScore=0;

    System.out.println("Welcome to the Number Guessing Game!");
    
    while(playAgain){
     int numberToGuess=random.nextInt(100)+1;
     int attempts=0;
     int maxAttempts=10;
     boolean guessedCorrectly=false;

    System.out.println("\n have chosen a number between 1 and 100. Can you guess it?");
    System.out.println("You have"+maxAttempts+"attempts.");

    while(attempts<maxAttempts){
     System.out.println("Enter your guess:");
     int userGuess;

    while(!scanner.hasNextInt()){
     System.out.println("Invalid input! Please enter a number.");
     scanner.next();
    }
    userGuess=scanner.nextInt();

    attempts++;

    if(userGuess==numberToGuess){
       System.out.println("Congratulations!You guessed the number in"+attempts+"attempts.");
       guessedCorrectly=true;
       totalScore+=(maxAttempts-attempts+1);
       break;
    }else if(userGuess<numberToGuess){
     System.out.println("Too low! Try again.");
    }else{
     System.out.println("Too high! Try again.");
    }
   }
   if(!guessedCorrectly){
      System.out.println("Sorry,you've run out of attempts.The correct number was:"+numberToGuess);
    }

     System.out.println("You total score:"+totalScore);
     System.out.println("Do you want to play again?(yes/no):");
     String response=scanner.next().toLowerCase();
     playAgain=response.equals("yes");
   }

     System.out.println("Thanks for playing! Your final score:"+totalScore);
     scanner.close();
   }
 }
