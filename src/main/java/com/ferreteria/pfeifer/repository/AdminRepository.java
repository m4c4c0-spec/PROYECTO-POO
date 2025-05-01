package com.ferreteria.pfeifer.repository;

import com.ferreteria.pfeifer.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {

}
