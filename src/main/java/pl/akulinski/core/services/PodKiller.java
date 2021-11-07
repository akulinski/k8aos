package pl.akulinski.core.services;

import io.smallrye.mutiny.Uni;

public interface PodKiller {
  Uni<PodDetails> killRandomPod();
}
