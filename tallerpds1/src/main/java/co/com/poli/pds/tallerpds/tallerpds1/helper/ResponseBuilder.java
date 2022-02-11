package co.com.poli.pds.tallerpds.tallerpds1.helper;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import static org.springframework.http.HttpStatus.*;

import co.com.poli.pds.tallerpds.tallerpds1.model.Response;

@Component
public class ResponseBuilder {

    public Response success(){
        return Response.builder()
                .statusCode(OK.value())
                .message(CREATED.value() + " " + HttpStatus.CREATED.name())
                .data(OK.value())
                .build();
    }
    @JsonAnyGetter
    public Response success(Object data){
    	
        return Response.builder()
        		.statusCode(CREATED.value())
                .message(CREATED.value() + " " + HttpStatus.CREATED.name())
                .data(data)
                .build();
    }
    public Response failed(Object data){
        return Response.builder()
                .statusCode(BAD_REQUEST.value())
                .message(BAD_REQUEST.value() +" " + HttpStatus.BAD_REQUEST.name())
                .data(data)
                .build();
    }
    
    public Response failed() {

    	return Response.builder()
                .statusCode(BAD_REQUEST.value())
                .message(BAD_REQUEST.value() +" " + HttpStatus.BAD_REQUEST.name())
                .build();
    }
    
    public Response succes(Double valor) {
    	return Response.builder()
    					.statusCode(ACCEPTED.value())
    					.message(HttpStatus.ACCEPTED.name() + " [" + "El total de horas es: " + valor + "]")
    					.build();
    }
    
    public Response changeStatus() {
    	return Response.builder()
                .statusCode(ACCEPTED.value())
                .message(ACCEPTED.value() + " " + HttpStatus.ACCEPTED.name())
                .data(ACCEPTED.value())
                .build();
    }
    
 

}