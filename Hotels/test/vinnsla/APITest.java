package vinnsla;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class APITest {
    API api;
    
    @BeforeEach
    public void setUp() {
        api = new API();
    }
    
    @AfterEach
    public void tearDown() {
        api = null;
    }

    /**
     * Test of getAvailableHotels method, of class API.
     */
    @Test
    public void testGetAvailableHotels() throws Exception {
        System.out.println("getAvailableHotels");
        assertNotNull(api.getAvailableHotels("SELECT * FROM hotels", "name"));
        assertNotNull(api.getAvailableHotels(null, null));
        assertEquals("Tower Resort","SELECT * FROM hotels WHERE name LIKE \"Tower Resort\"");
    }
}
