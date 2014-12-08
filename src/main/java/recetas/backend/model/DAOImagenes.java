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
public class DAOImagenes extends DAO {
	
	public DAOImagenes() {
		this.openBegin();
	}

	@Override
	public String buscar() throws IOException {
		Criteria cricri = this.session.createCriteria(Imagenes.class);
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Imagenes> imagenes = (ArrayList<Imagenes>) cricri.list();
		
		Map<String, ArrayList<Imagenes>> map = Collections.singletonMap("imagenes", imagenes);
		
		this.closeCommit();
		return mapper.writeValueAsString(map);
	}

	@Override
	public String buscar(Integer id) throws IOException {
		Criteria cricri = this.session.createCriteria(Imagenes.class).add(Restrictions.idEq(id));
		ObjectMapper mapper = new ObjectMapper();
		
		Imagenes imagen = (Imagenes) cricri.uniqueResult();
		Map<String, Imagenes> map = Collections.singletonMap("imagen", imagen);
		
		this.closeCommit();
		return mapper.writeValueAsString(map);
	}

	@Override
	public String guardar(Object entity) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Imagenes i = (Imagenes) entity;
		this.session.save(i);
		this.closeCommit();
		return mapper.writeValueAsString(i);
	}

	@Override
	public String actualizar(Object entity) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Imagenes i = (Imagenes) entity;
		this.session.update(i);
		this.closeCommit();
		return mapper.writeValueAsString(i);
	}

	@Override
	public String borrar(Object entity) throws IOException {
		Imagenes i = (Imagenes) entity;
		this.session.delete(i);
		this.closeCommit();
		return "";
	}
	
}
