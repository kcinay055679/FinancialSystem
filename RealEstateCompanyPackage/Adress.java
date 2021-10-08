package RealEstateCompanyPackage;

import java.util.ArrayList;
import java.util.List;

public class Adress {
    private String Strassenname;
    private int Hausnummer;
    private String Ort;
    private int PLZ;

    List<Apartement> apartements = new ArrayList<>();

    public Apartement addApartement(int floor , String description) {
        Apartement apartement = new Apartement(this, floor, apartements.size(), description);
        this.apartements.add(apartement);
        return apartement;
    }

    public List<Apartement> getApartements() {
        return apartements;
    }

    public String getStrassenname() {
        return Strassenname;
    }

    public int getHausnummer() {
        return Hausnummer;
    }

    public String getOrt() {
        return Ort;
    }

    public int getPLZ() {
        return PLZ;
    }

    public Adress(String strassenname, int hausnummer, String ort, int PLZ) {
        Strassenname = strassenname;
        Hausnummer = hausnummer;
        Ort = ort;
        this.PLZ = PLZ;
    }

}
