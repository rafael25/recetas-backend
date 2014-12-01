/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetas.backend.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author rafael
 */
@Entity
@Table(name = "recetas")
public class Recetas implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	@Lob
    @Column(name = "ingredientes")
	private String ingredientes;
	@Lob
    @Column(name = "preparacion")
	private String preparacion;
	@Column(name = "tiempo_prep")
	private Integer tiempoPrep;
	@Column(name = "rendimiento")
	private String rendimiento;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "recetasList")
	@JsonIgnore
	private List<Categorias> categoriasList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idReceta")
	@JsonIgnore
	private List<Imagenes> imagenesList;

	public Recetas() {
	}

	public Recetas(Integer id) {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public Integer getTiempoPrep() {
		return tiempoPrep;
	}

	public void setTiempoPrep(Integer tiempoPrep) {
		this.tiempoPrep = tiempoPrep;
	}

	public String getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(String rendimiento) {
		this.rendimiento = rendimiento;
	}

	public List<Categorias> getCategoriasList() {
		return categoriasList;
	}

	public void setCategoriasList(List<Categorias> categoriasList) {
		this.categoriasList = categoriasList;
	}

	public List<Imagenes> getImagenesList() {
		return imagenesList;
	}

	public void setImagenesList(List<Imagenes> imagenesList) {
		this.imagenesList = imagenesList;
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
		if (!(object instanceof Recetas)) {
			return false;
		}
		Recetas other = (Recetas) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "recetas.backend.model.Recetas[ id=" + id + " ]";
	}
	
}
