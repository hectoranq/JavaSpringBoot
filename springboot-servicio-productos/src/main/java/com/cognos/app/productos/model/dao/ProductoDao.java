package com.cognos.app.productos.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.cognos.app.productos.model.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
