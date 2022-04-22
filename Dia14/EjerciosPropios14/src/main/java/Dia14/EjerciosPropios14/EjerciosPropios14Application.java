package Dia14.EjerciosPropios14;


import Dia14.EjerciosPropios14.Adapters.CartAdapter;
import Dia14.EjerciosPropios14.Models.Cart;
import Dia14.EjerciosPropios14.Models.Product;
import Dia14.EjerciosPropios14.Models.User;
import Dia14.EjerciosPropios14.Ports.ProductPort;

import java.util.Scanner;

public class EjerciosPropios14Application {

	public static void main(String[] args)
	{
		int op;
		ProductPort pp = new ProductPort();
		CartAdapter cp = new CartAdapter();

		Scanner scan = new Scanner(System.in);
		Cart cart = new Cart();
		User user = new User("Franco", "Luzardi", "123", cart);
		boolean flag = true;



		//EXAMPLE MENU (NOT FUNCTIONAL)
		while(flag) {

			System.out.println("1- Show products");
			System.out.println("2- Add a  product to Cart");
			System.out.println("3- Show Carts");
			System.out.println("4- Exit");

			int option = scan.nextInt();

			switch (option) {

				case 1:

					pp.showProducts();

					break;
				case 2:

					System.out.println("Enter Product id: ");
					op = scan.nextInt();
					user.getCart().getProducts().add(pp.getProductById(op));

					break;
				case 3:

					cp.getCarts();

					break;
				case 4:
					flag = false;
					break;
				default:
					System.out.println("Invalid Option");
					break;
			}
		}

	}

}
