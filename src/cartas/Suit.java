package cartas;

public enum Suit {
    ESPADAS("Espadas"),
    OUROS("Ouros"),
    COPAS("Copas"),
    PAUS("Paus");

    String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    public String toString(){
        return suitName;
    }
}