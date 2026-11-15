package io.github.emantous.flowlens.api.web;

import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/version")
public class VersionController {

  private final BuildProperties buildProperties;

  public VersionController(BuildProperties buildProperties) {
    this.buildProperties = buildProperties;
  }

  @GetMapping
  public VersionResponse version() {
    return new VersionResponse("flowlens-api", buildProperties.getVersion());
  }

  public record VersionResponse(String name, String version) {}
}
