package cards;

import java.util.Objects;

/**
 * Represents a card from a standard deck of cards.
 * This class is immutable.
 */
public class Card {

    /* Checkoff TAs: be sure to ask students if the order of these constants matters.
     * For Suit it doesn't matter, but for Value it might (see below).
     */
    enum Suit{
        HEARTS, DIAMONDS, CLUBS, SPADES
    }
    
    /* Graders: note that if a student uses ordinal() in their implementation of
     * getNumber or values() in the int constructor, as this implementation does,
     * they must have declared the constants in Value in this order.
     */
    enum Value{
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    
    private final Suit suit;
    private final Value value;
    
    /**
     * Create a new Card.
     * @param value the value of the new card
     * @param suit the suit of the new card
     */
    public Card(Value value, Suit suit){
        this.value = value;
        this.suit = suit;
    }
   
    /**
     * Create a new Card.
     * @param number from 1 (ace) to 13 (king). Throws IllegalArgumentException
     *     if number < 1 or number > 13.
     * @param suit the suit of the new card
     */
    public Card(int number, Suit suit){
        if (number < 1 || number > 13){
            throw new IllegalArgumentException("Called Card(int, Suit)"
                    + " constructor with an illegal number.");
        }
        this.value = Value.values()[number - 1];
        this.suit = suit;
    }
    
    /**
     * @return the suit of this Card.
     */
    public Suit getSuit(){
        return suit;
    }
    
    /**
     * @return the value of this Card.
     */
    public Value getValue(){
        return value;
    }
    
    /**
     * @return the number of this Card, from 1 to 13.
     */
    public int getNumber(){
        // 1+ because ordinals start at 0 but the number of an ace is 1.
        return 1 + this.value.ordinal();
        
        /* An alternate solution declares each enum constant in Value
         * with an number from 1 to 13, then gets the number from this.value.
         * That solution is clunkier because ordinal() is available, but they
         * shouldn't lose points for doing it that way. 
         */
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
        return this.getNumber() - otherCard.getNumber();
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
        return Objects.hash(suit, value);
    }
    
}
