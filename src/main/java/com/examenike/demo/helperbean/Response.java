package com.examenike.demo.helperbean;


//Clase de ayuda para la entrega de una respuesta de un servicio 
//codigo y mensaje de excepciones o por el contrario de correcto funcionamiento 
public class Response {

	private Integer errorCode;
	private Object infoError;

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Object getInfoError() {
		return infoError;
	}

	public void setInfoError(Object infoError) {
		this.infoError = infoError;
	}

}
