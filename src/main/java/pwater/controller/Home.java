package Pwater.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Pwater.Model.Account;

@RestController
public class Home {

    @RequestMapping(value = {"/","/Home","/home"}, method = RequestMethod.GET)
    public List index() {
    	List account = new Account().GetAll();
    	return account;
    }

}