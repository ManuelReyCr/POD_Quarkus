package org.PDO.servicio;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import org.PDO.dto.PersonaDto;
import org.PDO.entidad.Persona;
import org.PDO.repositorio.PersonaRepositorio;

@ApplicationScoped
public class PersonaServicio implements PersonaServicioInt{

    @Inject
    PersonaRepositorio personaRepositorio;

    @Transactional
    public Persona getPersona(Long id){
        return personaRepositorio.findById(id);
    }

    
    @Transactional 
    public Persona addPersona(PersonaDto personaDto){
        if(Integer.parseInt(personaDto.fechaNacimiento)<=1959 && Integer.parseInt(personaDto.fechaNacimiento)>=2004 ){
            throw new WebApplicationException("Persona no registrada", 404);
        }
        Persona persona = new Persona(personaDto.nombre,personaDto.primerApellido,personaDto.segundoApellido,personaDto.fechaNacimiento,personaDto.domicilio);
        persona.edad = 2022 - Integer.parseInt(personaDto.fechaNacimiento);
        persona.fechaNacimiento = persona.fechaNacimiento + "/01/01";
        persona.persist();   
        return persona;
    }

    @Transactional
    public Persona actualizar(Long id,PersonaDto personaDto){
        Persona persona = Persona.findById(id);
        if(persona == null){
            throw new WebApplicationException("Persona no registrada", 404);
        }else{
            if(Integer.parseInt(personaDto.fechaNacimiento)>=1959 && Integer.parseInt(personaDto.fechaNacimiento)<=2004 ){
                persona.nombre = personaDto.nombre;
                persona.primerApellido = personaDto.primerApellido;
                persona.segundoApellido = personaDto.segundoApellido;
                persona.fechaNacimiento = personaDto.fechaNacimiento;
                persona.domicilio = personaDto.domicilio;
                persona.edad = 2022 - Integer.parseInt(personaDto.fechaNacimiento);
                persona.fechaNacimiento = persona.fechaNacimiento + "/01/01";
                persona.persist();
                return persona;
            }
        }
    
       return null;
    }
}
