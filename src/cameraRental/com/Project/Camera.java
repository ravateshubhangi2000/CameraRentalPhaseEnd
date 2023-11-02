package cameraRental.com.Project;

public class Camera {
	private int id;
	private String brand;
	private String model;
	private float pricePerDay;
	private String status;
	
	public Camera(int id, String brand, String model, float pricePerDay, String status) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.status = status;
		this.pricePerDay = pricePerDay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(float pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	
	@Override
	public String toString() {
		return "Camera [id=" + id + ", brand=" + brand + ", model=" + model + ", status=" + status + ", pricePerDay="
				+ pricePerDay + "]";
	}
	
	
}


