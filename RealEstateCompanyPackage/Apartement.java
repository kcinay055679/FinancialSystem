package RealEstateCompanyPackage;

import java.util.Calendar;

public class Apartement {

    private Adress adress;
    private int stockwerk;
    private int wohnungnummer;
    private Contract contract;

    public Apartement(Adress adress, int stockwerk, int wohnungsnummer, String beschreibung) {
        this.adress = adress;
        this.stockwerk = stockwerk;
        this.wohnungnummer = wohnungsnummer;
        this.beschreibung = beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public void setContract (Contract contract){
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }

    public Adress getAdress() {
        return adress;
    }

    public int getStockwerk() {
        return stockwerk;
    }

    public int getWohnungnummer() {
        return wohnungnummer;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    private String beschreibung;

    public boolean runsContractOut(){
        Calendar oneMonth = Calendar.getInstance();
        oneMonth.add(Calendar.MONTH,1);
        Calendar endDate = Calendar.getInstance();
        int lenghtOfMonth = oneMonth.compareTo(endDate);
        endDate.setTime(java.sql.Date.valueOf(contract.getEndDate()));
        return endDate.compareTo(oneMonth)< lenghtOfMonth;

    }

}
