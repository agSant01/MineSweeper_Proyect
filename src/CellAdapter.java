import java.awt.Color;

import javax.swing.JPanel;

public class CellAdapter extends JPanel {

	private static final long serialVersionUID = -6099641386621438159L;

	public static int mineCnter = 0;

	public static int MineCounter(int mouseDownX, int mouseDownY){
		mineCnter = 0;
		for (int i = mouseDownX-1; i <= mouseDownX+1; i++){
			for (int j = mouseDownY-1; j <= mouseDownY+1;j++){
				if (i < 0 || i > MyPanel.TOTAL_COLUMNS-1 || j < 0 || j > MyPanel.TOTAL_ROWS-1 ){
					//Do nothing out of colorArray bounds
				}else if (MyPanel.Mines[i][j] == 1){
					mineCnter++;
				}
			}
			if (mineCnter == 0){
				CellUncoverer(mouseDownX, mouseDownY);
			}
		}
		return mineCnter;
	}

	public static void CellUncoverer(int mouseDownX, int mouseDownY){
		for (int i = mouseDownX-1; i <= mouseDownX+1; i++){
			for (int j = mouseDownY-1; j <= mouseDownY+1;j++){
				if (i < 0 || i > MyPanel.TOTAL_COLUMNS-1 || j < 0 || j > MyPanel. TOTAL_ROWS-1 ){
					//Do nothing out of colorArray bounds
				}else if (MyPanel.Mines[i][j] == 1){
					//Do nothing: Cell is a mine
					return;
				}else if (MyPanel.Mines[i][j] == 0 && MyPanel.colorArray[i][j] != Color.LIGHT_GRAY){
					MyPanel.colorArray[i][j] = Color.LIGHT_GRAY;
					MineCounter(i,j);
				}
			}
		}
	}

	public static void MineFound() {
		for (int i = 0; i < MyPanel.TOTAL_COLUMNS; i++){
			for (int j = 0; j < MyPanel.TOTAL_ROWS; j++){
				if (MyPanel.Mines[i][j] == 1){
					MyPanel.colorArray[i][j] = Color.BLACK;
				}
			}
		}
		Main.flag=true;
	}
	
	public static boolean allUncover(){
		boolean allCellsUncovered = true;
		
		for (int i = 0; i < MyPanel.TOTAL_COLUMNS; i++){
			for (int j = 0; j < MyPanel.TOTAL_ROWS;j++){
				if (MyPanel.colorArray[i][j] == Color.WHITE && MyPanel.Mines[i][j] == 0){
					allCellsUncovered = false;
				}
			}
		}
		return allCellsUncovered;		
	}
}