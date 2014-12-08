/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetas.backend.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author rafael
 */
@Entity
@Table(name = "categorias")
public class Categorias implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@JoinTable(name = "categoria_receta", joinColumns = {
    	@JoinColumn(name = "id_categoria", referencedColumnName = "id")}, inverseJoinColumns = {
    	@JoinColumn(name = "id_receta", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Recetas> recetasList;

	public Categorias() {
	}

	public Categorias(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Recetas> getRecetasList() {
		return recetasList;
	}

	public void setRecetasList(List<Recetas> recetasList) {
		this.recetasList = recetasList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Categorias)) {
			return false;
		}
		Categorias other = (Categorias) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "recetas.backend.model.Categorias[ id=" + id + " ]";
	}
	
}
