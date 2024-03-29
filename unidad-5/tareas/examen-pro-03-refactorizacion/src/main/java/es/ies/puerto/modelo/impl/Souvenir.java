package es.ies.puerto.modelo.impl;

import es.ies.puerto.modelo.abstracts.ProductoAbstracts;
import org.simpleframework.xml.Root;

@Root(name = "row")
public class Souvenir extends ProductoAbstracts {

    /**
     * Constructors of the class
     */
    public Souvenir() {
    }
    public Souvenir(String udi){
        super(udi);
    }

    public Souvenir(String name, float price, String dateOfEntrance, String udi) {
        super(name, price, dateOfEntrance, udi);
    }


    @Override
    public float maxPrice() {
        return super.getPrice()*1.3f ;
    }

    @Override
    public int availableQuantity() {
        return 0;
    }

    /**
     * Method to String
     */
    @Override
    public String toString() {
        return "Souvenir{" +
                "name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", dateOfEntrance='" + super.getDateOfEntrance() + '\'' +
                ", udi='" + super.getUdi() + '\'' +
                '}';
    }
    @Override
    public String toCsv() {
        return getName()+DELIMITATOR +getPrice()+DELIMITATOR+getDateOfEntrance()+DELIMITATOR+getUdi();
    }
}
