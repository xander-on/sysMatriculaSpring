package cloud.alexanderweb.sysAlumnos.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatriculaDTO {
  private String id;
  private String nombre;
  private String apellidos;
  private String direccion;
  private String telefono;
  private String idCarrera;
}
