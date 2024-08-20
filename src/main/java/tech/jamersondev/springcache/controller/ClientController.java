package tech.jamersondev.springcache.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.jamersondev.springcache.domain.Client;
import tech.jamersondev.springcache.domain.ClientDTO;
import tech.jamersondev.springcache.repository.ClientRepository;
import tech.jamersondev.springcache.service.ClientService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {

   private final ClientService clientService;

   public ClientController(ClientService clientService) {
      this.clientService = clientService;
   }

   @GetMapping
   public ResponseEntity<List<ClientDTO>> listClients(){
      List<Client> clients = this.clientService.listClients();
      List<ClientDTO> listClients = clients.stream().map(ClientDTO::new).toList();
      if(listClients.isEmpty() || clients.isEmpty()){
         return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(listClients);
   }

   @PostMapping
   @Transactional
   public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO, UriComponentsBuilder uriComponentsBuilder){
      Client client = this.clientService.create(clientDTO);
      URI uri = uriComponentsBuilder.path("client/{clientId}").buildAndExpand(client.getClientId()).toUri();
      return ResponseEntity.created(uri).body(new ClientDTO(client));
   }
}
