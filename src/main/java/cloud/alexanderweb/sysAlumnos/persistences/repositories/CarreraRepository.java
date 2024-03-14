package cloud.alexanderweb.sysAlumnos.persistences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import cloud.alexanderweb.sysAlumnos.persistences.entities.CarreraEntity;

public interface CarreraRepository extends JpaRepository<CarreraEntity, String> {
  
}
