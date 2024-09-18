package com.cognos.app.items.model.service;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognos.app.items.model.Item;
import com.cognos.app.items.model.Producto;

@Service
public class ItemServiceImpl implements ItemService {
    
	// ItemServiceImpl es un cliente que usa RestTemplate
	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		String url="http://localhost:8081/listar";
		List<Producto> productos = Arrays.asList(clienteRest.getForObject(url, Producto[].class));
		List<Item> items =  productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
		return items;
	}

	@Override
	public Item findbyId(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String,String>();
		pathVariables.put("id",id.toString());
		String url = "http://localhost:8081/mostrar/{id}";
		Producto producto = clienteRest.getForObject(url, Producto.class,pathVariables);
		return new Item(producto, cantidad);
	}

}
