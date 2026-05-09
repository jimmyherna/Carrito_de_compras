package com.umg.carrito.controller;

import com.umg.carrito.model.Producto;
import com.umg.carrito.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") 
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // Lógica para restar el stock al confirmar la compra
    @PutMapping("/{id}/comprar")
    public Producto restarStock(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        if (producto.getStock() > 0) {
            producto.setStock(producto.getStock() - 1);
            return productoRepository.save(producto);
        } else {
            throw new RuntimeException("Sin existencias de: " + producto.getNombre());
        }
    }
}
