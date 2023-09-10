// Generated with g9.

package com.example.proyecto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import jakarta.persistence.Lob;
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
@Table(name="files")
public class Files {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;
    
    @Column(name="nombre", nullable=false, length=255)
    private String nombre;
    
    @Column(name="extension", length=10)
    private String extension;
    
    @Column(name="tamaño", precision=10, scale=2)
    private BigDecimal tamano;
    
    @Column(name="fecha_subida")
    private LocalDateTime fechaSubida;
    
    @Column(name="visibilidad")
    private boolean visibilidad;
    
    @Lob
    @Column(name="contenido", columnDefinition="BLOB")
    private byte[] contenido;
    
    @ManyToOne
    @JoinColumn(name="category_nombre", referencedColumnName="nombre")
    private Categories categories;
    
    @ManyToOne
    @JoinColumn(name="subcategory_nombre", referencedColumnName="nombre")
    private Subcategories subcategories;
    
    @OneToMany(mappedBy="files", fetch = FetchType.LAZY)
    private List<Multimedia> multimedia;

    @OneToMany(mappedBy="files", fetch = FetchType.LAZY)
    private List<Comentarios> comentarios;
    
    @OneToMany(mappedBy="files", fetch = FetchType.LAZY)
    private List<Acciones> acciones;

    
	@JsonIgnore
	public List<Multimedia> getMultimedia() {
		return multimedia;
	}

	@JsonIgnore
	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	@JsonIgnore
	public List<Acciones> getAcciones() {
		return acciones;
	}


	/**
     * Compares the key for this instance with another Files.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Files and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Files)) {
            return false;
        }
        Files that = (Files) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Files.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Files)) return false;
        return this.equalKeys(other) && ((Files)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Files |");
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
