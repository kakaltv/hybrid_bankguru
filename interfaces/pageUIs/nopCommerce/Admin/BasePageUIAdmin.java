package pageUIs.nopCommerce.Admin;

public class BasePageUIAdmin {
	public static final String MENU_LINK_BY_NAME = "//ul[@role='menu']/li/a/p[contains(text(),'%s')]";
	public static final String SUB_MENU_LINK_BY_NAME = "//ul[@class='nav nav-treeview']//a[@href='/Admin/Product/List']/p[contains(text(),'%s')]";
	
	public static final String UPLOAD_PRODUCT_BY_CARD_NAME = "//div[@id='product-%s']//input[@type='file']";
	
	
}
