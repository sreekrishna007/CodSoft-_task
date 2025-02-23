import java.util.Scanner;

public class StudentGradeCalculator{
  public static void main(String[]args){
    Scanner scanner=new Scanner(System.in);
   
    System.out.print("Enter the number of subjects:");
    int numSubjects=scanner.nextInt();

    if(numSubjects<=0){
      System.out.println("Invalid number of subjects!Exiting program...");
      return;
    }

    int[] marks=new int[numSubjects];
    int totalMarks=0;

    for(int i=0;i<numSubjects;i++){
       System.out.print("Enter marks obtained in Subject"+(i+1)+"(out of 100):");
       marks[i]=scanner.nextInt();

       while(marks[i]<0||marks[i]>100){
         System.out.print("Invalid! Enter marks between 0 & 100:");
         marks[i]=scanner.nextInt();
       }

        totalMarks+=marks[i];
    }

    double averagePercentage=(double)totalMarks/numSubjects;

    String grade;
    if(averagePercentage>=90){
      grade="A+(Excellent)";
    }else if(averagePercentage>=80){
      grade="A(Very Good)";
    }else if(averagePercentage>=70){
      grade="B(Good)";
    }else if(averagePercentage>=60){
      grade="C(Average)";
    }else if(averagePercentage>=50){
      grade="D(Below Average)";
    }else{
      grade="F(Fail)";
    }


   System.out.println("\n---Student Grade Report---");
   System.out.println("Total Marks Obtained:"+totalMarks);
   System.out.println("Average Percentage:"+String.format("%.2f",averagePercentage)+"%");
   System.out.println("Grade:"+grade);

   if(grade.equals("F(Fail)")){
     System.out.println("Advice:Work harder! Better luck next time.");
   }else{
     System.out.println("Great job! Keep improving.");
   }

   scanner.close();
  }
}