 package tqs_hw;

import tqs_hw.entities.OpenWeatherConsume;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Bean(name = "consume")
  public OpenWeatherConsume apiConsume() {
    return new OpenWeatherConsume();
  }
}
