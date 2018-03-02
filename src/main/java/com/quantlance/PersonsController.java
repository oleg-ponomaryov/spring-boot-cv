package com.quantlance;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.ArrayList;

@Controller
public class PersonsController {

	@Autowired
	PersonRepository repository;

	@Autowired
	CountryRepository countryRepository;

	@RequestMapping("/")
	public String index(Model model) {
		List<Country> countries = countryRepository.findAllByOrderByNameAsc();
	    List<Country> country = new ArrayList<>();
	    model.addAttribute("countries", countries);
	    model.addAttribute("country", country);

        return "index";
    }

	@RequestMapping("/person/{id}")
	public String person(@PathVariable Long id, Model model) {
        Person person = repository.findOne(id);
	    model.addAttribute("person", person);
    	model.addAttribute("country", person.getCountry());
        return "cv";
	}

    @RequestMapping(value="/persons",method=RequestMethod.POST)
	public String personsAdd(@RequestParam Long country, 
						@RequestParam String firstName, @RequestParam String lastName, @RequestParam Date date, Model model) {
        Country cn = countryRepository.findOne(country);
        Person newPerson = new Person();
        newPerson.setCountry(cn);
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);
        newPerson.setDate(date);
        repository.save(newPerson);

        return "redirect:/person/" + newPerson.getId();
	}
}
