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

    HashMap<String, Object> datos;

    private final FichaRepository fichaRepository;

    
    public FichaService(FichaRepository fichaRepository){
        this.fichaRepository = fichaRepository;
    }

	public List<Ficha> getFichas(){
		return this.fichaRepository.findAll();
    }

    public ResponseEntity<Object> crearFicha(Ficha ficha){
        Optional<Ficha> res = fichaRepository.findFichaByNombreAndApellido(ficha.getNombre(), ficha.getApellido());
        datos = new HashMap<>();

        if (res.isPresent() && ficha.getId()==null){
            datos.put("error",true);
            datos.put("message","Ya existe un paciente con ese nombre");
            return new ResponseEntity<>(
                datos,
                HttpStatus.CONFLICT 
            );
        }else{
                datos.put("message","Se creo la ficha con exito!");
            if(ficha.getId() != null){
                datos.put("message","Se actualizo la ficha con exito!");
            }
            fichaRepository.save(ficha);
            datos.put("data", ficha);
            
            return new ResponseEntity<>(
                datos,
                HttpStatus.OK
            ); 
        }  
        
    }

    public ResponseEntity<Object> eliminarFicha(Long id){
        datos = new HashMap<>();
        boolean existe = this.fichaRepository.existsById(id);
        if(!existe){
            datos.put("error",true);
            datos.put("message","No existe una ficha con ese id");
            return new ResponseEntity<>(
                datos,
                HttpStatus.CONFLICT);
        } else {
            fichaRepository.deleteById(id);
            datos.put("message","Ficha eliminada");
            return new ResponseEntity<>(
                datos,
                HttpStatus.OK);
        }
    }

} 
