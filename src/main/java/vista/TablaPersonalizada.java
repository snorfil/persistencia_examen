package vista;

import javax.swing.table.AbstractTableModel;

public class TablaPersonalizada extends AbstractTableModel {
    Object[][] datos;
    String[] titulos;
    int rowSize;
    int columnSize;

    public TablaPersonalizada(Object[][] data , String[] tit) {
        this.titulos = tit;
        this.datos = data;
        this.rowSize = data.length;
        this.columnSize = tit.length;
    }

    @Override
    public int getRowCount() {
        return rowSize;
    }

    @Override
    public int getColumnCount() {
        return columnSize;
    }

    @Override
    public String getColumnName(int column) {
        return this.titulos[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos[rowIndex][columnIndex];
    }


}
