package com.gaos.users.repositories;

import com.gaos.users.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
