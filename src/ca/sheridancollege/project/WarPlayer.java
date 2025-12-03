/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Masaki Takenaka Dec 2025
 */
public class WarPlayer extends Player{
    
    private GroupOfCards playerDeck;
    private GroupOfCards myDiscardPile;
    
    public WarPlayer(String name){
        super(name);
        this.playerDeck = new GroupOfCards(52);
        this.myDiscardPile = new GroupOfCards(52);
    }

    public GroupOfCards getPlayerDeck() {
        return playerDeck;
    }

    public GroupOfCards getMyDiscardPile() {
        return myDiscardPile;
    }
    
    public boolean hasCards(){
        return !playerDeck.isEmpty() || !myDiscardPile.isEmpty();
    }
    
    public Card drawCard(){
        checkRefillNeeded();
        return playerDeck.removeCard();
    }
    
    public void checkRefillNeeded() {
        if(playerDeck.isEmpty() && !myDiscardPile.isEmpty()) {
            playerDeck.addAll(new ArrayList<>(myDiscardPile.getCards()));
            myDiscardPile.getCards().clear();
            playerDeck.shuffle();
        }
    }
    
    public void putThreeCards(List<Card> field){
        for (int i = 0; i < 3; i++){
            Card c = drawCard();
            if (c == null){
                break;
            }
            field.add(c);
        }
    }
    
    public void Receive(List<Card> field){
        myDiscardPile.addAll(field);
        field.clear();
    }
    
    @Override
    public void play(){
        
    }
    
}
