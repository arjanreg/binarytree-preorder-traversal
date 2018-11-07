import java.util.Stack;

public class traversePreorder {
	
	public static void main(String args[])
	{
		BinaryTree T = new BinaryTree(8, new BinaryTree(2, new BinaryTree(8, null, null), new BinaryTree(7, null, null)), new BinaryTree(6, null, null));
		int answer = solution(T);
		//System.out.println("Number of Visible nodes: " + answer); 
	}
	
	public static int solution(BinaryTree T)
	{
		int num = Integer.MIN_VALUE; 
		int visibleNodes = 0;
		int root = T.x; 
		
		if(T == null)
		{
			return 0; 
		}
		
		while(T != null)
		{
			if(T.x >= num)
			{
				num = T.x;
				visibleNodes++; 
			}
			//If the left child is null, move to right child
			if(T.l == null)
			{
				System.out.print(T.x + " ");
				T = T.r; 
			}
			else
			{
				//Find iorder predecessor
				BinaryTree current = T.l;
				
				while(current.r != null && current.r != T)
				{
					current = current.r; 
				}
				
				//If the right child of iorder predecessor already
				//points to this node
				if(current.r == T)
				{
					current.r = null; 
					T = T.r;
				}
				
				//If the right child doesn't point to this node, then
				//print this node and make right child point to this node
				else
				{
					System.out.print(T.x + " ");
					current.r = T; 
					T = T.l; 
				}
			}
		}
		
		return visibleNodes; 
	}

}
