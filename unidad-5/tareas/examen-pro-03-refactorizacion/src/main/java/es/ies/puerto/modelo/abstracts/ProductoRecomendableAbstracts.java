package es.ies.puerto.modelo.abstracts;

import es.ies.puerto.modelo.interfaces.IRecomendable;
import org.simpleframework.xml.Root;

@Root(name = "row")
public abstract class ProductoRecomendableAbstracts extends ProductoAbstracts implements IRecomendable {
    public ProductoRecomendableAbstracts() {
    }

    public ProductoRecomendableAbstracts(String udi) {
        super(udi);
    }

    public ProductoRecomendableAbstracts(String name, float price, String dateOfEntrance, String udi) {
        super(name, price, dateOfEntrance, udi);
    }

    @Override
    public String toString() {
        return "ProductoRecomendableAbstracts{" +
                "name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", dateOfEntrance='" + super.getDateOfEntrance() + '\'' +
                ", udi='" + super.getUdi() + '\'' +
                '}';
    }
}
