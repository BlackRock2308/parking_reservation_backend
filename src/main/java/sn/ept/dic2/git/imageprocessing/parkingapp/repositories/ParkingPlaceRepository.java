package sn.ept.dic2.git.imageprocessing.parkingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ept.dic2.git.imageprocessing.parkingapp.models.ParkingPlace;

import java.util.Optional;

public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace, Integer> {
    Optional<ParkingPlace> findById(String id);
}
