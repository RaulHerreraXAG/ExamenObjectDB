package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.Cliente;

public class Session {
    @Getter
    @Setter
    private static Cliente currentCliente;
}
