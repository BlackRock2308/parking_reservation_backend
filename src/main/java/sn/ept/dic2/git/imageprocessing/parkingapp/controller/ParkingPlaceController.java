package sn.ept.dic2.git.imageprocessing.parkingapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ept.dic2.git.imageprocessing.parkingapp.models.ParkingPlace;
import sn.ept.dic2.git.imageprocessing.parkingapp.repositories.ParkingPlaceRepository;
import sn.ept.dic2.git.imageprocessing.parkingapp.services.place.IParkingPlaceService;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/places")
@AllArgsConstructor
public class ParkingPlaceController {

    private final IParkingPlaceService parkingPlaceService;
    private final ParkingPlaceRepository parkingPlaceRepository;

    //************************ add a Parking Place ****************************************

    @PostMapping
    public ResponseEntity<ParkingPlace> saveParkingPlace(@RequestBody ParkingPlace parkingPlace){

        ParkingPlace savePlace = parkingPlaceService.saveParkingPlace(parkingPlace);
        parkingPlaceService.saveParkingPlace(savePlace);
        return ResponseEntity.status(HttpStatus.OK).body(savePlace);
    }


    //************************ get a Parking place by ID ****************************************

    @GetMapping("/{id}")
    public ResponseEntity<ParkingPlace> getParkingPlaceById(@PathVariable String id) {
        Optional<ParkingPlace> optionalReport= parkingPlaceService.getParkingPlace(id);
        if(!optionalReport.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalReport.get());
    }

    //************************ get All Parking places ****************************************

    @GetMapping
    public Iterable<ParkingPlace> getParkingPlaces(){
        return parkingPlaceService.getAllParkingPlaces();
    }


    //************************ Delete a parking place ****************************************


    @DeleteMapping("/{id}")
    public ResponseEntity<ParkingPlace> deleteParkingPlace(@PathVariable String id){
        Optional<ParkingPlace> optionalParkingPlace= parkingPlaceService.getParkingPlace(id);
        if(!optionalParkingPlace.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        parkingPlaceRepository.delete(optionalParkingPlace.get());
        return ResponseEntity.status(HttpStatus.OK).body(optionalParkingPlace.get());
    }
    //************************ Update a parking place ****************************************


    @PutMapping
    public ResponseEntity<ParkingPlace> updateParkingPlace(@RequestBody ParkingPlace place) {

        ParkingPlace updateParkingPlace=parkingPlaceService.updateParkingPlace(place);
        return new ResponseEntity<>(updateParkingPlace,HttpStatus.OK);
    }

}
