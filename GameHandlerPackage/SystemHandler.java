package GameHandlerPackage;

import SupermarketPackage.Person;
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

    public static void addEmployeeToCompany(String name, String companyName) {
        Person p = personList.get(name);
        //ToDo
        // "supermarketChainMap.get()" zu Company änderen
        supermarketChainMap.get(companyName).getEmployeeMap().put(p.getName(), new Pair<>(p, supermarketChainMap.get(companyName).getShopMap().get(null)));
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
