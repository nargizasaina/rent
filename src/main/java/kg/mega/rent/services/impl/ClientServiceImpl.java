package kg.mega.rent.services.impl;

import kg.mega.rent.mappers.ClientMapper;
import kg.mega.rent.models.Address;
import kg.mega.rent.models.Client;
import kg.mega.rent.models.dtos.ClientAddressDto;
import kg.mega.rent.models.dtos.ClientDto;
import kg.mega.rent.repos.ClientRepo;
import kg.mega.rent.services.AddressService;
import kg.mega.rent.services.ClientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    private final AddressService addressService;

    public ClientServiceImpl(ClientRepo clientRepo, AddressService addressService) {
        this.clientRepo = clientRepo;
        this.addressService = addressService;
    }

    @Override
    public ClientAddressDto save(ClientAddressDto clientAddressDto) {
        Address address = addressService.saveClientAddress(clientAddressDto);


        Client client = ClientMapper.INSTANCE.clientAddressDtoToClient(clientAddressDto, address);
        client = clientRepo.save(client);
        clientAddressDto.setId(client.getId());
        return clientAddressDto;
    }

    @Override
    public List<ClientDto> getClients(int rowsCount, int pageNumber) {
        List<Client> clients = clientRepo.findAllOrderByLastName((Pageable) PageRequest.of(pageNumber, rowsCount));
        return ClientMapper.INSTANCE.clientsToClientDtos(clients);
    }

    private String validateClientData(String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Введите данные клиента!");
        }

        if (data.length() < 2) {
            throw new IllegalArgumentException("Введите данные клиента!");
        }

        if (!data.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Строка должна содержать только алфавитные символы!");
        }
        return data.substring(0, 1).toUpperCase() + data.substring(1).toLowerCase();
    }
}
