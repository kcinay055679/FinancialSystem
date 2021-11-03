package SupermarketPackage;

import SupermarketPackage.Articles.Article;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import java.util.ArrayList;
import java.util.List;

import static GameHandlerPackage.SystemHandler.*;

public class Tablet implements java.io.Serializable{

    public int findArticle(String articleName, String shopName, String supermarketChainName) {
        Shop shop = getSupermarketChainMap().get(supermarketChainName).getShopMap().get(shopName);
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
        Shop shop = getSupermarketChainMap().get(supermarketChainName).getShopMap().get(shopName);
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
        for (Shop shop : getSupermarketChainMap().get(supermarketChainName).getShopMap().values()) {
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
        for (Shop shop : getSupermarketChainMap().get(supermarketChainName).getShopMap().values()) {
            for (Shelf s : shop.getShelfList().values()) {
                for (Pair<Article, Integer> a : s.getArticleList().values()) {
                    if (a.getValue0().getArticleType().toUpperCase().equals(articleType.toUpperCase())) {
                        foundArticles.add(new Triplet<>(shop, a.getValue0(), a.getValue1()));
                    }
                }
            }
        }
        return foundArticles;
    }

    public List<Triplet<Shop, Article, Integer>> findArticleInShop(String articleName, String shopName,String supermarketChainName) {
        List<Triplet<Shop, Article, Integer>> foundArticles = new ArrayList<>();
            for (Shelf s : getSupermarketChainMap().get(supermarketChainName).getShopMap().get(shopName).getShelfList().values()) {
                for (Pair<Article, Integer> a : s.getArticleList().values()) {
                    if (a.getValue0().getName().equals(articleName)) {
                        foundArticles.add(new Triplet<>(getSupermarketChainMap().get(supermarketChainName).getShopMap().get(shopName), a.getValue0(), a.getValue1()));
                    }
                }
            }

        return foundArticles;
    }
}
