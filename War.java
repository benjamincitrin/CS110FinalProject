/*
Benjamin Citrin
CS 110
Assignment #10
War
Game Class
*/

import javax.swing.*; //needed for Swing classes
import java.awt.*; 
import java.awt.event.*; //needed for ActionListener interface

public class War extends JFrame
{
   //declare object variables
   QueueReferenceBased queue1; 
   QueueReferenceBased queue2;
   Deck1 deck; 
   JButton flipButton;
   JPanel panel;
   JLabel label;
   
   //main method
   public static void main(String[] args) 
   {  
      War w = new War();
      w.windowMethod();    
      
        
   }//end main method
   
   
   public void nonMain()
   {
      try 
      {
      //deal cards
      deal();
 
      /*while (!queue1.isEmpty() && !queue2.isEmpty()) 
      { 
         
         //flip first card
         System.out.println(flipCard1());
  

      }//end while loop*/   
      
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
   
   Card card3; 
   Card card11;
   Card card13;         
   public String flipCard1()
   {
    do {
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
         
         card3 = (Card) queue1.dequeue();
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
            return "WAR: " + string1 + " vs. " + string2 + "\n" +
            "After war, " + string3 + " is greater than " + string4 + "--You win!";
          }
            
         if (card4.getRank() > card3.getRank())
          {
            queue2.enqueue(card1);
            queue2.enqueue(card2); //add card from first flip
            queue2.enqueue(card3);
            queue2.enqueue(card4); //add card from war flip 
            queue2.enqueue(card9);
            queue2.enqueue(card10);
            return "WAR: " + string1 + " vs. " + string2 + "\n" +
            "After war, " + string4 + " is greater than " + string3 + "--CPU wins!";
          }  
         //double war   
         else
            card11 = (Card) queue1.dequeue(); //facedown card
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
               return "DOUBLE WAR: " + string3 + " vs. " + string4 + "/n" +
               "After double war, " + string5 + " is greater than " + string6 + "--You win!";
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
               return "DOUBLE WAR: " + string3 + " vs. " + string4 + "/n" +
               "After double war, " + string6 + " is greater than " + string5 + "--CPU wins!";
             }  
            //triple war
            else
               card13 = (Card) queue1.dequeue();
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
                  return "TRIPLE WAR: " + string5 + " vs. " + string6 + "/n" + 
                  string7 + " is greater than " + string8 + "--You win!";
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
                  return "TRIPLE WAR: " + string5 + " vs. " + string6 + "/n" +
                  string8 + " is greater than " + string7 + "--CPU wins!";
                }  
               //quintuple war
               else
                  return "QUADRUPLE WAR! THIS IS CRAZY!" ;
           } while (!queue1.isEmpty() && !queue2.isEmpty());        
   }//end flipCard1   
   
   //GUI
   public void windowMethod()
   {
      try 
      {
      final int WINDOW_WIDTH = 450;  //window width in pixels
      final int WINDOW_HEIGHT = 250; //window height in pixels
      
      //create the window w/ label and size
      JFrame window = new JFrame("A Game of War");
      window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      //specify what happens when close button is clicked
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //build the panel and add it to the frame
      buildPanel();
      
      // add the panel to the frame's content pane
      window.add(panel);
      
      //display window
      window.setVisible(true);
      }
      catch(QueueException e)
      {}
   }   
   /** 
      The buildPanel method adds labels and a button to the panel
    */
   private void buildPanel()
   {
      //Create a label.
      label = new JLabel("Try your luck in war!");
      
      //Create a button with caption "Go to War!"  
      flipButton = new JButton("Flip!");
      
      ImageIcon back = new ImageIcon("cardpics//back.jpg");
      JLabel warCard = new JLabel(back);
    
      //Add an action listener to the button
      flipButton.addActionListener(new FlipButtonListener());
      //Create a JPanel object and let the panel field reference it
      panel = new JPanel();
      
      //Add the label and button components to the panel
      panel.add(label);
      panel.add(warCard);
      panel.add(flipButton);   
   }      
   
  /** 
   FlipButtonLIstener is an action listener class for flipButton.
  */
  
  private class FlipButtonListener implements ActionListener
  {
      /** 
         The actionPerformed method executes when the user clicks on the flip button.
         @param e The even object.
      */
   
      public void actionPerformed(ActionEvent e)
      {
         try{
         War w = new War();
         w.nonMain();
         String s = w.flipCard1();
         //display the flip
         JOptionPane.showMessageDialog(null, s);  
         }
         catch(QueueException f)
         {} 
      }
  }//end private class   
}//end class