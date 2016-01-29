/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
public class ControllerBreadCrumb {
    
    @RequestMapping("home")
    public String retornaHome(){
        return "home";
    }
    
    @RequestMapping("managerUser")
    public String managerUser(){
        return "managerUser";
    }
}
