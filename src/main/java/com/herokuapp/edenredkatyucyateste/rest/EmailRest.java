package com.herokuapp.edenredkatyucyateste.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.edenredkatyucyateste.dao.inter.InterEmailDAO;
import com.herokuapp.edenredkatyucyateste.entity.Email;

@EnableAutoConfiguration
@RestController
public class EmailRest {

	@Autowired
	private InterEmailDAO interEmailDAO;
	 
	@RequestMapping(value="/emailrest/lista",method = RequestMethod.GET)
	public  List<Email>  getListaEmail() {
		return (List<Email>) interEmailDAO.findAll();
	}
		
	@RequestMapping(value="/emailrest/salvar",method = RequestMethod.POST)
	public  String salvar(Email j) {
		Email jog=interEmailDAO.save(j);
		if(jog!=null) {			
			return "ok";
		}else {
			return "erro";
		}
	}	 	
	@RequestMapping(value="/emailrest/buscarporid",method = RequestMethod.POST)
	public  Email buscarPorId(@RequestParam("idEmail") Integer id) {
		Email e=interEmailDAO.findById(id).orElse(null);
		return e;
	}
	 
	@RequestMapping(value="/emailrest/deletar",method = RequestMethod.POST)
	public  String deletar(@RequestParam("idEmail") Integer id) {
		 interEmailDAO.deleteById(id); 
		 Email e=interEmailDAO.findById(id).orElse(null);
		 if(e==null) {
			 return "ok";
		 }else {
			 return "erro";
		 }
		 
	}
	
}

