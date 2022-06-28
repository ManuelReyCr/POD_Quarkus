package org.PDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import io.smallrye.common.constraint.NotNull;

public class Persona {

    public int id;
    public String nombre;
    public String primerApellido;
    public String segundoApellido;
    public String fechaNacimiento;
    public String domicilio;

    public Persona(){

    }

    public Persona( int id, String nombre, String primerApellido, String segundoApellido, String fechaNacimiento, String domicilio ){
        this.id=id;
        this.nombre=nombre;
        this.primerApellido=primerApellido;
        this.segundoApellido=segundoApellido;
        this.fechaNacimiento=fechaNacimiento;
        this.domicilio=domicilio;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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

    public void setprimerApellido(String primerApellido){
        this.primerApellido = primerApellido;
    }

    public String getsegundoApellido(){
        return segundoApellido;
    }

    public void setsegundoApellido(String segundoApellido){
        this.segundoApellido = segundoApellido;
    }

    public String getfechaNacimiento(){
        return fechaNacimiento;
    }
    public void setfechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getdomicilio(){
        return domicilio;
    }

    public void setdomicilio(String domicilio){
        this.domicilio = domicilio;
    }

}
