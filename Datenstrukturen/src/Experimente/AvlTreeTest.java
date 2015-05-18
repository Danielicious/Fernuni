package src.Experimente;

import java.util.*;

public class AvlTreeTest {
	
	public static void main(String[] args){
		AvlTreeTest test = new AvlTreeTest();
		AvlTree rootNode = new AvlTree();
		int min = 0;
		int max = 100;
		List<Integer> list = new ArrayList<Integer>();
		test.randomTree(rootNode, min, max, list);
		bubble(list);
		for (int elem : list)
			System.out.println(elem);
		System.out.println("" + rootNode.getSecondSmallest());
		rootNode.setSmallerValues();
		int amount = 0;
		for (AvlNode elem : rootNode.inorder())
		{
			amount = elem.smallerValues;
			System.out.println("" + elem.key + "->" + elem.smallerValues);
		}
		System.out.println("Now giving all nodes of AVLTree with r smaller values");
		for (int i = 0; i< amount;i++)
			System.out.println("" + i + "-> " + rootNode.getRSmallest(i));
	}
	
	public void randomTree(AvlTree rootNode,int min, int max, List<Integer> list){
		int range = max - min;
		rootNode.insert(min + range/2);
		Random rnd = new Random();
		for (int i = 0;i<range/2;i++)
		{
			int current = min + rnd.nextInt(range);
			rootNode.insert(current);
			if (!list.contains(current))
				list.add(current);
		}
	}
	
	public static int bubble(List<Integer> sorted) {
	    int count=0; int i=sorted.size();
	    boolean changed = true;
	    while(changed && i>0) {
	      changed = false;
	      for(int j=1; j<i; j++) {
	        if(sorted.get(j).compareTo(sorted.get(j-1))<0) {
	          int s=sorted.get(j);
	          sorted.set(j,sorted.get(j-1));
	          sorted.set(j-1, s);
	          changed = true;
	        }   
	      }
	      count++;
	      i--;
	    }
	    return count;
	  }

}
