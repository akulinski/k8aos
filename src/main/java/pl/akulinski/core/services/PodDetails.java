package pl.akulinski.core.services;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PodDetails {
  private String podName;
  private LocalDateTime killedAt;
}
