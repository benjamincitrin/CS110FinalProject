/*
Benjamin Citrin
CS 110
Assignment #10
War
GUI
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Graphics implements  ActionListener
{
    // Definition of global values and items that are part of the GUI.
    int playerScoreAmount = 0;
    int cpuScoreAmount = 0;

    JPanel titlePanel, scorePanel, buttonPanel;
    JLabel playerLabel, cpuLabel, playerScore, cpuScore;
    JButton warButton;

    public JPanel createContentPane (){

        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        // Creation of a Panel to contain the title labels
        titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setLocation(10, 0);
        titlePanel.setSize(250, 30);
        totalGUI.add(titlePanel);

        playerLabel = new JLabel("You");
        playerLabel.setLocation(0, 0);
        playerLabel.setSize(120, 30);
        playerLabel.setHorizontalAlignment(0);
        playerLabel.setForeground(Color.red);
        titlePanel.add(playerLabel);

        cpuLabel = new JLabel("Computer");
        cpuLabel.setLocation(130, 0);
        cpuLabel.setSize(120, 30);
        cpuLabel.setHorizontalAlignment(0);
        cpuLabel.setForeground(Color.blue);
        titlePanel.add(cpuLabel);

        // Creation of a Panel to contain the score labels.
        scorePanel = new JPanel();
        scorePanel.setLayout(null);
        scorePanel.setLocation(10, 40);
        scorePanel.setSize(260, 30);
        totalGUI.add(scorePanel);

        playerScore = new JLabel(""+playerScoreAmount);
        playerScore.setLocation(0, 0);
        playerScore.setSize(120, 30);
        playerScore.setHorizontalAlignment(0);
        scorePanel.add(playerScore);

        cpuScore = new JLabel(""+cpuScoreAmount);
        cpuScore.setLocation(130, 0);
        cpuScore.setSize(120, 30);
        cpuScore.setHorizontalAlignment(0);
        scorePanel.add(cpuScore);

        // Creation of a Panel to contain all the JButtons.
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(10, 80);
        buttonPanel.setSize(260, 70);
        totalGUI.add(buttonPanel);

        // We create a button and manipulate it using the syntax we have
        // used before. Now each button has an ActionListener which posts 
        // its action out when the button is pressed.
        warButton = new JButton("Go to war!");
        warButton.setLocation(0, 40);
        warButton.setSize(250, 30);
        warButton.addActionListener(this);
        buttonPanel.add(warButton);
        
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // This is the new ActionPerformed Method.
    // It catches any events with an ActionListener attached.
    // Using an if statement, we can determine which button was pressed
    // and change the appropriate values in our GUI.
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == warButton)
        {
            playerScoreAmount = playerScoreAmount + 1;
            playerScore.setText(""+playerScoreAmount);
        }
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("WAR");

        //Create and set up the content pane.
        Graphics demo = new Graphics();
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280, 190);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
} //end class