package PageObjects;

import java.time.Duration;
import java.time.Month;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePAge extends BaseObject {

	public HomePAge(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="(//div[@role='Combobox']/p)[2]")
	WebElement src;
	@FindBy(xpath="//input[contains(@id,'input-with-icon-adornment')]")
	WebElement srcname;
	@FindBy(xpath="(//div[@role='Combobox']/p)[5]")
	WebElement dest;
	@FindBy(xpath="((//ul)[2]//li)[1]")
	WebElement autosug;
	@FindBy(xpath="//div[@aria-label='Departure Date inputbox']//div[2]")
	WebElement cl;
	@FindBy(xpath="(//div[contains(@class,'react-datepicker__month-container')])[1]//div[@role='option' and not(contains(@class,'outside-month'))]//span[contains(@class,'custom-day-content ')]")
	List<WebElement> price;
	@FindBy(xpath="(//span[contains(@class,'current-month')])[1]")
	WebElement crmnt;
	@FindBy(xpath="(//button[contains(@aria-label,'Next Month')])[2]")
	WebElement nxtmnth;
	@FindBy(xpath="(//ul)[2]//li")
	WebElement txtadult;
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchbtn;
	@FindBy(xpath="(//div[contains(@class,'SearchPanel')]//a[contains(@href,'hotel')]//button)[1]")
	WebElement htl;
	@FindBy(xpath="//button[contains(.,'Add Another City')]")
	WebElement addbtn;
	@FindBy(xpath="(//input[@name='controlled-radio-buttons-group'])[3]")
	WebElement radiomulti;
	public void setSrc(String value) throws InterruptedException {
		src.click();
		srcname.sendKeys(value);
		Thread.sleep(1000);
		autosug.click();
	}

	public void setDest(String value) throws InterruptedException {
		dest.click();
		srcname.sendKeys(value);
		Thread.sleep(1000);
		autosug.click();
	}
	public void opencalendar() {
		cl.click();
	}
	public void calender(String mnth) {

		int tmonth=Month.valueOf(mnth.toUpperCase()).getValue();
		String crmnth=crmnt.getText().split(" ")[0];
		int crmonth=Month.valueOf(crmnth.toUpperCase()).getValue();
		while(tmonth!=crmonth) {



			nxtmnth.click();
			crmnth=crmnt.getText().split(" ")[0];
			crmonth=Month.valueOf(crmnth.toUpperCase()).getValue();
		}
	}

	public void clickPrice() {
		int min=Integer.MAX_VALUE;
		WebElement k=null;

		for(WebElement e:price) {
			int price=Integer.parseInt(e.getAttribute("textContent").replaceAll("[^0-9]", "").trim());

			if(min>price) {
				min=price;
				k=e;

			}
		}
		js.executeScript("arguments[0].click();", k);
	}



	public void clicksearch() {
		searchbtn.click();
	}

	public void selectTxtadult() {
		txtadult.click();
	}



public void multicity(int citycount,List<String> names) throws InterruptedException {
		int count=citycount;

		if(citycount<2){
			System.out.println("City count is less than 2");
		}

		else{
			try{
				Thread.sleep(2000);
			} catch(InterruptedException e){}

			int i=1;

			if(names.size()/2!=citycount) {
				System.out.println("not a valid list of cities");
			}
			else{

				// ✅ FIRST: enter 4 entries (2 cities)
				int firstBatch = 4;

				while(i <= firstBatch && i < names.size()) {

					String locat = "(//div[contains(@aria-label,'inputbox') and @role='Combobox'])[" + i+"]";
					WebElement k = driver.findElement(By.xpath(locat));
					act.moveToElement(k);
					k.click();
					srcname.sendKeys(names.get(i-1));
					i++;

					try{ Thread.sleep(1000);} catch(InterruptedException e){}
					autosug.click();
				}

				// ✅ AFTER first 4 entries → check and click add
				if(count != 2){
					js.executeScript("arguments[0].click();",addbtn);
					System.out.println("yes clicked add");
					count--;
				}

				// ✅ NOW: only 2 entries per loop
				while(i < names.size()) {

					// first field
					String locat = "(//div[contains(@aria-label,'inputbox') and @role='Combobox'])[" + i+"]";
					WebElement k = driver.findElement(By.xpath(locat));
					act.moveToElement(k);
					k.click();
					srcname.sendKeys(names.get(i-1));
					i++;

					try{ Thread.sleep(1000);} catch(InterruptedException e){}
					autosug.click();

					// second field
					locat = "(//div[contains(@aria-label,'inputbox') and @role='Combobox'])[" + i+"]";
					k = driver.findElement(By.xpath(locat));
					act.moveToElement(k);
					k.click();
					srcname.sendKeys(names.get(i-1));
					i++;

					try{ Thread.sleep(1000);} catch(InterruptedException e){}
					autosug.click();

					// click add if more cities remaining
					if(count != 2){
						js.executeScript("arguments[0].click();",addbtn);
						System.out.println("yes clicked add");
						count--;
					}
				}
			}
		}
	}

public void openmulticity(){
	radiomulti.click();
}
}