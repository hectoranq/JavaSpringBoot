package com.cognos.app.items.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognos.app.items.model.Item;
import com.cognos.app.items.model.service.ItemService;

@RefreshScope
@RestController
public class ItemController {
    
	@Autowired
	private Environment env;
	
	private static Logger log =     
            LoggerFactory.getLogger(ItemController.class);

	@Value("${configuracion.texto}")
    private String texto;

	// Seleccionamos el cliente del servicio basado en OpenFeign
	@Autowired
    @Qualifier("itemServiceFeign")    
	private ItemService itemService;
	
    @GetMapping("/listar")
    public List<Item> listar(){
    	return itemService.findAll();
    }
    
    @GetMapping("/mostrar/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id,@PathVariable Integer cantidad) {
    	return itemService.findbyId(id, cantidad);
    }
    
    @GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfiguracion(@Value("${server.port}") 
                                                            String puerto){
    	log.info(texto);
    	Map<String,String> json = new HashMap<>();
    	json.put("texto", texto);
    	json.put("puerto", puerto);
    	
    	//Mostramos los datos del perfil siempre que sea dev
    	if (env.getActiveProfiles().length > 0  &&  env.getActiveProfiles()[0].equals("dev")) {
    		json.put("autor.nombre",env.getProperty("configuracion.autor.nombre") );
    		json.put("autor.email",env.getProperty("configuracion.autor.email") );
    	}    	
    	return new ResponseEntity<Map<String , String>> (json, HttpStatus.OK);
    } 

}
