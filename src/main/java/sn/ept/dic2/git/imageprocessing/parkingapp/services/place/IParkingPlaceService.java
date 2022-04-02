package sn.ept.dic2.git.imageprocessing.parkingapp.services.place;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.ept.dic2.git.imageprocessing.parkingapp.models.ParkingPlace;

import java.util.Optional;

@Service("parkingPlaceService")
public interface IParkingPlaceService {

    public Iterable<ParkingPlace> getAllParkingPlaces();
    public ParkingPlace saveParkingPlace(ParkingPlace parkingPlace);
    public Optional<ParkingPlace> getParkingPlace(Integer id);
    public ParkingPlace updateParkingPlace(ParkingPlace parkingPlace);


}
