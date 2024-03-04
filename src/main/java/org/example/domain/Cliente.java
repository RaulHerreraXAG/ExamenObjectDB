package org.example.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombrecliente;
    private Long totalventas = 0L;
    private String estado;



    public Cliente() {}

    public Cliente(Long id, String nombrecliente, Long totalventas, String estado) {
        this.id = id;
        this.nombrecliente = nombrecliente;
        this.totalventas = totalventas;
        this.estado = estado;
    }
}
