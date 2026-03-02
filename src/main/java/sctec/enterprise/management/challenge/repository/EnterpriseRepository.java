package sctec.enterprise.management.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sctec.enterprise.management.challenge.model.Enterprise;

public interface EnterpriseRepository  extends JpaRepository<Enterprise, Integer> {
}
