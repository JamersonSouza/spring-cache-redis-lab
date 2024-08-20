package tech.jamersondev.springcache.service;

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
    public Client create(ClientDTO clientDTO){
        Client client = new Client(clientDTO);
       return this.clientRepository.save(client);
    }
    public List<Client> listClients(){
        List<Client> allClients = this.clientRepository.findAll();
        return allClients;
    }
}
