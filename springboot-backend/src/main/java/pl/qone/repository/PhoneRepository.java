package pl.qone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.qone.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long>{

}
