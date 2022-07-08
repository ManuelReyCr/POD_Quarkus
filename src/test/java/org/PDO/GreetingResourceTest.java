package org.PDO;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.given;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.PDO.entidad.Persona;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GreetingResourceTest {

    @Test
    @Order(1)
    public void testAddPersona(){
      Persona persona = new Persona();
      Date date = new GregorianCalendar(2002, Calendar.OCTOBER, 18).getTime();
      persona.setNombre("manuel");
      persona.setPrimerApellido("rey");
      persona.setSegundoApellido("cruz");
      persona.setFechaNacimiento(date);
      persona.setDomicilio("av.siempre viva #111");
      given()
        .contentType("application/json")
        .body(persona)
        .post("/persona")
        .then()
        .statusCode(200);
    }

    @Test
    @Order(2)
    public void testGetPersona(){
        given()
            .when()
            .get("/persona/1/nombre")
            .then()
            .statusCode(200);
    }

}