package com.coding.fruityloops;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FruitController {
 
 @RequestMapping("/")
 public String index(Model model) {
     
     ArrayList<Fruit> fruits = new ArrayList<Fruit>();
     fruits.add(new Fruit("Kiwi", 1.5));
     fruits.add(new Fruit("Mango", 2.0));
     fruits.add(new Fruit("Goji Berries", 4.0));
     fruits.add(new Fruit("Guava", .75));     
     return "index.jsp";
 }
}
