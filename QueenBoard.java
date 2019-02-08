public class QueenBoard{
private int[][] board;
private int size;
/**0-safe
1-not safe
-1-queen

**/
public QueenBoard(int size){
  size=size;
  int[][] board = new int[size][size];
  for (int i=0;i<size;i++){
    for (int j=0;j<size;j++){
      if (i==0) board[i][j]=1;
      else board[i][j]=0;}
  }
}
private boolean addQueen(int r, int c){
  if (board[r][c]==0){//checks if it's safe
  board[r][c]=-1;//puts down the queen
  for (int row=r;row<size;row++){
    board[row][c]=1;
  }
  for (int col=c;col<size;col++){
    board[r][col]=1;
  }
  board[r+1][c+1]=1;
  board[r-1][c+1]=1;
  return true;}
  return false;
}
private boolean removeQueen(int r, int c){
  board[r][c]=1;
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
  public String toString(){
    String value="";
    for (int i=0;i<size;i++){
      for (int j=0;j<size;j++){
      if (board[i][j]==-1) value+="Q ";
      else value+="_ ";}
    }
    return value.substring(0,value.length()-1);
  }



  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    return solveHelper(size,0,0,false);
  }
private boolean solveHelper(int size,int queens,int putdown,boolean added){
  if (putdown==size) return true;
  if(queens==size) return false;
  int spot=0;
  if (added) putdown++;
  int queen=queens;
  for (int i=0;i<size;i++){
    spot=board[i][queen];
    solveHelper(size,queens+1,putdown, addQueen(i,queen));
  }
  return false;
}
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    return 4;
  }

}
