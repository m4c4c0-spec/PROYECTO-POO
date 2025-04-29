package com.ferreteria.pfeifer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private String idCliente;
    private String nombre;
    private String email;
    private String telefono;
    private String contrasena;
}


