package kg.mega.rent.controllers;

import kg.mega.rent.models.Address;
import kg.mega.rent.models.Client;
import kg.mega.rent.models.dtos.ClientAddressDto;
import kg.mega.rent.models.dtos.ClientDto;
import kg.mega.rent.services.AddressService;
import kg.mega.rent.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public List<ClientDto> getClients (@RequestParam(defaultValue = "10") int rowsCount, @RequestParam(defaultValue = "1") int pageNumber) {
        return clientService.getClients(rowsCount, pageNumber);
    }

    @PostMapping("/create")
    public ClientAddressDto createClient(@RequestBody ClientAddressDto clientAddressDto) {
        return clientService.save(clientAddressDto);
    }
}
