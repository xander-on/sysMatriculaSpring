package cloud.alexanderweb.sysAlumnos.persistences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import cloud.alexanderweb.sysAlumnos.persistences.entities.MateriaEntity;

public interface MateriaRepository extends JpaRepository<MateriaEntity, String> {
  
}
