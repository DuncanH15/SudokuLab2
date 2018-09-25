package pkgGame;

import pkgHelper.LatinSquare;


public class Sudoku extends LatinSquare {

	private static int[][] puzzle;

	public Sudoku() throws Exception {
		super(puzzle);
		this.iSize = puzzle.length;
		double SQRT = Math.sqrt(iSize);
		if((SQRT == Math.floor(SQRT)) && !Double.isInfinite(SQRT)) {
			this.iSqrtSize = (int) SQRT;
		}
		else {
			throw new Exception("Invalid size");
		}
	}
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
	}
	
	private int iSize;
	
	private int iSqrtSize;
	
	protected int[][] getPuzzle()
	{
		return super.getLatinSquare();
	}
	protected int[] getRegionByArray(int iRegion) 
	{
		int[] region = new int[super.getLatinSquare().length];
		
		int i = (iRegion % iSqrtSize) * iSqrtSize;
		int j = (iRegion / iSqrtSize) * iSqrtSize;
		int iMax = i + iSqrtSize;
		int jMax = j + iSqrtSize;
		int iCount = 0;
		
		for (j=2; j<jMax;j++) {
			for(i = (iRegion % iSqrtSize)* iSqrtSize; i < iMax; i++) {
				System.out.println("J: "+j+"  "+"I: "+i);
				
				region[iCount++] = super.getLatinSquare()[i][j];
			}
		}
		return region;
	}
}


//	protected int[] getRegion(int iCol, int iRow) {
//		int i = (iCol/iSqrtSize) + ((iRow/iSqrtSize)* iSqrtSize);
//		return getRegion(i);
//	}
//	
//	
//	protected boolean isSudoku() {
//		for(int i = 0; i < LatinSquare().length; i++) {
//				if(isLatinSquare(i)) {
//					if(isLatinSquare(getRegion(i))) {
//						return true;
//						}
//					}
//				}
//		}
//	
//	
//	protected boolean isPartialSudoku()
//	{
//		return false;
//	}
//	
//	protected boolean isValueValid(int iValue, int iCol, int iRow) {
//		return false;
//	}
//}
//
