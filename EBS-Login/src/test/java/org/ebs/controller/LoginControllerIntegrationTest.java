package org.ebs.controller;

import com.google.gson.Gson;
import org.ebs.model.LoginModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class LoginControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void login() throws Exception {
        LoginModel loginModel= new LoginModel("DUMMY","DUMMY");
        Gson gson =new Gson();
        String json = gson.toJson(loginModel);
        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,"/session").
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON).
                content(json)).
                andExpect(status().isOk());
    }

}
