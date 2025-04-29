package com.ferreteria.pfeifer.repository;



import com.ferreteria.pfeifer.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio que maneja el acceso a datos de la entidad Cliente.
 * Extiende CrudRepository para operaciones básicas CRUD.
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {
    // Aquí podríamos agregar métodos personalizados si es necesario.
}
