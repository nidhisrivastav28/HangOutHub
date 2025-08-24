package com.hangouthub.hangouthub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hangouthub.hangouthub.models.Mood;
import com.hangouthub.hangouthub.services.MoodService;

@RestController
@RequestMapping("api/moods")
public class RestAPIController {
	
	@Autowired
	private MoodService moodService;
	
	@GetMapping
	public List<Mood> getAllMoods(){
		return moodService.getAllMoods();
	}
	@GetMapping("/{id}")
	public Mood getMoodById(@PathVariable Long id) {
		return moodService.getMoodById(id);
	}
	// @PostMapping
	// public Mood createMood(@RequestBody Mood mood) {
	// 	return moodService.saveMood(mood);
	// }
	@DeleteMapping("/{id}")
	public void deleteMood(@PathVariable Long id) {
		moodService.deleteMood(id);
	}
}
