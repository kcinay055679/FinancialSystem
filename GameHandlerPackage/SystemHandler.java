package GameHandlerPackage;

import SupermarketPackage.Person;
import SupermarketPackage.Shop;
import SupermarketPackage.SupermarketChain;
import org.javatuples.Pair;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static SupermarketPackage.SupermarketHandler.*;

public class SystemHandler implements java.io.Serializable{

    private static Person selectedUser;

    private static String currentCompany;
    private static String currentShop;

    public static String getCurrentCompany() {
        return currentCompany;
    }

    public static void setCurrentCompany(String currentCompany) {
        SystemHandler.currentCompany = currentCompany;
    }

    public static String getCurrentShop() {
        return currentShop;
    }

    public static void setCurrentShop(String currentShop) {
        SystemHandler.currentShop = currentShop;
    }

    private static Map<String, Person> personList = new HashMap<>();
    private static Map<String, Company> companyMap = new HashMap<>();
    private static Map<String, SupermarketChain> supermarketChainMap = new HashMap<>();

    public static void hireEmployee(String personName, String companyName, String shopName, int salary) {
        Person p = personList.get(personName);

        SupermarketChain supermarketChain = getSupermarketChainMap().get(companyName);
        Shop shop = supermarketChain.getShopMap().get(shopName);

        p.setCurrentCompanyWork(companyMap.get(companyName));
        p.setCurrentShopWork(shop);

        p.setRank(Rank.EMPLOYEE);

        supermarketChain.getEmployeeMap().put(p.getName(), new Pair<>(p, supermarketChain.getShopMap().get(shopName)));
        shop.getEmployeeList().put(p.getName(), p);
        p.setSalary(salary);
    }

    public static void fireEmployee(String person) {

        Person p = personList.get(person);
        Shop shop = p.getCurrentShopWork();
        employeeLeave(person);
        p.setRank(Rank.UNEMPLOYED);
        shop.getSupermarketChain().getEmployeeMap().remove(person);
        shop.getEmployeeList().remove(person);
        p.setCurrentCompanyWork(null);
        p.setCurrentShopWork(null);
    }

    public static Person getSelectedUser() {
        return selectedUser;
    }

    public static Map<String, Person> getPersonList() {
        return personList;
    }

    public static Map<String, Company> getCompanyMap() {
        return companyMap;
    }

    public static Map<String, SupermarketChain> getSupermarketChainMap() {
        return supermarketChainMap;
    }

    public static boolean createSupermarketChain(String name) {
        if (supermarketChainMap.get(name) == null) {
            supermarketChainMap.put(name, new SupermarketChain(name));
            companyMap.put(name, supermarketChainMap.get(name));
            return true;

        } else {
            System.out.println("Kette konnte nicht erstellt werden, bitte wenden sie sich an ihren Systemadministrator "+name);
            return false;
        }
    }

    public static void setSelectedUser(Person selectedUser) {
        SystemHandler.selectedUser = selectedUser;
    }

    public static boolean login(String name, String password) {
        if (getPersonList().get(name) != null) {
            if (getPersonList().get(name).checkPassword(password)) {
                setSelectedUser(getPersonList().get(name));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean adminCheck(String name, String password) {
        if (getPersonList().get(name) != null) {
            if (getPersonList().get(name).checkPassword(password)) {
                setSelectedUser(getPersonList().get(name));
                if (getSelectedUser().getRank() == Rank.ADMIN) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    public static void logout() {
        setSelectedUser(null);
    }

    public static void safeToFile() {
        try {
            //persons
            FileOutputStream fileOutPerson = new FileOutputStream("Data/persons.ser");
            ObjectOutputStream outPerson = new ObjectOutputStream(fileOutPerson);
            outPerson.writeObject(personList);

            //supermarkets
            FileOutputStream fileOutSupermarkets = new FileOutputStream("Data/supermarketChains.ser");
            ObjectOutputStream outSupermarket = new ObjectOutputStream(fileOutSupermarkets);
            outSupermarket.writeObject(supermarketChainMap);

            FileOutputStream fileOutTIme = new FileOutputStream("Data/time.ser");
            ObjectOutputStream outTime = new ObjectOutputStream(fileOutTIme);
            outTime.writeObject(DigitalClock.SimpleDigitalClock.realTime);


            fileOutTIme.close();
            outTime.close();
            outSupermarket.close();
            fileOutSupermarkets.close();
            outPerson.close();
            fileOutPerson.close();
            System.out.println("Serialized data is saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFromFile() {

        try {
            FileInputStream fileInPerson = new FileInputStream("Data/persons.ser");
            ObjectInputStream inPerson = new ObjectInputStream(fileInPerson);
            personList = (Map<String, Person>) inPerson.readObject();

            FileInputStream fileInSupermarket = new FileInputStream("Data/supermarketChains.ser");
            ObjectInputStream inSupermarket = new ObjectInputStream(fileInSupermarket);
            supermarketChainMap = (Map<String, SupermarketChain>) inSupermarket.readObject();

            FileInputStream fileInTime = new FileInputStream("Data/time.ser");
            ObjectInputStream inTIme = new ObjectInputStream(fileInTime);
            DigitalClock.SimpleDigitalClock.realTime = (LocalDateTime) inTIme.readObject();


            inSupermarket.close();
            fileInSupermarket.close();
            inPerson.close();
            fileInPerson.close();
            System.out.println("Data is loaded");
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }
}
