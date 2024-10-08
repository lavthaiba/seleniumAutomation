/**
 * @author Lav Thaiba
 */

package myPrj;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagerepo.DashboardPage;
import pagerepo.LoginPage;


public class LoginTest extends BaseClass{
		
	
	
	@Test(priority=1, description="Testcase - To Verify Successful Login")
	public void loginValid() {
		
		LoginPage login = new LoginPage(driver);
		login.inputEmail().sendKeys(login.email());
		login.inputPassword().sendKeys(login.password());
		login.loginBtn().click();
		System.out.println("Logged in successfully\n"+
							"Now verifying Login by validating Dashboard text..");
		
		DashboardPage dashboardText = new DashboardPage(driver);
		String actualDashboardText = dashboardText.dashboardLinkText().getText().trim();
		//System.out.println(actualDashboardText);
		String expectedDashboardText = "Dashboard";
		assertEquals(actualDashboardText, expectedDashboardText);
		test= extent.createTest("Valid Login Case");
		test.log(Status.PASS, "Test Passed with successful Login");
		Reporter.log("==Login Test case Verified==", true);
		
	}
	
			

}
