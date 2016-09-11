package by.epamlab.registration;

public class PasswordValidator implements FieldValidator {
	
	private String fieldName;
	private String password;
	private String password2;
	private String result = "";

	@Override
	public boolean validate() {
		if (password==null || password2==null ){
			throw new IllegalStateException("Field for checking not set");
		}
		if(password.equals(password2)){
			return true;
		}
		result = "Passwords do not match.";
		return false;
	}

	public void setFieldName(String fieldName) {
		 this.fieldName = fieldName;

	}

	public void setFieldValue(String fieldValue) {
		this.password = fieldValue;

	}

	public void setSecondFieldValue(String fieldValue) {
		this.password2 = fieldValue;

	}

	
	public String getFieldName() {
		if (fieldName==null){
			throw new IllegalStateException("Field for checking not set");
		}
		return fieldName;
	}

	public String getResultDescription() {
		return result;
	}

}
