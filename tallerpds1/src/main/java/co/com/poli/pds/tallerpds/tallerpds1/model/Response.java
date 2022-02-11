package co.com.poli.pds.tallerpds.tallerpds1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
	
	private Integer statusCode;
	private String message;
	private Object data;
	
}
