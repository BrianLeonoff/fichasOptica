package com.hyloptica.fichas.ficha;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FichaService {

    private final FichaRepository fichaRepository;

    
    public FichaService(FichaRepository fichaRepository){
        this.fichaRepository = fichaRepository;
    }

	public List<Ficha> getFichas(){
		return this.fichaRepository.findAll();
    }

    public ResponseEntity<Object> crearFicha(Ficha ficha){
        Optional<Ficha> res = fichaRepository.findFichaByNombre(ficha.getNombre());
        Optional<Ficha> res1 = fichaRepository.findFichaByApellido(ficha.getApellido());
        HashMap<String, Object> datos = new HashMap<>();
        
        if (res.isPresent() && res1.isPresent()){
            datos.put("error",true);
            datos.put("message","Ya existe un paciente con ese nombre");
            return new ResponseEntity<>(
                datos,
                HttpStatus.CONFLICT 
            );
        }  
        fichaRepository.save(ficha);
        datos.put("data", ficha);
        datos.put("message","Se creo la ficha con exito!");
        return new ResponseEntity<>(
            datos,
            HttpStatus.CREATED
        ); 
    }

} 
