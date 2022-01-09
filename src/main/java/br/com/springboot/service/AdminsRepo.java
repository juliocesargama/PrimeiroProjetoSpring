package br.com.springboot.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.springboot.models.Admin;

@Service
public interface AdminsRepo extends CrudRepository<Admin, Integer> {
    
}
