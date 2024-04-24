package kg.mega.rent.services;

import kg.mega.rent.models.Client;
import kg.mega.rent.models.dtos.ClientAddressDto;
import kg.mega.rent.models.dtos.ClientDto;

import java.util.List;

public interface ClientService {

    ClientAddressDto save(ClientAddressDto clientAddressDto);

    List<ClientDto> getClients(int rowsCount, int pageNumber);
}
