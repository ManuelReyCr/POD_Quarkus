package org.PDO.controlador;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.PDO.dto.PersonaDto;
import org.PDO.entidad.Persona;
import org.PDO.servicio.PersonaServicio;
import org.springframework.web.bind.annotation.PathVariable;

@Path("/persona")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    PersonaServicio personaServicio;

    @POST
    @Transactional
    public Persona addPersona(PersonaDto personaDto){
        return personaServicio.addPersona(personaDto);
    }   

    @GET
    @Path("/{id}/nombre")
    public Persona getPersona(@PathVariable("id") long id){
        return personaServicio.getPersona(id);
    }

    @PUT
    @Path("/{id}/persona")
    @Transactional
    public Persona actualizar(@PathParam("id") Long id,PersonaDto personaDto){
        return personaServicio.actualizar(id, personaDto);
    }
}