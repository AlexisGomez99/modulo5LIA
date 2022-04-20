package ar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Estudiante {

 private String nombre;
 private String apellido;
 private int edad;
 private int numLegajo;
 private String carrera;
 private List<Materia> materias;

 public Estudiante(String nombre, String apellido, int edad, int legajo, String carrera) {
  this.nombre = new NotNullNotEmpty(nombre).value();
  this.apellido = new NotNullNotEmpty(apellido).value();
  this.materias = new ArrayList<>();
  this.edad = edad;
  this.numLegajo = legajo;
  this.carrera = carrera;
 }

 public void addMateria(String nombreMateria) {
	  this.materias.add(new Materia(new NotNullNotEmpty(nombreMateria).value()));
	 }

 public void addMaterias(String[] nombres) {
	  
	  String[] materias = new NotNullNotEmpty(nombres).values();
	  
	  var mat = List.of(materias).stream().map((n) -> {
	   return new Materia(n);
	  }).collect(Collectors.toList());
	  
	  this.materias.addAll(mat);
	 }
 
 public String nombre() {
  return nombre + " " + apellido;
 }


 public Map<String, Object> toMap() {
  var map = new HashMap<String, Object>(
    Map.of("nombre", nombre, "apellido", apellido,"edad",edad,"legajo",numLegajo,"carrera",carrera));


  if (this.materias != null && this.materias.size() > 0) {
	   map.put("materias", materias.stream().map((m) -> m.toMap())
	     .collect(Collectors.toList()));
	  }
  return map;
 }

 public boolean containsLegajo(int legajo) {
  return this.numLegajo == legajo;
 }
 public boolean containsApellido(String apellido) {
	  return this.apellido.contains(apellido);
	 }
}
