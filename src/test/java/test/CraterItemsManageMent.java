package test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CraterItemsPage;
import pages.CraterLoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class CraterItemsManageMent {
	
	
	CraterLoginPage loginpage;
	BrowserUtils utils;
	
  @Test
  public void addItem() throws InterruptedException {
//    Scenario: user is able to create an item or service
//    Given user logs in
	  Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
	  loginpage = new CraterLoginPage();
	  
	  
	  
	  
//	  loginpage.useremail.sendKeys(TestDataReader.getProperty("craterValidUserEmail"));
//	  loginpage.password.sendKeys(TestDataReader.getProperty("craterValidUserPassword"));
//	  loginpage.loginButton.click();
//    And user navigates to Items tab
	  utils = new BrowserUtils();
	  loginpage.login();
	  
	  
	  CraterItemsPage itemsPage = new CraterItemsPage();
	  utils.waitUntilElementVisible(itemsPage.itemsLink);
	  itemsPage.itemsLink.click();
	  

//    When user clicks on the Add Item button
	  utils.waitUntilElementVisible(itemsPage.addItemButton);
	  itemsPage.addItemButton.click();
	  
//    Then user should be on item create page
	  Assert.assertTrue(itemsPage.newItemText.isDisplayed());
	  
//    When user provides item information "name" and "price" and "unit" and "description"
	  utils.waitUntilElementVisible(itemsPage.itemNameField);
	  itemsPage.itemNameField.sendKeys("coffee machine");
	  itemsPage.itemPriceField.sendKeys("15000");
	  
	  itemsPage.itemUnitField.click();
	  itemsPage.itemUnitPC.click();
	  itemsPage.itemDescriptionField.sendKeys("black espresso machine");
	  
	  
//    And click Save Item button
	  itemsPage.saveButton.click();
	  
//    Then the Item is added to the Item list table
	  utils.waitUntilElementVisible(itemsPage.lastestAddItem);
	  Assert.assertTrue(itemsPage.lastestAddItem.getText().contains("coffee machine"));



  }
  @Test
  public void updateItem() throws InterruptedException {
	  
//	  Scenario: user is able to update an item or service
//	  Given user is on the login page
	  Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
	  loginpage = new CraterLoginPage();
	  
	  
//	  loginpage.useremail.sendKeys(TestDataReader.getProperty("craterValidUserEmail"));
//	  loginpage.password.sendKeys(TestDataReader.getProperty("craterValidUserPassword"));
//	  loginpage.loginButton.click();

//	  And user navigates to Items tab
      utils = new BrowserUtils();
      loginpage.login();
	  
	  
	  CraterItemsPage itemsPage = new CraterItemsPage();
	  utils.waitUntilElementVisible(itemsPage.itemsLink);
	  itemsPage.itemsLink.click();
//	  When selects the item "Books"
	  utils.waitUntilElementVisible(itemsPage.itemPageBookLink);
	  itemsPage.itemPageBookLink.click();
	  
//	  and user should be on item details page
	  utils.waitUntilElementVisible(itemsPage.itemNameField);
	  Assert.assertTrue(itemsPage.editItemHeaderText.isDisplayed());
	  
	  
	  
//	  When user updates the item price to 30 dollars
	  if (itemsPage.itemPriceField.getText() != "3000") {
		  utils.clearTextOfAFieldMac(itemsPage.itemPriceField);
		  itemsPage.itemPriceField.sendKeys("3000");
	  } else {
		  
	  }
	  
//	  And click Update Item button 
	  itemsPage.updateItemButton.click();

//	  Then the Item price is updated to 30 dollars
	  utils.waitUntilElementVisible(itemsPage.itemPageBookPrice);
	  Assert.assertEquals(itemsPage.itemPageBookPrice.getText(), "$ 30.00");
	  
  }
  public void test1() {
//	  Create an item on UI.
//	  Then go to database, and query from the items table using select * to get the information
//	  Then verify the information that you have provided on UI is correct. 
//
//	  Then update your Item using DB, and come back to UI and verify the update is in effect.
//	  Then delete the Item using DB,  and come back to UI and verify the Item no longer exist.
	  
	  
 
  }
  
  @BeforeMethod
  public void setUp() {
	  Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
  }

  @AfterMethod
  public void tearDown() {
	  Driver.quitDriver();
  }
 
  
}
