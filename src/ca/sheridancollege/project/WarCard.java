/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author mtake
 */
public class WarCard extends Card {
    
    public enum Suit{
        HEARTS, DIAMONDS, CLUBS, SPEADS
    }
    
    public enum Value {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;
    }
    
    private Suit suit;
    private Value value;

    public WarCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    
    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toStrong(){
        return value + " of " + suit;
    }
    
    
}
