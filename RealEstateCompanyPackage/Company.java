package RealEstateCompanyPackage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Company {
    private Adress companyAdress;
    private String companyName;
    private final Map<String, Building> buildings = new HashMap<>();
    public final Map<String, Person> angestellte = new HashMap<>();

    private List<Adress> apartementsAtAdress = new ArrayList<Adress>();
    private List<Person> worklessPeople = new ArrayList<>();
    private List<Apartement> apartements = new ArrayList<Apartement>();


    public Adress getCompanyAdress() {
        return companyAdress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Person> getWorklessPeople() {
        return worklessPeople;
    }

    public void addWorklessPerson(Person person) {
        this.worklessPeople.add(person);
    }

    public void removeWorklessPerson(int i) {
        this.worklessPeople.remove(i);
    }


    public Map<String, Building> getBuilding() {
        return buildings;
    }

    public Building getBuildingByName(String buildingName) {
        return buildings.get(buildingName);
    }

    public Map<String, Person> getEmployee() {
        return angestellte;
    }

    public void addBuilding(String name, Building building) {
        buildings.put(name, building);
    }

    public void addApartementtoAdress(Adress adress, int floor, String description) {
        adress.addApartement(floor, description);
        apartementsAtAdress.add(adress);
        apartements.add(adress.getApartements().get(adress.getApartements().size() - 1));
    }

    public List<Apartement> getApartements() {
        return apartements;
    }

    public void addApartementsToList(Apartement apartement) {

        apartements.add(apartement);
    }

    public void addEmployee(String name, Person emloyee) {
        angestellte.put(name, emloyee);
        worklessPeople.add(emloyee);
    }

    public Company(String companyName, Adress companyAdress) {
        this.companyAdress = companyAdress;
        this.companyName = companyName;
    }

    public int numberOfApartmentsInAllBuildings() {
        AtomicInteger numberOfApartements = new AtomicInteger();
        buildings.forEach((key, value) -> numberOfApartements.addAndGet(value.getApartements().size()));
        return numberOfApartements.get();
    }

    public Person getCaretaker(int apartementNumber) throws ParseException {
        for (Building building : buildings.values()) {
            for (int i = 0; i < building.getApartements().size(); i++) {
                if (apartements.get(apartementNumber) == building.getApartements().get(i)) {
                    return building.getCaretaker();
                }
            }
        }
        return new Person("Unknown", Gender.MALE, "01/01/1973");
    }
    public List<Contract> getContracts(String buildingName){
        return buildings.get(buildingName).getContracts();
    }
    public Apartement[] getEmptyApartments(String buildingName){
        return buildings.get(buildingName).getEmptyApartments();
    }
    public Apartement[] getAlmostEmptyApartments(){
       return apartements.stream().filter(Apartement::runsContractOut).toArray(Apartement[]::new);
    }
    public int getEarningsOfBuilding(String buildingName){
        return buildings.get(buildingName).getMonthlyEarnings();
    }
    public int getAnnuallyEarnings(){
        AtomicInteger amount = new AtomicInteger();
        buildings.values().forEach(building -> amount.addAndGet(building.getAnnuallyEarnings()));
        return amount.get();
    }


}
