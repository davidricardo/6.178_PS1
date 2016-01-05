package cards;

import java.util.Objects;

/**
 * Represents a card from a standard deck of cards. Immutable.
 * Cards have values, which are the numbers from 2 to 10 (inclusive)
 * and ace, jack, queen, and king. Cards have a number, which can be used
 * instead of the value. For 2 through 10, the number is the same as the value.
 * The number of a jack is 11, queen is 12, king is 13, and ace is 1.
 * Card numbers will be used in future p-sets.
 */
public class Card {

    enum Suit {
        SPADES, DIAMONDS, CLUBS, HEARTS
    }
    
    enum Value{
        // Fill in this enumeration with the thirteen card values.
    }
    
    /**
     * Create a new Card.
     * @param value the value of the new card
     * @param suit the suit of the new card
     */
    public Card(Value value, Suit suit){
        throw new UnsupportedOperationException(); // Your code here
    }
   
    /**
     * Create a new Card.
     * @param number from 1 (ace) to 13 (king). Throws IllegalArgumentException
     *     if number < 1 or number > 13.
     * @param suit the suit of the new card
     */
    public Card(int number, Suit suit){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /** @return the suit of this Card. */
    public Suit getSuit(){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /** @return the value of this Card. */
    public Value getValue(){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /**
     * @return the number of this Card, from 1 (ace) to 13 (king).
     */
    public int getNumber(){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /**
     * The difference in value between this card and another.
     * Returns a negative number, zero, or a positive number if this Card has
     * a lower value, the same value, or a higher value than otherCard.
     * For example, if this card is a jack, calling this.valueDifference on 
     * an eight returns 3.
     * @param otherCard card to compare to.
     */
    public int valueDifference(Card otherCard){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /**
     * Express this Card as a String.
     * @return a string consisting of the value of this card if it is a
     *      numbered card or A, J, Q, or K for ace, jack, queen, or king
     *      respectively followed by a lowercase s, d, c, or h if the suit
     *      is spades, diamonds, clubs or hearts respectively.
     *      For example, the ace of spades is "As", two of clubs is "2c",
     *      jack of hearts is "Jh", and the 10 of diamonds is "10d".
     */
    @Override 
    public String toString(){
        throw new UnsupportedOperationException(); // Your code here
    }
    
    /* Students: don't worry about the two functions below.
     * They are provided by staff and necessary so that collections of cards,
     * like Set<Card> or Map<Card, whatever> work correctly.
     * The purpose and implementation of these functions is beyond the scope
     * of 6.178 and is covered in 6.005.
     */
    @Override
    public boolean equals(Object other){
        if (other instanceof Card){
            Card otherCard = (Card) other;
            return otherCard.getSuit() == this.getSuit() &&
                    otherCard.getValue() == this.getValue();
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return 0;
    }
    
}
