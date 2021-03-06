package SupermarketPackage;

import SupermarketPackage.Articles.Article;
import SupermarketPackage.Articles.BuildingMaterial;
import SupermarketPackage.Articles.Food;
import org.javatuples.Pair;
import java.util.HashMap;
import java.util.Map;

public class Shelf implements java.io.Serializable{
    private final int ID;
    private final Shop shop;
    public final SupermarketChain supermarketChain;
    private final Map<String, Pair<Article, Integer>> articleList = new HashMap<>();
    public Map<String, Pair<Article, Integer>> getArticleList() {
        return articleList;
    }

    public Shelf(int ID, Shop shop) {
        this.ID = ID;
        this.shop = shop;
        this.supermarketChain = shop.getSupermarketChain();
    }

    public int getID() {
        return ID;
    }

    public void addArticle(Article article, int amount) {
        Pair<Article, Integer> articlePair = new Pair<>(article, amount);
        articleList.put(article.getName(), articlePair);
    }

    public void removeArticle(String name) {
        articleList.remove(name);
    }

    public Article getArticle(String name) {
        if (articleList.get(name) == null) {
            return null;
        }
        return articleList.get(name).getValue0();
    }

    public Pair<Article, Integer> getArticlePair(String name) {
        return articleList.get(name);
    }

    public Pair<Article, Integer> takeArticle(String name, int amount) {
        if (getArticlePair(name).getValue1() > amount) {
            articleList.put(name, getArticlePair(name).setAt1(getArticleAmount(name) - amount));
            return new Pair<>(getArticle(name), amount);
        } else {
            Pair<Article, Integer> articlePair = new Pair<>(getArticle(name), getArticleAmount(name));
            articleList.put(name, getArticlePair(name).setAt1(0));
            return articlePair;
        }
    }

    public int getArticleAmount(String name) {
        return getArticlePair(name).getValue1();
    }

    public void setArticleAmount(String name, int amount) {
        articleList.put(getArticle(name).getName(), new Pair<>(getArticle(name), amount));
    }

    public void increaseArticleAmountFood(String name, int amount) {
        if (getArticle(name) == null) {
            Food article = (Food) supermarketChain.getArticleMap().get(name);
            SupermarketHandler.createFood(article.getName(), article.getPrice(), amount, article.isBarcode(), article.getArticleType(), shop.getName(),supermarketChain.getName(), ID, article.getFleisch());
        } else {
            articleList.put(getArticle(name).getName(), new Pair<>(getArticle(name), getArticlePair(name).getValue1() + amount));
        }
    }

    public void increaseArticleAmountBuildingMaterial(String name, int amount ) {
        if (getArticle(name) == null) {
            BuildingMaterial article = (BuildingMaterial) supermarketChain.getArticleMap().get(name);
            SupermarketHandler.createBuildingMaterial(article.getName(), article.getPrice(), amount,article.isBarcode(), shop.getName(), article.getTons() ,article.getMaterial().toString(), supermarketChain.getName(), ID);
        } else {
            articleList.put(getArticle(name).getName(), new Pair<>(getArticle(name), getArticlePair(name).getValue1() + amount));
        }
    }

    public void decreaseArticleAmount(String name, int amount) {
        articleList.put(getArticle(name).getName(), new Pair<>(getArticle(name), getArticlePair(name).getValue1() - amount));
    }
}
