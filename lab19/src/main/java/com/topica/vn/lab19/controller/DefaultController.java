package com.topica.vn.lab19.controller;

import com.topica.vn.lab19.model.ServiceResponse;
import com.topica.vn.lab19.model.Word;
import com.topica.vn.lab19.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    DictionaryService dictionaryService;


    @GetMapping("/")
    public String home1() {
        return "/index";
    }

    @GetMapping("/home")
    public String home() {
        return "/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @RequestMapping(value = "/getWord", method = RequestMethod.GET)
    public ResponseEntity<Object> getWords(HttpServletRequest request) {
        Word dictionary = dictionaryService.findByWord(request.getParameter("word"));
        ServiceResponse<Word> response = new ServiceResponse<>("success", dictionary);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/getSuggestions", method = RequestMethod.GET)
    public ResponseEntity<Object> getSuggestions(HttpServletRequest request) {
        List<Word> words = dictionaryService.findByWord(request.getParameter("word"),0,5);
        ServiceResponse<List<Word>> response = new ServiceResponse<>("success", words);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Word word, Model model) {
        if(word.getWord() == null){
            model.addAttribute("myword",word);
        }else{
            model.addAttribute("myword", word);
            model.addAttribute("listword", dictionaryService.findByWord(word.getWord(),0,10));
            System.out.println(dictionaryService.findByWord(word.getWord(),0,10));
        }
        return "home";
    }

}
