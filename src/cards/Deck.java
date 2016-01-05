package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cards.CardSolution.Suit;
import cards.CardSolution.Value;

/**
 * Represents an ordered deck of cards that can be drawn from and added to.
 * This class is mutable.
 */
public class Deck {
    
    
    /**
     * Create a new Deck with 52 standard cards.
     * The cards must be in the following new deck order: ace, the numbered
     * cards in ascending order, jack, queen, and king for each of the four
     * suits in the order: spades,  diamonds, clubs, hearts. The ace of spades
     * is at the top of the deck, and is the first card drawn.
     */
    public Deck(){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /**
     * Create a new Deck from a list of cards.
     * @param cards the cards to put in the deck. The first card in the list
     *     becomes the top card of the deck.
     */
    public Deck(List<CardSolution> cards){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /**
     * Draw the top card of the deck and remove it.
     * @return the top card.
     */
    public CardSolution draw(){
        throw new UnsupportedOperationException(); // Your code here
    }

    // Testers: what is a better name for this function?
    /**
     * Modify this deck by putting another deck on top of it.
     * @param otherDeck what to put on top.
     */
    public void putOnTop(Deck otherDeck){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /**
     * Shuffles this deck into an unpredictable order.
     * This function must use actual randomness: taking two decks in the same order
     * and shuffling them both must (usually) result in different orders.
     */
    public void shuffle(){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /**
     * Convert this Deck into a string.
     * @return the "[" character, the string representations of all cards in
     *      the deck from top to bottom, and then the "]" character.
     */
    @Override
    public String toString(){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /**
     * Get the position of a card with specified suit and value.
     * @param targetSuit the suit to search for
     * @param targetValue the value to search for 
     * @return how far a card with suit suit and value value is from the top of
     *      the deck. For example, returns 0 when only the top card matches.
     */
    public int search(Suit targetSuit, Value targetValue){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /**
     * Get the positions of all cards in the deck.
     * @return a map where each key is an integer from 0 to the number of cards
     *      in the deck - 1.  
     */
    public Map<Integer, CardSolution> getPositions(){
        throw new UnsupportedOperationException(); // Your code here
    }

    
    /* Testers: what should we do with this comment and the functions below it? 
     * I included this comment to explain why the following functions were 
     * package-private instead of public. I worried that the p-set would be too
     * easy and too boring without more challenging exercises. Also, these
     * functions are the only places where the students use Map and Set.
     */
    /* The above functions are important to the functionality of Deck, and will
     * be used in future p-sets. The following functions are exercises to test
     * your understanding.
     */
    
    /**
     * Draw until a card of the specified suit is drawn.
     * Always draws at least one card (unless the deck is empty).
     * @param targetSuit the suit to stop drawing on.
     * @return a list of drawn cards. the first in the list is the first card
     *      drawn. The last card in the list is the only one whose suit is suit.
     */
    List<CardSolution> drawUntil(Suit targetSuit){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /**
     * Find the most common values in the deck.
     * @return all values such that no other value is more common than those.
     *      If there is one most common value, the returned set has one element.
     *      If two values are tied, the set includes both of those and no others.
     */
    Set<Value> mostCommonValues(){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    // Is this spec clear enough?
    /**
     * @return the highest value that has exactly two cards in this deck, or
     *      null if there is no such value.
     */
    Value findHighestPair(){
        throw new UnsupportedOperationException(); // Your code here
    }
}
