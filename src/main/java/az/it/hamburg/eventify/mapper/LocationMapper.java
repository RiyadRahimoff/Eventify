package az.it.hamburg.eventify.mapper;

import az.it.hamburg.eventify.dao.entity.LocationEntity;
import az.it.hamburg.eventify.model.request.create.CreateLocationRequest;
import az.it.hamburg.eventify.model.response.LocationResponse;


public enum LocationMapper {
    LOCATION_MAPPER;

    public LocationEntity requestToEntity(CreateLocationRequest createLocationRequest) {
        return LocationEntity.builder().
                name(createLocationRequest.getName()).
                address(createLocationRequest.getAddress()).
                city(createLocationRequest.getCity()).
                country(createLocationRequest.getCountry()).
                mapUrl(createLocationRequest.getMapUrl()).
                build();
    }

    public static LocationResponse entityToResponse(LocationEntity locationEntity) {
        return LocationResponse.builder()
                .id(locationEntity.getId())
                .name(locationEntity.getName())
                .address(locationEntity.getAddress())
                .city(locationEntity.getCity())
                .country(locationEntity.getCountry())
                .mapUrl(locationEntity.getMapUrl())
                .locationStatus(locationEntity.getLocationStatus())
                .build();
    }

}
