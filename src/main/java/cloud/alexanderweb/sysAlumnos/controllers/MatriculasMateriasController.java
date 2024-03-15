package cloud.alexanderweb.sysAlumnos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cloud.alexanderweb.sysAlumnos.dtos.MatriculaMateriasDTO;
import cloud.alexanderweb.sysAlumnos.persistences.entities.MateriaEntity;
import cloud.alexanderweb.sysAlumnos.persistences.entities.MatriculaMateriaEntity;
import cloud.alexanderweb.sysAlumnos.services.MatriculaMateriaService;
import java.util.List;
@RestController
@RequestMapping("/matriculas-materias")
public class MatriculasMateriasController {
  
  @Autowired
  MatriculaMateriaService matriculaMateriaService;

  @GetMapping("")
  @CrossOrigin
  public ResponseEntity<MatriculaMateriasDTO> 
    getMateriasByMatricula( @RequestParam("matricula") String idMatricula){

    List<MatriculaMateriaEntity> materias = this.matriculaMateriaService
      .getByIdMatricula( idMatricula );

    List<MateriaEntity> listMaterias = materias.stream()
      .map( matriculaMateria -> new MateriaEntity(
        matriculaMateria.getMateria().getId(),
        matriculaMateria.getMateria().getNombre(),
        matriculaMateria.getMateria().isActivo()
      ) )
      .toList();

    MatriculaMateriasDTO matriculaWithMaterias = new MatriculaMateriasDTO();
    matriculaWithMaterias.setIdMatricula(idMatricula);
    matriculaWithMaterias.setMaterias(listMaterias);
  
    return ResponseEntity.ok(matriculaWithMaterias);
  }

  @PostMapping
  @CrossOrigin
  public ResponseEntity<?> postMatriculaMateria( 
    @RequestBody MatriculaMateriaEntity matriculaMateria
  ) {

    String uuid = java.util.UUID.randomUUID().toString();
    matriculaMateria.setId(uuid);
    matriculaMateria.setActivo(true);

    MatriculaMateriaEntity matriculaMateriaCreated = 
      this.matriculaMateriaService.postMatriculaMateria( matriculaMateria );

    return ResponseEntity.ok(matriculaMateriaCreated);
  }

}
