package integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.epam.homework.config.ApplicationConfig;
import com.epam.homework.config.SwaggerConfig;
import com.epam.homework.config.WebInitializer;
import com.epam.homework.controller.TaskController;
import com.epam.homework.controller.UserController;
import com.epam.homework.entity.UserRole;
import com.epam.homework.exception.UserRoleException;
import javax.servlet.ServletContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SwaggerConfig.class, WebInitializer.class})
@WebAppConfiguration
public class UserControllerTest {

  @Autowired
  private WebApplicationContext wac;
  private MockMvc mockMvc;
  private static final String CONTENT_TYPE = "text/plain;charset=ISO-8859-1";


  @Before
  public void setup() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    mockMvc.perform(post("/user/sign-up")
        .param("id", "1")
        .param("name", "Anton")
        .param("email", "email@dot.com")
        .param("phoneNumber", "+789456123")
        .param("password", "password")
        .param("subscription", "secret")
        .param("userRole", UserRole.ORDINARY_USER.name())).andExpect(status().isOk());
  }

  @Test
  public void gettingWebContextTest() {
    ServletContext servletContext = wac.getServletContext();
    Assert.assertNotNull(servletContext);
    Assert.assertTrue(servletContext instanceof MockServletContext);
    Assert.assertNotNull(wac.getBean(UserController.class));
    Assert.assertNotNull(wac.getBean(TaskController.class));
  }

  @Test
  public void helloPageTest() throws Exception {
    final MvcResult mvcResult = mockMvc.perform(get("/hello"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello from server!"))
        .andReturn();
    Assert.assertEquals(CONTENT_TYPE, mvcResult.getResponse().getContentType());
  }


  @Test
  public void userSignUpTest() throws Exception {
    mockMvc.perform(post("/user/sign-up")
        .param("id", "2")
        .param("name", "Not Anton")
        .param("email", "email@email.com")
        .param("phoneNumber", "+79113585555")
        .param("password", "password")
        .param("subscription", "asdsdas")
        .param("userRole", UserRole.ADMIN_USER.name())).andExpect(status().isOk());
  }


  @Test
  public void userSignInTest() throws Exception {
    mockMvc.perform(post("/user/sign-in")
        .param("email", "email@dot.com")
        .param("password", "password"))
        .andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void userSubscribeTest() throws Exception {
    mockMvc.perform(post("/user/subscribe")
        .param("userEmail", "email@dot.com")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void userAdminCheckerTest() throws Exception {
    mockMvc.perform(get("/user/admin")
        .param("email", "email@email.com"))
        .andExpect(status().isOk());
  }

  @Test(expected = NestedServletException.class)
  public void userNotAdminCheckerTest() throws Exception {
    mockMvc.perform(get("/user/admin")
        .param("email", "email@dot.com"));
  }

}
