package com.JavaIntermedioUTN.Servicios;

import com.JavaIntermedioUTN.DTOs.ClienteDTO;
import com.JavaIntermedioUTN.Modelos.Cliente;
import com.JavaIntermedioUTN.SistemaDeReportes.ConectorMySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServicioDeClientes {
    @Autowired
    private ConectorMySQL conectorMySQL;

    public void crearCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getCuit(), Set.of(), Set.of(), clienteDTO.getRazonSocial(), clienteDTO.getEmailCliente());
        conectorMySQL.insertar(cliente);
    }

    public List<Cliente> getClientes() {
        return conectorMySQL.getAll("Cliente");
    }

    public void borrarCliente(String cuit) {
        Cliente cliente = conectorMySQL.get(cuit, "Cliente", "cuitCliente");
        conectorMySQL.eliminar(cliente);

    }
}
