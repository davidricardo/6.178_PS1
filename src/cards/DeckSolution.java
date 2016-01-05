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
public class DeckSolution {
    
    /*
     * Graders: there are many possible implementations of Deck, including 
     * an array, a list, or a queue. This solution is not the most concise or
     * fast implementation, but it's how I think most students will do it.
     * They should, of course, not lose points for writing a faster or neater
     * implementation than expected.
     */
    
    private List<CardSolution> cards;
    
    /**
     * Create a new Deck with 52 standard cards.
     * The cards must be in the following new deck order: ace, the numbered
     * cards in ascending order, jack, queen, and king for each of the four
     * suits in the order: spades,  diamonds, clubs, hearts. The ace of spades
     * is at the top of the deck, and is the first card drawn.
     */
    public DeckSolution(){
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()){
            for (Value value : Value.values()){
                cards.add(new CardSolution(value, suit));
            }
        }
    }
    
    /**
     * Create a new Deck from a list of cards.
     * @param cards the cards to put in the deck. The first card in the list
     *     becomes the top card of the deck.
     */
    public DeckSolution(List<CardSolution> cards){
        this.cards = new ArrayList<>();
        this.cards.addAll(cards);
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
    public CardSolution draw(){
        if (cards.size() > 0){
            CardSolution cardToReturn = cards.get(0);
            cards = cards.subList(1, cards.size());
            return cardToReturn;
        } else {
            return null;
        }
    }

    /* Testers: what is a better name for this function?
     * Checkoff TAs: Ask the students about rep exposure. What if a client puts
     * another deck on top and then changes it? Does this one change? Should it?
     */
    /**
     * Modify this deck by putting another deck on top of it.
     * @param otherDeck what to put on top.
     */
    public void putOnTop(DeckSolution otherDeck){
        List<CardSolution> newCards = new ArrayList<>(otherDeck.cards);
        newCards.addAll(cards);
        this.cards = newCards;
    }
    
    /**
     * Shuffles this deck into an unpredictable order.
     * This function must use actual randomness: taking two decks in the same order
     * and shuffling them both must (usually) result in different orders.
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }
    
    /**
     * Convert this Deck into a string.
     * @return the "[" character, the string representations of all cards in
     *      the deck from top to bottom, and then the "]" character.
     */
    @Override
    public String toString(){
        String stringToReturn = "[";
        for (CardSolution card : cards){
            stringToReturn += card.toString();
        }
        stringToReturn += "]";
        return stringToReturn;
    }
    
    /* Checkoff TAs: ask students what their implementation does when multiple
     * cards match the suit and value, or when none do. Ask them why they chose
     * that behavior. Make sure they realize that they cannot return null if no
     * result was found because primitive types cannot be null.
     */
    /**
     * Get the position of a card with specified suit and value.
     * @param targetSuit the suit to search for
     * @param targetValue the value to search for 
     * @return how far a card with suit suit and value value is from the top of
     *      the deck. For example, returns 0 when only the top card matches.
     */
    public int search(Suit targetSuit, Value targetValue){
        for (int i = 0; i < cards.size(); i++){
            CardSolution currentCard = cards.get(i);
            if (currentCard.getSuit() == targetSuit &&
                    currentCard.getValue() == targetValue){
                return i;
            }
        }
        
        // Alternate solution:
        for (CardSolution card : cards){
            if (card.getSuit() == targetSuit && card.getValue() == targetValue){
                return cards.indexOf(card);
            }
        }
        
        return -1;
    }
    
    /**
     * Get the positions of all cards in the deck.
     * @return a map where each key is an integer from 0 to the number of cards
     *      in the deck - 1.  
     */
    public Map<Integer, CardSolution> getPositions(){
        Map<Integer, CardSolution> mapToReturn = new HashMap<>();
        for (int i = 0; i < cards.size(); i++){
            mapToReturn.put(i, cards.get(i));
        }
        return mapToReturn;
    }

    
    /* Testers: what should we do with this comment and the functions below it? 
     * I included this comment to explain why the following functions were 
     * package-private instead of public. I worried that the p-set would be too
     * easy and too boring without more challenging exercises. Also, these
     * functions are the only places where the students use Map and Set.
     */
    
    /* The above functions are important to making Deck function, and may be
     * used in future p-sets. The following functions are exercises to test 
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
        List<CardSolution> drawnCards = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++){
            /* Checkoff TAs: make sure students understand why it should be
             * cards.get(0) here, not cards.get (i). It's because we're removing
             * from the front of the list as we go. I'm sure this problem will
             * teach our students all about ConcurrentModificationException.
             */
            if (cards.get(0).getSuit() != targetSuit){
                drawnCards.add(draw());
            } else {
                break;
            }
        }
        return drawnCards;
    }
    
    /**
     * Find the most common values in the deck.
     * @return all values such that no other value is more common than those.
     *      If there is one most common value, the returned set has one element.
     *      If two values are tied, the set includes both of those and no others.
     */
    Set<Value> mostCommonValues(){
        Map<Value, Integer> valueFrequency = new HashMap<>();
        for (Value value : Value.values()){
            valueFrequency.put(value, 0);
        }
        
        for (CardSolution card : cards) {
            valueFrequency.put(card.getValue(), 
                    valueFrequency.get(card.getValue()) + 1);
        }
        
        Set<Value> valuesToReturn = new HashSet<>();
        int currentHighestFrequency = 0;
        for (Value currentValue : Value.values()){
            if (valueFrequency.get(currentValue) > currentHighestFrequency){
                valuesToReturn = new HashSet<>();
            }
            if (valueFrequency.get(currentValue) >= currentHighestFrequency){
                valuesToReturn.add(currentValue);
            }
        }
        
        return valuesToReturn;
        
    }
    
    // Is this spec clear enough?
    /**
     * @return the highest value that has exactly two cards in this deck, or
     *      null if there is no such value.
     */
    Value findHighestPair(){
        for (int i = 13; i > 0; i--){
            Value currentValue = Value.values()[i];
            
            int cardsInDeckWithCurrentValue = 0;
            for (CardSolution card : cards){
                if (card.getValue() == currentValue){
                    cardsInDeckWithCurrentValue += 1;
                }
            }
            
            if (cardsInDeckWithCurrentValue == 2){
                return currentValue;
            }
        }
        
        return null;
    }
}
