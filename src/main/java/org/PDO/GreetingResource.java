package org.PDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.smallrye.common.constraint.NotNull;


@Path("/persona")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    public static List<Persona> personas = new ArrayList<>();

    @POST
    @Transactional
    public Response crearPersona(Persona nuevaPersona){
        personas.add(nuevaPersona);
        return Response.ok(personas).build();
        
    }

    @GET
    @Path("{id}/nombre")
    public Response getPersona(@PathParam("id") int id) {

        List<Persona> id_2 = personas.stream().filter(x-> x.getId() == id).collect(Collectors.toList());

        if(!id_2.isEmpty()){
            return Response.ok(id_2).build();
        }
       return Response.noContent().build();
    }

    @PUT
    @Path("{id}/persona")
    public Response actualizarPersona(@PathParam("id") int id, Persona actualizar){
        personas = personas.stream().map(persona->{
            if(persona.getId() == id){
                persona.setNombre(actualizar.nombre);
                persona.setprimerApellido(actualizar.primerApellido);
                persona.setsegundoApellido(actualizar.segundoApellido);
                persona.setfechaNacimiento(actualizar.fechaNacimiento);
                persona.setdomicilio(actualizar.domicilio);
            }
            return persona;
        }).collect(Collectors.toList());
        return Response.ok(personas).build();
    }

    // @DELETE
    // @Path("{id}")
    // public Response eliminarPersona(@PathParam("id") int id){
    //     Optional<Persona> eliminar = personas.stream().filter(persona -> persona.getId() == id).findFirst();
    //     boolean removed = false;
    //     if(eliminar.isPresent()){
    //         removed = personas.remove(eliminar.get());
    //     }
    //     if(removed){
    //         return Response.noContent().build();
    //     }
    //     return Response.status(Response.Status.BAD_REQUEST).build();
    // }
}