import java.util.*;


public class Permutations {
	static Set<String> oldPerms;
	static Set<String> newPerms;
	
	public static void getPermutations(String arg) {
		if(arg.length() == 0){
			oldPerms = new HashSet<String>();
			return ;
		}
		
        if(arg.length() > 2){
        	getPermutations(arg.substring(0,arg.length()-1));
        	newPerms = new HashSet<String>();
        }
        else{	//arg is a 2-char string
        	oldPerms = new HashSet<String>();
        	oldPerms.add(arg);	//add original 2-char
        	oldPerms.add(arg.substring(1).concat(arg.substring(0, 1)));	//add the reversed 2-char
        	return;
        }
        //3 chars or more
        String charToConcat = arg.substring(arg.length()-1);
        Iterator<String> iter = oldPerms.iterator();
        String str;
        while(iter.hasNext()){
        	str = (String) iter.next();	
        	for(int i=0; i<=str.length(); i++){	//calc all possible permutations and add them to newPerms
        		newPerms.add(str.substring(0, str.length()-i).concat(charToConcat).concat(str.substring(str.length()-i,str.length())));
        	}
        }
        
        oldPerms.removeAll(oldPerms);	//empty oldPerms
        oldPerms.addAll(newPerms);	//oldPerms is now ready for next recursion
        newPerms.removeAll(newPerms);	//empty newPerms

    }


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a word: ");
        String testInput = sc.nextLine();
        getPermutations(testInput);
        System.out.println(oldPerms.toString());
        System.out.println("There are " + oldPerms.size() + " permutations!");
    }

}
