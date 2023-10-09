package no.domainName.firstspringboot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PartsUnitTest {

    @MockBean //this allows mock out the partsRepository, that we can test the Service
    //Create a mock of PartsRepository
    private PartsRepository partsRepository;
    @Autowired
    private PartsService partsService;
    @Test
    void shouldRetrieveValueFromRepo(){ //Repo = Repository
        PartsRepository partsRepository = new PartsRepository();

        assertThat(partsRepository.getParts().size()).isEqualTo(2);
    }
    @Test
    void addingNewPartShouldInceraseArraySize(){
        PartsRepository partsRepository = new PartsRepository();
        partsRepository.addParts(new Part("pineaplle"));
        assertThat(partsRepository.getParts().size()).isEqualTo(3);
    }
    @Test
    void shouldGetPartsFromService(){
        ArrayList<Part> partsList = new ArrayList<Part>(List.of(new Part("pogo")));
        when(partsRepository.getParts()).thenReturn(partsList);

        assertThat(partsService.getParts().size()).isEqualTo(1);
        assertThat(partsService.getParts().get(0).name()).isEqualTo("pogo");
    }

    @Test
    void shouldDeleteFromRepo(){
        PartsRepository partsRepository1 = new PartsRepository();
        partsRepository1.addParts(new Part("nyttNavn"));
        partsRepository1.addParts(new Part("blabla"));
        partsRepository1.deletePartByName(new Part("nyttNavn"));
        List<Part> parts = partsRepository1.getParts(); //getParts returnerer arraylist
        for (int i = 0; i < parts.size(); i ++){
            if (parts.get(i).name().equals("nyttNavn")){ //sjekke om navnet finnes
                Assert.isTrue(false, "nyttNavn still in the List");
            }
        }
        Assert.isTrue(true);



    }

}
