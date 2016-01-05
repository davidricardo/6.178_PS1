package cards;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cards.Card.Suit;
import cards.Card.Value;

/**
 * Represents an ordered deck of cards that can be drawn from and added to.
 * This class is mutable.
 */
public class Deck {
    
    /*
     * Graders: there are many possible implementations of Deck, including 
     * an array, a list, or a queue. This implementation uses a List<Card>
     * because I think that's what most students will use.
     */
    
    private List<Card> cards;
    
    /**
     * Create a new Deck with 52 standard cards.
     * The cards must be in the following new deck order: ace, the numbered
     * cards in ascending order, jack, queen, and king for each of the four
     * suits in the order: spades,  diamonds, clubs, hearts.
     */
    public Deck(){
        throw new UnsupportedOperationException();
    }
    
    /**
     * Create a new Deck from a list of cards.
     * @param cards the cards to put in the deck. The first card in the list
     *     becomes the top card of the deck.
     */
    public Deck(List<Card> cards){
        throw new UnsupportedOperationException();
    }
    
    /* Graders: note that the behavior of this function when called on an empty
     * deck is unspecified.
     * Checkoff TAs: Ask students about what their implementation does when
     * called on an empty deck, and ask them why they chose that behavior.
     */
    /**
     * Draw the top card of the deck and remove it.
     * @return the top card.
     */
    public Card draw(){
        throw new UnsupportedOperationException();
    }

    // Testers: what is a better name for this function?
    /**
     * Modify this deck by putting another deck on top of it.
     * @param otherDeck what to put on top.
     */
    public void putOnTop(){
        throw new UnsupportedOperationException();
    }
    
    /**
     * Shuffles this deck into an unpredictable order.
     * This function must use actual randomness: taking two decks in the same order
     * and shuffling them both must (usually) result in different orders.
     */
    public void shuffle(){
        throw new UnsupportedOperationException();
        /* Collections.shuffle
         * Random.random
         * implement themselves
         */
    }
    
    /* Checkoff TAs: ask students what their implementation does when multiple
     * cards match the suit and value, or when none do. Ask them why they chose
     * that behavior.
     */
    /**
     * Get the position of a card with specified suit and value.
     * @param suit the suit to search for
     * @param value the value to search for 
     * @return how far a card with suit suit and value value is from the top of
     *      the deck. For example, returns 0 when only the top card matches.
     */
    public int search(Suit suit, Value value){
        throw new UnsupportedOperationException();
    }
    
    /**
     * Get the positions of all cards in the deck.
     * @return a map where each key is an integer from 0 to the number of cards
     *      in the deck - 1.  
     */
    public Map<Integer, Card> getPositions(){
        throw new UnsupportedOperationException();
    }
    
    /**
     * Draw until a card of the specified suit is drawn.
     * Always draws at least one card (unless the deck is empty).
     * @param suit the suit to stop drawing on.
     * @return a list of drawn cards. the first in the list is the first card
     *      drawn. The last card in the list is the only one whose suit is suit.
     */
    List<Card> drawUntil(Suit suit){
        throw new UnsupportedOperationException();
    }
    
    /**
     * Count how many cards have a certain value.
     * @param value the value to search for
     * @return the number of Cards in this Deck whose value is value.
     */
    int countCardsWithValue(Value value){
        throw new UnsupportedOperationException();
    }
    
    /**
     * Find the most common values in the deck.
     * @return all values such that no other value is more common than those.
     *      If there is one most common value, the returned set has one element.
     *      If two values are tied, the set includes both of those and no others.
     */
    Set<Value> mostCommonValues(){
        throw new UnsupportedOperationException();
    }
    
    /**
     * @return the highest value that has exactly two cards in the deck, or
     *      null if no value has exactly two cards in the deck. 
     */
    Value findHighestPair(){
        throw new UnsupportedOperationException();
    }
    
    
    

}
