abstract class Shape
{
    abstract public double calArea();   
    
    public double displayArea()
    {
        return calArea();
    }
}

class Rectangle extends Shape
{
    private double length;
    private double breadth;
    
    public Rectangle(double length , double breadth)
    {
        this.length = length;
        this.breadth =  breadth;
    }
    
    public double calArea()
    {
         double Rarea = length * breadth;
         return Rarea;
    }
    
}

class Square extends Shape
{
    private double side;
    
    public Square(double side)
    {
        this.side = side;
    }
     
    public double calArea()
    {
        return side * side;
    }
    
}

class Circle extends Shape
{
    static final double PI = 3.14;
    private double radius;
    
    public Circle(double radius)
    {
        this.radius = radius;
    }
    
    public double calArea()
    {
       return PI * radius * radius;
    }
}

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Shape s1 = new Rectangle(10 , 20);
		Shape s2 = new Square(10);
		Shape s3 = new Circle(2);
		
		System.out.println("Rectangle :  " + s1.displayArea());
		System.out.println("Square : " + s2.displayArea());
		System.out.println("Circle :  " + s3.displayArea());
	}
}

//Explanation
Exactly 👍 you’ve got the right intuition. Let me explain clearly why you declared `calArea()` as **abstract in the `Shape` class**.

---

### 🔹 1. The role of `Shape` (Abstract Class)

* `Shape` represents a **general concept** of a shape.
* Every shape (rectangle, square, circle, triangle, etc.) has an **area**, but **the formula is different** for each.

So you can’t define a single fixed formula in `Shape`.
Instead, you declare an **abstract method**:

```java
abstract double calArea();
```

This means:

* "Every subclass must provide its own implementation of `calArea()`."

---

### 🔹 2. Why Abstract?

If you didn’t make it abstract, then:

* Either `Shape` would need to provide some *dummy/default* implementation (which doesn’t make sense for area).
* Or subclasses wouldn’t be forced to implement it, which breaks the OOP design.

By making it abstract → the compiler **forces all child classes** (`Rectangle`, `Square`, `Circle`) to override and provide their own logic.

---

### 🔹 3. Benefit in Your Code

Now, in your `main()` method, you can write:

```java
Shape s1 = new Rectangle(10 , 20);
Shape s2 = new Square(10);
Shape s3 = new Circle(2);

System.out.println("Rectangle : " + s1.displayArea());
System.out.println("Square : " + s2.displayArea());
System.out.println("Circle : " + s3.displayArea());
```

Here:

* You are using **polymorphism** → the same method `calArea()` is called, but the actual implementation depends on whether the object is a `Rectangle`, `Square`, or `Circle`.
* You didn’t need to write `s1.calArea()`, `s2.calArea()`, etc. separately. The abstract method + polymorphism handled it for you.

---

### ✅ In Simple Words

* **Abstract method** in `Shape` = a **promise** that "every shape must know how to calculate its area."
* Each subclass (Rectangle, Square, Circle) provides its **own formula**.
* `Shape` can now work as a **common reference type**, letting you treat all shapes in a unified way.

---

👉 That’s why you made `calArea()` abstract in `Shape` → to **enforce** that all shapes must define their own way of calculating area while still being able to treat them as a general `Shape`.

---

Do you want me to also make a **real-world analogy** (like “abstract class = contract, subclasses = workers fulfilling contract”) so you can remember this easily in interviews?
