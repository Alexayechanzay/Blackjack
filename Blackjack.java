import java.util.Random;
import java.util.Scanner;

public class Blackjack {
  private int[] user_card = new int[5];
  private int[] comp_card = new int[5];
  
  private int number_user_card =  2;
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

  // Taking more card 
  public void add_more_card(){
    Random rand = new Random();
    user_card[number_user_card] = rand.nextInt(11)+1;

    if (user_card[number_user_card] == 11 && sum_user_card > 21) {
      user_card[number_user_card] = 1;
      sum_user_card -= 10;
    }
    // update the sum of user card
    sum_user_card += user_card[number_user_card];
    number_user_card++;
  }

  // Check for end game
  public boolean isEnd(){
    return (sum_user_card > 21 || sum_comp_card > 21 ||  number_user_card == 5);
  }

  // chekcing winner
  public void checkWinner() {
		if (sum_user_card > 21) {
			winner = "Computer";
		} else if (sum_comp_card > 21) {
			winner = "You";
		} else if (sum_user_card == 21 && sum_comp_card == 21) {
			winner = "Computer";
		} else if (sum_user_card == 21) {
			winner = "You";
		} else if (sum_comp_card == 21) {
			winner = "Computer";
		} else if (number_user_card == 5) {
			winner = "Computer";
		} else {
			if (sum_user_card > sum_comp_card) {
				winner = "You";
			} else {
				winner = "Computer";
			}
		}
	}

  public String get_winner() {
    return "The winner is " + winner;
  }
  
  public void show_sum_card() {
    System.out.println("Sum of your cards: "+ sum_user_card);
    System.out.println("Sum of computer cards: "+ sum_comp_card);
  }
  
  public void display_winner() {
    if (sum_user_card > sum_comp_card) {
       winner = "The winner is You!";
    }
    else if (sum_user_card == sum_comp_card) {
      winner = "Draw!";
    }
    else {
       winner = "The winner is Computer!";
    }
    System.out.println(winner);
    
}
	public static void main(String[] args) {
    String choice;
    Blackjack bj = new Blackjack();
    Scanner scanner = new Scanner(System.in); // Create once
    
    while (!bj.isEnd()) {
        bj.show_user_card();
        System.out.println("Computer: ? ?");
        System.out.println();
        System.out.print("Want another card? <y/n>...");
        choice = scanner.nextLine();
        if (choice.equals("y")) {
            bj.add_more_card();
        } else {
            break;
        }
    }
    scanner.close(); // Close when done
    bj.show_user_card();
    bj.show_comp_card();
    System.out.println();
    bj.show_sum_card();
    bj.checkWinner();
    System.out.println(bj.get_winner());
}
}
