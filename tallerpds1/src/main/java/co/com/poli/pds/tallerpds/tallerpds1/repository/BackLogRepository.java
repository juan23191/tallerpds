 package co.com.poli.pds.tallerpds.tallerpds1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.poli.pds.tallerpds.tallerpds1.entity.BackLog;

@Repository("iBackLogRepository")
public interface BackLogRepository extends JpaRepository<BackLog, Long>{

}
