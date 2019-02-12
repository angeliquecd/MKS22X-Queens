 public class QueenDriver{
   public static void main(String[] args){
     QueenBoard tester = new QueenBoard(20);
     System.out.println(tester);
     System.out.println(tester.toStringDebug());
     tester.addQueen(0,0);
     System.out.println("added to 0,0");
     System.out.println(tester.toStringDebug());
     tester.addQueen(5,7);
     System.out.println("added to 5,7");
     System.out.println(tester.toStringDebug());
     System.out.println(tester);
     tester.removeQueen(5,7);
     System.out.println("removed 5,7");
     System.out.println(tester.toStringDebug());
     QueenBoard tester2 = new QueenBoard(2);
    System.out.println(tester2.solve());
    System.out.println(tester2.toStringDebug());
    QueenBoard tester3 = new QueenBoard(4);
    System.out.println(tester3.solve());
    QueenBoard tester5 = new QueenBoard(13);
    System.out.println(tester5.solve());
    QueenBoard tester6 = new QueenBoard(11);
    System.out.println(tester5);
    tester6.solve();
    System.out.println(tester6);
    QueenBoard tester7 = new QueenBoard(11);
    System.out.println(tester7.countSolutions());
    QueenBoard tester8 = new QueenBoard(9);
    System.out.println(tester8.countSolutions());
    System.out.println(tester5.countSolutions());//should throw an exception
   }
 }
