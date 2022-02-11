package co.com.poli.pds.tallerpds.tallerpds1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import co.com.poli.pds.tallerpds.tallerpds1.entity.Project;
import co.com.poli.pds.tallerpds.tallerpds1.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CrossOrigin
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean save(Project project) {
		boolean validData = true;
		if (verificarIngesta(project)) {
			List<Project> projectsAll = projectRepository.findAll();
			for (Project projectValid : projectsAll) {
				if (projectValid.getProjectIdentifier().toUpperCase()
						.equals(project.getProjectIdentifier().toUpperCase())
						|| projectValid.getProjectName().toUpperCase().equals(project.getProjectName().toUpperCase())) {
					validData = false;
				} else {
					validData = true;
				}
			}
		}
		return validData;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Project project) {
		projectRepository.delete(project);
	}

	@Transactional(readOnly = true)
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Project findById(Long id) {
		return projectRepository.findById(id).orElse(null);
	}

	@Override
	public boolean verificarIngesta(Project newProject) {
		System.out.println(newProject.getProjectIdentifier());
		if (newProject.getProjectName() == "" || newProject.getProjectIdentifier() == ""
				|| newProject.getDescription() == "") {
			return false;
		} else {
			return true;
		}
	}

}
