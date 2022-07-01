package org.PDO;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.given;

import org.PDO.entidad.Persona;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GreetingResourceTest {

    @Test
    @Order(1)
    public void testAddPersona(){
      Persona persona = new Persona();
      persona.setNombre("manuel");
      persona.setPrimerApellido("rey");
      persona.setSegundoApellido("cruz");
      persona.setFechaNacimiento("2002");
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