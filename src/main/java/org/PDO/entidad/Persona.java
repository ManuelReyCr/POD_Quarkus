package org.PDO.entidad;

import java.util.Date;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Persona extends PanacheEntity{

    public String nombre;
    public String primerApellido;
    public String segundoApellido;
    public Date fechaNacimiento;
    public String domicilio;
    public int edad;

    public Persona(){

    }

    public Persona(String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String domicilio ){
        this.nombre=nombre;
        this.primerApellido=primerApellido;
        this.segundoApellido=segundoApellido;
        this.fechaNacimiento=fechaNacimiento;
        this.domicilio=domicilio;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getprimerApellido(){
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido){
        this.primerApellido = primerApellido;
    }

    public String getsegundoApellido(){
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido){
        this.segundoApellido = segundoApellido;
    }

    public Date getfechaNacimiento(){
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getdomicilio(){
        return domicilio;
    }

    public void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad =edad;
    }
    

}
