import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PS_Page {

	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) {

		//WebDriver driver = new FirefoxDriver();

//http://toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/
		
    	int delay = 500;
    	//WebDriver driver = new FirefoxDriver();
    	//user.dir = C:\Users\brahv\eclipse-workspace\MyNottinghamUIAutomation
		
    	System.out.println(System.getProperty("user.dir"));
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:/Users/brahv/eclipse-workspace/UoNUIAutomation" + "/drivers/chromedriver.exe");
		
    	driver = new ChromeDriver();
    	wait = new WebDriverWait(driver, 1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		

		//StaleElement
		//driver.get("https://csregr.transform.nottingham.ac.uk/psp/csregr/EMPLOYEE/HRMS/c/PROCESS_APPLICATIONS.ADM_APPL_ENTRY1.GBL?FolderPath=PORTAL_ROOT_OBJECT.HCAD_STUDENT_ADMISSIONS.HCAD_APPLICATION_ENTRY.HC_ADM_APPL_ENTRY1_GBL");
		
		//GetRuleOutcome
		
		https://csregr.transform.nottingham.ac.uk/psp/csregr/EMPLOYEE/HRMS/c/UN_PRG_CONFIG_TBL.UN_PRG_STD_CALC_DT.GBL?FolderPath=PORTAL_ROOT_OBJECT.UN_BOLTONS.UN_AWARD_CALC_FLDR.UN_PROGRESSION.UN_PRG_STD_CALC_DT_GBL&IsFolder=false&IgnoreParamTempl=FolderPath%2cIsFolder
		driver.findElement(By.id("userid")).sendKeys("brahv");
		driver.findElement(By.id("pwd")).sendKeys("Agra0717");
		driver.findElement(By.name("Submit")).click();

		//staleElement();
		GetRuleOutcome("myRule");
}
	
	public static void staleElement()
	{
		
		driver.switchTo().frame("ptifrmtgtframe");
		driver.findElement(By.id("ADM_APPL_SCTY_EMPLID")).clear();
		driver.findElement(By.id("ADM_APPL_SCTY_EMPLID")).sendKeys("NEW2");
		driver.findElement(By.id("ADM_APPL_SCTY_INSTITUTION")).clear();
		driver.findElement(By.id("ADM_APPL_SCTY_INSTITUTION")).sendKeys("UON2");
		
		
		//driver.findElement(By.id("ADM_APPL_SCTY_ACAD_CAREER")).sendKeys("ab");
		
		
		int count = 0;
		boolean clicked = false;
		while (count < 4 || !clicked){
		    try {
		       WebElement yourSlipperyElement= driver.findElement(By.id("ADM_APPL_SCTY_ACAD_CAREER"));
		       yourSlipperyElement.sendKeys("ab"); 
		       clicked = true;
		     } catch (StaleElementReferenceException e){
		       e.toString();
		       System.out.println("Trying to recover from a stale element :" + e.getMessage());
		       count = count+1;
		     }   		
		
		
		driver.findElement(By.id("#ICSearch")).click();

		driver.switchTo().defaultContent();
		//driver.close();
	}

	}

	public static String GetRuleOutcome(String rule)
	{
		
		List<WebElement> ruleNames = driver.findElements(By.xpath("//*[@id='UN_PRG_RULE_VW_SCC_RULE_NAME'"));
		WebElement ruleName;
		String str_rule = "UN Progression - UG - Regulation 9";
		String ruleOutcome = "myRule";
		
		int i=1;  
	    while(i<=7){  
	        
	        ruleName = driver.findElement(By.xpath("//*[@id='UN_PRG_RULE_VW_SCC_RULE_NAME$'"+i));
	        System.out.println(ruleName.getText());  
	        
	    i++;  
	    }  

		return ruleOutcome;
	}



}