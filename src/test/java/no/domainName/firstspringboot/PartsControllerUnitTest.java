package no.domainName.firstspringboot;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PartsControllerUnitTest {

    @MockBean
    private PartsService partsService;
    @Autowired
    private PartController partController;
    @Test
    void shouldReturnResult(){
        ArrayList<Part> partsList = new ArrayList<Part>(List.of(new Part("pogo")));
        when(partsService.getParts()).thenReturn(partsList);
        //We can test with Assert. or assertThat()
        //assertThat ( tests things that are supposed to return boolean)
        //Assert. has many .methods so that i can test with that
        assertThat(partController.getParts().getBody().get(0).name()).isEqualTo("pogo");

    }
}
