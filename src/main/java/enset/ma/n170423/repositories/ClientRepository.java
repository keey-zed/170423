package enset.ma.n170423.repositories;

import enset.ma.n170423.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findByUsernameContains(String keyword, PageRequest pageRequest);
}
