package personagens;

import cartas.Deck;
import personagens.Person;

import java.util.Scanner;

public class Player extends Person {

    Scanner input = new Scanner(System.in);

    public Player() {
        super.setName("Jogador");

    }
    public void makeDecision(Deck deck, Deck discard) {

        int  decision = 0;
        boolean getNum = true;

        while(getNum){

            try{
                System.out.println("Voce quer proxima carta 1) ou 2) Parar");

                decision = input.nextInt();
                getNum = false;

            }
            catch(Exception e){
                System.out.println("Invalido");
                input.next();
            }
        }

        if (decision == 1) {
            this.hit(deck, discard);
            //return if they have blackjack or busted
            if(this.getHand().calculatedValue()>20){
                return;
            }
            else{
                this.makeDecision(deck, discard);
            }

        } else {
            System.out.println("Você parou.");
        }


    }


}