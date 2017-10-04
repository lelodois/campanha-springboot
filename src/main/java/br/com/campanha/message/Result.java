package br.com.campanha.message;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Base result")
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 5293702235435749775L;

	private boolean success;

	@ApiModelProperty(notes = "Mensagem somente em caso de erro")
	private String errorMessage;

	@ApiModelProperty(notes = "Objeto retornado")
	private T result;

	public Result() {
	}

	public Result(boolean success) {
		this();
		this.success = success;
	}

	public Result(Exception e) {
		this(false);
		this.errorMessage = e.getMessage();
	}

	public Result(String errorMessage) {
		this(false);
		this.errorMessage = errorMessage;
	}

	public Result(boolean success, T result) {
		this(success);
		this.result = result;
	}

	public void setResult(T objectResult) {
		this.result = objectResult;
	}

	public T getResult() {
		return result;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

}
