package com.examen;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Matrix {

	List<List<Integer>> rows = new LinkedList<List<Integer>>();

	public Matrix getSubMatrixBetweenRows(int rowFrom, int rowTo) throws IllegalMatrixRange {
		checkArguments(rowFrom,rowTo);

		Matrix subMatrix = new Matrix();
		for (int i = rowFrom - 1; i < rowTo; i++) {
			subMatrix.addRow(rows.get(i));
		}
		return subMatrix;
	}

	private void checkArguments(int rowFrom, int rowTo) throws IllegalMatrixRange {
		checkToNotLowerThanFrom(rowFrom,rowTo);
		checkRangeInsideMatrix(rowFrom,rowTo);		
	}

	private void checkRangeInsideMatrix(int from, int to) throws IllegalMatrixRange {
		if( from < 0 || to > rows.size())
			throw new IllegalMatrixRange("The from and to value should be legal values inside the matrix Range");
		
	}

	private void checkToNotLowerThanFrom(int from, int to) throws IllegalMatrixRange {
		if( to < from) 
			throw new IllegalMatrixRange("The value TO should be greater or equal than FROM");
		
	}

	public void addRow(Integer... elements) {
		addRow(Arrays.asList(elements));
	}

	public void addRow(List<Integer> elements) {
		rows.add(elements);
	}

	public Matrix getSubMatrixBetweenColumns(int columnFrom, int columnTo) {

		Matrix subMatrix = new Matrix();
		for (int i = 0; i < rows.size(); i++) {
			List<Integer> aRow = rows.get(i);
			List<Integer> newRow = new LinkedList<>();
			for (int j = columnFrom -1; j < columnTo; j++) {
				newRow.add(aRow.get(j));
			}
			subMatrix.addRow(newRow);
		}
		return subMatrix;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (List<Integer> aRow : rows) {
			stringBuilder.append(aRow);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		try{
			Matrix aMatrix = (Matrix) obj;
			
			return rows.equals(aMatrix.rows);
			
		}catch (ClassCastException e) {
			return false;
		}
	}

	public int getElement(int rowNumber, int columnNumber) {
		List<Integer> aRow = rows.get(rowNumber -1);
		return aRow.get(columnNumber -1);
	}

	public List<Integer> getElements() {
		List<Integer> elements = new LinkedList<>();
		for (List<Integer> aRow : rows) {
			elements .addAll(aRow);
		}
		return elements;
	}
}
