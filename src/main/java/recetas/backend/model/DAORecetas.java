/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetas.backend.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Recetas> recetas = (ArrayList<Recetas>) cricri.list();
		Map<String, ArrayList<Recetas>> map = Collections.singletonMap("recetas", recetas);
		
		this.closeCommit();
		return mapper.writeValueAsString(map);
	}

	@Override
	public String buscar(Integer id) throws IOException {
		Criteria cricri = this.session.createCriteria(Recetas.class).add(Restrictions.idEq(id));
		ObjectMapper mapper = new ObjectMapper();
		Recetas r = (Recetas) cricri.uniqueResult();
		
		this.closeCommit();
		return mapper.writeValueAsString(r);
	}

	@Override
	public String guardar(Object entity) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Recetas r = (Recetas) entity;
		this.session.save(r);
		this.closeCommit();
		return mapper.writeValueAsString(r);
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
}
