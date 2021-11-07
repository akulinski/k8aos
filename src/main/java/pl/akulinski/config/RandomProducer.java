package pl.akulinski.config;

import javax.inject.Singleton;
import javax.ws.rs.Produces;
import java.util.Random;

@Singleton
public class RandomProducer {

  @Produces
  public Random kubernetesClient() {
    return new Random();
  }
}
