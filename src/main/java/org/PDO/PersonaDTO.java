package org.PDO;

public class PersonaDTO {

    public String nombre;
    public String primerApellido;
    public String segundoApellido;
    public int fechaNacimiento;
    public String domicilio;

    public PersonaDTO(){

    }

    public PersonaDTO(String nombre, String primerApellido, String segundoApellido, int fechaNacimiento, String domicilio ){
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

    public void setprimerApellido(String primerApellido){
        this.primerApellido = primerApellido;
    }

    public String getsegundoApellido(){
        return segundoApellido;
    }

    public void setsegundoApellido(String segundoApellido){
        this.segundoApellido = segundoApellido;
    }

    public int getfechaNacimiento(){
        return fechaNacimiento;
    }
    public void setfechaNacimiento(int fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getdomicilio(){
        return domicilio;
    }

    public void setdomicilio(String domicilio){
        this.domicilio = domicilio;
    }
}
