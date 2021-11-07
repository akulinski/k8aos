package pl.akulinski.web.rest.v1;

import io.smallrye.mutiny.Uni;
import lombok.AllArgsConstructor;
import pl.akulinski.core.services.PodDetails;
import pl.akulinski.core.services.PodKiller;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;

@AllArgsConstructor
@Path("/api/v1/pods")
public class PodController {
  private final PodKiller podKiller;

  @Path("/random")
  @DELETE
  public Uni<PodDetails> killRandomPod() {
    return podKiller.killRandomPod();
  }
}
