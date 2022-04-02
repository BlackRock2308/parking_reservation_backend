package sn.ept.dic2.git.imageprocessing.parkingapp.services.place;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.ept.dic2.git.imageprocessing.parkingapp.models.ParkingPlace;
import sn.ept.dic2.git.imageprocessing.parkingapp.repositories.ParkingPlaceRepository;

import java.util.Optional;

@AllArgsConstructor
@Service("parkingPlaceService")
public class ParkingPlaceServiceImpl implements IParkingPlaceService{

    private final ParkingPlaceRepository parkingRepository;
    @Override
    public Iterable<ParkingPlace> getAllParkingPlaces() {
        return parkingRepository.findAll();
    }

    @Override
    public ParkingPlace saveParkingPlace(ParkingPlace parkingPlace) {
        return parkingRepository.save(parkingPlace);
    }

    @Override
    public Optional<ParkingPlace> getParkingPlace(String id) {
        return parkingRepository.findById(id);
    }

    public ParkingPlace updateParkingPlace(ParkingPlace place) {
        ParkingPlace existingParkingPlace = parkingRepository.findById(place.getId()).orElse(null);
        existingParkingPlace.setParkingNumber(place.getParkingNumber());
        existingParkingPlace.setPhoneNumber(place.getPhoneNumber());
        existingParkingPlace.setMatriculeCar(place.getMatriculeCar());
        existingParkingPlace.setClientFullName(place.getClientFullName());
        existingParkingPlace.setStatus(place.getStatus());
        return parkingRepository.save(existingParkingPlace);

    }

}
