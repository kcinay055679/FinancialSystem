package SupermarketPackage;

public class Article {
    private float price;
    private boolean barcode;
    private String name;
    private ArticleType articleType;

    public Article(String name, float price, boolean barcode, String articleSort) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
        this.articleType = ArticleType.valueOf(articleSort.toUpperCase());
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

    public ArticleType getArticleType() {
        return articleType;
    }
}
