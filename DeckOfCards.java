/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckofcards;

/**
 *
 * @author hkadagala2024
 */
import java.util.*;

public class DeckOfCards {
    public static void main(String[] args) {
        // Initialize the deck as a 2D String array with 4 suits, each containing 13 cards
        String[][] deckOfCards = new String[4][13];
        // Define the suits
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        // Define the card values
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // Populate the deck with cards, combining suits and values
        for (int i = 0; i < deckOfCards.length; i++) {
            for (int j = 0; j < deckOfCards[i].length; j++) {
                deckOfCards[i][j] = values[j] + " of " + suits[i];
            }
        }

        // Shuffle the deck to ensure randomness
        shuffleDeck(deckOfCards);

        // Deal 4 hands of 5 cards each from the shuffled deck
        String[][] hands = dealHands(deckOfCards, 4, 5);

        // Print out each hand to show the dealt cards
        for (int i = 0; i < hands.length; i++) {
            System.out.println("Hand " + (char)('A' + i) + ": " + Arrays.toString(hands[i]));
        }
    }

    // Method to shuffle the deck of cards
    public static void shuffleDeck(String[][] deck) {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            for (int j = 0; j < deck[i].length; j++) {
                // Select a random card to swap with
                int i1 = rand.nextInt(deck.length);
                int j1 = rand.nextInt(deck[i].length);

                // Swap the current card with the randomly selected card
                String temp = deck[i][j];
                deck[i][j] = deck[i1][j1];
                deck[i1][j1] = temp;
            }
        }
    }

    // Method to deal the specified number of hands with a specified number of cards per hand
    public static String[][] dealHands(String[][] deck, int numHands, int cardsPerHand) {
        // Initialize the array to hold the dealt hands
        String[][] hands = new String[numHands][cardsPerHand];
        // Counter to keep track of the number of cards dealt
        int cardCount = 0;

        // Loop through each hand and each card slot to deal cards
        for (int i = 0; i < numHands; i++) {
            for (int j = 0; j < cardsPerHand; j++) {
                // Deal the card from the deck and increment the card counter
                hands[i][j] = deck[cardCount / 13][cardCount % 13];
                cardCount++;
            }
        }

        // Return the array containing the dealt hands
        return hands;
    }
}
