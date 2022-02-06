public class Database {
    private String[] colNames;
    private int numRows;
    private String[][] data;

    public String[] getColNames() {
        return colNames;
    }

    public void setColNames(String[] colNames) {
        this.colNames = colNames;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public Database(String contents) {
/* TODO 
This constructor should take the contents of a CSV file and initialize the memember variables of the Database class.
*/
    }

    public String getValue(String columnName,int row){
/* TODO */
This method should return the data contained on row "row" and the column matching  @columname
    }

}


