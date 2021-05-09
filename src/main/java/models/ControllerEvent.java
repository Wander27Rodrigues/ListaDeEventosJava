package models;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerEvent {
    @RequestMapping ("/casdastrarEvent")
    public String form (){
        return "event/formEvent";
    }
}
