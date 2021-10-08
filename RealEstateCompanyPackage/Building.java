package RealEstateCompanyPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Building {
    private String builingName;
    private Adress adress;
    private Person caretaker;
    private Person administrator;

    public Adress getAdress() {
        return adress;
    }

    public Person getCaretaker() {
        return this.caretaker;
    }

    public Person getAdministrator() {
        return administrator;
    }



    public List<Apartement> getApartements() {
        return apartements;
    }

    private List<Apartement> apartements = new ArrayList<>();


    public Building(String builingName,Adress adress, Person caretaker, Person administrator) {
        this.builingName = builingName;
        this.adress = adress;
        this.caretaker = caretaker;
        this.administrator = administrator;
    }

    public Apartement addApartement(int floor , String description) {
        Apartement apartement = new Apartement(this.adress, floor, apartements.size(), description);
        this.apartements.add(apartement);
        return apartements.get(apartements.size()-1);
    }

    public void removeApartement(int i) {
        this.apartements.remove(i);
    }

    public List<Contract> getContracts(){
        List<Contract> contracts = new ArrayList<>();
        apartements.forEach(e -> contracts.add(e.getContract()));
        return contracts;
    }
    public Apartement[] getEmptyApartments(){
        Apartement[] emptyApartments = apartements.stream().filter(e-> e.getContract() == null).toArray(Apartement[]::new);
        return emptyApartments;
    }

//    public int getMonthlyEarnings(){
//        return apartements.stream().mapToInt(apartment -> apartment.getContract().getMonatlicherPreis()).sum();
//    }
//    public int getFulEarnings(){
//        return apartements.stream().mapToInt(apartment -> apartment.getContract().getMonatlicherPreis()).sum();
//    }

    public int getMonthlyEarnings(){
        AtomicInteger amount = new AtomicInteger();
        apartements.stream().filter(apartment -> apartment.getContract()!=null).forEach(apartment -> amount.getAndAdd (apartment.getContract().getMonatlicherPreis())) ;
        return amount.get();
    }

    public int getAnnuallyEarnings(){
        AtomicInteger amount = new AtomicInteger();
        apartements.stream().filter(apartment -> apartment.getContract()!=null).forEach(apartment -> amount.addAndGet(apartment.getContract().getAnnuallyEarnings())) ;

        return amount.get();
    }








}
