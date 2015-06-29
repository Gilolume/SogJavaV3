
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gwen
 */
public class MyTableModel extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int col) {
		return false;
	}
}
