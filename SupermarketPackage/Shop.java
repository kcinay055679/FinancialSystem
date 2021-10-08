package SupermarketPackage;

import GameHandlerPackage.Place;
import SupermarketPackage.Articles.Article;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {

    private final boolean selfCheckout;
    private final String name;
    private final Place place;
    private final SupermarketChain supermarketChain;
    private final Map<String, Person> employeeList = new HashMap<>();
    private final Map<String, Person> presentEmployeeList = new HashMap<>();
    private final Map<String, Integer> articlePositionList = new HashMap<>();
    private final Map<Integer, Shelf> shelfList = new HashMap<>();

    public SupermarketChain getSupermarketChain() {
        return supermarketChain;
    }

    private Person chief;

    public Place getPlace() {
        return place;
    }

    public Person getChief() {
        return chief;
    }

    public void setChief(Person chief) {
        this.chief = chief;
    }

    public Shop(String name, boolean selfCheckout, SupermarketChain supermarketChain, Place place, Person chief) {
        this.name = name;
        this.selfCheckout = selfCheckout;
        this.supermarketChain = supermarketChain;
        this.place = place;
        this.chief = chief;
    }

    public Map<String, Person> getPresentEmployees() {
        return presentEmployeeList;
    }

    public Map<String, Integer> getArticlePositionList() {
        return articlePositionList;
    }

    public Map<Integer, Shelf> getShelfList() {
        return shelfList;
    }

    public boolean isSelfCheckout() {
        return selfCheckout;
    }

    public String getName() {
        return name;
    }

    public void addArticle(Article article, int amount, int shelfId) {
        Pair<Article, Integer> articlePair = new Pair<>(article, amount);
        shelfList.get(shelfId).getArticleList().put(article.getName(), articlePair);
    }

    public void createShelf() {
        int id = shelfList.size() + 1;
        shelfList.put(id, new Shelf(id, this));
    }

    public Shelf getShelfById(int id) {
        return shelfList.get(id);
    }

    public void checkOut(Person p) {
        if (p.getCurrentShop() == this) {
            p.decreaseMoney(p.getCartPrice());
            if (p.getCard() != null) {
                p.getCard().increasePoints(p.getCartPrice());
            }
            p.getCart().getArticleList().clear();
            p.getCart().setFullPrice(0);

        }
    }

    public void selfCheckOut(Person p, int price) {
        if (p.getCurrentShop() == this && this.selfCheckout) {
            p.decreaseMoney(price);
            if (p.getCard() != null) {
                p.getCard().increasePoints(p.getCartPrice());
            }
        }
    }

    public void employeeJoined(Person employee) {
        presentEmployeeList.putIfAbsent(employee.getName(), employee);
    }

    public void employeeLeaved(String employee) {
        if (presentEmployeeList.get(employee).getName().equals(employee)) {
            presentEmployeeList.remove(employee);
        }
    }

    public Map<String, Person> getEmployeeList() {
        return employeeList;
    }

    public List<Pair<Article, Integer>> getAllArticle() {
        List<Pair<Article, Integer>> articleList = new ArrayList<>();
        for (Shelf s : this.shelfList.values()) {
            for (Pair<Article, Integer> a : s.getArticleList().values()) {
                articleList.add(a);
            }
        }
        return articleList;
    }
}
