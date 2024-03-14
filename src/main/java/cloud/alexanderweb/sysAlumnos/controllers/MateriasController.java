package cloud.alexanderweb.sysAlumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.alexanderweb.sysAlumnos.persistences.entities.MateriaEntity;
import cloud.alexanderweb.sysAlumnos.persistences.entities.MatriculaMateriaEntity;
import cloud.alexanderweb.sysAlumnos.services.MateriaService;
import cloud.alexanderweb.sysAlumnos.services.MatriculaMateriaService;
import cloud.alexanderweb.sysAlumnos.utils.MateriaUtils;

@RestController
@RequestMapping("/materias")
public class MateriasController {
  
  @Autowired
  MateriaService materiaService;


  @Autowired
  private MateriaUtils materiaUtils;

  @GetMapping
  @CrossOrigin
  public ResponseEntity<List<MateriaEntity>> getMaterias() {
    List<MateriaEntity> materias = this.materiaService.getMaterias();
    return ResponseEntity.ok(materias);
  }



  @PostMapping
  @CrossOrigin
  public ResponseEntity<?> postMateria( @RequestBody MateriaEntity materia) {

    List<String> errors = materiaUtils.getErrors( materia );

    if( !errors.isEmpty() ){
      return ResponseEntity.badRequest().body(errors);
    }

    String uuid = java.util.UUID.randomUUID().toString();
    materia.setId(uuid);
    materia.setActivo(true);
    MateriaEntity alumnoCreated = this.materiaService.postMateria(materia);
    return ResponseEntity.ok(alumnoCreated);
  }
}
