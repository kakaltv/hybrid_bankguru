package pageUIs.DataTable;

public class HomePageUI {
	// public: phạm vi rộng, ngoài package để các class trong PageObject có thể truy cập được
	// static: biến tĩnh cho phép class khác truy cập đến biến của class này mà không phải khởi tạo đối tượng của class này
	// final: ngăn cản việc gán lại giá trị cho biến này
	// static final: hằng số (constant) - phải viết hoa và phân cách bởi dấu _
	
	public static final String PAGING_BY_NUMBER = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGING_BY_NUMBER_ACTIVE = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_NAME = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String ICON_BY_COUNTRY_NAME = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	public static final String ROW_VALUE = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	
	public static final String HEADER_NAME_INDEX = "//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_ROW_INDEX = "//tr[%s]/td[%s]/input";
	public static final String ACTION_BUTTON_BY_ROW_INDEX = "//tr[%s]//button[@title='%s']";
	
	


}
