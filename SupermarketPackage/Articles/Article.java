package SupermarketPackage.Articles;

import SupermarketPackage.SupermarketChain;

import static GameHandlerPackage.SystemHandler.getSupermarketChainMap;

public class Article implements java.io.Serializable{
    private final float price;
    private final boolean barcode;
    private final String name;

    public Article(String name, float price, boolean barcode ) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean isBarcode() {
        return barcode;
    }

    public String getArticleType() {
        return this.getClass().getSimpleName();
    }


}
