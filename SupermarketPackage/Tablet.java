package SupermarketPackage;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

public class Tablet {

    public int findArticle(String articleName, String shopName) {
        Subsidiary shop = Main.coop.subsidiaryList.get(shopName);
        for (Shelf s : shop.shelfList.values()) {
            for (Pair<Article, Integer> a : s.getArticleList().values()) {
                if (a.getValue0().getName().equals(articleName)) {
                    return s.getID();
                }
            }
        }
        return -1;
    }

    public Pair<Article, Integer> getArticlePair(String articleName, String shopName) {
        Subsidiary shop = Main.coop.subsidiaryList.get(shopName);
        List<Pair<Article, Integer>> articleList = new ArrayList<>();
        for (Shelf s : shop.shelfList.values()) {
            for (Pair<Article, Integer> a : s.getArticleList().values()) {
                if (a.getValue0().getName().equals(articleName)) {
                    return a;
                }
            }
        }
        return null;
    }

    public List<Triplet<Subsidiary, Article, Integer>> findArticleInSystem(String articleName) {
        List<Triplet<Subsidiary, Article, Integer>> foundArticles = new ArrayList<>();
        for (Subsidiary shop : Main.coop.subsidiaryList.values()) {
            for (Shelf s : shop.shelfList.values()) {
                for (Pair<Article, Integer> a : s.getArticleList().values()) {
                    if (a.getValue0().getName().equals(articleName)) {
                        foundArticles.add(new Triplet<>(shop, a.getValue0(), a.getValue1()));
                    }
                }
            }
        }
        return foundArticles;
    }

    public List<Triplet<Subsidiary, Article, Integer>> findArticleByType(String articleType) {
        List<Triplet<Subsidiary, Article, Integer>> foundArticles = new ArrayList<>();
        for (Subsidiary shop : Main.coop.subsidiaryList.values()) {
            for (Shelf s : shop.shelfList.values()) {
                for (Pair<Article, Integer> a : s.getArticleList().values()) {
                    if (a.getValue0().getArticleType() == ArticleType.valueOf(articleType.toUpperCase())) {
                        foundArticles.add(new Triplet<>(shop, a.getValue0(), a.getValue1()));
                    }
                }
            }
        }
        return foundArticles;
    }
}
