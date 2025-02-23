import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz{
  private String[] questions={"Which country won the 2023 FIFA Women's World Cup?",
                              "Who won the 2023 Noble Prize in Literature?",
                              "Which city hosted the 2023 World Athletics Championships?",
                              "Who won the 2023 Ballon d'Or?",
                              "Which team won the 2023 Super Bowl?"};

  private String[][] options={{"1.Spain","2.England","3.Sweden","4.Australia"},
                             {"1.Annie Ernaux","2.Jon Fosse","3.Abdulrazak Gurnah","4.Olga Tokarczuk"},
                             {"1.Landon","2.Eugene","3.Doha","4.Budapest"},
                             {"1.Kylian Mbappe","2.Erling Haaland","3.Lionel Messi","4.Kevin De Bruyne"},
                             {"1.Kansas City Chiefs","2.Philadelphia Eagles","3.Cincinnati Bengals","4.San Francisco 49ers"}};

  private int[] correctAnswers={1,2,4,3,1};
  private int score=0;
  private int[] userAnswers=new int[questions.length];

  public void startQuiz(){
    Scanner scanner=new Scanner(System.in);

    for(int i=0;i<questions.length;i++){
       final int questionIndex=i;

       System.out.println("\nQuestion"+(i+1)+":"+questions[i]);
       for(String option:options[i]){
          System.out.println(option);
       }

       Timer timer=new Timer();
       TimerTask task=new TimerTask(){
         public void run(){
           System.out.println("\nTime's up!Moving to the next questions...");
           userAnswers[questionIndex]=0;
           synchronized(scanner){
             scanner.notify();
           }
         }
       };
       timer.schedule(task,10000);
       System.out.print("Enter your answer(1-4):");
       synchronized(scanner){
         try{
           userAnswers[questionIndex]=scanner.nextInt();
           timer.cancel();
         }catch(Exception e){
           userAnswers[questionIndex]=0;
           scanner.next();
         }
       }

       if(userAnswers[questionIndex]==correctAnswers[questionIndex]){
          score++;
          System.out.println("Correct!");
       }else{
          System.out.println("Wrong!The correct answer was:"+correctAnswers[questionIndex]);
       }
     }
     scanner.close();
     displayResults();
  }

  private void displayResults(){
    System.out.println("\n======Quiz Results======");
    System.out.println("Your final score:"+score+"/"+questions.length);
    System.out.println("Summary of your answers:");
    for(int i=0;i<questions.length;i++){ 
       System.out.println("Q"+(i+1)+":"+questions[i]);
       if(userAnswers[i]==correctAnswers[i]){
          System.out.println("Your answer:"+userAnswers[i]+"(Correct)");
       }else if(userAnswers[i]==0){
          System.out.println("You didn't answer(Correct:"+correctAnswers[i]+")");
       }else{
          System.out.println("Your answer:"+userAnswers[i]+")");
       }
    }

  System.out.println("================");
    }
  }
 
  public class QuizApplication{
    public static void main(String[]args){
      System.out.println("===Welcome to the Quiz===");
      Quiz quiz=new Quiz();
      quiz.startQuiz();
    }
  }




   