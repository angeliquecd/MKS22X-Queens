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
  }
  board[r][c]=-1;//puts down the queen
  if (c<size-1){
    if (r<size-1) board[r+1][c+1]+=1;
    if (r>0) board[r-1][c+1]+=1;}
  if (c>0){
    if (r<size-1) board[r+1][c-1]+=1;
    if (r>0) board[r-1][c-1]+=1;}//eliminates the diagonal parts
  return true;}
  return false;
}
public boolean removeQueen(int r, int c){
  if (board[r][c]==-1){
  for (int inc=0;inc<size;inc++){
    board[inc][c]-=1;//eliminates the row
    board[r][inc]-=1;//eliminates the column
  }
  if (c<size-1){
    if (r<size-1) board[r+1][c+1]-=1;
  if (r>0)board[r-1][c+1]-=1;}
  if (c>0){
    if (r<size-1)board[r+1][c-1]-=1;
    if (r>0) board[r-1][c-1]-=1;}//eliminates the diagonal parts
  board[r][c]=0;
  return true;}
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
    return solveHelper(size,0,0,0,false,0,0);
  }
private boolean solveHelper(int size,int col,int row,int putdown,boolean added, int lastrow,int lastcol){
  if (putdown==size) return true;
  if(col==size) return false;
  if (row==size) {
    removeQueen(lastrow,lastcol);
    col--;}
  if (added) {
    putdown++;
     lastrow=row;
     lastcol=col;
  }
  for (int rowz=0;rowz<size && col<size;rowz++){
    row=rowz;
    solveHelper(size,col+1,row,putdown, addQueen(row,col+1),lastrow,lastcol);
  }
  return false;
}
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    int count = 0;
    return count;
  }

}
