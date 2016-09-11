package by.epamlab.registration;

import static by.epamlab.registration.Checkers.checkLength;
import static by.epamlab.registration.Checkers.checkSymbols;

public class TextValidator implements FieldValidator {

	private String fieldName;
	private String fieldValue;
	private String result = "";
	
	@Override
	public boolean validate() {
		if (fieldValue==null){
			throw new IllegalStateException("Field for checking not set");
		}
		if(!checkLength(fieldValue)){
			result = "Field "+fieldName+" less than 5 symbols.";
			return false;
		}
		if(!checkSymbols(fieldValue)){
			result = "Field "+fieldName+" contains wrong symbols.";
			return false;
		}
		
		return true;
	}

	
	public void setFieldName(String fieldName) {
		 this.fieldName = fieldName;
	}
	
	public void setFieldValue(String fieldValue) {
		 this.fieldValue = fieldValue;
	}
	
	public String getResultDescription() {
		return result;
	}
	
	public String getFieldName() {
		if (fieldName==null){
			throw new IllegalStateException("Field for checking not set");
		}
		return fieldName;
	}
}
