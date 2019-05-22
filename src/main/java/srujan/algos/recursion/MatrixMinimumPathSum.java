package srujan.algos.recursion;



public class MatrixMinimumPathSum {
	
	 
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[][]  A  =  {  {  1,  0, 12, -1 },
                {  7, -3,  2,  5 },
                { -5, -2,  2, -9 }
             };
        int[][]  B  =  {  {  1,  2 },
                {  1,1},
                
             };
        
        System.out.println(B[0][1]);
        System.out.println(recMinimumPathSum(0,0,B));
       
    }
 public static  int recMinimumPathSum(int x ,int y,int[][] matrix){
	 
	   int route1Cost = Integer.MAX_VALUE;
	   int route2Cost = Integer.MAX_VALUE;
	   
       if(x==matrix.length-1 && y == matrix[0].length-1)
    	   return matrix[x][y];
       if(x+1 < matrix.length  )
           route1Cost = recMinimumPathSum(x+1,y,matrix);
       if(y+1 < matrix[0].length  )
           route2Cost = recMinimumPathSum(x,y+1,matrix);
       System.out.println(x +":"+y + "Cost:" + matrix[x][y] );
       return matrix[x][y] + Math.min(route1Cost, route2Cost);
            
    }

}
