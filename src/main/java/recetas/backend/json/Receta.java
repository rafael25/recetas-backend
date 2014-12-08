/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetas.backend.json;

import java.util.Arrays;
import recetas.backend.model.Categorias;
import recetas.backend.model.Imagenes;
import recetas.backend.model.Recetas;

/**
 *
 * @author rafael
 */
public class Receta {
	private Integer id;
	private String nombre;
	private String descripcion;
	private String ingredientes;
	private String preparacion;
	private Integer tiempoPrep;
	private String rendimiento;
	private int[] categorias;
	private int[] imagenes;
	
	public Receta() {}

	public Receta(Recetas r) {
		this.id = r.getId();
		this.nombre = r.getNombre();
		this.descripcion = r.getDescripcion();
		this.ingredientes = r.getIngredientes();
		this.preparacion = r.getPreparacion();
		this.tiempoPrep = r.getTiempoPrep();
		this.rendimiento = r.getRendimiento();
		this.categorias = new int[r.getCategoriasList().size()];
		this.imagenes = new int[r.getImagenesList().size()];
		
		int i = 0;
		for (Categorias c : r.getCategoriasList()) {
			this.categorias[i] = c.getId();
			i += 1;
		}
		
		int j = 0;
		for (Imagenes img : r.getImagenesList()) {
			this.imagenes[j] = img.getId();
			j += 1;
		}
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

	public int[] getCategorias() {
		return categorias;
	}

	public void setCategorias(int[] categorias) {
		this.categorias = categorias;
	}

	public int[] getImagenes() {
		return imagenes;
	}

	public void setImagenes(int[] imagenes) {
		this.imagenes = imagenes;
	}

	@Override
	public String toString() {
		return "Receta{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", ingredientes=" + ingredientes + ", preparacion=" + preparacion + ", tiempoPrep=" + tiempoPrep + ", rendimiento=" + rendimiento + ", categorias=" + Arrays.toString(categorias) + ", imagenes=" + Arrays.toString(imagenes) + '}';
	}
}
