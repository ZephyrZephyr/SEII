package postManBL;

import words.DeliveryType;
import words.PacketType;

public class Ticket {
	private Customer sender;
	private Customer recipient;
	private String script_number;
	private String height;
	private String weight;
	private String width;
	private String internal;
	private String depth;
	private String volume;
	private String ticket_no;
	private DeliveryType Dtype;
	private PacketType Ptype;
	private String price;
	
	public Ticket(Customer sender, Customer recipient, String script_number,
			String height, String weight, String width, String internal,
			String depth, String volume, String ticket_no, DeliveryType dtype,
			PacketType ptype) {
		
		this.sender = sender;
		this.recipient = recipient;
		this.script_number = script_number;
		this.height = height;
		this.weight = weight;
		this.width = width;
		this.internal = internal;
		this.depth = depth;
		this.volume = volume;
		this.ticket_no = ticket_no;
		Dtype = dtype;
		Ptype = ptype;
		this.price = new PostmanBLController().getTotalPrice(sender.getAddress(), recipient.getAddress(), dtype, weight);
	}
	public Customer getSender() {
		return sender;
	}
	public void setSender(Customer sender) {
		this.sender = sender;
	}
	public Customer getRecipient() {
		return recipient;
	}
	public void setRecipient(Customer recipient) {
		this.recipient = recipient;
	}
	public String getScript_number() {
		return script_number;
	}
	public void setScript_number(String script_number) {
		this.script_number = script_number;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getInternal() {
		return internal;
	}
	public void setInternal(String internal) {
		this.internal = internal;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getTicket_no() {
		return ticket_no;
	}
	public void setTicket_no(String ticket_no) {
		this.ticket_no = ticket_no;
	}
	public DeliveryType getDtype() {
		return Dtype;
	}
	public void setDtype(DeliveryType dtype) {
		Dtype = dtype;
	}
	public PacketType getPtype() {
		return Ptype;
	}
	public void setPtype(PacketType ptype) {
		Ptype = ptype;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
