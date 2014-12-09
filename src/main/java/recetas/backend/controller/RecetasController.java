/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetas.backend.controller;

import java.io.IOException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import recetas.backend.json.Receta;
import recetas.backend.model.DAORecetas;
import recetas.backend.model.Recetas;

/**
 *
 * @author rafael
 */
@Controller
@RequestMapping("/recetas")
public class RecetasController {
	
	@RequestMapping(method = RequestMethod.GET, headers = {"Accept=Application/json;Content-Type:Application/json; charset=utf-8"})
    public @ResponseBody String index() throws IOException {
		DAORecetas dao = new DAORecetas();
		return dao.buscar();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET, headers = {"Accept=Application/json;Content-Type:Application/json; charset=utf-8"})
    public @ResponseBody String show(@PathVariable Integer id) throws IOException {
		DAORecetas dao = new DAORecetas();
		return dao.buscar(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = {"Accept=Application/json;Content-Type:Application/json; charset=utf-8"})
	public @ResponseBody String save(@RequestBody String data) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		DAORecetas dao = new DAORecetas();
		JsonNode jnode = mapper.readValue(data, JsonNode.class);
		Receta r = mapper.readValue(jnode.get("receta"), Receta.class);
		
		Recetas receta = r.getRecetas();
		return dao.guardar(receta);
	}
}
