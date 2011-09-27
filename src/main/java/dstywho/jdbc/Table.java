package dstywho.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Table extends Vector<Row>{
    private Vector<String> columns;
    public Vector<String> getColumns()
        {
            return columns;
        }

    public void setColumns(Vector<String> columns)
        {
            this.columns = columns;
        }



    private Vector<Row> rows;



    public Table(){
        columns = new Vector<String>();
    }

    public void getRow(int row){
        this.get(0);

    }

    public void insertRow(Row row){
        this.add(row);
    }

    public void setRow(int index, Row row){
        this.set(index, row);
    }

    public ArrayList<HashMap<String, String>> toListOfHash(){
        ArrayList<HashMap<String, String>> listOfRowHashes = new ArrayList<HashMap<String,String>>();
        for(Row row: rows){
            listOfRowHashes.add(row.toHash());
        }
        return listOfRowHashes;
    }






}
