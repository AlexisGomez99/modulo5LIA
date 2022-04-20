package ar.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ar.model.Materia;
import ar.model.Estudiante;
import ar.model.PersonaException;

import ar.servicios.Materias;
import ar.servicios.Estudiantes;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class WebAPI {

 private Estudiantes estudiantes;
 private Materias materias;
 private int webPort;

 public WebAPI(Materias materias,Estudiantes estudiantes, int webPort) {
  this.estudiantes = estudiantes;

  this.materias = materias;
  this.webPort = webPort;
 }

 public void start() {
  Javalin app = Javalin.create(config -> {
   config.enableCorsForAllOrigins();
  }).start(this.webPort);
  app.get("/estudiantes", traerEstudiante());
  app.get("/materias", traerMaterias());
  app.get("/estudiantesid", traerEstudianteId());
  app.post("/estudiantes", crearEstudiante());

  app.exception(PersonaException.class, (e, ctx) -> {
   ctx.json(Map.of("result", "error", "message", e.getMessage()));
   // log error in a stream...
  });  
  
  app.exception(Exception.class, (e, ctx) -> {
   ctx.json(Map.of("result", "error", "message", "Ups... algo se rompió.: " + e.getMessage()));
   // log error in a stream...
  });
 }


 private Handler crearEstudiante() {
  return ctx -> {
   EstudianteDto dto = ctx.bodyAsClass(EstudianteDto.class);
   this.estudiantes.crearPersona(dto.getNombre(), dto.getApellido(), dto.getMaterias(),dto.getEdad(),dto.getLegajo(),dto.getCarrera());
   ctx.json(Map.of("result", "success"));
  };
 }

 private Handler traerEstudiante() {
  return ctx -> {
   String apellido = ctx.queryParam("apellido");
   List<Estudiante> estudiantes = this.estudiantes.personas(apellido);

   var list = new ArrayList<Map<String, Object>>();

   for (Estudiante p : estudiantes) {
    list.add(p.toMap());
   }

   ctx.json(Map.of("result", "success", "estudiantes", list));

  };
 }
  private Handler traerEstudianteId() {
	  return ctx -> {
	   String id = ctx.queryParam("legajo");
	   List<Estudiante> estudiantes = this.estudiantes.personas(Integer.parseInt(id));

	   var list = new ArrayList<Map<String, Object>>();

	   for (Estudiante p : estudiantes) {
	    list.add(p.toMap());
	   }

	   ctx.json(Map.of("result", "success", "estudiantes", list));

	  };
 }
  private Handler traerMaterias() {
      return ctx -> {
          List<Materia> materias = this.materias.materias();
          System.out.println(materias.toString());
          var list = new ArrayList<Map<String, String>>();

          for (Materia m : materias) {
              list.add(m.toMap());
          }

          ctx.json(Map.of("result", "success", "materias", list));

      };
  }
}
