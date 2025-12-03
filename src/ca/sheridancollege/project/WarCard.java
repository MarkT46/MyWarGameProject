/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Masaki Takenaka Dec 2025
 */
public class WarCard extends Card {
    
    public enum Suit{
        HEARTS, DIAMONDS, CLUBS, SPADES
    }
    
    public enum Value {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);
        
        private int power;
        Value(int power){
            this.power = power;
        }
        
        public int getPower(){
            return power;
        }
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
    public String toString(){
        return value + " of " + suit;
    }
    
    
}
