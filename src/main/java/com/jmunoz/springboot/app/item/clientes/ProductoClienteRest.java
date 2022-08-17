package com.jmunoz.springboot.app.item.clientes;

import com.jmunoz.springboot.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Usando Ribbon se elimina la parte de la url y tenemos que configurarlo en el archivo properties con Ribbon.
// Con esto se desacopla aún más la ubicación física (ip, nombre máquina o localhost) y el puerto.
@FeignClient(name="servicio-productos")
public interface ProductoClienteRest {

    // Aquí en FeignClient se usa @GetMapping para consumir el servicio API REST, obtener los datos JSON convertidos
    // a objeto Producto.
    // Se indica la misma ruta que aparece en el @GetMapping del proyecto servicio productos
    @GetMapping("/listar")
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);

}
