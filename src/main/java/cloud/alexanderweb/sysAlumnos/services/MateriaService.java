package cloud.alexanderweb.sysAlumnos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cloud.alexanderweb.sysAlumnos.persistences.entities.MateriaEntity;
import cloud.alexanderweb.sysAlumnos.persistences.repositories.MateriaRepository;

@Service
public class MateriaService {

  @Autowired
  private MateriaRepository materiaRepository;

  public List<MateriaEntity> getMaterias() {
    return this.materiaRepository.findAll();
  }

  
  public MateriaEntity postMateria(MateriaEntity materia) {
    return this.materiaRepository.save(materia);
  }
}
