package cloud.alexanderweb.sysAlumnos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cloud.alexanderweb.sysAlumnos.persistences.entities.CarreraEntity;
import cloud.alexanderweb.sysAlumnos.persistences.repositories.CarreraRepository;

@Service
public class CarreraService {
  

  @Autowired
  private CarreraRepository carreraRepository;

  public List<CarreraEntity> getCarreras() {
    return this.carreraRepository.findAll();
  }


  public CarreraEntity getCarreraById(String id) {
    Optional<CarreraEntity> carreraOptional = this.carreraRepository.findById(id);
    return carreraOptional.orElse(null);
  }
}
