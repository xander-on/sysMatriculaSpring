package cloud.alexanderweb.sysAlumnos.persistences.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "Matriculas")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaEntity {
  
  @Id
  @Column(name = "id", unique = true, nullable = false, length = 50)
  private String id;

  @Column(name = "name", length = 50)
  private String nombre;

  @Column(name = "lastName", length = 50)
  private String apellidos;

  @Column(name = "address")
  private String direccion;

  @Column(name = "phone")
  private String telefono;

  @Column(name = "active", nullable = false)
  @JsonIgnore
  private boolean activo;

  @ManyToOne
  @JoinColumn(name = "id_carrera", referencedColumnName = "id")
  private CarreraEntity carrera;
}
