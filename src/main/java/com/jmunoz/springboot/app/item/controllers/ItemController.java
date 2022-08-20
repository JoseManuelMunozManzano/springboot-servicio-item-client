package com.jmunoz.springboot.app.item.controllers;

import com.jmunoz.springboot.app.item.models.Item;
import com.jmunoz.springboot.app.item.models.Producto;
import com.jmunoz.springboot.app.item.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Para probar esta app primero tenemos que arrancar la de productos, ya que items depende de productos.
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/listar")
    public List<Item> listar() {
        return itemService.findAll();
    }

    // Se ha provocado un error en el servicio producto.
    // https://github.com/JoseManuelMunozManzano/springboot-servicio-productos-client
    // Ver commit: Generado error para probar Hystrix
    //
    // En caso de fallo se indica un método alternativo.
    // Es lo que se llama un cortocircuito. Cerramos el camino actual y derivamos a otro camino alternativo.
    // Evitamos errores en cascada.
    @HystrixCommand(fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
        return itemService.findById(id, cantidad);
    }

    // El método alternativo tiene que tener la misma cabecera que detalle. Cambia la implementación.
    public Item metodoAlternativo(@PathVariable Long id, @PathVariable Integer cantidad) {
        Item item = new Item();
        Producto producto = new Producto();

        // Esto podría hacer uso de otro endpoint, usando Feign...
        // Aquí se pasa un item hecho a mano
        item.setCantidad(cantidad);
        producto.setId(id);
        producto.setNombre("Camara Sony");
        producto.setPrecio(500.00);
        item.setProducto(producto);
        return item;
    }
}
