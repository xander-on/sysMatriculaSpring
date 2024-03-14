package cloud.alexanderweb.sysAlumnos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.alexanderweb.sysAlumnos.persistences.entities.CarreraEntity;
import cloud.alexanderweb.sysAlumnos.services.CarreraService;

@RestController
@RequestMapping("/carreras")
public class CarrerasController {
  

  @Autowired
  CarreraService carreraService;

  @GetMapping
  @CrossOrigin
  public ResponseEntity<List<CarreraEntity>> getCarreras() {
    List<CarreraEntity> carreras = this.carreraService.getCarreras();
    return ResponseEntity.ok(carreras);
  }
}
