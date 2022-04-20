package ar.web;

public class EstudianteDto {

 private String nombre;
 private String apellido;
 private String[] materias;
 private int edad;
 private int legajo;
 private String carrera;

 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public String[] getMaterias() {
	return materias;
}

public void setMaterias(String[] materias) {
	this.materias = materias;
}

public String getApellido() {
  return apellido;
 }

 public void setApellido(String apellido) {
  this.apellido = apellido;
 }


public int getEdad() {
	return edad;
}

public void setEdad(int edad) {
	this.edad = edad;
}

public int getLegajo() {
	return legajo;
}

public void setLegajo(int legajo) {
	this.legajo = legajo;
}

public String getCarrera() {
	return carrera;
}

public void setCarrera(String carrera) {
	this.carrera = carrera;
}

}
