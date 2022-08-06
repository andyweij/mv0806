package model;

public class product {
    private String code;
    private String price;
    private int quantity;
    private String description;
	public product(String code, String price, int quantity, String description) {
		super();
		this.code = code;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}
	public product() {

	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "product [code=" + code + ", price=" + price + ", quantity=" + quantity + ", description=" + description
				+ "]";
	}

}
