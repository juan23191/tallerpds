package co.com.poli.pds.tallerpds.tallerpds1.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.poli.pds.tallerpds.tallerpds1.entity.Project;

@Service
@RequestMapping("/project")
@CrossOrigin //Para manejar las solicitudes cruzadas que provienen del navegador del cliente
public interface ProjectService {

	boolean save(Project product);
    void delete(Project product);
    List<Project> findAll();
    Project findById(Long id);
	boolean verificarIngesta(Project project);
	
}
