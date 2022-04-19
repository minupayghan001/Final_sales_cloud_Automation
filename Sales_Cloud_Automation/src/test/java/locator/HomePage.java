package locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonsAction.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'Campaigns')]/parent::a/parent::one-app-nav-bar-item-root")
	WebElement Campaignobj;
	
	@FindBy(xpath="//span[contains(text(),'Leads')]/parent::a/parent::one-app-nav-bar-item-root")
	WebElement leadobj;
	
public HomePage() {
	PageFactory.initElements(driver, this);

}

public String verifyHomePageTitle() {
	return driver.getTitle();
}

public CampaignPage clickOnCampaign() {
	Campaignobj.click();
	return new CampaignPage();
}

public LeadPage clickOnLead() {
	leadobj.click();
	return new LeadPage();
}

}
