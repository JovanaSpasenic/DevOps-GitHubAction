package no.domainName.firstspringboot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PartsServerIntegrationTest {
    @Autowired
    private MockMvc mockMvc; //Lets us make a call to rest of endpoints and do inserts.
    //MockMvc is imitating a api (Http requests: GET, POST, PUT, DELETE)
    //This allows you to test how your controller handles different types of requests without actual network requests.

    @Test //need a throw exception because .perform()
    void shouldGetListOfParts() throws Exception {
        mockMvc   //need imports for the AutoConfigureMockMvc from springframwork
                .perform(get("/api/parts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("cog")));
    }
}
