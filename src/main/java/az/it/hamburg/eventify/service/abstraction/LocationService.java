package az.it.hamburg.eventify.service.abstraction;

import az.it.hamburg.eventify.model.request.CreateLocationRequest;
import az.it.hamburg.eventify.model.request.UpdateLocationRequest;
import az.it.hamburg.eventify.model.response.LocationResponse;

import java.util.List;

public interface LocationService {
    void saveLocation(CreateLocationRequest createLocationRequest);

    void deleteLocation(Long id);

    List<LocationResponse> getAllLoc();

    LocationResponse findLocationById(Long id);

    void updateLocation(Long id, UpdateLocationRequest updateLocationRequest);
}
