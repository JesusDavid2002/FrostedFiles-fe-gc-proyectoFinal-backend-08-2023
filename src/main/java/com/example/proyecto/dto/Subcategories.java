// Generated with g9.

package com.example.proyecto.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="subcategories")
public class Subcategories{

    /** Primary key. */
    protected static final String PK = "subcategoryId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="subcategory_id", unique=true, nullable=false)
    private int subcategoryId;
    
    @Column(length=255)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name="categoria")
    private Categories categories;
    
    @OneToMany(mappedBy="subcategoria")
    private List<Files> files;
    
    /** Default constructor. */
    public Subcategories() {}

    public Subcategories(int subcategoryId, String nombre, Categories categories, List<Files> files) {
		this.subcategoryId = subcategoryId;
		this.nombre = nombre;
		this.categories = categories;
		this.files = files;
	}

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int aSubcategoryId) {
        subcategoryId = aSubcategoryId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Files> getFiles() {
		return files;
	}

	public void setFiles(List<Files> files) {
		this.files = files;
	}

	/**
     * Compares the key for this instance with another Subcategories.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Subcategories and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Subcategories)) {
            return false;
        }
        Subcategories that = (Subcategories) other;
        if (this.getSubcategoryId() != that.getSubcategoryId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Subcategories.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Subcategories)) return false;
        return this.equalKeys(other) && ((Subcategories)other).equalKeys(this);
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
        i = getSubcategoryId();
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
        StringBuffer sb = new StringBuffer("[Subcategories |");
        sb.append(" subcategoryId=").append(getSubcategoryId());
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
        ret.put("subcategoryId", Integer.valueOf(getSubcategoryId()));
        return ret;
    }

}
