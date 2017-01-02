/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/animal-shelter
@Language: Java
@Datetime: 16-10-20 18:44
*/

class AnimalShelter {
    int total;
    LinkedList<String> cats;
    LinkedList<String> dogs;

    public AnimalShelter() {
        // do initialize if necessary
        total = 0;
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
        total ++;
        if(type == 1){
            dogs.add(total + "#" + name);
        }else if(type == 0){
            cats.add(total + "#" + name);
        }
    }
    public int getTime(String str){
    	String s = str.substring(0, str.indexOf("#"));
    	return Integer.parseInt(s);
    }
    
    public String getName(String str){
    	String s = str.substring(str.indexOf("#") + 1, str.length());
    	return s;
    }
    
    public String dequeueAny() {
        // Write your code here
        if(cats.isEmpty()){
        	return dequeueDog();
        }else if(dogs.isEmpty()){
        	return dequeueCat();
        }else{
        	int dogTime = getTime(dogs.getFirst());
        	int catTime = getTime(cats.getFirst());
        	if(dogTime < catTime){
        		return dequeueDog();
        	}else{
        		return dequeueCat();
        	}
        }
    }

    public String dequeueDog() {
        // Write your code here
    	String dog = getName(dogs.getFirst());
    	dogs.removeFirst();
    	return dog;
    }

    public String dequeueCat() {
        // Write your code here
    	String cat = getName(cats.getFirst());
    	cats.removeFirst();
    	return cat;
    }
}
