package com.JavaIntermedioUTN.Controladores;

import com.JavaIntermedioUTN.DTOs.ClienteDTO;
import com.JavaIntermedioUTN.Modelos.Cliente;
import com.JavaIntermedioUTN.Servicios.ServicioDeClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControladorDeCliente {

    @Autowired
    private ServicioDeClientes servicioDeClientes;

    @GetMapping
    public List<Cliente> getClientes(){
      return servicioDeClientes.getClientes();
    }

    @PostMapping
    public void crearCliente(@RequestBody ClienteDTO clienteDTO){
        servicioDeClientes.crearCliente(clienteDTO);


    }

    @DeleteMapping("/{cuit}")
    public void deleteCliente (@PathVariable String cuit){
        servicioDeClientes.borrarCliente(cuit);
    }


}
