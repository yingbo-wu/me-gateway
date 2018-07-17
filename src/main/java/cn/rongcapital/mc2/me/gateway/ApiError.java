package cn.rongcapital.mc2.me.gateway;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import cn.rongcapital.mc2.me.commons.api.ApiMessageReader;
import cn.rongcapital.mc2.me.commons.api.ApiResult;

@RestControllerAdvice
public class ApiError {

	@Autowired
	private ApiMessageReader apiMessageReader;

	@ExceptionHandler(WebExchangeBindException.class)
	@ResponseStatus(HttpStatus.OK)
	public ApiResult<?> serverExceptionHandler(WebExchangeBindException exception) {
		BindingResult bindingResult = exception.getBindingResult();
		Object target = bindingResult.getTarget();
		Class<?> clazz = target.getClass();
		String className = clazz.getName();
		List<FieldError> errors = exception.getFieldErrors();
		if (CollectionUtils.isNotEmpty(errors)) {
			FieldError error = errors.stream().findFirst().get();
			String messageCode = error.getDefaultMessage();
			return apiMessageReader.read(className, messageCode);
		}
		return ApiResult.error(-1, exception.getMessage());
	}

}
