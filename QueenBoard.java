public class QueenBoard{
private int[][] board;
/**0-safe
1-not safe
-1-queen

**/
public QueenBoard(int size){
  board = board[size][size];
  for (int i=0;i<size;i++){
    for (int j=0;j<size;j++){
    board[i][j]=0;}
  }
}
private boolean addQueen(int r, int c){
  board[r][c]=-1;
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
    return value;
  }



  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    return solveHelper(size,0,0);
  }
private boolean solveHelper(int size,int place,int putdown){
  if (putdown==size) return true;
  if(place==size) return false;
  for (int i=0;i<size;i++){
    if ()
    addQueen(i,0);
  3}
}
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    return 4;
  }

}
