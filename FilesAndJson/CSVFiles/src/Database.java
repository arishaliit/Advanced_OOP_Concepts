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
        String[] temp = contents.split("\n");

        //column names are in first row
        this.colNames = temp[0].trim().split(",");

        this.numRows = temp.length - 1;
        //initialize array
        this.data = new String[this.numRows][];

        //fill data array with values
        for(int i = 1; i < numRows; i++){
            this.data[i-1] = temp[i].split(",");
        }
    }

    public String getValue(String columnName,int row){

        int  colIndex = 0;
        for(int i = 0; i< this.colNames.length; i++){
            if(this.colNames[i].equals(columnName)){
                colIndex = i;
                break;
            }
        }

        return this.data[row][colIndex];

    }

}


