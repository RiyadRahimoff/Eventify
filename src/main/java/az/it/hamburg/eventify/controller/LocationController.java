package az.it.hamburg.eventify.controller;

import az.it.hamburg.eventify.model.request.create.CreateLocationRequest;
import az.it.hamburg.eventify.model.request.update.UpdateLocationRequest;
import az.it.hamburg.eventify.model.response.LocationResponse;
import az.it.hamburg.eventify.service.concrete.LocationServiceHandler;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "BasicAuth")
@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationServiceHandler locationServiceHandler;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLocation(@RequestBody @Valid CreateLocationRequest createLocationRequest) {
        locationServiceHandler.saveLocation(createLocationRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLocation(@PathVariable Long id) {
        locationServiceHandler.deleteLocation(id);
    }

    @GetMapping("/getLocations")
    @ResponseStatus(HttpStatus.OK)
    public Page<LocationResponse> getAllLoc(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return locationServiceHandler.getAllLoc(pageable);
    }

    @GetMapping("/get/location/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LocationResponse findLocationById(@PathVariable Long id) {
        return locationServiceHandler.findLocationById(id);
    }

    @PutMapping("/update/location/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLocation(@PathVariable Long id, @RequestBody @Valid UpdateLocationRequest updateLocationRequest) {
        locationServiceHandler.updateLocation(id, updateLocationRequest);
    }

}
