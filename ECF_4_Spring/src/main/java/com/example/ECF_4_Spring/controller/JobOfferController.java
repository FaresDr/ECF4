package com.example.ECF_4_Spring.controller;

import com.example.ECF_4_Spring.entity.Appointement;
import com.example.ECF_4_Spring.entity.JobOffer;
import com.example.ECF_4_Spring.entity.User;
import com.example.ECF_4_Spring.service.AppointementService;
import com.example.ECF_4_Spring.service.JobOfferService;
import com.example.ECF_4_Spring.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobOfferController {

    private final JobOfferService jobOfferService;
    private final HttpSession httpSession;
    private final UserService userService;
    private final AppointementService appointementService;

    public JobOfferController(JobOfferService jobOfferService, HttpSession httpSession, UserService userService, AppointementService appointementService) {
        this.jobOfferService = jobOfferService;
        this.httpSession = httpSession;
        this.userService = userService;
        this.appointementService = appointementService;
    }


    @GetMapping("/joboffer")
    public String home(Model model){
        System.out.println(httpSession.getAttribute("user"));
        if((httpSession.getAttribute("user")) == null || httpSession.getAttribute("user").equals("null")){
            System.out.println("toto");
            return "redirect:/login";
        };
        User toto = userService.findByMailAndPassword(((User) httpSession.getAttribute("user")).getEmail(), ((User) httpSession.getAttribute("user")).getPassword());
        model.addAttribute("joboffers", jobOfferService.findAll());
        model.addAttribute("user", toto);
        return "listoffers";
    }
    @GetMapping("/joboffer/add")
    public String addForm(Model model){
        if((httpSession.getAttribute("user")) == null){
            System.out.println("toto");
            return "redirect:/";
        }
        model.addAttribute("joboffer", new JobOffer());
        return "jobOfferForm";
    }

    @PostMapping("/joboffer/add")
    public String addPerson(@ModelAttribute("joboffer") JobOffer jobOffer){
        if((httpSession.getAttribute("user")) == null){
            System.out.println("toto");
            return "redirect:/";
        }

        if (jobOffer.getId() == null)  {
           jobOfferService.save(jobOffer);
        }else {
            jobOfferService.update(jobOffer);
        }
        return "redirect:/joboffer";
    }
    @GetMapping("/joboffer/delete/{idoffer}")
    public String delete(@PathVariable("idoffer") Long idoffer){
        if((httpSession.getAttribute("user")) == null){
            System.out.println("toto");
            return "redirect:/";
        };
        jobOfferService.delete(jobOfferService.findById(idoffer));
        return "redirect:/joboffer";
    }
    @GetMapping("/joboffer/update/{idoffer}")
    public String formUpdate(@PathVariable("idoffer") Long idoffer, Model model){
        if((httpSession.getAttribute("user")) == null){
            System.out.println("toto");
            return "redirect:/";
        };
        JobOffer jobOffer = jobOfferService.findById(idoffer);
        model.addAttribute("joboffer", jobOffer);
        return "jobOfferForm";
    }
    @GetMapping("/joboffer/postuler/{idjob}")
    public String postuler(@PathVariable("idjob") Long idjob, Model model){
        if((httpSession.getAttribute("user")) == null){
            System.out.println("toto");
            return "redirect:/";
        };
        JobOffer jobOffer = jobOfferService.findById(idjob);
        model.addAttribute("joboffer", jobOffer);
        model.addAttribute("appointements", new Appointement());
        return "postulForm";
    }
    @PostMapping("/joboffer/postuler/{idjob}")
    public String postuler(@PathVariable("idjob") Long idjob, Appointement appointement){
        if((httpSession.getAttribute("user")) == null){
            System.out.println("toto");
            return "redirect:/joboffer";
        };
        System.out.println(idjob);
        JobOffer jobOffer = jobOfferService.findById(idjob);

        User user = userService.findByMailAndPassword(((User) httpSession.getAttribute("user")).getEmail(), ((User) httpSession.getAttribute("user")).getPassword());
        user.addjob(jobOffer);
        jobOffer.add(user);
        System.out.println(jobOffer);
        appointement.setJobOffer(jobOffer);
        System.out.println(user);
        appointement.setUser(user);

        appointement.setNameOfClient(user.getName());
        System.out.println(appointement);
        appointementService.save(appointement);
        return "redirect:/joboffer";
    }

    @GetMapping("/joboffer/appointenement")
    public String appointement(Model model){
        if((httpSession.getAttribute("user")) == null){
            System.out.println("toto");
            return "redirect:/";
        };
        User user = userService.findByMailAndPassword(((User) httpSession.getAttribute("user")).getEmail(), ((User) httpSession.getAttribute("user")).getPassword());
        model.addAttribute("user",user);
        model.addAttribute("appointements", appointementService.findAll());
        return "listappointement";
    }

}
