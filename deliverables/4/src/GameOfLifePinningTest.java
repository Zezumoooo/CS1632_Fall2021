import org.junit.*;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameOfLifePinningTest {
	MainPanel panel;
	@Before
	public void setUp() {
		
		Cell[][] boardCells=new Cell[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <5; j++) {
				boardCells[i][j]=Mockito.mock(Cell.class);
				panel=new MainPanel(boardCells);
				if (i==2) {
					if (j==1||j==2||j==3) {
						
					}
					else {
						
					}
				}
			}
		}

}
@Test 
	public void test1() {
	Cell[][] boardCells=new Cell[5][5];
	panel.calculateNextIteration();
	for (int i = 0; i < 5; i++) 
	{
		for (int j = 0; j < 5; j++) 
		{
			if(j==2) {
				if(i == 1 || i == 2 || i == 3) {
					Mockito.verify(boardCells[i][j].setAlive(true),times(1));
				}
				else {
					Mockito.verify(boardCells[j][k].setAlive(true),times(1));
				}
			}
		}
	}
}
@Test 
	public void test2() {
	Cell[][] boardCells=new Cell[5][5];
	for (int i = 0; i < 5; i++) 
	{
		for (int j = 0; j < 5; j++) 
		{
			if (j == 2) {
				if(i == 1 || i == 2 || i == 3) {
					assertEquals(boardCells.iterateCell(i,j),true);
				}
			}
			else {
				assertEquals(boardCells.iterateCell(i,j),false);
			}
		}
	}
}
@Test 
	public void test3() {
	Cell alive=new Cell(true);
	Cell dead=new Cell(false);
	assertEquals(alive.toString(),"x");
	assertEquals(dead.toString(), ".");
}
	/* TODO: Write the three pinning unit tests for the three optimized methods */

}