package model;

import java.time.LocalDate;

public class PhoneBook {
    private String name;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String group;
    private LocalDate dayOfBirth;

    public PhoneBook(String name, String gender, String address, String phoneNumber, String email, LocalDate dayOfBirth, String group) {
    }

    public PhoneBook(String name, String gender, String address, String phoneNumber, String email, String group, LocalDate dayOfBirth) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.group = group;
        this.dayOfBirth = dayOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return "Danh bạ {" +
                "Tên: '" + name + '\'' +
                ", Giới tính: '" + gender + '\'' +
                ", Địa chỉ: " + address + '\'' +
                ", Số điện thoại: '" + phoneNumber + '\'' +
                ", email: '" + email + '\'' +
                ", Nhóm: '" + group + '\'' +
                ", Ngày sinh: " + dayOfBirth +
                '}';
    }
}