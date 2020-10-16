package ar.com.ada.api.xmen.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Mutant")
public class Mutant {
    @Id
    private ObjectId _id;
    private String[] adn;
    private String nombre;

    /**
     * @return the _id
     */
    public ObjectId get_id() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    /**
     * @return the adn
     */
    public String[] getAdn() {
        return adn;
    }

    /**
     * @param adn the adn to set
     */
    public void setAdn(String[] adn) {
        this.adn = adn;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
