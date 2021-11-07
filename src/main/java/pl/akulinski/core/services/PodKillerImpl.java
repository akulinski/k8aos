package pl.akulinski.core.services;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.smallrye.mutiny.Uni;
import lombok.AllArgsConstructor;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Singleton
public class PodKillerImpl implements PodKiller {
  private final KubernetesClient kubernetesClient;
  private final Random random = new Random();

  @Override
  public Uni<PodDetails> killRandomPod() {
    final Pod podToKill = getRandomPod();
    kubernetesClient.pods().delete(podToKill);
    return Uni.createFrom().item(getPodDetails(podToKill));
  }

  private PodDetails getPodDetails(Pod podToKill) {
    return new PodDetails(podToKill.getMetadata().getName(), LocalDateTime.now());
  }

  private Pod getRandomPod() {
    final List<Pod> podList = kubernetesClient.pods().list().getItems();
    final int index = random.nextInt(podList.size());
    return podList.get(index);
  }
}
