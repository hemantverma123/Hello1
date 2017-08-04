import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WD_findElements 
{
    @Test
    public void test_byxpath() throws InterruptedException{

    	int delay = 500;
    	//WebDriver driver = new FirefoxDriver();
    	//user.dir = C:\Users\brahv\eclipse-workspace\MyNottinghamUIAutomation
		
    	System.out.println(System.getProperty("user.dir"));
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:/Users/brahv/eclipse-workspace/MyNottinghamUIAutomation" + "/drivers/chromedriver.exe");
		
    	WebDriver driver = new ChromeDriver();
    	WebDriverWait wait = new WebDriverWait(driver, 1000);
		

        try{
            driver.get("https://csregr.transform.nottingham.ac.uk/psp/csregr/?&cmd=login&languageCd=UKE");
            
            //driver.findElement(By.linkText("Sign in to PeopleSoft")).click(); will be displayed after logout
            
            driver.findElement(By.id("userid")).clear();
            driver.findElement(By.id("userid")).sendKeys("brahv");
            driver.findElement(By.id("pwd")).clear();
            driver.findElement(By.id("pwd")).sendKeys("Agra0717");
            driver.findElement(By.name("Submit")).click();
           
            
            driver.findElement(By.id("pthnavbca_PORTAL_ROOT_OBJECT")).click();

    		//wait.until(ExpectedConditions.visibilityOf(element));
    		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("fldra_UN_BOLTONS"))));
            driver.findElement(By.id("fldra_UN_BOLTONS")).click();
            
            Thread.sleep(delay);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("fldra_UN_AWARD_CALC_FLDR"))));
            driver.findElement(By.id("fldra_UN_AWARD_CALC_FLDR")).click();
            Thread.sleep(delay);
            
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("fldra_UN_PROGRESSION"))));
            driver.findElement(By.id("fldra_UN_PROGRESSION")).click();
            
            Thread.sleep(delay);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("crefli_UN_PRG_STD_CALC_DT_GBL"))));
            driver.findElement(By.id("crefli_UN_PRG_STD_CALC_DT_GBL")).click();
            
            
            // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _parent | 30000]]
            // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | TargetContent | ]]
            Thread.sleep(delay);
            
            driver.switchTo().frame("ptifrmtgtframe");

            //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("app_label"))));
            
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='app_label']"))));
            assertEquals("Student Calculation Details", driver.findElement(By.xpath("//*[@id='app_label']")).getText());

            driver.switchTo().defaultContent();

            
        
            List<WebElement> ele = driver.findElements(By.tagName("iframe"));
            System.out.println("Number of iframes in a page :" + ele.size());
            for(WebElement el : ele){
              //Returns the Id of a frame.
                System.out.println("Frame Id :" + el.getAttribute("id"));
              //Returns the Name of a frame.
                System.out.println("Frame name :" + el.getAttribute("name"));
            }
            
            System.out.println("Now printing all the elements on the page...");
            //List<WebElement> el = driver.findElements(By.cssSelector("*"));
            List<WebElement> el = driver.findElements(By.xpath("//*"));
            int count=0;
            for ( WebElement e : el ) {
             System.out.println("TagName: "+e.getTagName()+"	Text: "+e.getText()+"	id: "+e.getAttribute("id")+"	name: "+e.getAttribute("name"));

             count++;

            }
          System.out.println(count );
        }
        finally {
            driver.close();
        }

    }//end of test_byxpath

 public void xpathDemo2() {
           WebDriver driver = new FirefoxDriver();
           try{
               driver.get("http://www.hexbytes.com");
               WebElement webelement = driver.findElement(By.id("container"));
               //matching single element with attribute value=container
               System.out.println("The id value is: " + webelement.getAttribute("id"));
               System.out.println("The tag name is: " + webelement.getTagName());
           }
           finally {
               driver.close();
           }
       }//end of xpathDemo2 

public void xpathDemo3() {
       WebDriver driver = new FirefoxDriver();
       try{
           driver.get("http://www.hexbytes.com");
          //find first child node of div element with attribute=container
          List<WebElement> elements = driver.findElements(By.xpath("//div[@id='container']/*[1]"));
          System.out.println("Test1 number of elements: " + elements.size()); 

          for(WebElement ele : elements){
              System.out.println(ele.getTagName());
              System.out.println(ele.getAttribute("id"));
              System.out.println("");
              System.out.println("");
          }
   }
   finally {
       driver.close();
   }
 }//end of xpathDemo3
 }