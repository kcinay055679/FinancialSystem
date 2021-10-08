package RealEstateCompanyPackage;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, Company> companies = new HashMap<>();
    public static final Map<String, Person> renters = new HashMap<>();

    public static void main(String[] args) throws ParseException {
        createCompany("Egli's AG", "Riedeggweg", 70, "Riedbach", 3020);
        addEmployee("Egli's AG", "Marc", Gender.valueOf("male".toUpperCase()), "25/05/2005");
        addEmployee("Egli's AG", "Marc1", Gender.valueOf("male".toUpperCase()), "25/05/2004");
        addEmployee("Egli's AG", "Marc1", Gender.valueOf("male".toUpperCase()), "25/05/2004");
        addEmployee("Egli's AG", "Marc1", Gender.valueOf("male".toUpperCase()), "25/05/2004");
        addBuilding("Egli's AG", "GebäudeName1", "Riedeggweg", 70, "Riedbach", 3020);
        addBuilding("Egli's AG", "GebäudeName2", "Riedeggweg", 71, "Riedbach", 3020);
        addApartement("Egli's AG", "GebäudeName1", 3, "test");
        addApartement("Egli's AG", "GebäudeName1", 2, "test");
        addApartement("Egli's AG", "GebäudeName2", 1, "test");
        addApartement("Egli's AG", "GebäudeName2", 1, "test");
        //addApartement("Egli's AG", "GebäudeName1", 1, "test");
//        createApartement("Egli's AG", 5, "test", "teststreet", 25, "Thun", 3600);
        joinApartement("Egli's AG", 0, "01/01/2000", "01/06/2000", 500, new Person("Marc", Gender.MALE, "25/10/2002"));
        joinApartement("Egli's AG", 1, "01/01/2000", "01/06/2000", 500, new Person("Marc", Gender.MALE, "25/10/2002"));
        joinApartement("Egli's AG", 2, "01/01/2000", "01/01/2002", 1000, new Person("Yanick", Gender.MALE, "25/10/2002"));
        joinApartement("Egli's AG", 3, "01/01/2000", "01/01/2002", 1000, new Person("Yanick", Gender.MALE, "25/10/2002"));

//        joinApartement("Egli's AG",2, "11/11/2011", "12/12/2012", 550, new Person("yanick", Gender.MALE, "25/10/2002" ));
//        System.out.println(Arrays.toString(getAllContractsOfPerson("Yanick")));
//        System.out.println(getCaretaker("Egli's AG", 1));
//        System.out.println(Arrays.toString(getAllCotractsOfBuilding("Egli's AG", "GebäudeName1")));
//        System.out.println(Arrays.toString(getEmptyApartments("Egli's AG", "GebäudeName1")));
        ///getContractsOfAllPeoples().forEach(contracts -> System.out.println(Arrays.toString(contracts)));
        //System.out.println(Arrays.toString(getAllContractsOfPerson("Yanick")));

         System.out.println(getEarningsofBuilding("Egli's AG", "GebäudeName2"));
        System.out.println(companies.get("Egli's AG").getAnnuallyEarnings());
        System.out.println("test");

    }

    public static Apartement[] getEmptyApartments(String companyName, String buildingName) {
        return companies.get(companyName).getEmptyApartments(buildingName);
    }

    public static Contract[] getAllCotractsOfBuilding(String companyName, String Buildingname) throws ParseException {
        return companies.get(companyName).getContracts(Buildingname).toArray(Contract[]::new);
    }

    public static String getCaretaker(String companyName, int apartmentNumber) throws ParseException {
        return companies.get(companyName).getCaretaker(apartmentNumber).getName();
    }

    public static void createCompany(String companyName, String streetName, int houseNumber, String place, int ZipCode) {
        companies.put(companyName, new Company(companyName, new Adress(streetName, houseNumber, place, ZipCode)));
    }

    public static void addBuilding(String companyName, String buildingname, String streetName, int houseNumber, String place, int ZipCode) {
        Adress adress = new Adress(streetName, houseNumber, place, ZipCode);
        Company company = companies.get(companyName);
        company.addBuilding(buildingname, new Building(buildingname, adress, company.getWorklessPeople().get(0), company.getWorklessPeople().get(1)));
        company.removeWorklessPerson(0);
        company.removeWorklessPerson(0);
    }

    public static void addEmployee(String companyName, String name, Gender sexuality, String BirthDate) throws ParseException {
        Company company = companies.get(companyName);
        company.addEmployee(name,
                new Person(name, sexuality, BirthDate));
    }

    public static void addApartement(String companyName, String buildingName, int floor, String description) throws ParseException {
        Company company = companies.get(companyName);
        Building building = company.getBuildingByName(buildingName);
        company.addApartementsToList(building.addApartement(floor, description));
    }

    public static void createApartement(String companyName, int floor, String description, String streetName, int houseNumber, String place, int zipCode) throws ParseException {
        Company company = companies.get(companyName);
        Adress adress = new Adress(streetName, houseNumber, place, zipCode);
        company.addApartementtoAdress(adress, floor, description);
    }

    public static void joinApartement(String companyName, int apartmentNumber, String start, String end, int price, Person tenant) throws ParseException {
        Company company = companies.get(companyName);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");


        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);

        startDate = startDate.withDayOfMonth(1);


        Contract contract = new Contract(company, startDate, endDate, price, tenant);
        company.getApartements().get(apartmentNumber).setContract(contract);
        safeContract(tenant, company.getApartements().get(apartmentNumber).getContract());
    }


    public static Contract[] getAllContractsOfPerson(String name) {
        return renters.get(name).getContracts().toArray(Contract[]::new);
    }

    public static void safeContract(Person person, Contract contract) {
        if (!renters.containsKey(person.getName())) {
            person.addContract(contract);
            renters.put(person.getName(), person);
        } else {
            renters.get(person.getName()).addContract(contract);
        }
    }

    public static List<Contract[]> getContractsOfAllPeoples() {
        List<Contract[]> allContracts = new ArrayList<>();
        renters.values().forEach(person -> allContracts.add(person.getContracts().toArray(Contract[]::new)));
        return allContracts;
    }

    public static int getEarningsofBuilding(String companyName, String buildingName) {
        return companies.get(companyName).getEarningsOfBuilding(buildingName);
    }
}
