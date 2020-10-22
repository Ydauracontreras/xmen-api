package ar.com.ada.api.xmen.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mutants")
public class Mutant {
    private ObjectId _id;
    private String[] dna;
    private String uniqueHash;

    /**
     * @return the _id
     */
    public String get_id() {
        return _id.toHexString();
    }

    /**
     * @param _id the _id to set
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
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

}
