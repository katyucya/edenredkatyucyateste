package com.herokuapp.edenredkatyucyateste.dao.inter;


import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuapp.edenredkatyucyateste.entity.Email;

public interface InterEmailDAO extends JpaRepository<Email, Integer> {
    
}