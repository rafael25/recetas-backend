/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetas.backend.json;

import recetas.backend.model.Categorias;
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

	public Receta(Recetas r) {
		this.id = r.getId();
		this.nombre = r.getNombre();
		this.descripcion = r.getDescripcion();
		this.ingredientes = r.getIngredientes();
		this.preparacion = r.getPreparacion();
		this.tiempoPrep = r.getTiempoPrep();
		this.rendimiento = r.getRendimiento();
		this.categorias = new int[r.getCategoriasList().size()];
		
		int i = 0;
		for (Categorias c : r.getCategoriasList()) {
			this.categorias[i] = c.getId();
			i += 1;
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
}
