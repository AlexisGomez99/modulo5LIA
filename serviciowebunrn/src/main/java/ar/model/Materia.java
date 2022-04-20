package ar.model;

import java.util.Map;

public class Materia {
	
	private String nombre;

	 public Materia(String nombre) {
	  this.nombre = nombre;
	 }

	 public String numero() {
	  return nombre;
	 }

	 public Map<String, String> toMap() {
	  return Map.of("materia", nombre);
	 }

	 @Override
	 public String toString() {
	  return "Materia [materia=" + nombre + "]";
	 }

}
