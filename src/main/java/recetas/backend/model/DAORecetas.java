/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetas.backend.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import recetas.backend.json.Receta;

/**
 *
 * @author rafael
 */
public class DAORecetas extends DAO {

	public DAORecetas() {
		this.openBegin();
	}

	@Override
	public String buscar() throws IOException {
		Criteria cricri = this.session.createCriteria(Recetas.class);
		Criteria cricri2 = this.session.createCriteria(Imagenes.class);
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Recetas> recetas = (ArrayList<Recetas>) cricri.list();
		ArrayList<Object> imagenes = (ArrayList<Object>) cricri2.list();
		ArrayList<Object> recetaList = new ArrayList<Object>();
		
		for (Recetas r : recetas) {
			Receta rjson = new Receta(r);
			recetaList.add(rjson);
		}
		
		Map<String, ArrayList<Object>> map = new LinkedHashMap<String, ArrayList<Object>>();
		map.put("recetas", recetaList);
		map.put("imagenes", imagenes);
		
		this.closeCommit();
		return mapper.writeValueAsString(map);
	}

	@Override
	public String buscar(Integer id) throws IOException {
		Criteria cricri = this.session.createCriteria(Recetas.class).add(Restrictions.idEq(id));
		ObjectMapper mapper = new ObjectMapper();
		Recetas r = (Recetas) cricri.uniqueResult();
		Receta rJson = new Receta(r);
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("receta", rJson);
		map.put("imagenes", r.getImagenesList());
		map.put("categorias", r.getCategoriasList());
		
		this.closeCommit();
		return mapper.writeValueAsString(map);
	}

	@Override
	public String guardar(Object entity) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Recetas r = (Recetas) entity;
		this.session.save(r);
		
		Receta rJson = new Receta(r, false);
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("receta", rJson);
		
		this.closeCommit();
		return mapper.writeValueAsString(map);
	}

	@Override
	public String actualizar(Object entity) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Recetas r = (Recetas) entity;
		this.session.update(r);
		this.closeCommit();
		return mapper.writeValueAsString(r);
	}

	@Override
	public String borrar(Object entity) throws IOException {
		Recetas r = (Recetas) entity;
		this.session.delete(r);
		this.closeCommit();
		return "";
	}
	
	public Recetas buscarReceta(Integer id) {
		Criteria cricri = this.session.createCriteria(Recetas.class).add(Restrictions.idEq(id));
		Recetas r = (Recetas) cricri.uniqueResult();
		this.closeCommit();
		return r;
	}
}
