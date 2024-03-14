package cloud.alexanderweb.sysAlumnos.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cloud.alexanderweb.sysAlumnos.dtos.MatriculaDTO;
import cloud.alexanderweb.sysAlumnos.persistences.entities.CarreraEntity;
import cloud.alexanderweb.sysAlumnos.services.CarreraService;
import cloud.alexanderweb.sysAlumnos.services.MatriculaService;

@Component
public class MatriculaUtils {

  @Autowired
  MatriculaService matriculaService;

  @Autowired
  CarreraService carreraService;
  
  public List<String> getErrors( MatriculaDTO matricula) {
    List<String> errors = new ArrayList<>();

    if( matricula.getIdCarrera() != null ){

      CarreraEntity carreraSearched = this.carreraService.getCarreraById(
        matricula.getIdCarrera()
      );

      if( carreraSearched == null ){
        errors.add("El id de la carrera es incorrecto!!");
      }
    }
  
    
    return errors;
  }
}
