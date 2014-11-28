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
	public String buscar(Integer id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
