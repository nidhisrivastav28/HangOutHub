package com.hangouthub.hangouthub.services;

import java.util.List;

import com.hangouthub.hangouthub.models.Mood;

public interface MoodService {
	List<Mood> getAllMoods();
	Mood getMoodById(Long id);
	Mood saveMood(Mood mood);
	void deleteMood(Long id);
}
