package com.example.hateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.RepresentationModel;

@SpringBootApplication
public class HateoasApplication {

// Hateoas enables one to rapdily create REST representations using HATEOAS
// Hateoas == Hyper Text as the Engine of Application State
// Helps to guide the user through the application by providing meaningful urls and next steps etc


// To Add Hateoas one must extend RepresentationModel<NameOfClass> to the entity
// This adds the add() method.When we create a link can then add it to this Object easily
// To create Links use Link someLinkName = new Link("url);
// url is qualified as a "self" link in the return
//
	public static void main(String[] args) {
		SpringApplication.run(HateoasApplication.class, args);
	}

}
