package mountain.mania.com_DTO;

public class IDto {

	private int item_id;
	private String img;
	private String site;
	private String items_name;
	private String ilevel;
	
	public String getIlevel() {
		return ilevel;
	}
	public void setIlevel(String ilevel) {
		this.ilevel = ilevel;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getItems_name() {
		return items_name;
	}
	public void setItems_name(String items_name) {
		this.items_name = items_name;
	}
}
