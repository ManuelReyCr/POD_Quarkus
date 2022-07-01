package org.PDO.controlador;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.PDO.dto.PersonaDto;
import org.PDO.entidad.Persona;
import org.springframework.web.bind.annotation.PathVariable;


@Path("/persona")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @POST
    @Transactional
    public Response addPersona(PersonaDto personaDto){
        if(Integer.parseInt(personaDto.fechaNacimiento)>=1959 && Integer.parseInt(personaDto.fechaNacimiento)<=2004 ){
            Persona persona = new Persona(personaDto.nombre,personaDto.primerApellido,personaDto.segundoApellido,personaDto.fechaNacimiento,personaDto.domicilio);
            persona.edad = 2022 - Integer.parseInt(personaDto.fechaNacimiento);
            persona.fechaNacimiento = persona.fechaNacimiento + "/01/01";
            persona.persist();
            return Response.ok(persona).build();
        }
        return Response.noContent().build();
    }   

    @GET
    @Path("/{id}/nombre")
    public Persona getPersona(@PathVariable("id") long id){
        return Persona.findById(id);
    }

    @PUT
    @Path("/{id}/persona")
    @Transactional
    public Response actualizar(@PathParam("id") Long id,PersonaDto personaDto){
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
                return Response.ok(persona).build();
            }
        }
    
        return Response.noContent().build();
    }
}