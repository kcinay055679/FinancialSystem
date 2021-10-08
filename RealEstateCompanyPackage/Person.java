package RealEstateCompanyPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
    public Person(String name, Gender geschlecht, String birthDate) throws ParseException {
        this.name = name;
        this.gender = geschlecht;
        this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);;
    }

    private String name;
    private Gender gender; //Männlich
    private Date birthDate;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void addContract(Contract contract) {
        this.contracts.add(contract);
    }

    private List<Contract> contracts = new ArrayList<>();

    public void setWohnvertrag(Contract wohnvertrag) {
        this.wohnvertrag = wohnvertrag;
    }

    private Contract wohnvertrag;

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Contract getWohnvertrag() {
        return wohnvertrag;
    }

    public boolean equals(Person other){
        return other.getName().equals(this.name)&& other.getGender()==other.getGender()&& other.getBirthDate().toString() == this.birthDate.toString();
    }
}
