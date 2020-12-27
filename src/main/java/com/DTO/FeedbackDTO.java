package com.DTO;

public class FeedbackDTO {
	private Integer responseId;
	private String email;
	private String phone;
	private String content;

	public FeedbackDTO() {

	}

	public FeedbackDTO(Integer responseId, String email, String phone, String content) {
		super();
		this.responseId = responseId;
		this.email = email;
		this.phone = phone;
		this.content = content;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(email) || isNull(phone) || isNull(content);
		return includeId ? res || isNull(responseId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public Integer getResponseId() {
		return responseId;
	}

	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "FeedbackDTO [responseId=" + responseId + ", email=" + email + ", phone=" + phone + ", content="+ content + "]";
	}

}
