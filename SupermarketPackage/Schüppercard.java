package SupermarketPackage;

public class Schüppercard {
    int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void increasePoints(float points) {
        this.points += points;
    }
}
