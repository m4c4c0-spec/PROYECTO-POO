package com.ferreteria.pfeifer.controller;



// Importaciones necesarias para trabajar con Spring Boot y HTTP
import com.ferreteria.pfeifer.model.Cliente;
import com.ferreteria.pfeifer.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST que maneja las operaciones relacionadas a los clientes.
 * Ruta base: /clientes
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    // Inyección de la capa de servicio que maneja la lógica de negocio para Cliente
    private final ClienteService clienteService;

    /**
     * Constructor que inyecta el ClienteService mediante @Autowired.
     */
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Obtiene la lista de todos los clientes registrados.
     * Método HTTP: GET /clientes
     *
     * @return ResponseEntity con la lista de clientes y código 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    /**
     * Crea un nuevo cliente en la base de datos.
     * Método HTTP: POST /clientes
     *
     * @param cliente Objeto Cliente recibido en el cuerpo de la petición.
     * @return ResponseEntity con el cliente creado y código 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.save(cliente);
        return ResponseEntity.status(201).body(nuevoCliente);
    }

    /**
     * Busca un cliente por su ID.
     * Método HTTP: GET /clientes/{id}
     *
     * @param id ID del cliente a buscar.
     * @return ResponseEntity con el cliente encontrado o código 404 (NOT FOUND) si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable String id) {
        Optional<Cliente> clienteOpt = clienteService.findById(id);
        return clienteOpt
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Elimina un cliente por su ID.
     * Método HTTP: DELETE /clientes/{id}
     *
     * @param id ID del cliente a eliminar.
     * @return ResponseEntity con código 204 (NO CONTENT) si la eliminación es exitosa.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable String id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}