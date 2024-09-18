package com.cognos.app.items.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognos.app.items.model.Producto;

 
//LAB 6 Ribbon hace el balanceo se debe quitar el parametro URL
//@FeignClient(name="servicio-productos",url="http://localhost:8081")
@FeignClient(name="servicio-productos")
public interface ProductoClienteRest {
	
	@GetMapping("/listar")
	public List<Producto> listar();
	
	@GetMapping("/mostrar/{id}")
	public Producto mostrar(@PathVariable Long id);
}

