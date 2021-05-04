package pageUIsnopCommerceUser;

public class HomePageUI {
	// public: phạm vi rộng, ngoài package để các class trong PageObject có thể truy cập được
	// static: biến tĩnh cho phép class khác truy cập đến biến của class này mà không phải khởi tạo đối tượng của class này
	// final: ngăn cản việc gán lại giá trị cho biến này
	// static final: hằng số (constant) - phải viết hoa và phân cách bởi dấu _
	
	public static final String HOME_PAGE_SLIDER = "//div[@id='nivo-slider']";
	public static final String HOME_PAGE_REGISTER_LINK = "//a[@class='ico-register']";
	public static final String HOME_PAGE_LOGIN_LINK = "//a[@class='ico-login']";
	

}
