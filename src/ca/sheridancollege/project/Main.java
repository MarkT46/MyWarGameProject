/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;
/**
 *
 * @author Maasaki Takenaka Dec 2025
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player1's name:" );
        String p1Name = sc.nextLine();
        
        System.out.println("Enter Player2's name:");
        String p2Name = sc.nextLine();
        
        WarGame game = new WarGame("War Game", p1Name, p2Name);
        
        while(true){
            
            if (game.isGameOver()){
                game.declareWinner();
                break;
            }
            
            System.out.print("f = flip cards / q = quit game: ");
            String userChoice = sc.nextLine();
            
            if (userChoice.equals("f")){
                game.playOneRound();
                System.out.println("");
            }else if (userChoice.equals("q")){
                System.out.println("Game is quitted");
                break;
            }else{
                System.out.println("Invalid command");
            }
        }
        sc.close();
    }
}
