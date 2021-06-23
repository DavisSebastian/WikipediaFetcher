package tech.codingclub.database;

import tech.codingclub.entity.Coders;

import java.util.List;

public class CRUDExample {

    public static void main(String[] args) {

        Coders coders = new GenericDB<Coders>().getRow(tech.codingclub.tables.Coders.CODERS,Coders.class,null);

        readtable();

        new GenericDB<String>().updateColumn(tech.codingclub.tables.Coders.CODERS.NAME,"Biny Varghese", tech.codingclub.tables.Coders.CODERS, tech.codingclub.tables.Coders.CODERS.NAME.eq("Davis"));
        readtable();
    }



    private static void readtable() {
        List<Coders> rows = (List<Coders>) GenericDB.getRows(tech.codingclub.tables.Coders.CODERS,Coders.class,null,null);

        for(Coders row : rows)
        {
            System.out.println("Row : " + row.name + " " + row.age);
        }
    }
}
