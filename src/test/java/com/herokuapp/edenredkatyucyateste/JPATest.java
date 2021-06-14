package com.herokuapp.edenredkatyucyateste;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.herokuapp.edenredkatyucyateste.dao.inter.InterEmailDAO;
import com.herokuapp.edenredkatyucyateste.entity.Email;
@RunWith(SpringRunner.class)
class JPATest {
	@Autowired
	InterEmailDAO interEmailDAO;
	
	@Test
	void testeInserir() {
		Email e=new Email();
		e.setNome("Fulano");
		e.setCorreioEmail("fulano@gmail.com");
		
		interEmailDAO.save(e);
		
		Email emailBusca=interEmailDAO.findOne((Example<Email>) e).orElse(new Email());
	     
	    // then
	    assertThat(e.getNome())
	      .isEqualTo(emailBusca.getNome());
	}
	
	@Test
	void testeAlterar() {
		Email e=new Email();
		e.setNome("Fulano");
		e.setCorreioEmail("fulano@gmail.com");
		interEmailDAO.save(e);
		Email emailBusca=interEmailDAO.findOne((Example<Email>) e).orElse(new Email());
		emailBusca.setNome("Ciclano");
		interEmailDAO.save(emailBusca);
		Email emailBuscaSalvo=interEmailDAO.findOne((Example<Email>) e).orElse(new Email());
		assertThat(emailBuscaSalvo.getNome())
	      .isNotEqualTo(emailBusca.getNome());
				 
	    
	}
	
	@Test
	void testeDeletar() {
		Email e=new Email();
		e.setNome("Katyucya");
		e.setCorreioEmail("katyucya@gmail.com");
		
		interEmailDAO.save(e);
		
		Email emailBusca=interEmailDAO.findOne((Example<Email>) e).orElse(new Email());
	      
		interEmailDAO.deleteById(emailBusca.getIdEmail());
		
		Email deletado= interEmailDAO.findOne((Example<Email>) e).orElse(new Email());
	    // then
	    assertThat(deletado.getIdEmail()==null);
	}

}
