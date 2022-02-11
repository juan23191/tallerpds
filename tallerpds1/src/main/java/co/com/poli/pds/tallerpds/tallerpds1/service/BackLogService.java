package co.com.poli.pds.tallerpds.tallerpds1.service;

import java.util.List;

import co.com.poli.pds.tallerpds.tallerpds1.entity.BackLog;

public interface BackLogService {
	
//	ResponseEntity<BackLog> createBackLog(BackLog newBackLog);
//	List<BackLog> consultarBackLog();
	
	int save(BackLog backlog);
    void delete(BackLog backlog);
    List<BackLog> findAll();
    BackLog findById(Long id);
    boolean verificarIngesta(BackLog newBackLog);
	
}
