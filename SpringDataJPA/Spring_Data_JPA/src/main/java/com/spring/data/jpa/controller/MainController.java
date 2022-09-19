package com.spring.data.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.data.jpa.Repository.ChuyenBayRepository;
import com.spring.data.jpa.entity.ChuyenBay;

@Controller
public class MainController {

	@Autowired
	private ChuyenBayRepository cbE;
	
	@ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/getAll'>Get All</a></li>";
        html += "</ul>";
        return html;
    }
	
    @ResponseBody
    @RequestMapping("/getAll")
    public String showAllEmployee() {

        Iterable<ChuyenBay> chuyenbay = this.cbE.findAll();

        String html = "";
        for (ChuyenBay cb : chuyenbay) {
            html += cb + "<br>";
        }

        return html;
    }
}
