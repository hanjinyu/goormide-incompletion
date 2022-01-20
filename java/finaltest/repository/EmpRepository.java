package finaltest.repository;

import finaltest.model.EmpEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface EmpRepository extends JpaRepository<EmpEntity, Long>{
}
