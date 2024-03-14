package cloud.alexanderweb.sysAlumnos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.alexanderweb.sysAlumnos.persistences.entities.MatriculaMateriaEntity;
import cloud.alexanderweb.sysAlumnos.persistences.repositories.MatriculaMateriaRepository;

@Service
public class MatriculaMateriaService {
  

  @Autowired
  private MatriculaMateriaRepository matriculaMateriaRepository;

  public List<MatriculaMateriaEntity> getByIdMatricula(String idMatricula) {  
    return matriculaMateriaRepository.findAllByMatriculaId( idMatricula );
  }

  public MatriculaMateriaEntity postMatriculaMateria( MatriculaMateriaEntity matriculaMateria) {
    return matriculaMateriaRepository.save(matriculaMateria);
  }
}
