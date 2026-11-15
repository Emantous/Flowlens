package io.github.emantous.flowlens.api.web;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(VersionController.class)
class VersionControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockitoBean private BuildProperties buildProperties;

  @Test
  void returnsApplicationVersion() throws Exception {
    org.mockito.Mockito.when(buildProperties.getVersion()).thenReturn("0.0.1-SNAPSHOT");

    mockMvc
        .perform(get("/api/v1/version"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.name", is("flowlens-api")))
        .andExpect(jsonPath("$.version", is("0.0.1-SNAPSHOT")));
  }
}
