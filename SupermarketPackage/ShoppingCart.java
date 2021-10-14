package SupermarketPackage;

import SupermarketPackage.Articles.Article;
import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements java.io.Serializable{
    Map<String, Pair<Article, Integer>> articleList = new HashMap<>();
    float fullPrice = 0;

    public float getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(float fullPrice) {
        this.fullPrice = fullPrice;
    }

    public Map<String, Pair<Article, Integer>> getArticleList() {
        return articleList;
    }

    public void addArticle(Pair<Article, Integer> articlePair) {
        if (articleList.get(articlePair.getValue0().getName()) == null) {
            articleList.put(articlePair.getValue0().getName(), articlePair);
            fullPrice += articlePair.getValue0().getPrice() * articlePair.getValue1();
        } else {
            increaceArticleAmount(articlePair.getValue0().getName(), articlePair.getValue1());
        }
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

    public void decreaceArticleAmount(String name, int amount) {
        articleList.put(getArticle(name).getName(), new Pair<>(getArticle(name), getArticlePair(name).getValue1() - amount));
    }

    public void increaceArticleAmount(String name, int amount) {
        articleList.put(getArticle(name).getName(), new Pair<>(getArticle(name), getArticlePair(name).getValue1() + amount));
    }
}
