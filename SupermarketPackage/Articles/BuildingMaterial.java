package SupermarketPackage.Articles;

public class BuildingMaterial extends Article  implements java.io.Serializable{

    private int tons;
    Material material;
    public BuildingMaterial(String name, float price, boolean barcode, int tons, String material) {
        super(name, price*tons, barcode );
        this.material = Material.valueOf(material.toUpperCase());
        this.tons = tons;
    }

    public int getTons() {
        return tons;
    }

    public Material getMaterial() {
        return material;
    }
}
