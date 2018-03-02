package com.quantlance;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
	public List<Country> findAllByOrderByNameAsc();
}
