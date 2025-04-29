package com.ferreteria.pfeifer.service;


import com.ferreteria.pfeifer.model.Cliente;
import com.ferreteria.pfeifer.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que maneja la lógica de negocio relacionada a los Clientes.
 */
@Service
public class ClienteService {

    // Acceso a la capa de datos de Cliente
    private final ClienteRepository clienteRepository;

    /**
     * Constructor que inyecta ClienteRepository automáticamente.
     */
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Obtiene todos los clientes almacenados.
     *
     * @return Lista de clientes.
     */
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    /**
     * Guarda un nuevo cliente o actualiza uno existente.
     *
     * @param cliente Cliente a guardar.
     * @return Cliente guardado.
     */
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param id ID del cliente.
     * @return Cliente envuelto en Optional (puede estar vacío).
     */
    public Optional<Cliente> findById(String id) {
        return clienteRepository.findById(id);
    }

    /**
     * Elimina un cliente por su ID.
     *
     * @param id ID del cliente a eliminar.
     */
    public void eliminarCliente(String id) {
        clienteRepository.deleteById(id);
    }
}
