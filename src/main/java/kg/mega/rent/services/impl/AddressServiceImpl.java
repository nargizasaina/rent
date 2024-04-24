package kg.mega.rent.services.impl;

import kg.mega.rent.mappers.AddressMapper;
import kg.mega.rent.models.Address;
import kg.mega.rent.models.dtos.ClientAddressDto;
import kg.mega.rent.repos.AddressRepo;
import kg.mega.rent.services.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address saveClientAddress(ClientAddressDto clientAddressDto) {
        Address address = AddressMapper.INSTANCE.clientAddressDtoToAddress(clientAddressDto);
        address = addressRepo.save(address);
        return address;
    }
}
