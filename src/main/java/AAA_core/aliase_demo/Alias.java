package AAA_core.aliase_demo;

public class Alias {
	
	private int num;
	
	public void setNum(int num) {
		this.num=num;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public void changeAString(String str) {
		str = "this string has been changed";
	}
	
	public void changeAliaseDemoObj(AliaseDemo demo) {
		demo.str = "changed";
	}

}
