package cloud.alexanderweb.sysAlumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.alexanderweb.sysAlumnos.dtos.MatriculaDTO;
import cloud.alexanderweb.sysAlumnos.persistences.entities.CarreraEntity;
import cloud.alexanderweb.sysAlumnos.persistences.entities.MatriculaEntity;
import cloud.alexanderweb.sysAlumnos.services.CarreraService;
import cloud.alexanderweb.sysAlumnos.services.MatriculaService;
import cloud.alexanderweb.sysAlumnos.utils.MatriculaUtils;

@RestController
@RequestMapping("/matriculas")
public class MatriculasController {
  
  @Autowired
  MatriculaService matriculaService;
  
  @Autowired
  MatriculaUtils matriculaUtils;
  
  @Autowired
  CarreraService carreraService;
  
  @GetMapping
  @CrossOrigin
  public ResponseEntity<List<?>> getMatriculas() {
    List<MatriculaEntity> matriculas = this.matriculaService.getMatriculas();

    return ResponseEntity.ok(matriculas);

  }

  


  @PostMapping
  @CrossOrigin
  public ResponseEntity<?> postMatricula( @RequestBody MatriculaDTO matricula) {

    List<String> errors = matriculaUtils.getErrors( matricula );

    if( !errors.isEmpty() )
      return ResponseEntity.badRequest().body(errors);
    
    MatriculaEntity newMatricula = new MatriculaEntity();
    String uuid = java.util.UUID.randomUUID().toString();
    CarreraEntity carrera = carreraService.getCarreraById(
      matricula.getIdCarrera()
    );

    newMatricula.setId(uuid);
    newMatricula.setNombre( matricula.getNombre() );
    newMatricula.setApellidos( matricula.getApellidos() );
    newMatricula.setDireccion( matricula.getDireccion() );
    newMatricula.setTelefono( matricula.getTelefono() );
    newMatricula.setActivo(true);
    newMatricula.setCarrera(carrera);

    MatriculaEntity matriculaCreated = this.matriculaService.postMatricula(
      newMatricula
    );

    return ResponseEntity.ok(matriculaCreated);
  }
}
