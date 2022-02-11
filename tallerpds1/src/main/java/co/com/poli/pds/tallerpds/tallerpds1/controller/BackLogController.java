package co.com.poli.pds.tallerpds.tallerpds1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.pds.tallerpds.tallerpds1.entity.BackLog;
import co.com.poli.pds.tallerpds.tallerpds1.helper.ResponseBuilder;
import co.com.poli.pds.tallerpds.tallerpds1.model.Response;
import co.com.poli.pds.tallerpds.tallerpds1.repository.BackLogRepository;
import co.com.poli.pds.tallerpds.tallerpds1.service.BackLogService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/backlogs")
@RequiredArgsConstructor
public class BackLogController {
	
	private final BackLogService backLogService;
	private final BackLogRepository backlogRepository;
	
	private final ResponseBuilder builder;
	
	@PostMapping
	public Response createBackLog(@RequestBody BackLog newBackLog){
		int flag = backLogService.save(newBackLog);
		System.out.print(flag);
		if(flag == 0) {
			backlogRepository.save(newBackLog);
			return builder.success(newBackLog);
		}else {
			return builder.failed();
		}
	}
	
	
	@GetMapping("/{idBack}")
	public Response findById(@PathVariable("idBack") Long id) {
		BackLog back = backLogService.findById(id);
		if(back == null) {
			return builder.failed();
		}
		return builder.success(back);
	}
}
