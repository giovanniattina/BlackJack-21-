import personagens.Person;

public class Dealer extends Person {

    public Dealer(){
        super.setName("Dealer");

    }

    public void printFirstHand(){
        System.out.println("A mão do dealer está assim::");

        System.out.println(super.getHand().getCard(0));
        System.out.println("A segunda carta está para baixo");

    }



}