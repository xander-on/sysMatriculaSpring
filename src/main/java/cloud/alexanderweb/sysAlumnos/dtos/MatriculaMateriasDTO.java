package cloud.alexanderweb.sysAlumnos.dtos;
import java.util.List;

import cloud.alexanderweb.sysAlumnos.persistences.entities.MateriaEntity;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class MatriculaMateriasDTO {
  private String idMatricula;
  private List<MateriaEntity> materias;
}
