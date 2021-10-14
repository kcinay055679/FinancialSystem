package SupermarketPackage;

import GameHandlerPackage.Place;
import GameHandlerPackage.Rank;
import SupermarketPackage.Articles.Article;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static GameHandlerPackage.SystemHandler.getPersonList;
import static GameHandlerPackage.SystemHandler.hireEmployee;


public class Shop implements java.io.Serializable{

    private final boolean selfCheckout;
    private final String name;
    private final Place place;
    private int earnings;
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

    public Shop(String name, boolean selfCheckout, SupermarketChain supermarketChain, Place place, Person chief, int earnings) {
        this.name = name;
        this.selfCheckout = selfCheckout;
        this.supermarketChain = supermarketChain;
        this.place = place;
        this.chief = chief;
        this.earnings = earnings;
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

    public int getEarnings() {
        return earnings;
    }

    public void increaseEarnings(int value) {
        this.earnings += value;
    }

    public void decreaseEarnings(int value) {
        this.earnings -= value;
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
        if (p.getCurrentShopWork() == this) {
            p.decreaseMoney(p.getCartPrice());
            if (p.getCard() != null) {
                p.getCard().increasePoints(p.getCartPrice());
            }
            p.getCart().getArticleList().clear();
            p.getCart().setFullPrice(0);

        }
    }

    public void selfCheckOut(Person p, int price) {
        if (p.getCurrentShopWork() == this && this.selfCheckout) {
            p.decreaseMoney(price);
            if (p.getCard() != null) {
                p.getCard().increasePoints(p.getCartPrice());
            }
        }
    }

    public void employeeJoined(Person employee) {
        presentEmployeeList.putIfAbsent(employee.getName(), employee);
    }

    public void employeeLeft(String employee) {
        if (presentEmployeeList.get(employee) !=null) {
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

    public void promoteEmployee(String name){
        Person person = getPersonList().get(name);
        person.setRank(Rank.CHIEF);
        Pair<Person, Shop> collect = supermarketChain.getChiefMap().values().stream().filter(pair -> pair.getValue1() == this).collect(Collectors.toList()).get(0);
        collect.getValue0().setRank(Rank.EMPLOYEE);

        //Alter Chef wird als Mitarbeiter angestellt
        hireEmployee(collect.getValue0().getName(),supermarketChain.getName(), this.name, collect.getValue0().getSalary());

        //Neuer Chef wird aus den Mitarbeiterlisten entfernt
        supermarketChain.getEmployeeMap().remove(collect.getValue0().getName());
        getEmployeeList().remove(person.getName());

        //Alter Chef wird aus der Chef Map entfernt
        supermarketChain.getChiefMap().remove(collect.getValue0().getName());
       //Neuer Chef wird in die Chef Map aufgenommen
        supermarketChain.getChiefMap().put(name, new Pair<>(person, collect.getValue1()));
    }
}
