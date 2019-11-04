import com.epam.security.SecurityService;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Tests {

    @Test
    public void isAdminTest() {
        SecurityService service = new SecurityService();
        boolean successful = service.isAdmin("ADMIN_USER");
        boolean unsuccessful = service.isAdmin("ORDINARY_USER");
        assertTrue(successful);
        assertFalse(unsuccessful);
    }
}
