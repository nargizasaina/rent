package kg.mega.rent.models.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kg.mega.rent.models.Address;
import kg.mega.rent.models.Client;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDto {
    Long clientId;
    String name;
    String lastName;
    String patronymic;
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;
}
