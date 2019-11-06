package integration;

import com.epam.homework.config.ApplicationConfig;
import com.epam.homework.config.SwaggerConfig;
import com.epam.homework.config.WebInitializer;
import com.epam.homework.controller.TaskController;
import com.epam.homework.controller.UserController;
import com.epam.homework.entity.Task;
import com.epam.homework.entity.User;
import com.epam.homework.entity.UserRole;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SwaggerConfig.class, WebInitializer.class})
@WebAppConfiguration
public class ControllerTest {

  @Autowired
  private WebApplicationContext wac;
  private MockMvc mockMvc;

  @Before
  public void setup() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void gettingWebContextTest() {
    ServletContext servletContext = wac.getServletContext();
    Assert.assertNotNull(servletContext);
    Assert.assertTrue(servletContext instanceof MockServletContext);
    Assert.assertNotNull(wac.getBean(UserController.class));
    Assert.assertNotNull(wac.getBean(TaskController.class));
  }

}
