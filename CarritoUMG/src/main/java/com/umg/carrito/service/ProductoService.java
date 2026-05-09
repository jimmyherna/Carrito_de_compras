package com.umg.carrito.service;

import com.umg.carrito.model.Producto;
import com.umg.carrito.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Lógica para listar todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // Lógica para guardar (aquí podrías validar el stock antes de guardar)
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }
}
