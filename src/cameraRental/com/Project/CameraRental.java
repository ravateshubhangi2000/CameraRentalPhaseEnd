package cameraRental.com.Project;
import java.util.ArrayList;
import java.util.Scanner;


public class CameraRental {
	public static ArrayList<Camera> camerarent = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ValidateDetail Login = new ValidateDetail();
		Menu menu = new Menu();
		camerarent.add(new Camera(1, "Samsung" , "SM123 " , 30000.0f, "Rented"));
		camerarent.add(new Camera(2, "Canon  " , "5620  " ,  10000.0f, "Available"));
		camerarent.add(new Camera(3, "Nikon  " , "D7500 " , 15000.0f, "Available"));
		camerarent.add(new Camera(4, "LG     " , "L123  " ,  25000.0f, "Available"));
		camerarent.add(new Camera(5, "Sony   " , "DSLR14" ,20000.0f, "Available"));
		camerarent.add(new Camera(6, "Canon  " , "5619  " ,  10000.0f, "Available"));
		
		System.out.println("+=================================+");
		System.out.println("||  WELCOME TO CAMERA RENTAL APP  ||");
		System.out.println("+=================================+");

		while(true) {
			System.out.println("LOGIN YOUR ACCOUNT");
			System.out.println("USERNAME - ");
			String username = sc.next();
			System.out.println("PASSWORD - ");
			String password = sc.next();
			boolean isValidUser = Login.validateUser(username, password);
			if(isValidUser) {
				menu.menu();
				break;
			}
			else { 
				System.out.println("YOU HAVE ENTERED WRONG LOGIN DETAILS!!");

			}
		}
	}
}
// TODO Auto-generated method stub