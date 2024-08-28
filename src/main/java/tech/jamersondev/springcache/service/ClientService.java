package tech.jamersondev.springcache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.jamersondev.springcache.domain.Client;
import tech.jamersondev.springcache.domain.ClientDTO;
import tech.jamersondev.springcache.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @CacheEvict(value = "list_clients_cache", allEntries = true)
    public Client create(ClientDTO clientDTO){
        Client client = new Client(clientDTO);
       return this.clientRepository.save(client);
    }

    @Cacheable(value = "list_clients_cache")
    public List<Client> listClients(){
        List<Client> allClients = this.clientRepository.findAll();
        return allClients;
    }
}
