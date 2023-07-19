package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class MuseumController.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  MuseumServiceInterface service;
  
  @Autowired
  public MuseumController(MuseumServiceInterface service) {
    this.service = service;
  }
  
  /**
   * Controller method responsible for create a museum.
  */
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto museum) {
    Museum dto = ModelDtoConverter.dtoToModel(museum);
    Museum create = service.createMuseum(dto);
    MuseumDto result = ModelDtoConverter.modelToDto(create);
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }
  
  /**
   * Controller method responsible for get a museum closest.
  */
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(
      @RequestParam(name = "lat") double latitude,
      @RequestParam(name = "lng") double longitude,
      @RequestParam(name = "max_dist_km") double maxDistance) {
    Coordinate coordinate = new Coordinate(latitude, longitude);
    Museum get = service.getClosestMuseum(coordinate, maxDistance);
    MuseumDto result = ModelDtoConverter.modelToDto(get);
    return ResponseEntity.ok(result);
  }
}
