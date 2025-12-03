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
public class WarGame extends Game{
    private WarPlayer player1;
    private WarPlayer player2;
    private Deck mainDeck;

    public WarGame(String name, String player1, String player2) {
        super(name);
        this.player1 = new WarPlayer(player1);
        this.player2 = new WarPlayer(player2);
        this.mainDeck = new Deck();
        dealCards();
    }
    
    
    public void dealCards(){
        boolean toPlayer1 = true;
        while(!mainDeck.isEmpty()){
            Card c = mainDeck.drawCard();
            if(c == null) break;
            if(toPlayer1){
                player1.getPlayerDeck().addCard(c);
            }else{
                player2.getPlayerDeck().addCard(c);
            }
            toPlayer1 = !toPlayer1;
        }
    }
    
    
    public void playOneRound(){
        if(isGameOver()){
            System.out.println("No more cards.");
            return;
        }
        
        List<Card> field = new ArrayList<>();
        
        Card c1 = player1.drawCard();
        Card c2 = player2.drawCard();
        
        if (c1 == null || c2 == null){
          return;  
        }
        
        field.add(c1);
        field.add(c2);
        
        System.out.println(player1.getName()+" flips " + c1);
        System.out.println(player2.getName() + " flips " + c2);
        
        WarCard w1 = (WarCard) c1;
        WarCard w2 = (WarCard) c2;
        
        int result = compareLevel(w1, w2);
        
        if (result > 0){
            System.out.println(player1.getName() + " wins this round.");
        } else if (result < 0){
            System.out.println(player2.getName() + " wins this round.");
        } else{
            System.out.println("Start War");
            startWar(field);
        }
    }
    
    public boolean isGameOver(){
        return !player1.hasCards() || !player2.hasCards();
    }
        
    public int compareLevel(WarCard x, WarCard y){
        return Integer.compare(x.getValue().getPower(), y.getValue().getPower());
    }
        
        public void startWar(List<Card> field){
            if (!player1.hasCards() || !player2.hasCards()){
                return;
            }
            
            player1.putThreeCards(field);
            player2.putThreeCards(field);
            
            Card c1 = player1.drawCard();
            Card c2 = player2.drawCard();
            
            if (c1 == null || c2 == null){
                return;
            }
            
            field.add(c1);
            field.add(c2);
            
            System.out.println(player1.getName() + "war card: " + c1);
            System.out.println(player2.getName() + "war card: " + c2);
            
            WarCard w1 = (WarCard) c1;
            WarCard w2 = (WarCard) c2;
            
            int result = compareLevel(w1, w2);
            
            if(result > 0){
                System.out.println(player1.getName() + " wins the war");
                player1.Receive(field);
            }else if(result < 0){
                System.out.println(player2.getName() + " wins the war");
                player2.Receive(field);
            }else{
                System.out.println("It's tie. War again");
                startWar(field);
            }    
        }
        
        @Override
        public void play(){
            
            while (!isGameOver()){
                playOneRound();
            }
            
            declareWinner();
        }
        
        @Override
        public void declareWinner(){
            boolean p1Has = player1.hasCards();
            boolean p2Has = player2.hasCards();
            
            System.out.println();
            System.out.println("Game over");
            
            if (p1Has && p2Has){
                System.out.println("Winner is " + player1.getName());              
            }else if (!p1Has&& p2Has){
                System.out.println("Winner is " + player2.getName());
            }
        }
        
}


