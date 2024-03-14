package cloud.alexanderweb.sysAlumnos.utils;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cloud.alexanderweb.sysAlumnos.persistences.entities.MateriaEntity;

@Component
public class MateriaUtils {
  

  public List<String> getErrors( MateriaEntity materia) {
    List<String> errors = new ArrayList<>();

    if( materia.getNombre() == null ){
      errors.add("El nombre es requerido!!");
    }

    return errors;
  }
}
