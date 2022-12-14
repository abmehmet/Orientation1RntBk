package ui;

import domain.Customer;
import services.CustomerService;

import java.util.Scanner;

public class CustomerUI {

    CustomerService customerService = CustomerService.getInstance();
    Scanner readScreen = new Scanner(System.in);


    public void addCustomer() {
        try {
            Customer newCustomer = new Customer();
            readScreen = new Scanner(System.in);

            int customerId = customerService.getNewCustomerId();
            newCustomer.setId(customerId);

            System.out.println("Müşterinin Adını Giriniz:");
            newCustomer.setName(readScreen.nextLine());

            System.out.println("Müşterinin Soyadını Giriniz:");
            newCustomer.setSurName(readScreen.nextLine());

            System.out.println("Müşterinin Telefon Numarasını Giriniz:");
            newCustomer.setPhoneNumber(readScreen.nextLine());

            if (customerService.addCustomer(newCustomer)) {
                System.out.println("Müşteri kayıt edilmiştir.");
                UI.delay(1);
            } else {
                throw new Exception();
            }

        } catch (Exception exception) {
            System.out.println("Hata kodu:" + exception.getMessage() + "\n");
            System.out.println("Müşteri kaydedilirken bir hata meydana geldi. Tekrar Deneyiniz...");
            UI.delay(3);
            throw new RuntimeException(exception);

        }

    }

    public void showCustomerInfo(int id) {
        Customer customer = customerService.getCustomerInfo(id);
        if (customer != null) {
            System.out.println("Müşteri id'si: " + customer.getId());
            System.out.println("Müşteri Adı: " + customer.getName());
            System.out.println("Müşteri Soyadı: " + customer.getSurName());
            System.out.println("Müşteri telefon Numarası: " + customer.getPhoneNumber());
        }
    }


}
