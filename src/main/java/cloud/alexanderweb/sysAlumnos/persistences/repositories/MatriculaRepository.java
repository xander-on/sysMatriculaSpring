package cloud.alexanderweb.sysAlumnos.persistences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.alexanderweb.sysAlumnos.persistences.entities.MatriculaEntity;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, String> {
  
}
