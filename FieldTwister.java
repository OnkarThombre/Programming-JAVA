package com.onkar;
class Base
{
	public String name  = " Onkar";
	public int age = 23;
	
	public void display()
	{
		System.out.println(name + age);
	}
}

class Derived extends Base
{
	public String name = "Thombre";
	public void display()
	{
		System.out.println(name + age);
	}
}

public class FieldPolymorphism {
	public static void main(String[] args) {
    Base b = new Derived(); // Here o/p is Thombre23 Confusing?? Fields are inherited not overridden but method is get called for derived so derived things/entity are get called though reference is of Base
		b.display();
	}
}



Ah! Now we are hitting the **classic “field hiding vs method overriding” behavior** in Java. Let’s analyze your code carefully step by step.

---

### **Your code:**

```java
package com.onkar;

class Base {
    public String name  = " Onkar";
    public int age = 23;

    public void display() {
        System.out.println(name + age);
    }
}

class Derived extends Base {
    public String name = "Thombre";

    public void display() {
        System.out.println(name + age);
    }
}

public class FieldPolymorphism {
    public static void main(String[] args) {
        Base b = new Derived();
        b.display();
    }
}
```

---

### **Step 1: Field inheritance**

* `Base` has `name` and `age`.
* `Derived` **hides** `Base`’s `name` by declaring its own `name`.
* `age` is inherited because `Derived` did not redeclare it.
* **Important:** fields are **not overridden**, so `Base`’s `name` still exists in the object but is hidden.

---

### **Step 2: Method overriding**

* `Derived` overrides `display()` method.
* In Java, **method calls are polymorphic** → determined by **object type at runtime**, not reference type.

Here:

```java
Base b = new Derived();
b.display();
```

* `b` is of reference type `Base`
* Object type is `Derived` → **Derived’s `display()` is called**

---

### **Step 3: Inside `Derived.display()`**

```java
System.out.println(name + age);
```

* `name` → this refers to `Derived`’s field `"Thombre"`
* `age` → inherited from `Base`, value is `23`

---

### **✅ Output:**

```
Thombre23
```

---

### **Key Points**

1. Fields are **hidden**, not overridden.
2. Methods are **overridden**, so runtime type decides which `display()` runs.
3. Inside `Derived.display()`, **`name` refers to Derived’s field**, **`age` refers to Base’s field**.

---
