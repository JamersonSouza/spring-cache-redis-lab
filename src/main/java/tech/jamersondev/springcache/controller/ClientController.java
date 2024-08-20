package tech.jamersondev.springcache.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jamersondev.springcache.domain.ClientDTO;
import tech.jamersondev.springcache.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {


   @GetMapping
   public ResponseEntity<ClientDTO> listClients(){

   }
}
