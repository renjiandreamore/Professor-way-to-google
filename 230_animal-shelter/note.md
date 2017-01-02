```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/animal-shelter
@Language: Markdown
@Datetime: 16-10-20 18:44
```










class AnimalShelter {

	Queue<Animal> queue = new LinkedList<>();
	Queue<Animal> dogQueue = new LinkedList<>();
	Queue<Animal> catQueue = new LinkedList<>();
	Queue<Animal> queueCopy;

	int DOG;
	int CAT;
	
    public AnimalShelter() {
        // do initialize if necessary
    	CAT = 0;
    	DOG = 1;
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
    	Animal animal = new Animal(name, type);
    	queueCopy = queue;
    	queue.add(animal);
    }

    public String dequeueAny() {
        // Write your code here
        
    	return queueCopy.poll().name;
    }

    public String dequeueDog() {
        // Write your code here
    	if(!dogQueue.isEmpty()){
    		return dogQueue.poll().name;
    	}
    	else{
    	    while(!queue.isEmpty()){
    		    if(queue.peek().type == DOG){
        		    return queue.poll().name;
        	    }else{
        		    Animal cat = queue.poll();
        		    catQueue.offer(cat);
        	    }
    	    }
    	}
    	return null;
    }

    public String dequeueCat() {
        // Write your code here
    	if(!catQueue.isEmpty()){
    		return catQueue.poll().name;
    	}
    	else{
    	    while(!queue.isEmpty()){
    		    if(queue.peek().type == CAT){
                    return queue.poll().name;
                }
        	    else{
        	        Animal dog = queue.poll();
        	        dogQueue.offer(dog);
        	    }
    	    }
    	}
    	return null; 
    }
}

class Animal {
	String name;
	int type;
	public Animal(String name, int type){
		this.name = name;
		this.type = type;
	}
}
