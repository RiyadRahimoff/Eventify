package az.it.hamburg.eventify.service.concrete;

import az.it.hamburg.eventify.dao.entity.LocationEntity;
import az.it.hamburg.eventify.dao.repository.LocationRepository;
import az.it.hamburg.eventify.exception.LocationNotFound;
import az.it.hamburg.eventify.mapper.LocationMapper;
import az.it.hamburg.eventify.model.enums.LocationStatus;
import az.it.hamburg.eventify.model.request.CreateLocationRequest;
import az.it.hamburg.eventify.model.request.UpdateLocationRequest;
import az.it.hamburg.eventify.model.response.LocationResponse;
import az.it.hamburg.eventify.service.abstraction.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LocationServiceHandler implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public void saveLocation(CreateLocationRequest createLocationRequest) {
        LocationEntity locationEntity = LocationMapper.LOCATION_MAPPER.requestToEntity(createLocationRequest);
        locationEntity.setLocationStatus(LocationStatus.ACTIVE);
        locationRepository.save(locationEntity);
    }

    @Override
    public void deleteLocation(Long id) {
        LocationEntity locationEntity = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFound("Location not found " + id));
        locationEntity.setLocationStatus(LocationStatus.DEACTIVE);
        locationRepository.save(locationEntity);
    }

    @Override
    public List<LocationResponse> getAllLoc() {
        return locationRepository.findAll().stream().filter(locationEntity ->
                        locationEntity.getLocationStatus().equals(LocationStatus.ACTIVE))
                .map(LocationMapper::entityToResponse).toList();
    }

    @Override
    public LocationResponse findLocationById(Long id) {
        LocationEntity locationEntity = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFound("Location not found " + id));
        LocationResponse locationResponse = LocationMapper.entityToResponse(locationEntity);
        return locationResponse;
    }

    @Override
    public void updateLocation(Long id, UpdateLocationRequest updateLocationRequest) {
        LocationEntity locationEntity = locationRepository.findById(id).orElseThrow(() -> new LocationNotFound("Location not found " + id));

        if (updateLocationRequest.getName() != null) {
            locationEntity.setName(updateLocationRequest.getName());
        }

        if (updateLocationRequest.getCountry() != null) {
            locationEntity.setCountry(updateLocationRequest.getCountry());
        }

        if (updateLocationRequest.getCity() != null) {
            locationEntity.setCity(updateLocationRequest.getCity());
        }

        if (updateLocationRequest.getMapUrl() != null) {
            locationEntity.setMapUrl(updateLocationRequest.getMapUrl());
        }

        if (updateLocationRequest.getAddress() != null) {
            locationEntity.setAddress(updateLocationRequest.getAddress());
        }
    }
}
