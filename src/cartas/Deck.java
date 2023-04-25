package cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
    }

    public Deck(Deck c){
        Collections.copy(this.deck, c.getCards());
    }


    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            for(Suit suit : Suit.values()){
                for(Rank rank : Rank.values()){
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    public void addCard(Card card){
        deck.add(card);
    }

    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }


    public String toString(){
        StringBuilder output = new StringBuilder();

        for(Card card: deck){
            output.append(card);
            output.append("\n");
        }
        return output.toString();
    }


    public void shuffle(){
        Collections.shuffle(deck, new Random());
    }

    public Card takeCard(){

        Card cardToTake = new Card(deck.get(0));
        deck.remove(0);
        return cardToTake;

    }


    public boolean hasCards(){
        return deck.size() > 0;
    }

    public int cardsLeft(){
        return deck.size();
    }

    public ArrayList<Card> getCards() {
        return deck;
    }

    public void emptyDeck(){
        deck.clear();
    }



    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ficou sem cartas, criando um novo baralho a partir da pilha de descarte e embaralhando o baralho.");

    }


}