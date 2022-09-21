public class TwoWayTable {
    int numRows;
    int numCols;
    int[][] cell; //[i][j]
    int[] rowSum;
    int[] colSum;
    int grandTotal;

    // constructor
    TwoWayTable(int[][] data) {
        cell = data;
        rowSum = new int[data.length];
        colSum = new int[data[0].length];
        numRows = data.length;
        numCols = data[0].length;
        grandTotal = 0;
        setMargins();
    }

    void setMargins() {
        // compute the row and column sums and add to the grandTotal;
        // rowSum:
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[i].length; j++) {
                rowSum[i] = cell[i][j] + rowSum[i];
            }
            grandTotal = grandTotal+rowSum[i];
        }

        // colSum:
        for (int i = 0; i < cell[0].length; i++) {
            for (int j = 0; j < cell.length; j++) {
                colSum[i] = cell[j][i] + colSum[i];
            }
            grandTotal = grandTotal+colSum[i];
        }
    }
    
    public String toString() {
        String output = "";
        // Build the output for each row and print the rowSum
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[i].length; j++) {
                output = output+cell[i][j]+"\t";
            }
            output = output+"|"+rowSum[i]+"\n";
        }

        // Build a separation line at the bottom of the output
        for (int i = 0; i < colSum.length; i++) {
            output = output+"--\t";
        }
        output = output+"\n";

        // Build the colSum values
        for (int i = 0; i < colSum.length; i++) {
            output = output+colSum[i]+"\t";
        }

        // Build the grandTotal output
        output = output+grandTotal;          
        return output;
    }
}
