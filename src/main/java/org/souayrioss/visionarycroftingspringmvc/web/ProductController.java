package org.souayrioss.visionarycroftingspringmvc.web;


import org.souayrioss.visionarycroftingspringmvc.Repository.StockRepository;
import org.souayrioss.visionarycroftingspringmvc.entity.Product;
import org.souayrioss.visionarycroftingspringmvc.entity.Stock;
import org.souayrioss.visionarycroftingspringmvc.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
    @Qualifier("productService")
    @Autowired
    private IService<Product> service;

    @Autowired
    private StockRepository stockRepository;

    @PostMapping("/add")
    private String addProduct(Model model ,Product product){
        Product prd = service.save(product);
        return "redirect:/product/products";
    }
    @GetMapping(path = "/StockProducts")
    public String getAllProduct(Model model, @RequestParam(name = "page",defaultValue = "0")int page, @RequestParam(name = "size",defaultValue = "3")int size, @RequestParam(name = "keyword",defaultValue = "")String keyword){

        Page<Product> products =  service.getAll(keyword,PageRequest.of(page,size));
        model.addAttribute("products",products.getContent());
        model.addAttribute("pages",new int[products.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "products";
    }

    @GetMapping
    public String formProduct(Model model){
        List<Stock> stocks = stockRepository.findAll();
        model.addAttribute("stocks",stocks);
        return "addProduct";
    }
    @GetMapping(path = "/products")
    public String getProducts(Model model, @RequestParam(name = "page",defaultValue = "0")int page, @RequestParam(name = "size",defaultValue = "3")int size, @RequestParam(name = "keyword",defaultValue = "")String keyword){

        Page<Product> products =  service.getAll(keyword,PageRequest.of(page,size));
        model.addAttribute("products",products.getContent());
        model.addAttribute("pages",new int[products.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "clientProducts";
    }

    @GetMapping(path = "/detailProduct")
    public String detailProduct(Model model,@RequestParam(name = "reference")String reference){
        Product product = service.getOne(reference);
        model.addAttribute("product",product);
        return "detailProduct";
    }


}
