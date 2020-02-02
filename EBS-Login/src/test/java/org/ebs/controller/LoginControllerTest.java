package org.ebs.controller;

import com.google.gson.Gson;
import org.ebs.model.LoginModel;
import org.ebs.service.LoginService;
import org.ebs.utils.InvalidUserCredentialException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoginController.class)
@AutoConfigureMockMvc
@EnableWebMvc
public class LoginControllerTest {

    @MockBean
    private LoginService loginService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void TestLoginShouldBeSuccessful() throws Exception, InvalidUserCredentialException {
        LoginModel loginModel= new LoginModel("DUMMY","DUMMY");
        Gson gSon=new Gson();
        String jsonReq = gSon.toJson(loginModel);
        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,"/session").
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON).
                content(jsonReq)).
                andExpect(status().isOk());
    }

}
