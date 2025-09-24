
### 🔹 What happens when you write a **static method** in a class?

In your code:

```java
class Demo {
    public static void Method() {
        // some code
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

* `Method()` in `Demo` is **static**, which means:

  1. It **belongs to the class** itself, not to an object.
  2. You **don’t need to create an object** of `Demo` to call it.

---

### 🔹 How to call it

Since it’s static, you can call it like this:

```java
Demo.Method();  // Correct way to call a static method
```

* If it was **non-static**, you would need to create an object first:

```java
Demo d = new Demo();
d.Method();  // Only works if Method is non-static
```

---

### 🔹 Key Points about Static Methods

1. **No `this` reference**

   * Static methods **cannot use instance variables directly** (non-static fields) because they are tied to the class, not an object.

2. **Can call other static methods** directly inside the class.

3. **Cannot be overridden in the usual sense**

   * You can **hide** static methods in subclasses, but it’s not true polymorphism.

4. **Memory allocation**

   * Static methods are stored in **method area** of JVM memory, not in heap.

---

### ✅ Example

```java
class Demo {
    static int x = 10;

    public static void show() {
        System.out.println("x = " + x);
    }
}

public class Main {
    public static void main(String[] args) {
        Demo.show();  // prints: x = 10
    }
}
```

* Notice: **No object creation needed**.

---

In short:

> A **static method belongs to the class**, can be called without creating an object, and can only directly access other **static members** of the class.

