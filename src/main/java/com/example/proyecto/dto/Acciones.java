// Generated with g9.

package com.example.proyecto.dto;

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
@Table(name="acciones")
public class Acciones {

    /** Primary key. */
    protected static final String PK = "id";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;
    
    @Column(name="tipo_accion", nullable=false, length=255)
    private String tipoAccion;
    
    @Column(nullable=false)
    private LocalDateTime fecha;

    @OneToMany(mappedBy="acciones")
    private List<DatosEstadisticos> datosEstadisiticos;

    @ManyToOne
    @JoinColumn(name="user")
    private Users users;

    @ManyToOne
    @JoinColumn(name="file")
    private Files files;
    
    /** Default constructor. */
    public Acciones() {}

    public Acciones(int id, String tipoAccion, LocalDateTime fecha, List<DatosEstadisticos> datosEstadisiticos,
			Users users, Files files) {
		this.id = id;
		this.tipoAccion = tipoAccion;
		this.fecha = fecha;
		this.datosEstadisiticos = datosEstadisiticos;
		this.users = users;
		this.files = files;
	}

	public int getId() {
        return id;
    }

    public void setId(int aId) {
        id = aId;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String aTipoAccion) {
        tipoAccion = aTipoAccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime aFecha) {
        fecha = aFecha;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    public List<DatosEstadisticos> getDatosEstadisiticos() {
		return datosEstadisiticos;
	}

	public void setDatosEstadisiticos(List<DatosEstadisticos> datosEstadisiticos) {
		this.datosEstadisiticos = datosEstadisiticos;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	/**
     * Compares the key for this instance with another Acciones.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Acciones and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Acciones)) {
            return false;
        }
        Acciones that = (Acciones) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Acciones.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Acciones)) return false;
        return this.equalKeys(other) && ((Acciones)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Acciones |");
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
