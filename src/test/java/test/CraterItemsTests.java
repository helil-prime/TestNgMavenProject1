package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CraterCommonPage;
import pages.CraterItemsPage;
import pages.CraterLoginPage;
import utils.BrowserUtils;
import utils.DButils;
import utils.Driver;
import utils.TestDataReader;

public class CraterItemsTests {
  
	CraterCommonPage commonpage;
	CraterItemsPage itemsPage;
	BrowserUtils utils;
	CraterLoginPage loginPage;
	DButils dbutils;
	
	String newItemName = "Ipad Pro";
	
	
	
	@Test
	public void createItem() throws InterruptedException {
		/*
		 * Create an item on UI.
           Then go to database, and query from the items table using select * to get the information
    	   Then verify the information that you have provided on UI is correct. 
    	   Then update your Item on the UI, come back to database and verify the item no longer exist. 
		 */
		commonpage = new CraterCommonPage();
		itemsPage  = new CraterItemsPage();
		utils = new BrowserUtils();
		
		Assert.assertTrue(commonpage.commonPageItemsLink.isDisplayed());
		// click on the items tab
		commonpage.commonPageItemsLink.click();
		// verify that user is on the Add Items page
		Assert.assertTrue(itemsPage.addItemButton.isDisplayed());
		// click on the Add Item button
		itemsPage.addItemButton.click();
		// verify that the add item modal displays
		Assert.assertTrue(itemsPage.newItemHeaderText.isDisplayed());
		// provide item information
		newItemName = newItemName + utils.randomNumber();
		itemsPage.addItemNameField.sendKeys(newItemName);
		itemsPage.addItemPriceField.sendKeys("70000");
		itemsPage.addItemUnitField.click();
		// wait until the pc unit is display
		utils.waitUntilElementVisible(itemsPage.pc_unit);
		// click on the pc unit
		itemsPage.pc_unit.click();
		
		itemsPage.addItemDescription.sendKeys("Ipad pro 128Gb, silver");
		itemsPage.saveItemButton.click();
		
		// wait until the item create success message displays
		utils.waitUntilElementVisible(itemsPage.itemCreateSuccessMessage);
		Assert.assertTrue(itemsPage.itemCreateSuccessMessage.isDisplayed());
		
		WebElement newItem = Driver.getDriver().findElement(By.xpath("//a[text()='"+newItemName+"']"));
		Assert.assertTrue(newItem.isDisplayed());
		
		// go to database and select the item that just created. 
		System.out.println("New item with number: " + newItemName);
		dbutils = new DButils();
		String query = "SELECT * FROM items WHERE name='"+newItemName+"';";
		List<String> itemsData = dbutils.selectArecord(query);
		System.out.println("ITEM ID: " + itemsData.get(0));
		System.out.println("ITEM NAME: " + itemsData.get(1));
		
		Assert.assertEquals(itemsData.get(1), newItemName);
		

		// Then update your Item on the UI, 
		//come back to database and verify the update is in effect.
		
		Driver.getDriver().findElement(By.xpath("//a[text()='"+newItemName+"']")).click();
		// verify that user is on the edit item page
		Assert.assertTrue(itemsPage.editItemHeaderText.isDisplayed());
		// edit the item description 
		String itemNewDescription = "Rose gold, 256Gb";
		// first clear the existing message
		utils.clearTextOfAFieldMac(itemsPage.addItemDescription);
		Thread.sleep(1000);
		// send the new description
		itemsPage.addItemDescription.sendKeys(itemNewDescription);
		Thread.sleep(1000);
		// click on update item button
		itemsPage.updateItemButton.click();
		// wait the update success message banner
		utils.waitUntilElementVisible(itemsPage.itemUpdatedSuccessMessage);
		// verify the message banner displays
		Assert.assertTrue(itemsPage.itemUpdatedSuccessMessage.isDisplayed());
		
		// select query to get the item data from the DB
		String updateQuery = "SELECT * FROM items WHERE name='"+newItemName+"';";
		List<String> updatedData = dbutils.selectArecord(updateQuery);
		System.out.println("ITEM ID: " + updatedData.get(0));
		System.out.println("ITEM NAME: " + updatedData.get(1));
		System.out.println("ITEM DESCRIPTION: " + updatedData.get(2));
		// verify that the updated description match to the expected.
		Assert.assertEquals(updatedData.get(2), itemNewDescription);
		
		// Then delete the Item on the UI,  
		// come back to database and verify the item no longer exist.
		Driver.getDriver().findElement(
				By.xpath("(//a[text()='"+newItemName+"']//parent::td)//following-sibling::td[4]//button")).click();
		// click on the delete button
		utils.waitUntilElementVisible(itemsPage.deleteItemButton);
		itemsPage.deleteItemButton.click();
		// wait for the Ok button to be visible
		utils.waitUntilElementVisible(itemsPage.deleteOKButton);
		// click on Ok button
		itemsPage.deleteOKButton.click();
		// wait and verify the delete success message display
		utils.waitUntilElementVisible(itemsPage.itemDeletedSuccessMessage);
		Assert.assertTrue(itemsPage.itemDeletedSuccessMessage.isDisplayed());
		
		// data base query and verify the list is empty
		String deletedQuery = "SELECT * FROM items WHERE name='"+newItemName+"';";
		List<String> deletedData = dbutils.selectArecord(deletedQuery);
		Assert.assertTrue(deletedData.isEmpty());
		Assert.assertTrue(deletedData.size() == 0);
	  
	  
  }
  @Test
	public void createItem2() {
//	  Create an item on UI.
//	  Then go to database, and query from the items table using select * to get the information
//	  Then verify the information that you have provided on UI is correct. 

//	  Then update your Item using DB, and come back to UI and verify the update is in effect.
//	  Then delete the Item using DB,  and come back to UI and verify the Item no longer exist.
	  
	  commonpage = new CraterCommonPage();
	  itemsPage  = new CraterItemsPage();
	  utils = new BrowserUtils();
	  
	  commonpage.commonPageItemsLink.click();
	  itemsPage.addItemButton.click();
	  Assert.assertTrue(itemsPage.newItemHeaderText.isDisplayed());

//	  Create an item on UI.
	  newItemName = newItemName + utils.randomNumber();
	  itemsPage.addItemNameField.sendKeys(newItemName);
	  itemsPage.addItemPriceField.sendKeys("70000");
	  itemsPage.addItemUnitField.click();
	  utils.waitUntilElementVisible(itemsPage.pc_unit);
	  itemsPage.pc_unit.click();
	  itemsPage.addItemDescription.sendKeys("Rose gold, 256Gb");
	  itemsPage.saveItemButton.click();
		
//    wait until the item create success message displays
	  utils.waitUntilElementVisible(itemsPage.itemCreateSuccessMessage);
	  Assert.assertTrue(itemsPage.itemCreateSuccessMessage.isDisplayed());
	  
//	  Then go to database, and query from the items table using select * to get the information
	  dbutils = new DButils();
	  String query = "SELECT * FROM items WHERE name='"+newItemName+"';";
	  List<String> itemsData = dbutils.selectArecord(query);
	  System.out.println("ITEM ID: " + itemsData.get(0));
	  System.out.println("ITEM NAME: " + itemsData.get(1));

//	  Then verify the information that you have provided on UI is correct. 
	  Assert.assertEquals(itemsData.get(1), newItemName);
	  
//	  Then update your Item using DB, and come back to UI and verify the update is in effect.
	  
	  String updateQuery = "UPDATE items SET description = 'Silver, 512Gb', price = '100000' WHERE id = '"+itemsData.get(0)+"';";
	  dbutils.updateRecord(updateQuery);
	 
	  List<String> updateItemsData = dbutils.selectArecord(query);
	  System.out.println("ITEM ID: " + updateItemsData.get(0));
	  System.out.println("Update Item Description: " + updateItemsData.get(2));
	  
	  WebElement newItem = Driver.getDriver().findElement(By.xpath("//a[text()='"+newItemName+"']"));
	  Assert.assertTrue(newItem.isDisplayed());
	  
	  Driver.getDriver().findElement(By.xpath("//a[text()='"+newItemName+"']")).click();
	  utils.waitUntilElementVisible(itemsPage.addItemDescription);
	 
	  
		
//    verify that the updated description match to the expected.
	  Assert.assertEquals(itemsPage.addItemDescription.getText(), updateItemsData.get(2));
//	  
//	  
////	  Then delete the Item using DB,  and come back to UI and verify the Item no longer exist.	 
//	  String deleteItemQuery = "DELETE FROM items where id = '"+updateItemsData.get(0)+"';";
//      dbutils.deleteRecord(deleteItemQuery);
//      
//	  List<String> deleteItemsData = dbutils.selectArecord(query);
//	  Assert.assertTrue(deleteItemsData.isEmpty());
//	  Assert.assertFalse(newItem.isDisplayed());
		

  }  
  @BeforeMethod
	public void setup() throws InterruptedException {
		loginPage = new CraterLoginPage();
		Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		loginPage.login();
		
  }

  @AfterMethod
	public void wrapup() {
		Driver.quitDriver();
	}
}
