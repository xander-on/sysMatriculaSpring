package cloud.alexanderweb.sysAlumnos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.alexanderweb.sysAlumnos.persistences.entities.MatriculaEntity;
import cloud.alexanderweb.sysAlumnos.persistences.repositories.MatriculaRepository;

@Service
public class MatriculaService {
  
  @Autowired
  private MatriculaRepository matriculaRepository;

  public List<MatriculaEntity> getMatriculas() {
    return matriculaRepository.findAll();
  }

  public MatriculaEntity postMatricula( MatriculaEntity matricula) {
    return matriculaRepository.save(matricula);
  }

  public MatriculaEntity getMatriculaById(String id) {
    return matriculaRepository.findById(id).get();
  }
}
