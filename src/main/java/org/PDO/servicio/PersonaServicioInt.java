package org.PDO.servicio;

import org.PDO.dto.PersonaDto;
import org.PDO.entidad.Persona;

public interface PersonaServicioInt {

    Persona addPersona(PersonaDto personaDto);

    Persona getPersona(Long id);

    Persona actualizar(Long id, PersonaDto personaModificar);
}
