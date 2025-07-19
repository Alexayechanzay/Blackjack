import java.util.Random;

public class Blackjack {
  private int[] user_card = new int[2];
  private int[] comp_card = new int[2];
  
  private int sum_user_card = 0;
  private int sum_comp_card = 0;
  private String winner;
  
  // Just like in OOP, create a constructor
  public Blackjack() {
    Random rand = new Random();
    
    // For user
    user_card[0] = rand.nextInt(11)+1;
    user_card[1] = rand.nextInt(11)+1;
    
    // For computer
    comp_card[0] = rand.nextInt(11)+1;
    comp_card[1] = rand.nextInt(11)+1;
    
    sum_user_card  = user_card[0] + user_card[1];
    sum_comp_card  = comp_card[0] + comp_card[1];
    
    if (sum_user_card == 22) {
      sum_user_card = 12;
      user_card[1] = 1;
    }
    
    if (sum_comp_card == 22) {
      sum_comp_card = 12;
      comp_card[1] = 1;
    }
  }
    
  // creating methods for Blackjack class
  public void show_user_card() {
    System.out.print("You: ");
    for (int value: user_card) {
      System.out.print(value + " ");
    }
    System.out.println();
  }
  
  public void show_comp_card() {
    System.out.print("Computer: ");
    for (int value: comp_card) {
      System.out.print(value + " ");
    }
    System.out.println();
  }
  
  public void show_sum_card() {
    System.out.println("Sum of your cards: "+ sum_user_card);
    System.out.println("Sum of computer cards: "+ sum_comp_card);
  }
  
  public void display_winner() {
    if (sum_user_card > sum_comp_card) {
       winner = "You!";
    }
    else if (sum_user_card == sum_comp_card) {
      winner = "Draw!";
    }
    else {
       winner = "Computer!";
    }
    System.out.println("The wineer is "+ winner);
    
}
    public static void main(String[] args) {
      Blackjack bj = new Blackjack();
      bj.show_user_card();
      bj.show_comp_card();
      // \n
      System.out.println();
      
      bj.show_sum_card();
      bj.display_winner();
      
    }
}
