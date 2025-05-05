package com.practica.libros.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AutoIncrementLibroService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void ajustarAutoIncrement() {
        // Consulta SQL para obtener el valor máximo de ID
        Integer maxId = jdbcTemplate.queryForObject("SELECT MAX(id) FROM libro", Integer.class);
        
        // Ajustar el AUTO_INCREMENT al valor máximo + 1
        if (maxId != null) {
            jdbcTemplate.update("ALTER TABLE libro AUTO_INCREMENT = ?", maxId + 1);
        }
    }
}
