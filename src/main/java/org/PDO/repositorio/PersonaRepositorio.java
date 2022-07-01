package org.PDO.repositorio;

import javax.enterprise.context.ApplicationScoped;
import org.PDO.entidad.Persona;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PersonaRepositorio implements PanacheRepository<Persona>{


}
