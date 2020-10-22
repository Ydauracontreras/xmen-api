package ar.com.ada.api.xmen.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "humans")
public class Human {
    private ObjectId _id;
    private String[] dna;
    private String uniqueHash;

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
     * @return the uniqueHash
     */
    public String getUniqueHash() {
        return uniqueHash;
    }

    /**
     * @param uniqueHash the uniqueHash to set
     */
    public void setUniqueHash(String uniqueHash) {
        this.uniqueHash = uniqueHash;
    }

}
