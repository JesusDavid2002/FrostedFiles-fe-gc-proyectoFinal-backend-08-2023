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
@Table(name="users")
public class Users {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;
    
    @Column(nullable=false, length=255)
    private String nombre;
    
    @Column(nullable=false, length=255)
    private String email;
    
    @Column(name="fecha_creacion", nullable=false)
    private LocalDateTime fechaCreacion;
    
    @Column(name="es_moderador")
    private boolean esModerador;
    
    @Column(name="es_admin")
    private boolean esAdmin;
    
    @ManyToOne
    @JoinColumn(name="rol")
    private Roles roles;

    @OneToMany(mappedBy="usuario")
    private List<Acciones> acciones;
    
    /** Default constructor. */
    public Users() {}

    
    public Users(int id, String nombre, String email, LocalDateTime fechaCreacion, boolean esModerador, boolean esAdmin,
			Roles roles, List<Acciones> acciones) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.esModerador = esModerador;
		this.esAdmin = esAdmin;
		this.roles = roles;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String aEmail) {
        email = aEmail;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime aFechaCreacion) {
        fechaCreacion = aFechaCreacion;
    }

    public boolean getEsModerador() {
        return esModerador;
    }

    public void setEsModerador(boolean aEsModerador) {
        esModerador = aEsModerador;
    }

    public boolean getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean aEsAdmin) {
        esAdmin = aEsAdmin;
    }

    public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
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
     * Compares the key for this instance with another Users.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Users and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Users)) {
            return false;
        }
        Users that = (Users) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Users.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Users)) return false;
        return this.equalKeys(other) && ((Users)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Users |");
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
