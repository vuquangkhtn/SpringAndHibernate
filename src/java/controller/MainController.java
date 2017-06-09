/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.security.Principal;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MainController {
 
   @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
   public String loginPage(Model model ) {
        
       return "loginPage";
   }
 
   @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
   public String logoutSuccessfulPage(Model model) {
       model.addAttribute("title", "Logout");
       return "index";
   }
 
   @RequestMapping(value = "/loginError.htm", method = RequestMethod.GET)
   public String accessDenied(Model model, Principal principal) {
        
       if (principal != null) {
           model.addAttribute("message", "Hi " + principal.getName() +", You do not have permission to access this page!");
       } else {
           model.addAttribute("message",
                   "You do not have permission to access this page!");
       }
       return "403Page";
   }
}