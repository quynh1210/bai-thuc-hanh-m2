package main;

import manager.Manager;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Menu {
    Manager manager = new Manager();
    Scanner scanner = new Scanner(System.in);
    public void menu() {
        try {
            int choice;
            do {
                System.out.println();
                System.out.println("CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ");
                System.out.println(" 1. Xem danh sách ");
                System.out.println(" 2. Thêm mới ");
                System.out.println(" 3. Cập nhật ");
                System.out.println(" 4. Xóa");
                System.out.println(" 5. Tìm kiếm ");
                System.out.println(" 6. Đọc từ file");
                System.out.println(" 7. Ghi vào file ");
                System.out.println(" 0. Thoát");
                System.out.print("Nhập lựa chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 7) {
                    System.out.println();
                    System.out.println("Lựa chọn không đúng, mời nhập lại ");
                    System.out.println();
                }
                switch (choice) {
                    case 1:
                        manager.displayALl();
                        break;
                    case 2:
                        manager.create();
                        break;
                    case 3:
                        manager.edit();
                        break;
                    case 4:
                        manager.delete();
                        break;
                    case 5:
                        int choice2;
                        do {
                            System.out.println("1.Tìm kiếm bằng tên");
                            System.out.println("2.Tìm kiếm bằng số điện thoại");
                            System.out.println("0.Thoát");
                            choice2 = scanner.nextInt();
                            switch (choice2) {
                                case 1:
                                    manager.searchByName();
                                    break;
                                case 2:
                                    manager.searchByPhone();
                                    break;
                            }
                        } while (choice2 != 0);
                    case 6:
                        System.out.println("Đọc file thành công!");
                        break;
                    case 7:
                        System.out.println("Ghi file thành công!");
                        break;
                }
            } while (choice != 0);
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("Bạn nhập sai dữ liệu, mời nhập lại !");
            System.out.println();
            menu();
        }
    }}