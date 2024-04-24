package kg.mega.rent.mappers;

import kg.mega.rent.models.Address;
import kg.mega.rent.models.Client;
import kg.mega.rent.models.dtos.ClientAddressDto;
import kg.mega.rent.models.dtos.ClientDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);


    @Mapping(source = "clientId", target = "id")
    @Mapping(source = "name", target = "firstName")
    Client clientDtoToClient(ClientDto clientDto);

    @InheritInverseConfiguration
    ClientDto clientToClientDto(Client client);

    @Mapping(target = "client.address", source = "address")
    Client clientAddressDtoToClient(ClientAddressDto clientAddressDto, Address address);

    List<ClientDto> clientsToClientDtos(List<Client> clients);
}
