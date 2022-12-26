package com.webapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.dao.WebseriesDao;
import com.webapp.demo.webseries.Webseries;

@RestController
public class WebseriesController {
	@Autowired
	WebseriesDao dao;
@RequestMapping("/addSeries")
@ResponseBody
public void addSeries(@RequestParam int id, @RequestParam String name, @RequestParam String seasons, @RequestParam String episodes, @RequestParam String rating, Webseries obj) {
	
	obj.setId(id);
	obj.setName(name);
	obj.setSeason(seasons);
	obj.setEpisodes(episodes);
	obj.setRating(rating);
	dao.save(obj);
	System.out.println("series added");
	
}

@RequestMapping("/series")
@ResponseBody
public List<Webseries> addSeries() {
	
	return dao.findAll();
}

@RequestMapping("/seriesById")
@ResponseBody
public List<Webseries> seriesById(@RequestParam int id) {
	System.out.println("series by id");
	return dao.seriesById(id);
	
}

@RequestMapping("/seriesByName")
@ResponseBody
public List<Webseries> seriesByName(@RequestParam String name) {
	System.out.println("series by name");
	return dao.seriesByName(name);
	
}

@RequestMapping("/update")
@ResponseBody
public void updateSeries(@RequestParam int id,@RequestParam String name) {
	
	System.out.println("series name updated");
	dao.update(id,name);
	
}

@RequestMapping("/delete")
@ResponseBody
public void deleteSeries(@RequestParam int id) {
	
	System.out.println("series deleted");
	dao.delete(id);
	
}






}