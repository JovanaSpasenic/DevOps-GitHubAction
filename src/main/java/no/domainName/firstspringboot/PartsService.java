package no.domainName.firstspringboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//this service needs a partsRepository (buisness logic- retirve and send data)
@Service //--> this is a component
public class PartsService { //The PartsService asks the repository for getting the parts

    //Member field
    private final PartsRepository partsRepository; //The data comes from a private place, here is the

    //When we Autowired constructor --> then we know it is THREADSAFE
    // (because PartsRepository is final, and cant be changed
    @Autowired//Finds all the instances of PartsRepository --> this is dependency injection
    public PartsService(PartsRepository partsRepository){
        this.partsRepository = partsRepository;
    }
    public List<Part> getParts(){
        return partsRepository.getParts();
    }
    public void addPart(Part part){
        partsRepository.addParts(part);
    }
    public void deletePart(String name){partsRepository.deletePartByName(new Part(name));}

    public void updatePart(Part name, Part newName) {
        partsRepository.updatePartById(name, newName);
    }
}
