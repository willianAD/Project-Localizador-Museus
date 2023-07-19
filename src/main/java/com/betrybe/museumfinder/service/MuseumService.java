package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class MuseumService.
 */
@Service
public class MuseumService implements MuseumServiceInterface {
  MuseumFakeDatabase database;
  
  @Autowired
  public MuseumService(MuseumFakeDatabase database) {
    this.database = database;
  }
  
  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    return null;
  }
  
  @Override
  public Museum createMuseum(Museum museum) {
    Coordinate coordinate = museum.getCoordinate();
    boolean verify = CoordinateUtil.isCoordinateValid(coordinate);
    if (verify) {
      return database.saveMuseum(museum);      
    } else {
      throw new InvalidCoordinateException();
    }
  }
  
  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
