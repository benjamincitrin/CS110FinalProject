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

public class Deal extends JFrame
{
   
   public Deal()
   {
      Deck1 deck = new Deck1();
      deck.dealCard();
   }   

   //main method
   public static void main(String[] args)
   {
    Deck1 deck2 = new Deck1();
   } 
}