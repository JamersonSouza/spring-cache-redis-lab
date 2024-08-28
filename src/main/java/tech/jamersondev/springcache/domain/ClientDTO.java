package tech.jamersondev.springcache.domain;

import java.io.Serializable;

public record ClientDTO(String name, String email) implements Serializable {
    public ClientDTO(Client client) {
        this(client.getName(), client.getEmail());
    }
}
