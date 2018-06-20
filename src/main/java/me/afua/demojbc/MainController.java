package me.afua.demojbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @Autowired
    PersonRepository people;

    @RequestMapping("/")
    public String showIndex(Model model)
    {
        String yourName = "Enter your name here";
        model.addAttribute("theName",yourName);
        model.addAttribute("thePeople",people.findAll());
        if(people.count()>0)
         System.out.println("My ID is one:"+people.findById(new Long(1)).get().getFirstName());
        return "index";
    }


    @RequestMapping("/addpeople")
    public String addPeople()
    {
        Person p = new Person();
        p.setFirstName("Person One");
        people.save(p);
        p = new Person();
        p.setFirstName("Person Two");
        people.save(p);
        return "redirect:/";
    }





}
