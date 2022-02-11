package co.com.poli.pds.tallerpds.tallerpds1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import co.com.poli.pds.tallerpds.tallerpds1.helper.ResponseBuilder;
import co.com.poli.pds.tallerpds.tallerpds1.entity.Project;
import co.com.poli.pds.tallerpds.tallerpds1.model.Response;
import co.com.poli.pds.tallerpds.tallerpds1.repository.ProjectRepository;
import co.com.poli.pds.tallerpds.tallerpds1.service.ProjectService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

	private final ProjectService projectService;
	private final ProjectRepository projectRepository;
	private final ResponseBuilder builder;

	@PostMapping
	public Response save(@Validated @RequestBody Project project, BindingResult result) {

		boolean validProject = projectService.save(project);
		System.out.print(validProject);
		if (result.hasErrors() || !validProject) {
			return builder.failed(formatMessage(result));
		} else {
			projectRepository.save(project);
			return builder.success(project);
		}
	}

	@GetMapping
	public Response findAll() {
		List<Project> products = projectService.findAll();
		if (products.isEmpty()) {
			return builder.failed();
		}
		return builder.success(products);
	}

	private List<Map<String, String>> formatMessage(BindingResult result) {
		List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {
			Map<String, String> error = new HashMap<>();
			error.put(err.getField(), err.getDefaultMessage());
			return error;
		}).collect(Collectors.toList());
		return errors;
	}
}
