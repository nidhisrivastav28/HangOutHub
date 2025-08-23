package com.hangouthub.hangouthub.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hangouthub.hangouthub.models.Mood;
import com.hangouthub.hangouthub.repository.MoodRepo;

@Service
public class MoodServiceImpl implements MoodService{
	@Autowired
	private MoodRepo moodRepo;

	@Override
	public List<Mood> getAllMoods() {
		return moodRepo.findAll();
	}
	@Override
	public Mood getMoodById(Long id) {
		return moodRepo.findById(id).orElse(null);
	}
	@Override
	public Mood saveMood(Mood mood) {
		return moodRepo.save(mood);
	}
	@Override
	public void deleteMood(Long id) {
		moodRepo.deleteById(id);
	}
	
}
