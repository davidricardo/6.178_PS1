package cards;

/**
 * Represents a card from a standard deck of cards.
 */
public class Card {

    enum Value{
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    
    
    enum Suit{
        HEARTS, DIAMONDS, CLUBS, SPADES
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
        // 1+ because ordinals start at 0 but ace is 1.
        return 1 + this.value.ordinal();
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
    
}
