package SupermarketPackage;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import java.util.ArrayList;
import java.util.List;

import static GameHandlerPackage.SystemHandler.*;

public class Tablet {

    public int findArticle(String articleName, String shopName, String supermarketChainName) {
        Shop shop = getSupermarketChainMap().get(supermarketChainName).shopList.get(shopName);
        for (Shelf s : shop.getShelfList().values()) {
            for (Pair<Article, Integer> a : s.getArticleList().values()) {
                if (a.getValue0().getName().equals(articleName)) {
                    return s.getID();
                }
            }
        }
        return -1;
    }

    public Pair<Article, Integer> getArticlePair(String articleName, String shopName,String supermarketChainName) {
        Shop shop = getSupermarketChainMap().get(supermarketChainName).shopList.get(shopName);
        List<Pair<Article, Integer>> articleList = new ArrayList<>();
        for (Shelf s : shop.getShelfList().values()) {
            for (Pair<Article, Integer> a : s.getArticleList().values()) {
                if (a.getValue0().getName().equals(articleName)) {
                    return a;
                }
            }
        }
        return null;
    }

    public List<Triplet<Shop, Article, Integer>> findArticleInSystem(String articleName, String supermarketChainName) {
        List<Triplet<Shop, Article, Integer>> foundArticles = new ArrayList<>();
        for (Shop shop : getSupermarketChainMap().get(supermarketChainName).shopList.values()) {
            for (Shelf s : shop.getShelfList().values()) {
                for (Pair<Article, Integer> a : s.getArticleList().values()) {
                    if (a.getValue0().getName().equals(articleName)) {
                        foundArticles.add(new Triplet<>(shop, a.getValue0(), a.getValue1()));
                    }
                }
            }
        }
        return foundArticles;
    }

    public List<Triplet<Shop, Article, Integer>> findArticleByType(String articleType, String supermarketChainName) {
        List<Triplet<Shop, Article, Integer>> foundArticles = new ArrayList<>();
        for (Shop shop : getSupermarketChainMap().get(supermarketChainName).shopList.values()) {
            for (Shelf s : shop.getShelfList().values()) {
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
