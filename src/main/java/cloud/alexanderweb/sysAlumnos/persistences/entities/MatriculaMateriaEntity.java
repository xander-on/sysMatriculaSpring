package cloud.alexanderweb.sysAlumnos.persistences.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "matricula_materia")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaMateriaEntity {

  @Id
  @Column(name = "id", unique = true, nullable = false, length = 50)
  private String id;

  @ManyToOne
  @JoinColumn(name = "id_matricula", referencedColumnName = "id")
  private MatriculaEntity matricula;

  @ManyToOne
  @JoinColumn(name = "id_materia", referencedColumnName = "id")
  private MateriaEntity materia;

  @Column(name = "active", nullable = false)
  private boolean activo;

}
