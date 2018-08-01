package top.arexstorm.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class AppResponse {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer code;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<?> dataList;

	public AppResponse() {
	}

	public AppResponse(int code, String message, Object data, List<?> dataList) {
		this.code = code;
		this.message = message;
		this.data = data;
		this.dataList = dataList;
	}

	public static AppResponse okData() {
		AppResponse a = new AppResponse();
		a.code = 200;
		a.message = "success";
		return a;
	}

	public static AppResponse okData(Object data) {
		AppResponse a = new AppResponse();
		a.data = data;
		a.code = 200;
		a.message = "success";
		return a;
	}

	public static AppResponse okList(List<?> dataList) {
		AppResponse a = new AppResponse();
		a.dataList = dataList;
		a.code = 200;
		a.message = "success";
		return a;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
}
