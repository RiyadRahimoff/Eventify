package az.it.hamburg.eventify.service.abstraction;

import az.it.hamburg.eventify.model.request.create.CreateLocationRequest;
import az.it.hamburg.eventify.model.request.update.UpdateLocationRequest;
import az.it.hamburg.eventify.model.response.LocationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LocationService {
    void saveLocation(CreateLocationRequest createLocationRequest);

    void deleteLocation(Long id);

    Page<LocationResponse> getAllLoc(Pageable pageable);

    LocationResponse findLocationById(Long id);

    void updateLocation(Long id, UpdateLocationRequest updateLocationRequest);
}
