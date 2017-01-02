/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/shape-factory
@Language: Java
@Datetime: 16-12-22 19:02
*/

/**
 * Your object will be instantiated and called as such:
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape(shapeType);
 * shape.draw();
 */
interface Shape {
    void draw();
}

class Square implements Shape {
    // Write your code here
    @Override
    public void draw(){
        System.out.println(" ----");
        System.out.println("|    |");
        System.out.println("|    |");
        System.out.println(" ----");
    }
    
}

class Triangle implements Shape {
    // Write your code here
    @Override
    public void draw(){
        System.out.println("  /\\");
        System.out.println(" /  \\");
        System.out.println("/____\\");
    }
}

class Rectangle implements Shape {
    // Write your code here
    @Override
    public void draw(){
        System.out.println(" ----");
        System.out.println("|    |");
        System.out.println(" ----");
    }

}

public class ShapeFactory {
    /**
     * @param shapeType a string
     * @return Get object of type Shape
     */
    public Shape getShape(String shapeType) {
        // Write your code here
        if(shapeType == null){
            return null;
        }
        
        if(shapeType.equals("Square")){
            return new Square(); 
        }else if(shapeType.equals("Triangle")){
            return new Triangle();
        }else{
            return new Rectangle();
        }
        
    }
}