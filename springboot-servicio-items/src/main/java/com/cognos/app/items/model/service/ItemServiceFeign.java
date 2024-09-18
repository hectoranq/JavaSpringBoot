package com.cognos.app.items.model.service;

import java.util.List;

import com.cognos.app.items.model.Item;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.cognos.app.items.cliente.ProductoClienteRest;


@Service
@Primary
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findbyId(Long id, Integer cantidad) {
		return new Item(clienteFeign.mostrar(id),cantidad);
	}

}
