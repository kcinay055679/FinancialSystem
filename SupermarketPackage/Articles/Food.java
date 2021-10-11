package SupermarketPackage.Articles;

import SupermarketPackage.Fleischsorten;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Food extends Article {
    private Fleischsorten fleisch;
    private LocalDate expirationDate;
    public Food(String name, float price, boolean barcode, String expirationDate, Fleischsorten fleisch) {
        super(name, price, barcode);
        this.fleisch = fleisch;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        this.expirationDate = LocalDate.parse(expirationDate, formatter);
    }

    public Fleischsorten getFleisch() {
        return fleisch;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
