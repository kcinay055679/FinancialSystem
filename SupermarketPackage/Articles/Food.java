package SupermarketPackage.Articles;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Food extends Article {
    private int gram;
    private LocalDate expirationDate;
    public Food(String name, float price, boolean barcode, int gram, String expirationDate) {
        super(name, price*(gram/1000), barcode);
        this.gram = gram;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        this.expirationDate = LocalDate.parse(expirationDate, formatter);
    }

    public int getGram() {
        return gram;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
