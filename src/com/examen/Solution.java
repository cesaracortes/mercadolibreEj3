package com.examen;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {


	public static List<Integer> median(int matrixSize, Matrix matrix, int queryMatrixSize, Matrix queryMatrix) {
		List<Integer> result = new LinkedList<Integer>();
		for (int row = 1; row <= queryMatrixSize; row++) {
			Matrix subMatrix = getSubMatrixBetweenRows(matrix, queryMatrix, row);
			Matrix finalMatrix = getSubMatrixBetweenColumns(subMatrix, queryMatrix, row);
			List<Integer> elements = finalMatrix.getElements();
			result.add(getMedianForElements(elements));
		}

		return result;

	}

	private static Matrix getSubMatrixBetweenColumns(Matrix aMatrix, Matrix queryMatrix, int row) {
		Integer column = 2;
		Integer anotherColumn = 4;
		Integer columnFrom = queryMatrix.getElement(row, column);
		Integer columnTo = queryMatrix.getElement(row, anotherColumn);
		return aMatrix.getSubMatrixBetweenColumns(columnFrom, columnTo);

	}

	private static Matrix getSubMatrixBetweenRows(Matrix matrix, Matrix queryMatrix, int row) {
		Integer column = 1;
		Integer anotherColumn = 3;
		Integer rowFrom = queryMatrix.getElement(row, column);
		Integer rowTo = queryMatrix.getElement(row, anotherColumn);
		return matrix.getSubMatrixBetweenRows(rowFrom, rowTo);
	}

	private static Integer getMedianForElements(List<Integer> elements) {
		if (elements.size() % 2 != 0) {
			Integer elementIndex = elements.size() / 2;
			return elements.get(elementIndex);
		} else {
			elements.sort(getComparator());
			Integer middle = elements.size() / 2;
			return (elements.get(middle - 1) + elements.get(middle)) / 2;
		}
	}

	private static Comparator<Integer> getComparator() {
		return new Comparator<Integer>() {

			@Override
			public int compare(Integer aValue, Integer anotherValue) {
				return aValue - anotherValue;
			}

		};
	}

}