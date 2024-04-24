package kg.mega.rent.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientAddressDto {
    @JsonFormat(pattern = "client_id")
    Long id;
    String firstName;
    String lastName;
    String patronymic;
    String street;
    String house;
    int flat;
    int floor;
}
