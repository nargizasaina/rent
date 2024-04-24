package kg.mega.rent.mappers;

import kg.mega.rent.models.Address;
import kg.mega.rent.models.dtos.ClientAddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address clientAddressDtoToAddress(ClientAddressDto clientAddressDto);
}
