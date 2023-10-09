package no.domainName.firstspringboot;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties //This we use if we have four 4 fields, and I want to add 12 properties.. This will ignore the
//four fields, and still add the 12
public record Part(

        //This here will let me add something from Postman even if its not "name"
        @JsonIgnoreProperties("nomenclature")
        String name
) {
        //Getter for name
        public String getName(){
                return name;
        }
}
