package linkedin;

import org.testng.annotations.DataProvider;

public class loginData {
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[2][2];
		
		data[0][0] = "gmail.com";
		data[0][1] = "12345";
		
		return data;
	}
	
//	@DataProvider
//	public Object[][] getData2(){
//		Object[][] data=new Object[2][2];
//		
//		data[0][0]="mobile cover redmi note 8";
//		data[0][1]="";
//		
//		return null;
//		
//	}

}
