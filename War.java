/*
Benjamin Citrin
CS 110
Assignment #10
War
Game Class
*/

public class War
{
   //declare object variables
   QueueReferenceBased queue1; 
   QueueReferenceBased queue2;
   Deck1 deck;   
   
   //main method
   public static void main(String[] args) 
   {
      War w = new War();
      w.nonMain();
   }//end main method

   public void nonMain()
   {
      //deal cards
      deal();
      int i=1;
      while (!queue1.isEmpty() && !queue2.isEmpty()) 
      { 
         
         //flip first card
         System.out.println("Me: " + flipCard1());
         System.out.println("Card " + i);
         i++;
         System.out.println("CPU: " + flipCard2());
         System.out.println("Card " + i);
         i++;
      }//end while loop   
      System.out.println("Cards remaining: " + deck.cardsRemaining());
   }//end 
   
  
   public void deal() 
   {
      //delcare variables
      deck = new Deck1(); //create Deck1 object
      queue1 = new QueueReferenceBased(); //create player queue
      queue2 = new QueueReferenceBased(); //create cpu queue
      deck.freshDeck();
      deck.shuffle(); //shuffle deck
    
      while (!(deck.cardsRemaining() == 0))
      {
         queue1.enqueue(deck.dealCard());
         queue2.enqueue(deck.dealCard());
      }//end for loop 
      
   }//end deal method          
   
   
   public String flipCard1()
   {
      Card card1 = (Card) queue1.dequeue();
      return card1.getRankAsString() + " of " + card1.getSuitAsString();
   }   
   
   
   public String flipCard2()
   {
      Card card2 = (Card) queue2.dequeue();
      return card2.getRankAsString() + " of " + card2.getSuitAsString();
   }   
         
}//end class