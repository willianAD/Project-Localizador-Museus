package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.service.CollectionTypeService;
import com.betrybe.museumfinder.controller.CollectionTypeController;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

class CollectionTypeControllerTest {

  CollectionTypeService mockService;
  CollectionTypeController collectionTypeController;
  
  @BeforeEach
  public void setUp() {
    mockService = mock(CollectionTypeService.class);
    collectionTypeController = new CollectionTypeController(mockService);
  }

  @SuppressWarnings("deprecation")
  @Test
  void testCollectionTypeSingle() throws Exception {
    String typeList = "história";
    CollectionTypeCount countResult = new CollectionTypeCount(new String[]{"história"}, 10); 
    when(mockService.countByCollectionTypes(typeList)).thenReturn(countResult);

    ResponseEntity<CollectionTypeCount> response = collectionTypeController.getCollectionTypesCount(typeList);

      assertEquals(200, response.getStatusCodeValue());
      assertEquals(countResult, response.getBody());
  }
  
  @SuppressWarnings("deprecation")
  @Test
  void testCollectionTypeMultiple() throws Exception {
    String typeList = "hist, imag";
    CollectionTypeCount countResult = new CollectionTypeCount(new String[]{"hist", "imag"}, 492); 
    when(mockService.countByCollectionTypes(typeList)).thenReturn(countResult);

    ResponseEntity<CollectionTypeCount> response = collectionTypeController.getCollectionTypesCount(typeList);

      assertEquals(200, response.getStatusCodeValue());
      assertEquals(countResult, response.getBody());
  }
  
  @SuppressWarnings("deprecation")
  @Test
  void testCollectionTypeNoResult() throws Exception {
    String typeList = "unknown";
    CollectionTypeCount countResult = new CollectionTypeCount(new String[]{"unknown"}, 0); 
    when(mockService.countByCollectionTypes(typeList)).thenReturn(countResult);

    ResponseEntity<CollectionTypeCount> response = collectionTypeController.getCollectionTypesCount(typeList);

      assertEquals(404, response.getStatusCodeValue());
      assertEquals(null, response.getBody());
  }
}
