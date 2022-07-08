package org.PDO.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import org.PDO.dto.PersonaDto;
import org.PDO.entidad.Persona;
import org.PDO.repositorio.PersonaRepositorio;

@ApplicationScoped
public class PersonaServicio{
 
   private Date today = Calendar.getInstance().getTime();
   private Date this_year = new GregorianCalendar((today.getYear() + 1900), today.getMonth(), today.getDay()).getTime();

    @Inject
    PersonaRepositorio personaRepositorio;

    @Transactional
    public Persona getPersona(Long id){
        return personaRepositorio.findById(id);
    }

    @Transactional 
    public Persona addPersona(PersonaDto personaDto){
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.YEAR, -63);
        c.add(Calendar.DATE, -364);
        Date limiteInferior = c.getTime();
        Calendar e = Calendar.getInstance();
        e.setTime(today);
        e.add(Calendar.YEAR, -18);
        e.add(Calendar.DATE, -364);
        Date limiteSuperior = e.getTime();
        int x = personaDto.fechaNacimiento.compareTo(limiteInferior);
        int y = personaDto.fechaNacimiento.compareTo(limiteSuperior);
        if( ( x == -1 || x == 0 ) || ( y == 1 || y == 0)){
            throw new WebApplicationException("Persona no registrada", 404);
        }
        Persona persona = new Persona(personaDto.nombre,personaDto.primerApellido,personaDto.segundoApellido,personaDto.fechaNacimiento,personaDto.domicilio);
        persona.edad =  today.getYear() - persona.fechaNacimiento.getYear();
        persona.persist();   
        return persona;
    }

    @Transactional
    public Persona actualizar(Long id,PersonaDto personaDto){
        Persona persona = Persona.findById(id);
        if(persona == null){
            throw new WebApplicationException("Persona no registrada", 404);
        }else{
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.YEAR, -63);
        c.add(Calendar.DATE, -364);
        Date limiteInferior = c.getTime();
        Calendar e = Calendar.getInstance();
        e.setTime(today);
        e.add(Calendar.YEAR, -18);
        e.add(Calendar.DATE, -364);
        Date limiteSuperior = e.getTime();
        int x = personaDto.fechaNacimiento.compareTo(limiteInferior);
        int y = personaDto.fechaNacimiento.compareTo(limiteSuperior);
            if(  ( x == 1 ) && ( y == -1 )){
                persona.nombre = personaDto.nombre;
                persona.primerApellido = personaDto.primerApellido;
                persona.segundoApellido = personaDto.segundoApellido;
                persona.fechaNacimiento = personaDto.fechaNacimiento;
                persona.domicilio = personaDto.domicilio;
                persona.edad =  today.getYear() - persona.fechaNacimiento.getYear();
                persona.persist();
                return persona;
            }
        }
    
       return null;
    }
}
