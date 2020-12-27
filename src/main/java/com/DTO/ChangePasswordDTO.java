package com.DTO;

public class ChangePasswordDTO {
	private String email;
	private String oldPassword;
	private String newPassword;

	@Override
	public String toString() {
		return "ChangePasswordDTO [email=" + email + ", oldPassword="+oldPassword+", newPassword=" + newPassword
				+ "]";
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(oldPassword) || isNull(newPassword);
		return includeId ? res || isNull(email) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
