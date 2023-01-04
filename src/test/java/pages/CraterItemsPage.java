package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CraterItemsPage {
	
	
	public CraterItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (linkText = "Items")
	public WebElement itemsLink;
	
	@FindBy (xpath = "(//div[@class='flex items-center justify-end space-x-5']/button)[2]")
	public WebElement addItemButton;

	
	@FindBy (xpath = "//h3[text()='Items']")
	public WebElement ItemsText;
	  
	
	//add item window
	
	@FindBy (xpath = "//h3[text()='New Item']")
	public WebElement newItemHeaderText;
	
	@FindBy (xpath = "(//input[@type='text'])[2]")
	public WebElement itemNameField;
	
	@FindBy (id = "0")
	public WebElement itemPriceField;
	
	@FindBy (xpath = "(//input[@type='text'])[3]")
	public WebElement itemUnitField;
	
	@FindBy (xpath = "//span[text()='pc']")
	public WebElement itemUnitPC;
	
	
	@FindBy (name = "description")
	public WebElement itemDescriptionField;
	
	@FindBy (xpath = "//button[@type='submit']")
	public WebElement saveButton;
	
	// book item
	@FindBy (linkText = "Book")
	public WebElement BookLink;
	
	@FindBy (linkText = "Book")
	public WebElement itemPageBookLink;
	
	@FindBy (xpath = "//span[text()='$ 30.00']")
	public WebElement itemPageBookPrice;
	
	// update item
	@FindBy (xpath = "//button[@type='submit']")
	public WebElement updateItemButton;
	
	@FindBy (xpath = "//a[text()=' Delete']")
	public WebElement deleteItemButton;
	
	@FindBy (xpath = "//h3[text()='New Item']")
	public WebElement newItemText;
	
	@FindBy (linkText = "coffee machine")
	public WebElement lastestAddItem;
	
	
	
	
	
	
	@FindBy (xpath = "//h3[text()='Edit Item']")
	public WebElement editItemHeaderText;
	
	
	@FindBy (xpath = "//button[text()='Ok']")
	public WebElement deleteOKButton;
	

	@FindBy (xpath = "//h3[text()='Items']")
	public WebElement itemsHeaderText;
	
	@FindBy (xpath = "//button[text()='Filter ']")
	public WebElement filterItemButton;
	
	@FindBy (xpath = "//div[@name='name']/input")
	public WebElement filterNameField;

	
	// add item window
	
	
	@FindBy (xpath = "//div[@class='relative rounded-md shadow-sm font-base']/input")
	public WebElement addItemNameField;
	
	@FindBy (xpath = "//div[@class='flex flex-col mt-1']/input")
	public WebElement addItemPriceField;
	
	@FindBy (xpath = "(//div[@class='flex flex-col mt-1']/div/input)[2]")
	public WebElement addItemUnitField;
	
	@FindBy (xpath = "//textarea[@name='description']")
	public WebElement addItemDescription;
	
	@FindBy (xpath = "//button[text()=' Save Item']")
	public WebElement saveItemButton;
	
	@FindBy (xpath = "//span[text()='pc']")
	public WebElement pc_unit;
	
	@FindBy (xpath = "//p[text()='Item created successfully']")
	public WebElement itemCreateSuccessMessage;
	
	@FindBy (xpath = "//p[text()='Item updated successfully']")
	public WebElement itemUpdatedSuccessMessage;
	
	@FindBy (xpath = "//p[text()='Item deleted successfully']")
	public WebElement itemDeletedSuccessMessage;
	
	@FindBy (xpath = "//span[text()='No Results Found']")
	public WebElement noResultFoundText;

}
