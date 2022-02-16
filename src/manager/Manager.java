package manager;

import model.PhoneBook;
import read_write_files.Csv;
import regex.RegexEmail;
import regex.RegexPhoneNumber;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    public static ArrayList<PhoneBook> phoneBooks;
    Scanner scanner = new Scanner(System.in);
    public static Csv csv = new Csv();
    public static final String PATH_NAME = "files/phoneBook.csv";

    public Manager() {
        if (new File(PATH_NAME).length() == 0) {
            phoneBooks = new ArrayList<>();
        } else {
            phoneBooks = csv.readFile(PATH_NAME);
        }
    }

    public void create() {
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        String gender = getGender();
        scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        String phoneNumber;
        boolean checkPhoneNumber;
        do {
            System.out.println("Nhập số điện thoại :");
            phoneNumber = scanner.nextLine();
            checkPhoneNumber = RegexPhoneNumber.validate(phoneNumber);
        }while (!checkPhoneNumber);
        String phone = checkPhone(phoneNumber);
        boolean checkEmail;
        String email;
        do {
            System.out.println("Nhập email:");
            email = scanner.nextLine();
            checkEmail = RegexEmail.validate(email);
        }while (!checkEmail);
        System.out.println("Nhập nhóm: ");
        String gr = scanner.nextLine();
        System.out.println("Nhập ngày sinh(dd/mm/yyyy)");
        LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        phoneBooks.add(new PhoneBook(name, gender, address, phone, email, gr, date));
        csv.writeFile(phoneBooks, PATH_NAME);
        System.out.println("Thêm số điện thoại "+phoneNumber+" thành công!");
    }

    public String checkPhone(String a) {
        for (PhoneBook p : phoneBooks) {
            while (p.getPhoneNumber().equals(a)) {
                System.out.println("số điện thoại đã tồn tại, vui lòng nhập lại!");
                a = scanner.nextLine();
            }
        }
        return a;
    }

    public String getGender() {
        String gender = "";
        System.out.println("Chọn giới tính: ");
        System.out.println("1.Nam ");
        System.out.println("2.Nữ");
        System.out.println("3.Khác");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                gender = "Nam";
                break;
            case 2:
                gender = "Nữ";
                break;
            case 3:
                gender = "Giới tính khác";
                break;
        }
        return gender;
    }

    public void edit() {
        PhoneBook phoneBook = null;
        System.out.println("Nhập số điện thoại cần sửa: ");
        String phone = scanner.nextLine();
        for (PhoneBook p : phoneBooks) {
            if (p.getPhoneNumber().equals(phone)){
                phoneBook = p;
                break;
            }
        }

        if (phoneBook != null){
            int index = phoneBooks.indexOf(phoneBook);
            System.out.println("Nhập tên mới: ");
            String name = scanner.nextLine();
            phoneBook.setName(name);
            String gender = getGender();
            phoneBook.setGender(gender);
            scanner.nextLine();
            System.out.println("Nhập địa chỉ mới: ");
            String address = scanner.nextLine();
            phoneBook.setAddress(address);
            boolean checkEmail;
            String email;
            do {
                System.out.println("Nhập email mới:");
                email = scanner.nextLine();
                checkEmail = RegexEmail.validate(email);
            }while (!checkEmail);
            phoneBook.setEmail(email);
            System.out.println("Nhập nhóm mới: ");
            String gr = scanner.nextLine();
            phoneBook.setGroup(gr);
            System.out.println("Nhập ngày sinh mới(dd/mm/yyyy):");
            LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/mm/yyyy"));
            phoneBook.setDayOfBirth(date);
            phoneBooks.set(index,phoneBook);
            System.out.println("Sửa thành công");
        } else System.out.println("Không tìm thấy số điện thoại cần sửa");
        csv.writeFile(phoneBooks, PATH_NAME);
    }

    public void delete() {
        PhoneBook phoneBook = null;
        System.out.println("Nhập số điện thoại cần xoá: ");
        String phone = scanner.nextLine();
        for (PhoneBook p : phoneBooks) {
            if (p.getPhoneNumber().equals(phone)){
                phoneBook = p;
                break;
            }
        }

        if (phoneBook != null){
            phoneBooks.remove(phoneBook);
        } else System.out.println("Không tìm thấy số điện thoại");
        csv.writeFile(phoneBooks, PATH_NAME);
    }

    public void searchByName() {
        ArrayList<PhoneBook> phoneBook123 = new ArrayList<>();
        System.out.println("Nhập tên cần tìm: ");
        String name123 = scanner.nextLine();
        for (PhoneBook p : phoneBooks) {
            if (p.getName().equals(name123)){
                phoneBook123.add(p);
            }
        }

        if (phoneBook123.isEmpty()){
            System.out.println("Không tìm thấy tên.");
        } else System.out.println(phoneBook123);
    }

    public void searchByPhone() {
        PhoneBook phoneBook = null;
        System.out.println("Nhập số điện thoại cần tìm: ");
        String phone = scanner.nextLine();
        for (PhoneBook p : phoneBooks) {
            if (p.getPhoneNumber().equals(phone)){
                phoneBook = p;
                break;
            }
        }

        if (phoneBook != null){
            System.out.println(phoneBook);
        } else System.out.println("Không tìm thấy số điện thoại");
    }

    public void displayALl() {
        for (PhoneBook p : phoneBooks) {
            System.out.println(p);
        }
    }
}
