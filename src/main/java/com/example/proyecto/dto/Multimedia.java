// Generated with g9.

package com.example.proyecto.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="multimedia")
public class Multimedia {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;
    
    @Column(nullable=false, length=255)
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name="file")
    private Files files;

    /** Default constructor. */
    public Multimedia() {}

    public Multimedia(int id, String tipo, Files files) {
		this.id = id;
		this.tipo = tipo;
		this.files = files;
	}

	public int getId() {
        return id;
    }

    public void setId(int aId) {
        id = aId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String aTipo) {
        tipo = aTipo;
    }

    public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	/**
     * Compares the key for this instance with another Multimedia.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Multimedia and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Multimedia)) {
            return false;
        }
        Multimedia that = (Multimedia) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Multimedia.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Multimedia)) return false;
        return this.equalKeys(other) && ((Multimedia)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Multimedia |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
