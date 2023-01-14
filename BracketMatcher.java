import java.util.Scanner;

public class BracketMatcher{
	

	//instance variables
	private char[] opening = {'(', '[', '{', '<'};
	private char[] closing = {')', ']', '}', '>'};
	SinglyLinkedList list; //list to hold stack

	//constructor
	public BracketMatcher(){	
		list = new SinglyLinkedList();
	}

	//isOpening
	private boolean isOpeningBracket(char c){
		if (c == '(' || c == '{' || c == '[' || c == '<'){
			return true;  
		}else{ 
			return false;
		}
		
	}

	//isClosing
	private boolean isClosingBracket(char c){
		if (c == ')' || c == '}' || c == ']' || c == '>'){ 
			return true; 
		}else{
			return false; 
		}
	
	}

	//corresponds
	private boolean corresponds (char open, char close){
		int openIndex;
		int closeIndex;

		for(i=0; i<opening.length;i++){
			if(open == opening[i])
				openIndex = i; 
		}
		for(i=0; i<closing.length; i++){ 
			if(close == closing[i]){
				closeIndex = i; 
			}
		}

		if(openIndex == closeIndex){
			return true; 
		}else{ 
			return false; 
		}


	}




	//checkBrackets
	public boolean checkBrackets(String s){

		for (int i=0; i<s.length(); i++){

			//test for opening
			if (isOpeningBracket(s.charAt(i)) ){

				//push into stack 
				list.addFirst(s.charAt(i));

			}else if (isClosingBracket(s.charAt(i)) ){

				if(corresponds(list.first(), s.charAt(i)) ){
					list.removeFirst();
				}else{
					return false;
				}

			}else{
				continue;
			}

		}//close for

		if (list.isEmpty()){
			return true;
		}else{
			return false;
		}

	}

}//close BracketMatcher



class BracketMatchApp {
	public static void main(String [] args){

		Scanner scn = new Scanner (System.in);
		BracketMatcher brackMatch = new BracketMatcher();
		String s;
		boolean isMatched;

		//ask for input
		System.out.println("Please input a string: ");
		s = scn.nextLine();
		isMatched = brackMatch.checkBrackets(s);

		//output
		if (isMatched){
			System.out.println("All the brackets are matching.");
		}else{
			//this is where our extra credit will go
			System.out.println("The brackets don't match.");
		}

	}

}//BracketMatchApp