/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetas.backend.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import recetas.backend.model.DAOCategorias;

/**
 *
 * @author rafael
 */
@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@RequestMapping(method = RequestMethod.GET, headers = {"Accept=Application/json;Content-Type:Application/json; charset=utf-8"})
    public @ResponseBody String index() throws IOException {
		DAOCategorias dao = new DAOCategorias();
		return dao.buscar();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET, headers = {"Accept=Application/json;Content-Type:Application/json; charset=utf-8"})
    public @ResponseBody String show(@PathVariable Integer id) throws IOException {
		DAOCategorias dao = new DAOCategorias();
		return dao.buscar(id);
	}
}
