package GameHandlerPackage;

import SupermarketPackage.Person;
import SupermarketPackage.Shop;
import SupermarketPackage.SupermarketChain;
import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class SystemHandler {

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

    private static final Map<String, Person> personList = new HashMap<>();
    private static Map<String, Company> companyMap = new HashMap<>();
    private static Map<String, SupermarketChain> supermarketChainMap = new HashMap<>();

    public static void hireEmployee(String personName, String companyName, String shopName) {
        Person p = personList.get(personName);
        //ToDo
        // "supermarketChainMap.get()" zu Company änderen
        p.setWorkPlace(companyMap.get(companyName));
        supermarketChainMap.get(companyName).getEmployeeMap().put(p.getName(), new Pair<>(p, supermarketChainMap.get(companyName).getShopMap().get(null)));
        SupermarketChain supermarketChain = (SupermarketChain) getPersonList().get(personName).getWorkPlace();

        Shop shop = supermarketChain.getShopMap().get(shopName);
        p.setCurrentShopWork(shop);
        p.setRank(Rank.EMPLOYEE);
        supermarketChain.getEmployeeMap().put(p.getName(), new Pair<>(p, supermarketChain.getShopMap().get(shopName)));
        shop.getEmployeeList().put(p.getName(), p);
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

    public static void createSupermarketChain(String name) {
        supermarketChainMap.put(name, new SupermarketChain(name));
        companyMap.put(name, supermarketChainMap.get(name));
    }

    public static void setSelectedUser(Person selectedUser) {
        SystemHandler.selectedUser = selectedUser;
    }

    public static boolean login(String name, String password) {
        if (getPersonList().get(name) != null) {
            if (getPersonList().get(name).checkPassword(password)) {
                setSelectedUser(getPersonList().get(name));
            }else{
                return false;
            }
        }else{
            return false;
        }
        return getSelectedUser().getName().equals(name);


    }

    public static void logout(){
        setSelectedUser(null);
    }
}
