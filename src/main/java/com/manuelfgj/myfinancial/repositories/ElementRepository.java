package com.manuelfgj.myfinancial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manuelfgj.myfinancial.entities.Element;

public interface ElementRepository extends JpaRepository<Element, Long>{

}
