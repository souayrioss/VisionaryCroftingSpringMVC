package org.souayrioss.visionarycroftingspringmvc.web;

import lombok.AllArgsConstructor;

import org.souayrioss.visionarycroftingspringmvc.Repository.UserRepository;
import org.souayrioss.visionarycroftingspringmvc.entity.User;
import org.souayrioss.visionarycroftingspringmvc.service.IService;
import org.souayrioss.visionarycroftingspringmvc.service.Imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {


    private UserRepository userRepository;

    @Qualifier("userService")
    @Autowired
    private IService<User> service;
    @Autowired
    private UserService userService;


    @GetMapping(path = "/index")
    public String users(Model model, @RequestParam(name = "page",defaultValue = "0")int page,@RequestParam(name = "size",defaultValue = "3")int size,@RequestParam(name = "keyword",defaultValue = "")String keyword){

        Page<User> users = userRepository.findByFullNameContainsIgnoreCase(keyword,PageRequest.of(page,size));
        model.addAttribute("users",users.getContent());
        model.addAttribute("pages",new int[users.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "users";
    }

    @GetMapping("/delete")
    public String deleteUser(Long id,String keyword ,int page){
        userRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String authentication(){
        return "authentication";
    }

    @PostMapping(path="/login")
    public String login(Model model, String email, String password, HttpSession session){
        Optional<User> userconnect = userService.login(email);
        if (userconnect.get().getPassword().equals(password)) {
            //model.addAttribute("userconnect",userconnect);
            session.setAttribute("userconnect",userconnect);
            if (userconnect.get().getRole().equals(User.RoleEnum.CLIENT)) {
                return "redirect:/product/products";
            } else if (userconnect.get().getRole().equals(User.RoleEnum.SUPPLIER)){
                return "redirect:/index";

            }else return "redirect:/product/StockProducts";
        }else {
            return "authentication";
        }
    }
}
