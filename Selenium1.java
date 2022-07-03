package com.mindtree.seleniumclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/ ");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("refrigerator");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("nav-search-submit-button")).submit();
		driver.findElement(By.xpath("(//a[contains(@href,'/Samsung-Direct-Refrigerator-RR19A24')])[1]")).click();
		WebElement price1=driver.findElement(By.xpath("(//a[contains(@href,'/Samsung-Direct-Refrigerator-RR19A24')])[4]/span//span[@class='a-price-whole']"));
		WebElement sym=driver.findElement(By.xpath("//span[@class='a-price-symbol'])[3]"));
        String pr=price1.getText();
        System.out.println(pr);
        
        Set<String> ids=driver.getWindowHandles();
	    Iterator<String> newpage=ids.iterator();
	    String parenttab=newpage.next();
	    String childtab=newpage.next();
	    driver.switchTo().window(childtab);
	    //System.out.println(driver.getTitle());
	    WebElement price2=driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//span[@class='a-price whole']"));
	    String prinext=price2.getText();
	    System.out.println(prinext);
	    if(prinext.equals(pr))
	    {
	    	System.out.println("same price");
	    }
	    else
	    {
	    	System.out.println("not same price");
	    }
	    int count=driver.findElements(By.xpath("//tr[@class='comparision_other_attribute_row']")).size();
	    //System.out.println(count);
	    for(int i=0;i<count;i++)
	    {
	    	String weight=driver.findElements(By.xpath("//tr[@class='comparision_other_attribute_row']//th")).get(i).getText();
	    	if(weight.equalsIgnoreCase("Item weight"))
	    	{
	    		System.out.println(driver.findElements(By.xpath("//td[2]//--span[@class='a-size-base a-color-base']")).get(i).getText());
	    		break;
	    	}
	    }
	    
	}
	
}
	    
	
	    
		