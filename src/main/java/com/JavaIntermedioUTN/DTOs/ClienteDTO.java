package com.JavaIntermedioUTN.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {
   private String  cuit;
   private String razonSocial;
   private String emailCliente;


    public ClienteDTO(String cuit, String razonSocial, String emailCliente) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.emailCliente = emailCliente;
    }

}
