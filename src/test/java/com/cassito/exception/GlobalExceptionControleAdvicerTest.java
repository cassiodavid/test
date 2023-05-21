package com.cassito.exception;

import com.cassito.controller.ApiController;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class GlobalExceptionControleAdvicerTest {

    private MockMvc mockMvc;

    @Mock
    private ApiController apiController;

    @Test
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(apiController)
                .setControllerAdvice(new Exception())
                .build();
    }


}
