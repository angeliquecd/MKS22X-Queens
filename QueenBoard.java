public class QueenBoard{
private int[][] board;
private int size;
/**0-safe
1-not safe
-1-queen

**/
public QueenBoard(int sized){
  size=sized;
board = new int[sized][sized];
  for (int i=0;i<sized;i++){
    for (int j=0;j<sized;j++){
      board[i][j]=0;}
  }
}
public boolean addQueen(int r, int c){
  if (board[r][c]==0){//checks if it's safe
  for (int inc=0;inc<size;inc++){
    board[inc][c]+=1;//eliminates the row
    board[r][inc]+=1;//eliminates the column
    if (r-inc>=0&& c-inc>=0) board[r-inc][c-inc]+=1;
    if (r+inc<size && c+inc<size)board[r+inc][c+inc]+=1;
    if (r-inc>=0 && c+inc<size) board[r-inc][c+inc]+=1;
    if (r+inc<size && c-inc>=0)board[r+inc][c-inc]+=1;//diagonals
  }
  board[r][c]=-1;//puts down the queen
//  System.out.println(this.toStringDebug());
  return true;}
  //System.out.println(this.toStringDebug()+"no add");
  return false;
}
public boolean removeQueen(int r, int c){
  if (board[r][c]==-1){
  for (int inc=0;inc<size;inc++){
    board[inc][c]-=1;//eliminates the row
    board[r][inc]-=1;//eliminates the column
    if (r-inc>=0&& c-inc>=0) board[r-inc][c-inc]-=1;
    if (r+inc<size && c+inc<size)board[r+inc][c+inc]-=1;
    if (r-inc>=0&& c+inc<size) board[r-inc][c+inc]-=1;
    if (r+inc<size && c-inc>=0)board[r+inc][c-inc]-=1;//diagonals
  }
  board[r][c]=0; //sets queen back to safe
//  System.out.println(this.toStringDebug());
  return true;}
  //System.out.println(this.toStringDebug()+"no remove");
  return false;
}
/**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _

  *_ _ _ Q

  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toStringDebug(){
    String value=" ";
    for(int i=0;i<board.length;i++){
      for (int j=0;j<board.length;j++){
        value+=board[i][j];}
      value+="\n";
    }
    return value;
  }
  public String toString(){
    String value="";
    for (int i=0;i<size;i++){
      for (int j=0;j<size;j++){
      if (board[i][j]==-1) value+="Q ";
      else value+="_ ";}
      value+="\n";
    }
    return value;
  }



  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    for (int i=0;i<size;i++){//exception handling
      for (int j=0;j<size;j++){
        if (board[i][j]!=0) throw new IllegalStateException();
      }
    }
    return solveHelper(0);
    //return solveHelper(size,0,0,0,false,0,0);
  }
  private boolean solveHelper( int col){
    if (col==size) return true;//reached end of the board
    for (int row=0;row<size;row++){//loops by row, inside shifts column
      if (addQueen(row,col)){//if it's possible
        if (solveHelper(col+1)) return true;//try with the next column
        removeQueen(row,col);}}//if that doesn't work remove this one
      return false;//f it reaches the end of the tow without putting one down
    }
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    for (int i=0;i<size;i++){//exception handling
      for (int j=0;j<size;j++){
        if (board[i][j]!=0) throw new IllegalStateException();
      }
    }
    return countHelper(0);
  }
  public int countHelper(int col){
    int count=0;
    if (col==size) return 1;//reached end of the board = 1 solution
    for (int row=0;row<size;row++){//loops by row, inside shifts column
      if (addQueen(row,col)){//if it's possible
        count += countHelper(col+1);//try with the next column
        removeQueen(row,col);}}//solves as usual
      return count;//f it reaches the end of the row without finding a new solution, returns final count
    }

}
