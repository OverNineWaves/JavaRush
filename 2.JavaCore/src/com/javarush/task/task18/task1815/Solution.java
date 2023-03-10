package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {

        TableInterface face;
        public TableInterfaceWrapper(TableInterface face){
            this.face = face;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            face.setModel(rows);
        }
        @Override
        public String getHeaderText() {
            return face.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            face.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}