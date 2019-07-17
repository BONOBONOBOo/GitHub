package lab.spring.web.model;

public class SearchVO {
	private String code;
	private String codeName;
	
	
	
	
	
	public SearchVO() {
		super();
	}
	
	public SearchVO(String code, String codeName) {
		super();
		this.code = code;
		this.codeName = codeName;
	}
	
	public String getCode() {
		return code;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	@Override
	public String toString() {
		return "SearchVO [code=" + code + ", codeName=" + codeName + "]";
	}
	
	

}
