package com.test.examen;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.examen.Matrix;
import com.examen.Solution;

public class MainTest {

	@Test
	public void testMatriz4x4() {

		Matrix aMatrix =  new Matrix();
		aMatrix.addRow(1,3,2,4);
		aMatrix.addRow(8,1,2,9);
		aMatrix.addRow(1,1,2,2);
		aMatrix.addRow(7,5,3,6);
		
		int queryMatrixSize = 3;
		int matrixSize = 4;
		Matrix queryMatrix = new Matrix();
		queryMatrix.addRow(1,1,2,2);
		queryMatrix.addRow(1,2,3,4);
		queryMatrix.addRow(4,4,4,4);

		List<Integer> sol = Solution.median(matrixSize, aMatrix , queryMatrixSize , queryMatrix );
		Assert.assertEquals(sol, Arrays.asList(2,2,6));
		
	}
	
	@Test
	public void testMatriz2x2() {

		Matrix aMatrix =  new Matrix();
		aMatrix.addRow(1,2);
		aMatrix.addRow(3,4);
	
		
		int queryMatrixSize = 3;
		int matrixSize = 2;
		Matrix queryMatrix = new Matrix();
		queryMatrix.addRow(1,2,2,2);
		queryMatrix.addRow(1,1,2,1);
		queryMatrix.addRow(1,1,2,2);

		List<Integer> sol = Solution.median(matrixSize, aMatrix , queryMatrixSize , queryMatrix );
		Assert.assertEquals(sol, Arrays.asList(3,2,2));
		
	}

}
