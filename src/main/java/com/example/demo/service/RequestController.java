package com.example.demo.service;

import com.example.demo.db.Request;
import com.example.demo.db.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/request")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @RequestMapping(path = "/ping")
    public @ResponseBody String ping() {
        return "pong";
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewRequest(@RequestParam String name,
                                              @RequestParam String email,
                                              @RequestParam String ph_number,
                                              @RequestParam String adress) {
        Request req = new Request();
        req.setName(name);
        req.setEmail(email);
        req.setPh_number(ph_number);
        req.setAdress(adress);
        requestRepository.save(req);
        return "saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Request> getAllRequests() {
        // This returns a JSON or XML with the users
        return requestRepository.findAll();
    }

    @PostMapping(path = "/getByName")
    public @ResponseBody String getByName(@RequestParam String name) {

        Optional<Request> search = requestRepository.findByName(name);

        if(search.isPresent()) {
            return search.get().toString();
//                    getName() + "\n" +
//                    search.get().getEmail() + "\n" +
//                    search.get().getPh_number() + "\n" +
//                    search.get().getAdress();

        } else return "Ooops!.. Nothing found...";
    }

    @PostMapping(path = "/update")
    public @ResponseBody String update(@RequestParam String name,
                                              @RequestParam String newName,
                                              @RequestParam String email,
                                              @RequestParam String ph_number,
                                              @RequestParam String adress) {
        Optional<Request> updateRequest = requestRepository.findByName(name);
        if(updateRequest.isPresent()) {
            Request req = updateRequest.get();
            req.setName(newName);
            req.setEmail(email);
            req.setPh_number(ph_number);
            req.setAdress(adress);
            requestRepository.save(req);
            return "Updated";
        }
        else return "Ooops!.. Nothing found...";
    }


    @PostMapping(path = "/remove")
    public @ResponseBody String removeRequest(@RequestParam String name) {

        Optional<Request> removeRequest = requestRepository.findByName(name);

        if(removeRequest.isPresent()) {

            requestRepository.delete(removeRequest.get());
            return removeRequest.get().getName() + " is deleted";

        } else return "Ooops!.. Deleted failed ...";
    }
}

