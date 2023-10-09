package no.domainName.firstspringboot;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //This is like a record in Lombok, because now we dont need Get/Set, Constructors --> DATA creates everything
//@Getter
//@Setter
//@Builder --> creates builder for your class
//@RequiredArgsConstructor
//@NoArgsConstructor --> doesnt need constructors with info
//JsonIgnoreProperties -->able to handle no values and thats also because of RequiredArgConstructor
public class BigPart {

    private String partName;
    private int partNumber;
    private int numberOfChickens;


}
