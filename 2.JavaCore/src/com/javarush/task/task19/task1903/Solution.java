package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {

       private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        /*
        * Метод getCountryName() должен вернуть страну из countries, по ключу getCountryCode() объекта data.
        * */


        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getCountryName() {
            /*if (incomeData.getCountryCode().equals("UA"))
                 return "Ukraine";
            if (incomeData.getCountryCode().equals("RU"))
                return "Russia";
            if (incomeData.getCountryCode().equals("CA"))
                return "Canada";*/
           /* switch (data.getCountryCode()){
                case "RU": return "Russia";
                case "UA": return "Ukraine";
                case "CA": return "Canada";
                default:return "";
            }*/
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }


        @Override
        public String getPhoneNumber() {
            String number = String.valueOf(data.getPhoneNumber());
            while (number.length() < 10){
                number = "0" + number;
            }
            number = "(" + number.substring(0,3) + ")" + number.substring(3,6) + "-" + number.substring(6,8) + "-" + number.substring(8,10);
            return "+" + data.getCountryPhoneCode() + number;
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