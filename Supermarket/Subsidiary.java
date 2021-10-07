package Supermarket;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsidiary {

    Map<String, Person> employeeList = new HashMap<>();
    Map<String, Person> presentEmployees = new HashMap<>();
    Map<String, Integer> articlePositions = new HashMap<>();
    Map<Integer, Shelf> shelfList = new HashMap<>();

    private final String name;
    private final boolean selfCheckout;
    private final Place place;

    public boolean isSelfCheckout() {
        return selfCheckout;
    }

    public String getName() {
        return name;
    }

    public Subsidiary(String name, boolean selfCheckout, Place place) {
        this.name = name;
        this.selfCheckout = selfCheckout;
        this.place = place;
    }

    public void addArticle(Article article, int amount, int shelfId) {
        Pair<Article, Integer> articlePair = new Pair<>(article, amount);
        shelfList.get(shelfId).getArticleList().put(article.getName(), articlePair);
    }

    public void createShelf() {
        int id = shelfList.size() + 1;
        shelfList.put(id, new Shelf(id));
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
        presentEmployees.putIfAbsent(employee.getName(), employee);
    }

    public void employeeLeaved(String employee) {
        if(presentEmployees.get(employee).getName().equals(employee)) {
            presentEmployees.remove(employee);
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
