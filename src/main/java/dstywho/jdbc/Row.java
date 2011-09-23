package dstywho.jdbc;

import java.util.HashMap;
import java.util.Vector;

public class Row extends Vector<String>{

    private Vector<String> columns;


    /**
     * @return the columns
     */
    public Vector<String> getColumns()
        {
            return columns;
        }

    /**
     * @param columns the columns to set
     */
    public void setColumns(Vector<String> columns)
        {
            this.columns = columns;
        }

    public Row(){
        super();
        columns = new Vector<String>();
    }

    public Row(Vector<String> columns, Vector<String> data){
        super(data);
        this.columns = columns;

    }


    public HashMap<String,String> toHash(){
        HashMap<String,String> hash = new HashMap<String,String>();
        for(int i = 0; i < columns.size(); i ++){
            hash.put(columns.get(i), get(i));
        }
        return hash;

    }
}
