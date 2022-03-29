//Fix comments
//Fix Variable Names
//Fix Logic

package com.LoafBurger;

import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {

    private static JLabel topDesign;    //This is for the top pattern of my GUI
    private static JLabel totalPulledOutCardsLabel; //This is for the pull out cards label
    private static JLabel totalCardsCreatedLabel;  //This is for the total cards created label
    private static JLabel totalDecksLabel;  // This is for the total decks created label
    private static JLabel bototomDesign; //This is for the bottom pattern of my GUI
    private static JFrame frame;    //frame

    private static int totalPulledOutCards = 0; //These are all global variables which are used to update the values in the GUI
    private static int totalCardsCreated = 0;   //^
    private static int totalDecksCreated = 0;   //^

    private static int drawCardNumber;  //This is a holder for the value of number of cards being drawn that is ultimately decided from the Scanner
    private static boolean repeatElement;   //This was used for debugging but I am just going to leave this here for now


    public static void main(String[] args) throws IllegalArgumentException, InterruptedException {  //Im throwing exceptions here in order to enhance the user experience and not scare the user if there is ever an error



//Everything below is used for the GUI, in order to randomly generate card patterns for the GUI
        Deck deck1 = new Deck();
        deck1.shuffle();
        deck1.toString();
        Deck deck2 = new Deck();
        deck2.shuffle();
        deck2.toString();





        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

//Everything under this serve as elements for the GUI
        frame = new JFrame();
        frame.setForeground(Color.RED);
        frame.setBackground(Color.BLACK);
        frame.setTitle("Deck of Cards Simulator"); //title to the frame
        frame.setSize(500, 190);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);


        panel.setLayout(null);  //don't worry about the layout just yet, but doing this just give an empty layout

        Border border = BorderFactory.createLineBorder(Color.RED);

        topDesign = new JLabel(" "); //User label
        topDesign.setBounds(10, 10, 1000, 25);  //Padding to look nice
        topDesign.setForeground(Color.WHITE);
        panel.add(topDesign);   //Notice how we add this elements to the panel
        topDesign.setText(String.valueOf(deck1));


        totalPulledOutCardsLabel = new JLabel("Total Pulled Out Cards: "); //User label
        totalPulledOutCardsLabel.setBounds(150, 40, 200, 25);  //Padding to look nice
        totalPulledOutCardsLabel.setForeground(Color.WHITE);
        totalPulledOutCardsLabel.setBorder(border);
        panel.add(totalPulledOutCardsLabel);   //Notice how we add this elements to the panel



        totalCardsCreatedLabel = new JLabel("Total Cards Created: ");
        totalCardsCreatedLabel.setBounds(150, 70, 200, 25);
        totalCardsCreatedLabel.setForeground(Color.WHITE);
        totalCardsCreatedLabel.setBorder(border);
        panel.add(totalCardsCreatedLabel);

        totalDecksLabel = new JLabel("Total Decks Created: ");
        totalDecksLabel.setBounds(150, 100, 200, 25);
        totalDecksLabel.setForeground(Color.WHITE);
        totalDecksLabel.setBorder(border);
        panel.add(totalDecksLabel);

        bototomDesign = new JLabel(" "); //User label
        bototomDesign.setBounds(10, 130, 1000, 25);  //Padding to look nice
        bototomDesign.setForeground(Color.WHITE);
        panel.add(bototomDesign);   //Notice how we add this elements to the panel
        bototomDesign.setText(String.valueOf(deck2));



        //This always has to be set at the end so people can see everything
        frame.setVisible(true);






        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Deck of Cards simulator!");

        boolean repeatElementConnection = repeatElement;

        while(repeatElementConnection = true) {

            Deck deck = new Deck();
            totalDecksCreated += 1;
            totalCardsCreated += 52;
            System.out.printf("Deck: %s\n", deck);

            System.out.println(" ");

            System.out.println("How many cards would you like to draw? Pick a number between 0 and 52");
            int drawCardNumberQuestion = scanner.nextInt();

            drawCardNumber = drawCardNumberQuestion;
            totalPulledOutCards += drawCardNumberQuestion;

            if (drawCardNumber < 0 || drawCardNumber > 52) {
                throw new IllegalArgumentException("Number has to be between 0 and 52");
            }


            System.out.print("Pulled out " + drawCardNumber + " cards: ");
            for (Card card : deck.draw(drawCardNumber)) {
                System.out.printf("%s ", card);
            }
            System.out.println();
            System.out.printf("Adjusted Size: %d\n\n", deck.size());

            // check shuffle
            deck.shuffle();
            System.out.printf("Shuffled: %s\n\n", deck);

            // check sort
            deck.bubbleSort();
            System.out.printf("Sort: %s\n", deck);

            System.out.println("Would you like to run another Deck of Cards Simulator?");

            Scanner scanner2 = new Scanner(System.in);
            String repeatElementQuestion = scanner2.nextLine();

            if(repeatElementQuestion.equalsIgnoreCase("Nah")){
                totalPulledOutCardsLabel.setText("Total Pulled Out Cards: " + totalPulledOutCards);
                totalCardsCreatedLabel.setText("Total Cards Created: " + totalCardsCreated);
                totalDecksLabel.setText("Total Decks Created: " + totalDecksCreated);
                System.out.println("Thank you for using the Deck of Cards simulator!");
                Thread.sleep(5000);
                System.exit(1);
            } else if(repeatElementQuestion.equalsIgnoreCase("Yea")) {
                totalPulledOutCardsLabel.setText("Total Pulled Out Cards: " + totalPulledOutCards);
                totalCardsCreatedLabel.setText("Total Cards Created: " + totalCardsCreated);
                totalDecksLabel.setText("Total Decks Created: " + totalDecksCreated);
            } else throw new IllegalArgumentException("Answer has to be in String form");
        }
    }
}