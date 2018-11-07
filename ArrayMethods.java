public class ArrayMethods{
   /*
   *PART 1
   */
   public static int rowSum(int[][] ary, int x){
     int finale = 0;
     // ADDED AFTER TESTING WITH SECONDRIVER
     if (x >= ary.length){
       return 0;
     }
     for (int i = 0; i < ary[x].length; i++){
       finale += ary[x][i];
     }
     return finale;
   }
    //returns the sum of the elements in Row x of ary.

   public static int columnSum(int[][] ary, int x){
     int finale = 0;
     for (int i = 0; i < ary.length; i++){
       if (ary[i].length > x){
         finale += ary[i][x];
       }
     }
     return finale;
   }
    //returns the sum of the elements in Column x of ary (careful with rows of different lengths!).

   /*
   *PART 2 - use prior methods where appropriate
   */
   public static int[] allRowSums(int[][] ary){
     int[] finale = new int[ary.length];
     for (int i = 0; i < ary.length; i++){
       finale[i] = rowSum(ary, i);
     }
     return finale;
   }
    //returns an array of the row sums for each row of ary.
    //Index i of the return array contains the sum of elements in row i.

   public static int[] allColSums(int[][] ary){
     // we need to first determine the longest row to determine the indexOutOfBounds to prevent it
     int longest = 0;
     for (int i = 0; i < ary.length; i++){
       if (longest < ary[i].length){
         longest = ary[i].length;
       }
     }
     int[] finale = new int[longest]; // the new array's length has to be "longest"
     for (int x = 0; x < longest; x++){
       finale[x] = columnSum(ary, x); // same as rows
     }
     return finale;
   }
    //Returns an array with the column sum of each column of ary.
    //When a row is not long enough to reach the column count it as a zero. (NO indexOutOfBounds should ever occur)
    //Index i of the return array contains the sum of elements in column i, ignoring any rows that are too short.
    //The length of the returned array should be the length of the LONGEST array in ary.

   /*
   *PART 3 - use prior methods where appropriate
   */
   public static boolean isRowMagic(int[][] ary){
     // we can make an array of the rowSums and loop through to check if it's the same
     int magicFoo = allRowSums(ary)[0]; // use first element in the array to check
     boolean magical = true;
     for (int i = 0; i < allRowSums(ary).length; i++){
       if (allRowSums(ary)[i] != magicFoo){
         magical = false;
         return magical;
       }
     }
     return magical;
   }
   //checks if the array is row-magic (this means that every row has the same row sum).

   public static boolean isColumnMagic(int[][] ary){
     // similar method as isRowMagic
     int magicFoo = allColSums(ary)[0];
     boolean magical = true;
     for (int i = 0; i < allColSums(ary).length; i++){
       if (allColSums(ary)[i] != magicFoo){
         magical = false;
         return magical;
       }
     }
     return magical;
   }
   //checks if the array is column-magic (this means that every column has the same column sum).

}
