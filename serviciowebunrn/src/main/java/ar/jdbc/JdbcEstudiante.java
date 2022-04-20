package ar.jdbc;

import java.util.List;
import java.util.stream.Collectors;

import ar.model.Estudiante;
import ar.servicios.Estudiantes;

public class JdbcEstudiante implements Estudiantes {

 //constructor con dependencias
 
 @Override
 public List<Estudiante> personas(String apellido) {
  Estudiante p1 = new Estudiante("Joaquin", "Garcia",18, 23414,"Lic. Sistemas");
  Estudiante p2 = new Estudiante("Emilio", "Peroz",20,12341,"Agronomia");
  Estudiante p3 = new Estudiante("Ernesto", "Perez",23,12412,"Abogacia");
  
  
  p1.addMateria("Matematicas");
  p2.addMateria("Matematicas");
  p3.addMateria("Matematicas");
  p2.addMateria("Sistemas y Organizaciones");
  
  
  var personas = List.of(p1, p2, p3);
  
  if (apellido == null || apellido.isEmpty())
   return personas;
  
  return personas.stream().filter((p) -> {
   return p.containsApellido(apellido);
  }).collect(Collectors.toList());
 }

 @Override
 public void crearPersona(String nombre, String apellido,
  String[] materias,int edad, int legajo, String carrera) {

  Estudiante p = new Estudiante(nombre, apellido,edad,legajo,carrera);
  p.addMaterias(materias);
  
 }

@Override
public List<Estudiante> personas(int legajo) {
	Estudiante p1 = new Estudiante("Joaquin", "Garcia",18, 23414,"Lic. Sistemas");
	  Estudiante p2 = new Estudiante("Emilio", "Peroz",20,12341,"Agronomia");
	  Estudiante p3 = new Estudiante("Ernesto", "Perez",23,12412,"Abogacia");
	  	  
	  p1.addMateria("Matematicas");
	  p2.addMateria("Matematicas");
	  p3.addMateria("Matematicas");
	  p2.addMateria("Sistemas y Organizaciones");
	  	  
	  var personas = List.of(p1, p2, p3);
	  
	  if (legajo == 0 )
	   return personas;
	  
	  return personas.stream().filter((p) -> {
	   return p.containsLegajo(legajo);
	  }).collect(Collectors.toList());
}
}
