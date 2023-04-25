package personagens;

import cartas.Deck;
import cartas.Hand;

public abstract class Person {

    Hand hand;
    private String name;


    public Person(){
        this.hand = new Hand();
        this.name = "";
    }


    //Setters and Getters
    public Hand getHand(){
        return this.hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void printHand(){
        System.out.println(this.name + " sua mão esta assim:");
        System.out.println(this.hand + " Valor de: " + this.hand.calculatedValue());

    }

    public void hit(Deck deck, Deck discard){

        if (!deck.hasCards()) {
            deck.reloadDeckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " pega uma carta");

        this.printHand();
    }

    public boolean hasBlackjack(){
        return this.getHand().calculatedValue() == 21;
    }



}