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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="files")
public class Files {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;
    
    @Column(nullable=false, length=255)
    private String nombre;
    
    @Column(length=10)
    private String extension;
    
    @Column(name="tamaño", precision=10, scale=2)
    private BigDecimal tamano;
    
    @Column(name="fecha_subida", nullable=false)
    private LocalDateTime fechaSubida;
    
    @Column
    private boolean visibilidad;
    
    @ManyToOne
    @JoinColumn(name="category_nombre")
    private Categories categoria;
    
    @ManyToOne
    @JoinColumn(name="subcategory_nombre")
    private Subcategories subcategoria;
    
    @OneToMany(mappedBy="files")
    private List<Multimedia> multimedia;

    @OneToMany(mappedBy="files")
    private List<Comentarios> comentarios;
    
    @OneToMany(mappedBy="files")
    private List<Acciones> acciones;

    /** Default constructor. */
    public Files() {}

    public Files(int id, String nombre, String extension, BigDecimal tamano, LocalDateTime fechaSubida,
			boolean visibilidad, Categories categories, Subcategories subcategories, List<Multimedia> multimedia,
			List<Comentarios> comentarios, List<Acciones> acciones) {
		this.id = id;
		this.nombre = nombre;
		this.extension = extension;
		this.tamano = tamano;
		this.fechaSubida = fechaSubida;
		this.visibilidad = visibilidad;
		this.categoria = categories;
		this.subcategoria = subcategories;
		this.multimedia = multimedia;
		this.comentarios = comentarios;
		this.acciones = acciones;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String aExtension) {
        extension = aExtension;
    }

    public BigDecimal getTamano() {
        return tamano;
    }

    public void setTamano(BigDecimal aTamano) {
        tamano = aTamano;
    }

    public LocalDateTime getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(LocalDateTime aFechaSubida) {
        fechaSubida = aFechaSubida;
    }

    public boolean getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(boolean aVisibilidad) {
        visibilidad = aVisibilidad;
    }

    public Categories getCategories() {
		return categoria;
	}

	public void setCategories(Categories categories) {
		this.categoria = categories;
	}

	public Subcategories getSubcategories() {
		return subcategoria;
	}

	public void setSubcategories(Subcategories subcategories) {
		this.subcategoria = subcategories;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Multimedia> getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(List<Multimedia> multimedia) {
		this.multimedia = multimedia;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Acciones> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<Acciones> acciones) {
		this.acciones = acciones;
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
