package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ====");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("=== TEST 2: seller findByDepartments====");

		Department department = new Department(2, null);

		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("=== TEST 3: seller findAll====");

		Department dep = new Department(2, null);

		List<Seller> listAll = sellerDao.findAll();

		for (Seller seller2 : listAll) {
			System.out.println(seller2);
		}
		
		
		System.out.println("=== TEST 3: seller insert====");

		Seller sell = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, dep); 
		sellerDao.insert(sell);
		
		System.out.println("INSERTED NEW ID = " + sell.getId());

	}

}
