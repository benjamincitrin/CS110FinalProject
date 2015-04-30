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

public class War extends Deal
{
   //declare object variables
   QueueReferenceBased queue1; 
   QueueReferenceBased queue2;
   Deck1 deck; 
   JButton flipButton;
   JPanel panel;
   JLabel label;
   String playerCardURL;
   String cpuCardURL;
   String warCardURL;
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
      deal1();
 
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
   public void deal1() 
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
         cardPicsPlayer(card1);
         cardPicsCPU(card2); 
         return string1 + " is greater than " + string2 + "--You win!";
       }
      //if CPU card is greater  
      if (card2.getRank() > card1.getRank())
       {  
         queue2.enqueue(card1); //add player card to CPU pile
         queue2.enqueue(card2);
         cardPicsPlayer(card1);
         cardPicsCPU(card2); 
         return string1 + " does not beat " + string2 + "--CPU wins!";
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
            cardPicsPlayer(card1);
            cardPicsCPU(card2);
            cardPicsPlayer(card3);
            cardPicsCPU(card4);  
            cardPicsWar(card9);
            cardPicsWar(card10);
            //cardPics(card2, card1); 
            //cardPics2(card3, card4); 
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
            cardPicsPlayer(card1);
            cardPicsCPU(card2); 
            cardPicsPlayer(card3);
            cardPicsCPU(card4); 
            cardPicsWar(card9);
            cardPicsWar(card10);
            //cardPics(card2, card1); 
            //cardPics2(card4, card3); 
            return "WAR: " + string1 + " vs. " + string2 + "\n" +
            "After war, " + string3 + " does not beat " + string4 + "--CPU wins!";
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
               queue1.enqueue(card9);
               queue1.enqueue(card10);
               queue1.enqueue(card11);
               queue1.enqueue(card12);
               cardPicsPlayer(card3);
               cardPicsCPU(card4); 
               cardPicsPlayer(card5);
               cardPicsCPU(card6);
               cardPicsWar(card9);
               cardPicsWar(card10); 
               cardPicsWar(card11);
               cardPicsWar(card12);
               //cardPics(card3, card4); 
               //cardPics2(card5, card6); 
               return "DOUBLE WAR: " + string3 + " vs. " + string4 + "\n" +
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
               queue2.enqueue(card9);
               queue2.enqueue(card10);
               queue2.enqueue(card11);
               queue2.enqueue(card12);
               cardPicsPlayer(card3);
               cardPicsCPU(card4); 
               cardPicsPlayer(card5);
               cardPicsCPU(card6);
               cardPicsWar(card9);
               cardPicsWar(card10); 
               cardPicsWar(card11);
               cardPicsWar(card12);
               //cardPics(card3, card4); 
               //cardPics2(card6, card5); 
               return "DOUBLE WAR: " + string3 + " vs. " + string4 + "\n" +
               "After double war, " + string5 + " does not beat " + string6 + "--CPU wins!";
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
                  queue1.enqueue(card9);
                  queue1.enqueue(card10);
                  queue1.enqueue(card11);
                  queue1.enqueue(card12);
                  queue1.enqueue(card13);
                  queue1.enqueue(card14);
                  cardPicsPlayer(card5);
                  cardPicsCPU(card6); 
                  cardPicsPlayer(card7);
                  cardPicsCPU(card8);
                  cardPicsWar(card9);
                  cardPicsWar(card10); 
                  cardPicsWar(card11);
                  cardPicsWar(card12);
                  cardPicsWar(card13);
                  cardPicsWar(card14);
                  //cardPics(card5, card6);
                  //cardPics2(card7, card8);  
                  return "TRIPLE WAR: " + string5 + " vs. " + string6 + "\n" + 
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
                  queue2.enqueue(card9);
                  queue2.enqueue(card10);
                  queue2.enqueue(card11);
                  queue2.enqueue(card12);
                  queue2.enqueue(card13);
                  queue2.enqueue(card14);
                  cardPicsPlayer(card5);
                  cardPicsCPU(card6); 
                  cardPicsPlayer(card7);
                  cardPicsCPU(card8);
                  cardPicsWar(card9);
                  cardPicsWar(card10);
                  cardPicsWar(card11);
                  cardPicsWar(card12);
                  cardPicsWar(card13);
                  cardPicsWar(card14);
                  //cardPics(card5, card6); 
                  //cardPics2(card8, card7); 
                  return "TRIPLE WAR: " + string5 + " vs. " + string6 + "\n" +
                  string7 + " does not beat " + string8 + "--CPU wins!";
                }  
               //quintuple war
               else
                  return "QUADRUPLE WAR! THIS IS CRAZY!";
           } while (!queue1.isEmpty() && !queue2.isEmpty());        
   }//end flipCard1   
   
   //method to get player card image url
   public void cardPicsPlayer(Card playerCard) 
   {
      String playerURL = playerCard.getRankAsString() + playerCard.getSuitAsString().charAt(0) ;
      setCardPicsPlayer(playerURL);
      //return playerURL;
   }   
   
   public void setCardPicsPlayer(String a)
   {
      //System.out.print(a);
      playerCardURL = a;
   }
      
   public String getCardPicsPlayer()
   {
      return playerCardURL;
   }
   
   public void setCardPicsCPU(String a)
   {
      cpuCardURL = a;
   }
      
   public String getCardPicsCPU()
   {
      return cpuCardURL;
   }
      
   //method to get cpu card image url
   public void cardPicsCPU(Card cpuCard)
   {
      String cpuURL = cpuCard.getRankAsString() + cpuCard.getSuitAsString().charAt(0);
      setCardPicsCPU(cpuURL);
      
   }   
   
   public String cardPicsWar(Card cardBack)
   {
      return "back";
   }   
   
   public void setWarCardURL(String a)
   {
      warCardURL = a;
   }   
      
   public String getWarCardURL()
   {
      return warCardURL;
   }
      
   //GUI
   public void windowMethod()
   {
      try 
      {
      final int WINDOW_WIDTH = 450;  //window width in pixels
      final int WINDOW_HEIGHT = 68; //window height in pixels
      
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
      
      ImageIcon icon1 = new ImageIcon("cardpics//" + getCardPicsPlayer()+ ".jpg");
      JLabel pCard = new JLabel(icon1);
    
      //Add an action listener to the button
      flipButton.addActionListener(new FlipButtonListener());
      //Create a JPanel object and let the panel field reference it
      panel = new JPanel();
      //panel.setLayout(new GridLayout());
      
      //Add the label and button components to the panel
      panel.add(label/*, GridLayout*/);
      panel.add(pCard);
      panel.add(flipButton/*, GridLayout*/);   
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
         String p = w.getCardPicsPlayer();
         String c = w.getCardPicsCPU();
         //System.out.println(w.flipCard1());
         //display the flip
         ImageIcon iconPlayer = new ImageIcon("cardpics//" + p + ".jpg"); 
         ImageIcon iconCPU = new ImageIcon("cardpics//" + c + ".jpg");
         JOptionPane.showMessageDialog(null, new JLabel(s, iconCPU, JLabel.LEFT),
                                       "War", JOptionPane.INFORMATION_MESSAGE,iconPlayer);                              
         }
         catch(QueueException f)
         {} 
      }
  }//end private class   
}//end class