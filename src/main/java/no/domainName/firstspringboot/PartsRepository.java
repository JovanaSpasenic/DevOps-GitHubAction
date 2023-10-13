package no.domainName.firstspringboot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class PartsRepository { //When making repository --> anitate --> @Component
    private final Logger log = LoggerFactory.getLogger(PartsRepository.class);

    //ArrayList of list of parts
    private ArrayList<Part> parts = new ArrayList<>();

    //Genereate constructor
    public PartsRepository() {
        //Adding to the list
        parts.add(new Part ("gear"));
        parts.add(new Part ("cog"));
    }
    //getting this list
    public ArrayList<Part> getParts() {
        return parts;
    }

    //adding to the list
    public void addParts(Part part) {
        parts.add(part);
    }

    public void deletePartByName(Part part) {
        parts.remove(part);
    }

    //public void updatePartById(Part part, int id) {
        //parts.remove(id);
        //parts.add(id, part);
    //}

    public void updatePartById(Part name, Part newName){
        parts.set(parts.indexOf(name), newName);
    }
}
