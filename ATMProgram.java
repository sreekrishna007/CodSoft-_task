import java.util.Scanner;

class ATM {
  private UserAccount userAccount;
  
  public ATM(UserAccount userAccount){
    this.userAccount=userAccount;
  }

  public void withdraw(double amount){
    if(amount<=0){
      System.out.println("Invalid amount! Please enter a positive number.");
      return;
    }

    if(userAccount.getBalance()>=amount){
    userAccount.setBalance(userAccount.getBalance()-amount);
      System.out.println("Withdrawal successful! You withdrew:$"+amount);
    }else{
      System.out.println("Insufficient balance! Your balance is:$"+userAccount.getBalance());
    }
  }

  public void deposit(double amount){
    if(amount<=0){
      System.out.println("Invalid amount! Please enter a positive number.");
      return;
    }

   userAccount.setBalance(userAccount.getBalance()+amount);
    System.out.println("Deposit successful! You deposited:$"+amount);
  }

  public void checkBalance(){
    System.out.println("Your current balance is:$"+userAccount.getBalance());
  }

  public void displayMenu(){
    Scanner scanner=new Scanner(System.in);
    int choice;
    
    do{
      System.out.println("\nATM Menu:");
      System.out.println("1.Withdraw");
      System.out.println("2.Deposit");
      System.out.println("3.Check Balance");
      System.out.println("4.Exit");
      System.out.println("Please select an option(1-4):");

      choice=scanner.nextInt();

      switch(choice){
        case 1:
          System.out.print("Enter the amount to withdraw:$");
          double withdrawAmount=scanner.nextDouble();
          withdraw(withdrawAmount);
          break;
        case 2:
          System.out.print("Enter the amount to deposit:$");
          double depositAmount=scanner.nextDouble();
          deposit(depositAmount);
          break;
        case 3:
          checkBalance();
          break;
        case 4:
          System.out.println("Thank you for using the ATM. Goodbye!");
          break;
        default:
          System.out.println("Invalid option!Please try again.");
      }
    }while(choice!=4);

     scanner.close();
   }
  }

  class UserAccount{
    private double balance;
    
    public UserAccount(double initialBalance){
      if(initialBalance<0){
         System.out.println("Initial balance cannot be negative! Setting balance to $0.");
         this.balance=0;
      }else{
         this.balance=initialBalance;
      }
    }

    public double getBalance(){
      return balance;
    }

    public void setBalance(double balance){
      this.balance=balance;
    }
  }

    public class ATMProgram{
      public static void main(String[]args){
        UserAccount userAccount=new UserAccount(100000);
        ATM atm=new ATM(userAccount);
        atm.displayMenu();
      }
    }