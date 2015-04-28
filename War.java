/*
Benjamin Citrin
CS 110
Assignment #10
War
Game Class
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
      
      
      /*queue is empty
      catch (QueueException e)
      { 
         System.out.println("ERROR");*/
         
   }//end main method

   public void nonMain()
   {
      try 
      {
      //GUI
      final int WINDOW_WIDTH = 350;  //window width in pixels
      final int WINDOW_HEIGHT = 250; //window height in pixels
      
      //create the window w/ label and size
      JFrame window = new JFrame("A Game of War");
      window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      //specify what happens when close button is clicked
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //display window
      window.setVisible(true);
      
      
      //deal cards
      deal();
 
      while (!queue1.isEmpty() && !queue2.isEmpty()) 
      { 
         
         //flip first card
         System.out.println(flipCard1());
  

      }//end while loop   
      
      if(queue1.isEmpty())
      {
         System.out.println("CPU wins the war");
      }
      
      if(queue2.isEmpty())
      {
         System.out.println("You've won the war!");
      }
      }//end try
      catch (QueueException e)
      {
         if (!queue1.isEmpty())
            System.out.println("Computer is out of cards--you've won the war!");  
         if (!queue2.isEmpty()) 
            System.out.println("You are out of cards--you have lost the war!");
      }      
   }//end nonMain method
   
   //deal the cards
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
      String string1 = card1.getRankAsString() + " of " + card1.getSuitAsString();
      Card card2 = (Card) queue2.dequeue();
      String string2 = card2.getRankAsString() + " of " + card2.getSuitAsString();
      //if player card is greater
      if (card1.getRank() > card2.getRank())
       {
         //add cards to winner pile
         queue1.enqueue(card1);
         queue1.enqueue(card2); 
         return string1 + " is greater than " + string2 + "--You win!";
       }
      //if CPU card is greater  
      if (card2.getRank() > card1.getRank())
       {  
         queue2.enqueue(card1); //add player card to CPU pile
         queue2.enqueue(card2);
         return string2 + " is greater than " + string1 + "--CPU wins!";
       }  
      //war      
      else
         System.out.println("WAR: " + string1 + " vs. " + string2);
         
         Card card3 = (Card) queue1.dequeue();
         String string3 = card3.getRankAsString() + " of " + card3.getSuitAsString();
         Card card9 = (Card) queue1.dequeue(); //facedown card
         Card card4 = (Card) queue2.dequeue();
         Card card10 = (Card) queue2.dequeue(); //facedown card
         String string4 = card4.getRankAsString() + " of " + card4.getSuitAsString();
         
         if (card3.getRank() > card4.getRank())
          { 
            queue1.enqueue(card1);
            queue1.enqueue(card2);
            queue1.enqueue(card3); //add card from first flip
            queue1.enqueue(card4); //add card from war flip
            queue1.enqueue(card9); //add card from war flip
            queue1.enqueue(card10);
            return "After war, " + string3 + " is greater than " + string3 + "--You win!";
          }
            
         if (card4.getRank() > card3.getRank())
          {
            queue2.enqueue(card1);
            queue2.enqueue(card2); //add card from first flip
            queue2.enqueue(card3);
            queue2.enqueue(card4); //add card from war flip 
            queue2.enqueue(card9);
            queue2.enqueue(card10);
            return "After war, " + string4 + " is greater than " + string3 + "--CPU wins!";
          }  
         //double war   
         else
            System.out.println("DOUBLE WAR: " + string3 + " vs. " + string4);
            Card card11 = (Card) queue1.dequeue(); //facedown card
            Card card5 = (Card) queue1.dequeue();
            String string5 = card5.getRankAsString() + " of " + card5.getSuitAsString();
            Card card12 = (Card) queue2.dequeue(); //facedown card
            Card card6 = (Card) queue2.dequeue();
            String string6 = card6.getRankAsString() + " of " + card6.getSuitAsString();
            
         
            if (card5.getRank() > card6.getRank())
             {
               queue1.enqueue(card1);
               queue1.enqueue(card2); //add card from first flip
               queue1.enqueue(card3);
               queue1.enqueue(card4); //add card from war flip 
               queue1.enqueue(card5);
               queue1.enqueue(card6); //add card from double war flip
               queue1.enqueue(card11);
               queue1.enqueue(card12);
               return "After double war, " + string5 + " is greater than " + string6 + "--You win!";
             }  
            if (card6.getRank() > card5.getRank())
             {
               queue2.enqueue(card1);
               queue2.enqueue(card2); //add card from first flip
               queue2.enqueue(card3);
               queue2.enqueue(card4); //add card from war flip 
               queue2.enqueue(card5);
               queue2.enqueue(card6); //add card from double war flip
               queue2.enqueue(card11);
               queue2.enqueue(card12);
               return "After double war, " + string6 + " is greater than " + string5 + "--CPU wins!";
             }  
            //triple war
            else
               System.out.println("TRIPLE WAR: " + string5 + " vs. " + string6);
               Card card13 = (Card) queue1.dequeue();
               Card card7 = (Card) queue1.dequeue();
               String string7 = card7.getRankAsString() + " of " + card7.getSuitAsString();
               Card card14 = (Card) queue2.dequeue();
               Card card8 = (Card) queue2.dequeue();
               String string8 = card8.getRankAsString() + " of " + card8.getSuitAsString();
               if (card7.getRank() > card8.getRank())
                {
                  queue1.enqueue(card1); //add card from first flip
                  queue1.enqueue(card2); //add card from war flip 
                  queue1.enqueue(card3); //add card from double war flip
                  queue1.enqueue(card4); //add card from triple war flip
                  queue1.enqueue(card5); //add card from first flip
                  queue1.enqueue(card6); //add card from war flip
                  queue1.enqueue(card7); //add card from double war flip
                  queue1.enqueue(card8); //add card from triple war flip
                  queue1.enqueue(card13);
                  queue1.enqueue(card14);
                  return string7 + " is greater than " + string8 + "--You win!";
                }  
               if (card8.getRank() > card7.getRank())
                {
                  queue2.enqueue(card1); //add card from first flip
                  queue2.enqueue(card2); //add card from war flip 
                  queue2.enqueue(card3); //add card from double war flip
                  queue2.enqueue(card4); //add card from triple war flip
                  queue2.enqueue(card5); //add card from first flip
                  queue2.enqueue(card6); //add card from war flip
                  queue2.enqueue(card7); //add card from double war flip
                  queue2.enqueue(card8); //add card from triple war flip
                  queue2.enqueue(card13);
                  queue2.enqueue(card14);
                  return string8 + " is greater than " + string8 + "--CPU wins!";
                }  
               //quintuple war
               else
                  return "QUINTUPLE WAR! THIS IS CRAZY!" ;
                  
   }//end flipCard1   
   
   /*compareError method
   public String compareError()
   {
         if (!queue1.isEmpty())
            return "Computer is out of cards--you've won the war!";  
         else 
            return "You are out of cards--you have lost the war!"; 
   }//end compareError*/      
}//end class