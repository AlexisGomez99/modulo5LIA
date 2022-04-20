package ar.servicios;

import java.util.List;

import ar.model.Estudiante;

public interface Estudiantes {

 List<Estudiante> personas(int legajo);
 List<Estudiante> personas(String apellido);
  
 void crearPersona(String nombre, String apellido,String[] materias,int edad, int legajo, String carrera);

}
