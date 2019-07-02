package tqs_hw.repository;

import tqs_hw.entities.WeatherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WeatherRepo extends CrudRepository<WeatherEntity, Long> {

  WeatherEntity findByLocation(String location);

  List<WeatherEntity> findAllByLocation(String location);

  WeatherEntity findByUniqueKey(String uniqueKey);

  void deleteWeatherEntityByLocation(String location);
}
