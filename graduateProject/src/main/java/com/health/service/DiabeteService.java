package com.health.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.CardioTb;
import com.health.entity.DiabetesTb;
import com.health.repository.CardioRepository;
import com.health.repository.DiabetesRepository;

@Service
public class DiabeteService {
	
	@Autowired
	DiabetesRepository diabeteRepo;
	
	
	public void create(DiabetesTb dia)
	{
		diabeteRepo.save(dia);
	}
	
	public void delete(int id)
	{
		diabeteRepo.deleteById(id);
	}
	
	public List<DiabetesTb> findDiabetesTb()
	{
		List<DiabetesTb> list = new ArrayList<>();
		list = diabeteRepo.findAll();
		return list;
		
	}
	public DiabetesTb findDiabetesTbById(int id)
	{
		Optional<DiabetesTb> co = diabeteRepo.findById(id);
		return co.get();
	}

	
}
