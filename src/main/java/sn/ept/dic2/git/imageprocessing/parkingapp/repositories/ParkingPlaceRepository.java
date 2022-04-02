package sn.ept.dic2.git.imageprocessing.parkingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.ept.dic2.git.imageprocessing.parkingapp.models.ParkingPlace;

import java.util.List;
import java.util.Optional;

public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace, Integer> {
    Optional<ParkingPlace> findById(Integer id);

    @Query("select '*' from ParkingPlace where status='Pending'")
    List<ParkingPlace> findByPendingStatus();
}
