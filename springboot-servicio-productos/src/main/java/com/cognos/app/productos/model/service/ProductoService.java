package com.cognos.app.productos.model.service;

import java.util.List;

import com.cognos.app.productos.model.entity.Producto;

public interface ProductoService {
   public List<Producto> findAll();
   public Producto findById(Long id);
}
