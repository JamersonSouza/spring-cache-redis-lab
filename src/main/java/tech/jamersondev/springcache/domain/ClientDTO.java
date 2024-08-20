package tech.jamersondev.springcache.domain;

public record ClientDTO(String name, String email) {
    public ClientDTO(Client client) {
        this(client.getName(), client.getEmail());
    }
}
