package SupermarketPackage;

import org.javatuples.Pair;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Person {
    private final String name;
    private int salary;
    private int money;
    private String password;
    private Subsidiary currentShop;
    private Schüppercard card;
    private final ShoppingCart cart = new ShoppingCart();
    private byte[] hashedPassword;
    MessageDigest digest;
    {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public Person(String name, String password, String repeatPassword, int salary) {
        this.name = name;
        this.salary = salary;
        this.money = salary*5;

        setPassword(password, repeatPassword);

    }

    public void setPassword(String password, String repeatPassword) {

            hashedPassword = hashPassword(password);
    }

    public byte[] hashPassword(String password) {
        return digest.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    public void changePassword(String oldPassword, String newPassword, String newPasswordRepeat){
        if (Arrays.equals(hashPassword(oldPassword), hashedPassword) && newPassword.equals(newPasswordRepeat)){
            hashedPassword = hashPassword(newPassword);
        }
    }

    public boolean checkPassword(String password){
        return Arrays.equals(hashPassword(password), hashedPassword);
    }



    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
        money += salary*5;
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

    public Subsidiary getCurrentShop() {
        return currentShop;
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
        this.card = new Schüppercard();
    }

    public void takeArticle(String articleName, int amount, int shelfId) {
        Pair<Article, Integer> articlePair = currentShop.getShelfById(shelfId).takeArticle(articleName, amount);
        cart.addArticle(articlePair);
    }

    public void setShop(Subsidiary shop) {
        currentShop = shop;
    }

    public float getCartPrice() {
        return cart.getFullPrice();
    }

    public void convertSchüpperPoints() {
        this.increaseMoney(getCard().getPoints() / 100);
    }

    public void receiveSalary(){
        money+=salary;
    }

}
