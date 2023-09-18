// Generated with g9.

package com.example.proyecto.dto;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
@JsonIgnoreProperties(value = {"authorities"})
@Table(name="users")
public class Users implements UserDetails{

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;
    
    @Column(name="nombre", length=255)
    private String nombre;
    
    @Column(name="password", length=25)
    private String password;
    
    @Column(name="email", unique=true, nullable=false, length=255)
    private String username;
    
    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Lob
    @Column(name="foto_perfil", columnDefinition="BLOB")
    private byte[] fotoPerfil;
    
    @Lob
    @Column(name="foto_portada", columnDefinition="BLOB")
    private byte[] fotoPortada;
        
    @ManyToOne
    @JoinColumn(name = "role")
    private Roles roles;

    @OneToMany(mappedBy="users",fetch = FetchType.LAZY)
    private List<Acciones> acciones;

//    @OneToMany(mappedBy="users",fetch = FetchType.LAZY)
//    private List<Comentarios> comentarios;
    
    
	@JsonIgnore
	public List<Acciones> getAcciones() {
		return acciones;
	}


	//USER DETAILS
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    if (roles != null) {
	        return List.of(new SimpleGrantedAuthority(roles.getNombre()));
	    } else {
	        return Collections.emptyList(); 
	    }
	}


	@Override
	public String getPassword() {
		return this.password;
	}


	@Override
	public String getUsername() {
		return this.username;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}

}
