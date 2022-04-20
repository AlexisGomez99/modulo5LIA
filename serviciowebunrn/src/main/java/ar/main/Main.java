package ar.main;
import ar.jdbc.JdbcMaterias;
import ar.jdbc.JdbcEstudiante;
import ar.web.WebAPI;

public class Main {

 public static void main(String[] args) {
  WebAPI servicio = new WebAPI(new JdbcMaterias(), new JdbcEstudiante(),
    1234);
  servicio.start();
 }
}
