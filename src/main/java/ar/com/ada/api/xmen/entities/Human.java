package ar.com.ada.api.xmen.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Human")
public class Human {
    @Id
    private ObjectId _id;
    private String[] dna;
    private String name;

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
     * @return the dna
     */
    public String[] getDna() {
        return dna;
    }

    /**
     * @param dna the dna to set
     */
    public void setDna(String[] dna) {
        this.dna = dna;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
