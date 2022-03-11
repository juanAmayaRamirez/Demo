package com.API.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.dao.personaDao;
import com.API.model.personaa;

import java.util.List;

@RestController
@RequestMapping("personas")
public class personaRest {
	@Autowired
	private personaDao personaDao;
	//Metodos HTTP de solicitud
	
	//GET,POST,PUT,DELETE -> 200-500-404 estado en el cual devuelve la respuesta
	//get para recibir información
	@GetMapping("/lista")
	public List<personaa> lista(){
		return personaDao.findAll();
	}
	//post para mandar información
	@PostMapping("/guardar")
	public void guardar(@RequestBody personaa persona) {
		//Requestbody convierte el JSON de entrada a una clase de java en este caso de tipo persona
		personaDao.save(persona);
	}
	//Delete eliminar una entrada
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		personaDao.deleteById(id);
	}
	//actualizar
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody personaa persona) {
		personaDao.save(persona);
	}
}
