package com.example.demo.web;

import com.example.demo.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author zhaoyiwei 2018/12/21 18:57
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc               mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getUserById() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/getUserById"))
//                .andExpect(MockMvcResultMatchers.view().name("user/view"))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
//                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        log.info(GsonUtil.toJson(result));
    }

    @Test
    public void addUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void login() {
    }

    @Test
    public void jsonTest() {
    }
}
