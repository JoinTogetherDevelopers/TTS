package org.dorageecorp.exception;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

/**
 * 예외처리 핸들러 ( 에러처리 관련 논의 후 보강할 예정 )
 * 
 * @author soup
 *
 */
@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

	/**
	 * 존재하지 않는 프로젝트 요청 처리
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Project is not exist.")
	@ExceptionHandler(NoneProjectException.class)
	public void handleNoneProjectException() {
		log.debug("Project is not exist.");
	}

	/**
	 * 데이터베이스 관련 에러 처리
	 * 
	 * @param exception
	 * @return 데이터베이스 에러관련 화면
	 */
	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public String databaseError(Exception exception) {
		log.error("Request raised " + exception.getClass().getSimpleName());
		return "databaseError";
	}
}
