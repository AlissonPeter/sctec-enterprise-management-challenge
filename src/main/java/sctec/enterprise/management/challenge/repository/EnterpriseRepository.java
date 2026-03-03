package sctec.enterprise.management.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sctec.enterprise.management.challenge.model.Enterprise;

@Repository
public interface EnterpriseRepository  extends JpaRepository<Enterprise, Integer> {
}
