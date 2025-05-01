package com.ferreteria.pfeifer.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Admin extends Persona {
    private String idAdmin;
}
