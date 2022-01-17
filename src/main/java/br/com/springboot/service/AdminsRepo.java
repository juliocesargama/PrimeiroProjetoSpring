package br.com.springboot.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.springboot.models.Admin;

@Service
public interface AdminsRepo extends CrudRepository<Admin, Integer> {


    @Query(value= "SELECT * FROM admins WHERE email = :email AND password = :password", nativeQuery = true)
    public Admin Login(String email, String password);

}
