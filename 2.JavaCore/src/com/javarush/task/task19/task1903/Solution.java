package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {

        IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }

        @Override
        public String getCompanyName() {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName() {
            /*if (incomeData.getCountryCode().equals("UA"))
                 return "Ukraine";
            if (incomeData.getCountryCode().equals("RU"))
                return "Russia";
            if (incomeData.getCountryCode().equals("CA"))
                return "Canada";*/
            switch (incomeData.getCountryCode()){
                case "RU": return "Russia";
                case "UA": return "Ukraine";
                case "CA": return "Canada";
                default:return "";
            }
        }

        @Override
        public String getName() {
            return incomeData.getContactLastName() + ", " + incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String number = String.valueOf(incomeData.getPhoneNumber());
            while (number.length() < 10){
                number = "0" + number;
            }
            number = "(" + number.substring(0,3) + ")" + number.substring(3,6) + "-" + number.substring(6,8) + "-" + number.substring(8,10);
            return "+" + incomeData.getCountryPhoneCode() + number;
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}