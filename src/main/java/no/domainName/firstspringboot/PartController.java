package no.domainName.firstspringboot;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //this is creating a Servlet on that excatly URL
@RequestMapping("/api/parts") //THis is the URL when we get the request in the server, then we want to use this servlet
@Slf4j  //This is for Logback .. we dont use it now
public class PartController {
    @Autowired //Use this alot.
    private PartsService partsService;



    //Mapping
    //@GetMapping() //Getter
    //public String getHello() { //Method
       // return "Hello";
    //}
    @GetMapping() //if you go to "api/parts" then you will get this method
    public ResponseEntity<List<Part>> getParts(){
        return ResponseEntity.ok(partsService.getParts());
    }

    @PostMapping() //@Requestbody =
    public void addPart(@RequestBody Part part){
        partsService.addPart(part);
    }

    //@DeleteMapping("/{name}") // Define a path variable {name}
    @DeleteMapping("{name}") //Eiter you use @PathVariable or
    // @RequestBody (tell Spring to expect the name in the request body@)
    public void deletePart(@PathVariable String name){
        //DELETE hhtp://localhost:8080/api/parts/?"name":"blabla"
        partsService.deletePart(name);
    }

    @PutMapping("{name}")
            //@RequestBody = Da endrer man i bodyen i Postman
            //@PathVariable = Da endrer man i url path i Postman
    public ResponseEntity<String> updatePart(@PathVariable Part name, @RequestBody Part newName){
         partsService.updatePart(name, newName);
        System.out.println("Hey");
         return ResponseEntity.ok("part replaced" + name.name() + ", with:" + newName.name());
    }
}
