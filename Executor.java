// Morgan Evans, 1124703, mnevans

public class Executor {
   
	public static void main(String[] args) {
		Utility.init(); // initializes file readers
		String[] questions = Utility.readQuestions(); //reads question.txt file into questions array
		String[] answers = Utility.readAnswers(); // reads answers.txt file into answers array
      
      //finds the number of oracles
		int numOracles = answers.length; 
      
      ArrayQueue[] oracleArray = new ArrayQueue[numOracles];
      ListQueue[] oracleList = new ListQueue[numOracles];    
      
      createArray(numOracles, oracleArray);
      arrayEnqueue(questions, oracleArray, numOracles);
      arrayDequeue(numOracles, oracleArray, answers, questions);
      
      divide();
      
      createList(numOracles, oracleList);
      listEnqueue(numOracles, questions, oracleList);
      listDequeue(oracleList, numOracles, questions, answers);
   }   

	// Initialize one ArrayQueue per oracle.
   
   public static void createArray(int numOracles, ArrayQueue[] oracleArray) {
      for (int i = 0; i < numOracles; i++) {
         oracleArray[i] = new ArrayQueue();
      }
   }

	// Put the questions into the queues, assigning each one to the queue of the oracle 
   // whose number is returned by the random number generator.
   public static void arrayEnqueue(String[] questions, ArrayQueue[] oracleArray, int numOracles) {
      for (int i = 0; i < questions.length; i++) {
         for (int j = 0; j < numOracles; j++) {
            if (j == Utility.random(numOracles)) {
               String question = questions[i];
               oracleArray[j].enqueue(question);
            }   
         }  
      }   
   }
   
	// Print each oracle's question and answer it with its unique answer until the array is empty.
   public static void arrayDequeue(int numOracles, ArrayQueue[] oracleArray, String[] answers, String[] questions) {
     for (int i = 0; i < numOracles; i++) {
         if (oracleArray.length > 0) {
            for (int j = 0; j < oracleArray[i].getSize(); j++) {
               oracleArray[j].dequeue();
               System.out.print(questions[j] + " ");
               System.out.println(answers[j]); 
            }
         }   
      }   
   }
   
   // Divide the previous sets of questions and oracles answers from the following sets.
   public static void divide() {
      System.out.println();
      for (int i = 0; i < 50; i++) {
         System.out.print("-");
      }
      System.out.println();
      System.out.println();
   }
   
   // Initialize one ListQueue per oracle.
   public static void createList(int numOracles, ListQueue[] oracleList) {
      for (int i = 0; i < numOracles; i++) {
         oracleList[i] = new ListQueue();
      }      
   }
   
   // Put the questions into the lists, assigning each one to the queue of the oracle 
   // whose number is returned by the random number generator.
   public static void listEnqueue(int numOracles, String[] questions, ListQueue[] oracleList) {
      for (int i = 0; i < questions.length; i++) {
         for (int j = 0; j < numOracles; j++) {
            if (j == Utility.random(numOracles)) {
               String question = questions[i];
               oracleList[j].enqueue(question);
            }   
         }  
      }
   }
   
	// Print each oracle's question and answer it with its unique answer until the list empty.
   public static void listDequeue(ListQueue[] oracleList, int numOracles, String[] questions, String[] answers) {
     for (int i = 0; i < numOracles; i++) {
         if (oracleList.length != 0) {
            for (int j = 0; j < oracleList[i].getSize(); j++) {
               oracleList[j].dequeue();
               System.out.print(questions[j] + " ");
               System.out.println(answers[j]);                 
            }
         } 
      }         
   }
}
