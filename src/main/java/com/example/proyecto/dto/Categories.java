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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;
    
    @Column(length=255)
    private String nombre;

    @OneToMany(mappedBy="categories")
    private List<Subcategories> subcategories;

    @OneToMany(mappedBy="categoria",fetch = FetchType.LAZY)
    private List<Files> files;
    
    /** Default constructor. */
    public Categories() {}
    
    public Categories(String nombre) {
		this.nombre = nombre;
    }

    public Categories(int id, String nombre, List<Subcategories> subcategories, List<Files> files) {
		this.id = id;
		this.nombre = nombre;
		this.subcategories = subcategories;
		this.files = files;
	}

	public int getId() {
        return id;
    }

    public void setId(int aId) {
        id = aId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String aNombre) {
        nombre = aNombre;
    }
    
    @JsonIgnore
    public List<Subcategories> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Subcategories> subcategories) {
		this.subcategories = subcategories;
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
     * Compares the key for this instance with another Categories.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Categories and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Categories)) {
            return false;
        }
        Categories that = (Categories) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Categories.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Categories)) return false;
        return this.equalKeys(other) && ((Categories)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Categories |");
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
