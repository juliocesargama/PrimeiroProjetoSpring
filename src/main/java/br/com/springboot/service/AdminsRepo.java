package br.com.springboot.service;

import org.springframework.data.repository.CrudRepository;

import br.com.models.Admin;

public interface AdminsRepo extends CrudRepository<Admin, Integer> {
    
}
