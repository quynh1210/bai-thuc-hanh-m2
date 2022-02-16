package read_write_files;

import model.PhoneBook;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Csv {

    public void writeFile(ArrayList<PhoneBook> contactList, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (PhoneBook contact : contactList) {
                bufferedWriter.write(contact.getName() + "," +
                        contact.getGender() + "," +
                        contact.getAddress() + "," +
                        contact.getPhoneNumber() + "," +
                        contact.getEmail() + "," +
                        contact.getGroup() + "," +
                        contact.getDayOfBirth().format(DateTimeFormatter.ofPattern("dd/mm/yyyy"))
                        + "\n");
            }
            bufferedWriter.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public ArrayList<PhoneBook> readFile(String path) {
        ArrayList<PhoneBook> contacts = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                contacts.add(new PhoneBook(strings[0],
                        strings[1],
                        strings[2],
                        strings[3],
                        strings[4],
                        strings[5],
                        LocalDate.parse(strings[6], DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                ));
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return contacts;
    }

}
