package com.hyloptica.fichas.ficha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/fichas")

public class FichaController {

    private final FichaService fichaService;
    
    @Autowired 
    public FichaController(FichaService fichaService){
        this.fichaService = fichaService;
    }
		
    @GetMapping 
    public List<Ficha> getFichas() {
        return this.fichaService.getFichas();
    }
    
    @PostMapping
    public ResponseEntity<Object> crearFicha (@RequestBody Ficha ficha) {
        return this.fichaService.crearFicha(ficha); 
 
    } 
    
	

}
