package cloud.alexanderweb.sysAlumnos.persistences.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.alexanderweb.sysAlumnos.persistences.entities.MatriculaMateriaEntity;

public interface MatriculaMateriaRepository extends JpaRepository<MatriculaMateriaEntity, String> {
  
  List<MatriculaMateriaEntity> findAllByMatriculaId( String idMatricula );
}
