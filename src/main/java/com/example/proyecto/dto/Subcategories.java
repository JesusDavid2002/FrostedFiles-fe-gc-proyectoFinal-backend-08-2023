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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="subcategories")
public class Subcategories{

    /** Primary key. */
    protected static final String PK = "subcategoryId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="subcategory_id", nullable=false)
    private int subcategoryId;
    
    @Column(length=255, nullable=false)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name="category_nombre", referencedColumnName="nombre")
    private Categories category;
    
    @OneToMany(mappedBy="subcategories", fetch = FetchType.LAZY)
    private List<Files> files;
    
	@JsonIgnore
	public List<Files> getFiles() {
		return files;
	}
	
	public Subcategories(String nombre) {
		this.nombre = nombre;
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
