package RealEstateCompanyPackage;

import java.time.LocalDate;
import java.time.Period;

public class Contract {
    public Contract(Company company, LocalDate startDate, LocalDate endDate, int monatlicherPreis, Person tenant) {
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monatlicherPreis = monatlicherPreis;
        this.personmieter = tenant;
    }

    private Company company;

    public LocalDate getEndDate() {
        return endDate;
    }

    private LocalDate endDate;
    private LocalDate startDate;
    private int monatlicherPreis;

    public int getMonatlicherPreis() {
        return monatlicherPreis;
    }

    private Person personmieter;

    public int getAnnuallyEarnings() {
        Period period = Period.between(startDate, endDate);
        int months = period.getMonths()+(period.getYears()*12);

        if( !(endDate.getDayOfMonth() ==1)){
             months+=1;
        }
        if(months>12){
            months = 12;
        }
        return months*monatlicherPreis;
    }
}
