package SupermarketPackage;

public class Schüppercard {
    int points;
    int cardnumber;

    public Schüppercard(int cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCardnumber() {
        return cardnumber;
    }

    public void increasePoints(float points) {
        this.points += points;
    }
}
