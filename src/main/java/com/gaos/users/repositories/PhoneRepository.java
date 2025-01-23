package com.gaos.users.repositories;

import com.gaos.users.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
