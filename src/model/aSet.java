package model;

import java.util.ArrayList;
import java.util.List;

public class aSet {

	private List<Integer> elements;
//	private int[] elements;
	public int size;
	
//	public aSet(int size) {
//		
//		this.size = size;
//		elements = new int[size];
//	}
	
	public aSet(int size) {
		
		elements = new ArrayList<>();
		this.size = size;
	}
	
	public List<Integer> getElements() {
		return elements;
	}

	public int getSize() {
		return size;
	}

	public void setElements(List<Integer> elements) {
		this.elements = elements;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean elementExists(int n) {
		
//		System.out.println("s: " + size);
		
		for(int i = 0; i < size; i++) {
			
			if(elements.get(i) == n) {
				
				return true;
			}
		}
		
		return false;
	}
	
	public void addElement(int n) {
		
		if(!elementExists(n)) {
			
			elements.add(n);
			size++;
		}
	}
	
	public void removeElement(int n) {

		if(elementExists(n)) {
			
			elements.remove(n);
			size--;
		}
	}
	
	public aSet findUnion (aSet s) {

		List<Integer> unionSet = new ArrayList<>();
		List<Integer> aux = new ArrayList<>();
		
		aux.addAll(elements);
//		aux.addAll(s.getElements());
		
		for(int i = 0; i < s.size; i++) {
			
//			System.out.println("u: " + unionSet);
//			
//			System.out.println("b: " + elements.contains(s.getElements().get(i)));
			
			if(!elements.contains(s.getElements().get(i))) {
				
				aux.add(s.getElements().get(i));
			}
		}
		
		unionSet = aux;
		aSet union = new aSet(0);
		union.setElements(unionSet);
		union.insertionSort();
		union.setSize(unionSet.size());
		
		return union;
	}
	
	public aSet findIntersection(aSet s) {

		List<Integer> intersectionSet = new ArrayList<>();
		List<Integer> aux = new ArrayList<>();
		
		aux.addAll(elements);

		for(int i = 0; i < aux.size(); i++) {
			
			if(elements.contains(aux.get(i)) && s.getElements().contains(aux.get(i))) {
				
				intersectionSet.add(aux.get(i));
			}
		}
		
//		intersectionSet.addAll(s.getElements());
		
		aSet intersection = new aSet(0);
		intersection.setElements(intersectionSet);
		intersection.insertionSort();;
		intersection.setSize(intersectionSet.size());
		
		return intersection;
	}
	
	public aSet findSymmetricDifference(aSet s) {

		List<Integer> symmDiffSet = new ArrayList<>();
		List<Integer> aux = new ArrayList<>();
		
		aux.addAll(elements);

		for(int i = 0; i < aux.size(); i++) {
			
			if(!elements.contains(aux.get(i)) || !s.getElements().contains(aux.get(i))) {
				
				symmDiffSet.add(aux.get(i));
			}
		}
		
		aux = s.getElements();
		
		for(int i = 0; i < aux.size(); i++) {
			
			if(!elements.contains(aux.get(i)) || !s.getElements().contains(aux.get(i))) {
				
				symmDiffSet.add(aux.get(i));
			}
		}
		
		aSet symmDiff = new aSet(0);
		symmDiff.setElements(symmDiffSet);
		
//		System.out.println("Symm Diff: " + symmDiff.getElements());
		
		symmDiff.insertionSort();

//		System.out.println("-Symm Diff: " + symmDiff.getElements());
		
		symmDiff.setSize(symmDiffSet.size());
		
		return symmDiff;
	}
	
	public String print() {
		
		String line = "{";
		
		if(elements != null) {

			for(int i = 0; i < elements.size(); i++) {

				if(i == elements.size() - 1) {
					
					line += (elements.get(i));
				
				} else {
					
					line += (elements.get(i) + ", ");
				}
			}
		}
		
		line += "}";
		
		return line;
	}
	
	public void insertionSort() {

		int aux, j;

		for(int i = 1; i < size; i++) {

			aux = elements.get(i);
			j = i - 1;

			while(j >= 0 && aux < elements.get(j)) {

				elements.set(j+1, elements.get(j));
				j--;
			}
			
			elements.set(j+1, aux);
		}
	}
}
