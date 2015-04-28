/*
Benjamin Citrin
CS 110
Assignment #10
War
Card Class
*/
public class Card 
{
   //set the 4 suits as final ints
   public static final int SPADES = 0;   
   public static final int CLUBS = 1;
   public static final int HEARTS = 2;
   public static final int DIAMONDS = 3;
   
   /*set value of face cards; others cards ranked by respective number
    aces are low*/
   public static final int ACE = 1;     
   public static final int JACK = 11;     
   public static final int QUEEN = 12;   
   public static final int KING = 13;
   
   //initialize rank; private
   private int rank; 
   //initialize suit; private
   private int suit;
   
   //constructor; rank and suit are integer arguments
   public Card(int cardRank, int cardSuit)
   {
      rank = cardRank;
      suit = cardSuit;
   }
   
   /**
     @returns the suit, which is one of the constants 
    */
   public int getSuit() 
   {
      return suit;
   }
   
   /**
    * @return the rank, which is one of the numbers 1 through 13
    */
   public int getRank() 
   {
      return rank;
   }
   
   /**
    @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs"
    */
   public String getSuitAsString()
    {
      if (suit == SPADES)
      {
      return "Spades";
      }
      if (suit == CLUBS)
      {
      return "Clubs";
      }
      if (suit == HEARTS)
      {
      return "Hearts";
      } 
      else
      {
      return "Diamonds";
      }  
   }
   
   /**
      @returns the card number as a value
    */
   public String getRankAsString() 
   {
         if (rank == 1)
         {
         return "Ace";
         }
         if (rank == 2)
         {
         return "2";
         }
         if (rank == 3)
         {
         return "3";
         }
         if (rank == 4)
         {
         return "4";
         }
         if (rank == 5)
         {
         return "5";
         }
         if (rank == 6)
         {
         return "6";
         }
         if (rank == 7)
         {
         return "7";
         }
         if (rank == 8)
         {
         return "8";
         }
         if (rank == 9)
         {
         return "9";
         }
         if (rank == 10)
         {
         return "10";
         }
         if (rank == 11)
         {
         return "Jack";
         }
         if (rank == 12)
         {
         return "Queen";
         }
         else 
         {
         return "King";
         }
      }
   
   /**
    * returns suit and card number
    */
   public String toString() 
   {
   return "The card is the " + getRankAsString() + " of " + getSuitAsString();
   }
   
   //equals method, accepts Card object as argument
   public boolean equals(Card compareCard)
   {
      if (compareCard.getRank() == this.getRank())
      {
         return true; 
      }
      else
      {
         return false;
      }
   } 
   //short program
   public static void main(String [] args)
   {
      //create Card objects
      Card card1 = new Card(Card.KING, Card.CLUBS);
      Card card2 = new Card(7, 2);
      Card card3 = new Card(7, 2);
      //demonstrate getSuit method
      System.out.println(card1.getSuit());
      //demonstrate getRank method
      System.out.println(card1.getRank());
      //demonstrate getSuiteAsString method
      System.out.println(card1.getSuitAsString());
      //demonstrate getRankasString method
      System.out.println(card1.getRankAsString());
      //demonstrate boolean method
      //card 1 doesn't equal card 2
      if (card1.equals(card2))
      {
      System.out.println("The two cards are equal");
      }
      else
      {
      System.out.println("The two cards aren't equal");
      }
      //card 2 equals card 3
      if (card2.equals(card3))
      {
      System.out.println("The two cards are equal");
      }
      else
      {
      System.out.println("The two cards aren't equal");
      }
      //demonstrate toString method
      System.out.println("Card 1: " + card1.toString());
      System.out.println("Card 2: " + card2.toString());
      System.out.println("Card 3: " + card3.toString());
   
   }//end main method
} //end class