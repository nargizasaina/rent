package kg.mega.rent.repos;

import kg.mega.rent.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface ClientRepo extends JpaRepository<Client, Long> {
//    @Query("select new kg.mega.rent.models.dtos.ClientDto(с) from Client с")
    List<Client> findAllOrderByLastName(Pageable pageable);
}
