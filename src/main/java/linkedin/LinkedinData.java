package linkedin;

import org.testng.annotations.DataProvider;

public class LinkedinData {
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][2];
		
		data[0][0]="vaibhavphaltankar99@gmail.com";
		data[0][1]="Vaibhav@123@";
				
		return data;
		
		
	}

}
