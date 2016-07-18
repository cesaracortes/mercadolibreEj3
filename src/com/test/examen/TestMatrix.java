package com.test.examen;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.examen.IllegalMatrixRange;
import com.examen.Matrix;

public class TestMatrix {
	
	@Test
	public  void testGetSubMatrixRow() throws IllegalMatrixRange {
		
		Matrix aMatrix = new Matrix();
		
		aMatrix.addRow(1,2,3);
		aMatrix.addRow(4,5,6);
		aMatrix.addRow(7,8,9);
		
		Matrix actualList = aMatrix.getSubMatrixBetweenRows(1, 2);
		
		Matrix expectedMatrix = new Matrix();
		expectedMatrix.addRow(1,2,3);
		expectedMatrix.addRow(4,5,6);
		
		Assert.assertEquals(expectedMatrix, actualList);	
	}
	
	@Test(expected = IllegalMatrixRange.class)
	public void badRowRangeShoulThrowError() throws IllegalMatrixRange{
		
		Matrix aMatrix = new Matrix();
		aMatrix.addRow(1,2);
		aMatrix.addRow(5,6);
		aMatrix.getSubMatrixBetweenRows(2,3);
	}
	
	@Test
	public  void testGetSubMatrixByColumn() {
		
		Matrix aMatrix = new Matrix();
		
		aMatrix.addRow(1,2,3);
		aMatrix.addRow(4,5,6);
		aMatrix.addRow(7,8,9);
		
		Matrix actualList = aMatrix.getSubMatrixBetweenColumns(1, 2);
		
		Matrix expectedList = new Matrix();
		expectedList.addRow(1,2);
		expectedList.addRow(4,5);
		expectedList.addRow(7,8);
						
		Assert.assertEquals(expectedList, actualList);	
	}
	
	@Test
	public void testGetElement() {
		
		Matrix matrix = new Matrix();
		matrix.addRow(1,3,6);
		matrix.addRow(2,4,8);
		matrix.addRow(7,3,1);

		
		Integer element = matrix.getElement(1,2);
		
		Assert.assertEquals(new Integer(3), element);	
	}
	
	@Test
	public void testGetElements() {
		Matrix matrix = new Matrix();
		matrix.addRow(1,3);
		matrix.addRow(2,4);
		
		List<Integer> element = matrix.getElements();
				
		
		Assert.assertEquals(Arrays.asList(1,3,2,4), element);	

	}

}
