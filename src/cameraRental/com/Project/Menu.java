package cameraRental.com.Project;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
	Scanner sc = new Scanner(System.in);
	MyCam cam = new MyCam();

	CameraRental camerarental = new CameraRental();
	ArrayList<Camera> camerarent = CameraRental.camerarent;
	static MyWallet wallet = new MyWallet();

	public void showCameras() {
		System.out.println("======================================================================");
		System.out.println("CAMERA ID        BRAND       MODEL        PRICE(PER DAY)      STATUS");
		System.out.println("======================================================================");
		for(Camera c: camerarent) {
			System.out.print("  "+c.getId()+"  ");
			System.out.print("  "+c.getBrand()+" ");
			System.out.print("  "+c.getModel()+"  ");
			System.out.print("  "+c.getPricePerDay()+"  ");
			System.out.print("  "+c.getStatus()+" ");
			System.out.println();
		}
	}

	public void addCamera() {
		while(true) {
			System.out.println("ENTER THE CAMERA BRAND - ");
			String brand = sc.next();
			System.out.println("ENTER THE MODEL");
			String model = sc.next();
			System.out.println("ENTER THE PER DAY PRICE (INR)");
			int price = sc.nextInt();

			int id = camerarent.size()+1;

			Camera cam = new Camera(id, brand, model, price, "Available");
			camerarent.add(cam);
			System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");

			System.out.println("WANT TO ADD MORE? (Y/N)");
			char c = sc.next().charAt(0);
			if(c == 'N' || c == 'n') break;
		}
		showCameras();
	}

	public void removeCamera() {
		showCameras();
		System.out.println("ENTER THE CAMERA ID TO REMOVE");
		int input3 = sc.nextInt();
		for(int i=0; i<camerarent.size(); i++) {
			if(input3 == camerarent.get(i).getId()) {
				camerarent.remove(i);
				break;
			}
		}
		System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST");
		showCameras();
	}

	public void myCameras() {
		System.out.println("======================================================================");
		System.out.println("CAMERA ID        BRAND       MODEL        PRICE(PER DAY)      STATUS");
		System.out.println("======================================================================");
		for(Camera c: cam.myCamera) {
			System.out.print("  "+c.getId()+"           ");
			System.out.print("  "+c.getBrand()+"      ");
			System.out.print("  "+c.getModel()+"         ");
			System.out.print("  "+c.getPricePerDay()+"       ");
			System.out.print("  "+c.getStatus()+" ");
			System.out.println();
		}
	}


	public void myCamera() {
		System.out.println("1. ADD");
		System.out.println("2. REMOVE");
		System.out.println("3. VIEW MY CAMERAS");
		System.out.println("4. GO TO PREVIOUS MENU");

		int input = sc.nextInt();

		switch(input) {
		case 1: 
			addCamera();
			break;

		case 2: 
			removeCamera();
			break;

		case 3:
			myCameras();
			break;

		case 4:
			menu();
			break;
		}
	}


	public void rentCamera() {
		showCameras();
		System.out.println("ENTER THE CAMERA ID YOU WANT TO RENT");
		int id = sc.nextInt();
		for(int i=0;i<camerarent.size(); i++) {
			if(id == camerarent.get(i).getId()) {
				if( wallet.getMyBalance() >= camerarent.get(i).getPricePerDay() ) {
					wallet.debitAmount(camerarent.get(i).getPricePerDay());
					camerarent.get(i).setStatus("Rented");
					cam.myCamera.add(camerarent.get(i));
					System.out.println("YOUR TRANSACTION FOR CAMERA - "+camerarent.get(i).getBrand()+" "+camerarent.get(i).getModel()+" WITH RENT INR."+camerarent.get(i).getPricePerDay()+" HAS SUCCESSFULLY COMPLETED.");
					showCameras();
				}else {
					System.out.println("ERROR : TRANSACTION FALIED DUE TO INSUFFICIENT WALLET BALANCE. PLEASE DEPOSITE THE AMOUNT TO YOUR WALLET.");
				}
			}
		}
	}

	public void wallet() {

		System.out.println(" CURRENT WALLET BALANCE IS - INR."+wallet.getMyBalance());
		System.out.println("DO YOU WANT TO DEPOSIT AMOUNT TO YOUR WALLET?(1.Yes 2.No)");
		int input = sc.nextInt();
		if(input == 1) {
			System.out.println("ENTER THE AMOUNT (INR) - ");
			float amount = sc.nextFloat();
			wallet.creditAmount(amount);
			System.out.println("WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR."+wallet.getMyBalance());
		}
	}

	public void exit() {
		System.out.println("THANKS FOR USING CAMERA RENTAL APPLICATION!");
		return;
	}


	public void menu() {


		System.out.println("1. MY CAMERA");
		System.out.println("2. RENT A CAMERA");
		System.out.println("3. VIEW ALL CAMERAS");
		System.out.println("4. MY WALLET");
		System.out.println("5. EXIT");

		int input = sc.nextInt();

		switch(input) {
		case 1: 
			myCamera();
			System.out.println("WANT TO CONTINUE?(1.YES 2.NO)");
			int input1 = sc.nextInt();
			if(input1 == 1) {
				menu();
			}else exit();
			break;

		case 2:
			rentCamera();
			System.out.println("WANT TO CONTINUE?(1.YES 2.NO)");
			int input2 = sc.nextInt();
			if(input2 == 1) {
				menu();
			}else exit();
			break;

		case 3: 
			showCameras();
			System.out.println("WANT TO CONTINUE?(1.YES 2.NO)");
			int input3 = sc.nextInt();
			if(input3 == 1) {
				menu();
			}else exit();
			break;

		case 4:
			wallet();
			System.out.println("WANT TO CONTINUE?(1.YES 2.NO)");
			int input4 = sc.nextInt();
			if(input4 == 1) {
				menu();
			}else exit();
			break;

		case 5:
			exit();
			break;

		default:
			System.out.println("Invalid  CHOICE");
		}
	}
}



