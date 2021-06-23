package tech.codingclub.database;


import tech.codingclub.entity.Coders;

public class TestCodersTable {



    public static void main(String[] args) {

        Coders coder = new Coders("Divya Sebastian", 21L);
        new GenericDB<Coders>().addRow(tech.codingclub.tables.Coders.CODERS,coder);
        
    }
}
