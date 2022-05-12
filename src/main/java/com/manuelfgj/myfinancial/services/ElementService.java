package com.manuelfgj.myfinancial.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.manuelfgj.myfinancial.entities.Element;
import com.manuelfgj.myfinancial.repositories.ElementRepository;
import com.manuelfgj.myfinancial.services.exceptions.DatabaseException;
import com.manuelfgj.myfinancial.services.exceptions.ResourceNotFoundException;

@Service
public class ElementService {

	@Autowired
	private ElementRepository repository;

	public List<Element> findAll() {
		return repository.findAll();
	}

	public Element findById(Long id) {
		Optional<Element> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Element insert(Element obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Element update(Long id, Element obj) {
		try {
			Element entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Element entity, Element obj) {
		entity.setDescription(obj.getDescription());
		entity.setDate(obj.getDate());
		entity.setOperation(obj.getOperation());
		entity.setGroup(obj.getGroup());
		entity.setType(obj.getType());
		entity.setPortion(obj.getPortion());

	}

}
