package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
       /* Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };
        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };
        RowItem rowItem = new DataAdapter(customer,contact);
        System.out.println("county " + rowItem.getCountryCode() + "\n" + "company " + rowItem.getCompany() + "\n" + "name " + rowItem.getContactFirstName()
        + "\n" + "lastName " + rowItem.getContactLastName() + "\n" + "phoneNumber " + rowItem.getDialString());*/
    }

    public static class DataAdapter implements RowItem{
        Customer customer;
        Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String county = "";
            for (Map.Entry<String, String> mapka: countries.entrySet()) {
                if (customer.getCountryName().equals(mapka.getValue())){
                    county = mapka.getKey();
                }
            }
            return county;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] fullName = contact.getName().split(",");
            String name = fullName[1].replace(" ", "");
            return name;
        }

        @Override
        public String getContactLastName() {
            String[] fullName = contact.getName().split(",");
            String lastName = fullName[0].replace(" ", "");
            return lastName;
        }

        @Override
        public String getDialString() {
            String number = contact.getPhoneNumber().replaceAll("[()-]","");
            return number;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}