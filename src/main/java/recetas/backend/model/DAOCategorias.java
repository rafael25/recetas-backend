/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetas.backend.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import recetas.backend.json.Receta;

/**
 *
 * @author rafael
 */
public class DAOCategorias extends DAO {
	
	public DAOCategorias() {
		this.openBegin();
	}

	@Override
	public String buscar() throws IOException {
		Criteria cricri = this.session.createCriteria(Categorias.class);
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Categorias> categorias = (ArrayList<Categorias>) cricri.list();
		Map<String, ArrayList<Categorias>> map = Collections.singletonMap("categorias", categorias);
		
		this.closeCommit();
		return mapper.writeValueAsString(map);
	}

	@Override
	public String buscar(Integer id) throws IOException {
		Criteria cricri = this.session.createCriteria(Categorias.class).add(Restrictions.idEq(id));
		ObjectMapper mapper = new ObjectMapper();
		
		Categorias categoria = (Categorias) cricri.uniqueResult();
		Hibernate.initialize(categoria.getRecetasList());
		List<Recetas> recetas = categoria.getRecetasList();
		
		ArrayList<Object> recetaList = new ArrayList<Object>();
		
		for (Recetas r : recetas) {
			Receta rjson = new Receta(r);
			recetaList.add(rjson);
		}
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("categoria", categoria);
		map.put("recetas", recetaList);
		
		this.closeCommit();
		return mapper.writeValueAsString(map);
	}

	@Override
	public String guardar(Object entity) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Categorias c = (Categorias) entity;
		this.session.save(c);
		this.closeCommit();
		return mapper.writeValueAsString(c);
	}

	@Override
	public String actualizar(Object entity) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Categorias c = (Categorias) entity;
		this.session.update(c);
		this.closeCommit();
		return mapper.writeValueAsString(c);
	}

	@Override
	public String borrar(Object entity) throws IOException {
		Categorias c = (Categorias) entity;
		this.session.delete(c);
		this.closeCommit();
		return "";
	}
	
}
