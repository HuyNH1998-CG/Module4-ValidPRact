package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/users")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("/validate")
    public ModelAndView validate(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/index");
        } else {
            return new ModelAndView("/result");
        }

    }
}
