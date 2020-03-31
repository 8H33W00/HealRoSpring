package com.health.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.CardioTb;
import com.health.repository.CardioRepository;


@Service
public class CardioService {
	@Autowired
	CardioRepository cardioRepo;
	
	
	public void create(CardioTb cardio)
	{
		cardioRepo.save(cardio);
	}
	
	public void delete(int id)
	{
		cardioRepo.deleteById(id);
	}
	
	public List<CardioTb> findCardioTb()
	{
		List<CardioTb> list = new ArrayList<>();
		list = cardioRepo.findAll();
		return list;
		
	}
	public CardioTb findCardioTbById(int id)
	{
		Optional<CardioTb> co = cardioRepo.findById(id);
		return co.get();
	}
}
