package kg.mega.rent.services;

import kg.mega.rent.models.Address;
import kg.mega.rent.models.dtos.ClientAddressDto;

public interface AddressService {
    Address saveClientAddress(ClientAddressDto clientAddressDto);
}
