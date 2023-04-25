import cartas.Deck;
import personagens.Player;

public class Game {

    private Deck deck, discarded;

     Dealer dealer;
     Player player;
    private int wins, losses, pushes;


    public Game(){

        deck = new Deck(true);
        discarded = new Deck();

        dealer = new Dealer();
        player = new Player();


        deck.shuffle();
        startRound();
    }



    private void startRound(){

        if(wins>0 || losses>0 || pushes > 0){
            System.out.println();
            System.out.println("Começando a próxima rodada... Vitórias:" + wins + " Perdiads: "+ losses+ " Pushes: "+pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        //Check to make sure the deck has at least 4 cards left
        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscard(discarded);
        }

        //Give the dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        //Give the player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);


        dealer.printFirstHand();

        //Show the player's hand
        player.printHand();

        //Check if dealer has BlackJack to start
        if(dealer.hasBlackjack()){
            //Show the dealer has BlackJack
            dealer.printHand();

            if(player.hasBlackjack()){
                //End the round with a push
                System.out.println("Vocês dois têm 21 - Push.");
                pushes++;
                startRound();
            }
            else{
                System.out.println("O dealer tem BlackJack. Você perdeu.");
                dealer.printHand();
                losses++;
                startRound();
            }
        }

        if(player.hasBlackjack()){
            System.out.println("Você tem Blackjack! Você ganha!");
            wins++;
            startRound();
        }

        player.makeDecision(deck, discarded);

        //Check if they busted
        if(player.getHand().calculatedValue() > 21){
            System.out.println("Voce passou do 21.");
            losses ++;
            startRound();
        }

        dealer.printHand();
        while(dealer.getHand().calculatedValue()<17){
            dealer.hit(deck, discarded);
        }

        //Check who wins
        if(dealer.getHand().calculatedValue()>21){
            System.out.println("Dealer foi a falencia");
            wins++;
        }
        else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
            System.out.println("Voce perdeu.");
            losses++;
        }
        else if(player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
            System.out.println("Voce ganhou.");
            wins++;
        }
        else{
            System.out.println("Push.");
        }

        startRound();
    }

}
