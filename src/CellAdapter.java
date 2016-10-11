import java.awt.Color;

import javax.swing.JPanel;

public class CellAdapter extends JPanel {
	
	private static final long serialVersionUID = -6099641386621438159L;
	public int mineCnter = 0;
	
	public static void MineCounter(int mouseDownX, int mouseDownY){

		int mineCnter = 0;
		for (int i = mouseDownX-1; i <= mouseDownX+1; i++){
			for (int j = mouseDownY-1; j <= mouseDownY+1;j++){
				if (i < 0 || i > MyPanel.TOTAL_COLUMNS-1 || j < 0 || j > MyPanel.TOTAL_ROWS-1 ){
					//Do nothing out of colorArray bounds
				}else if (MyPanel.Mines[i][j] == 1){
					mineCnter++;
				}
			}
		}
		if (mineCnter == 0){
			for (int i = mouseDownX-1; i <= mouseDownX+1; i++){
				for (int j = mouseDownY-1; j <= mouseDownY+1;j++){
					if (i < 0 || i > MyPanel.TOTAL_COLUMNS-1 || j < 0 || j >MyPanel. TOTAL_ROWS-1 ){
						//Do nothing out of colorArray bounds
					}else if (MyPanel.Mines[i][j] == 0){
						MyPanel.colorArray[i][j] = Color.LIGHT_GRAY;
					}
				}
			}
		}
		return;
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
}
