package com.coding.one2many.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.one2many.models.Ninja;
import com.coding.one2many.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository)
	{
		this.ninjaRepository=ninjaRepository;
	}
	
	// C	
	public void Create(Ninja ninja)
	{
		ninjaRepository.save(ninja);
	}
	
	// R
	public Ninja ReadOne(Long id)
	{
		Optional<Ninja> ninja=ninjaRepository.findById(id);		
		return ninja.isPresent()?ninja.get():null;
	}
	
	// R
	public ArrayList<Ninja> ReadAll()
	{
		ArrayList<Ninja> ninjas=(ArrayList<Ninja>)ninjaRepository.findAll();
		return ninjas;
	}
	
	//	U.
	public void Update(Ninja ninja)
	{
		Create(ninja);
	}
	
	// D.	
	public void Delete(Long id)
	{
		ninjaRepository.deleteById(id);
	}
}
