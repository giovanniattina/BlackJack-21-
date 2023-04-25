package cartas;

public enum Rank {
    AS("As", 11),
    DOIS("Dois", 2),
    TRES("Tres", 3),
    QUATRO("Quatro",4),
    CINCO("Cinco",5),
    SEIS("Seis",6),
    Sete("Sete",7),
    OITO("Oito",8),
    NOVE("Nove",9),
    DEZ("Dez",10),
    VALETE("VALETE",10),
    RAINHA("Rainha",10),
    REI("Rei",10);

    public String rankName;
    public int rankValue;

    Rank(String rankName, int rankValue){
        this.rankName = rankName;
        this.rankValue = rankValue;
    }

    public String toString(){
        return rankName;
    }
}