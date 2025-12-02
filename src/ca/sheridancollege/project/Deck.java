/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Masaki Takenaka
 */
public class Deck extends GroupOfCards{
    
    public Deck(){
        super(52);
        for(WarCard.Suit suit : WarCard.Suit.values()){
            for(WarCard.Value value : WarCard.Value.values()){
                addCard(new WarCard(suit, value));
            }
        }
        shuffle();       
    }
    
    public Card drawCard(){
        return removeCard();
    }
}
