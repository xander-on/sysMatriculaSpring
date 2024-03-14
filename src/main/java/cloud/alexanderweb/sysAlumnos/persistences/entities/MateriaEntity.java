package cloud.alexanderweb.sysAlumnos.persistences.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "materias")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MateriaEntity {

  @Id
  @Column(name = "id", unique = true, nullable = false, length = 50)
  private String id;

  @Column(name = "name", length = 100, nullable = false)
  private String nombre;

  @Column(name = "active", nullable = false)
  private boolean activo;
}
