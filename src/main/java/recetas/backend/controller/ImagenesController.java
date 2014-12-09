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
import recetas.backend.json.Imagen;
import recetas.backend.model.DAOImagenes;
import recetas.backend.model.DAORecetas;
import recetas.backend.model.Imagenes;
import recetas.backend.model.Recetas;

/**
 *
 * @author rafael
 */
@Controller
@RequestMapping("/imagenes")
public class ImagenesController {
	
	@RequestMapping(method = RequestMethod.GET, headers = {"Accept=Application/json;Content-Type:Application/json; charset=utf-8"})
    public @ResponseBody String index() throws IOException {
		DAOImagenes dao = new DAOImagenes();
		return dao.buscar();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET, headers = {"Accept=Application/json;Content-Type:Application/json; charset=utf-8"})
    public @ResponseBody String show(@PathVariable Integer id) throws IOException {
		DAOImagenes dao = new DAOImagenes();
		return dao.buscar(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = {"Accept=Application/json;Content-Type:Application/json; charset=utf-8"})
    public @ResponseBody String save(@RequestBody String data) throws IOException {
		DAOImagenes dao = new DAOImagenes();
		ObjectMapper mapper = new ObjectMapper();
		DAORecetas daoRecetas = new DAORecetas();
		
		JsonNode jnode = mapper.readValue(data, JsonNode.class);
		Imagen jimg = mapper.readValue(jnode.get("imagen"), Imagen.class);
		Recetas r = daoRecetas.buscarReceta(Integer.parseInt(jimg.getReceta()));
		Imagenes img = new Imagenes();
		img.setUrl(jimg.getUrl());
		img.setReceta(r);
		
		return dao.guardar(img);
	}
}
