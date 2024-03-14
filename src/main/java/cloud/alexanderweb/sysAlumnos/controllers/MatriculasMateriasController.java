package cloud.alexanderweb.sysAlumnos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.alexanderweb.sysAlumnos.persistences.entities.MatriculaMateriaEntity;
import cloud.alexanderweb.sysAlumnos.services.MatriculaMateriaService;
import java.util.List;
@RestController
@RequestMapping("/matriculas-materias")
public class MatriculasMateriasController {
  
  @Autowired
  MatriculaMateriaService matriculaMateriaService;

  @GetMapping("/{idMatricula}")
  @CrossOrigin
  public ResponseEntity<List<MatriculaMateriaEntity>> 
    getMateriasByMatricula( @PathVariable String idMatricula){

      List<MatriculaMateriaEntity> materias = this.matriculaMateriaService
        .getByIdMatricula( idMatricula );
    
      return ResponseEntity.ok(materias);
  }
}
