package SupermarketPackage;

import GameHandlerPackage.Company;
import GameHandlerPackage.Rank;
import SupermarketPackage.Articles.Article;
import org.javatuples.Pair;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Person {
    private int salary;
    private int money;
    private final String name;
    private byte[] hashedPassword;

    private Company currenCompanyWork;
    private Shop currentShopWork;
    private Rank rank = Rank.UNEMPLOYED;
    private Schüppercard card;
    private final ShoppingCart cart = new ShoppingCart();
    private MessageDigest digest;

    {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Company getCurrentCompanyWork() {
        return currenCompanyWork;
    }

    public void setCurrentCompanyWork(Company company) {
        this.currenCompanyWork = company;
    }

    public Shop getCurrentShopWork() {
        return currentShopWork;
    }

    public void setCurrentShopWork(Shop currentShopWork) {
        this.currentShopWork = currentShopWork;
    }

    public Person(String name, String password, String repeatPassword, int salary) {
        this.name = name;
        this.salary = salary;
        this.money = salary * 5;
        setPassword(password, repeatPassword);
    }

    public void setPassword(String password, String repeatPassword) {
        if (password.equals(repeatPassword)) {
            hashedPassword = hashPassword(password);
        } else {
            throw new SecurityException();
        }
    }

    public byte[] hashPassword(String password) {
        return digest.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    public void changePassword(String oldPassword, String newPassword, String newPasswordRepeat) {
        if (Arrays.equals(hashPassword(oldPassword), hashedPassword) && newPassword.equals(newPasswordRepeat)) {
            hashedPassword = hashPassword(newPassword);
        }
    }

    public boolean checkPassword(String password) {
        return Arrays.equals(hashPassword(password), hashedPassword);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
        money += salary * 5;
    }

    public Schüppercard getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void increaseMoney(int money) {
        this.money += money;
    }

    public void decreaseMoney(float money) {
        this.money -= money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCard(Schüppercard card) {
        this.card = card;
    }

    public void addSchüppercard() {
        this.card = new Schüppercard(1000 + (int)(Math.random() * ((9999 - 1000) + 1)));
    }

    public void takeArticle(String articleName, int amount, int shelfId) {
        Pair<Article, Integer> articlePair = currentShopWork.getShelfById(shelfId).takeArticle(articleName, amount);
        cart.addArticle(articlePair);
    }

    public void setShop(Shop shop) {
        currentShopWork = shop;
    }

    public float getCartPrice() {
        return cart.getFullPrice();
    }

    public void convertSchüpperPoints() {
        this.increaseMoney(getCard().getPoints() / 100);
    }

    public void receiveSalary() {
        money += salary;
    }
}
