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
	
	

}
