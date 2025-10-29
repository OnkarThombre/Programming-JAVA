---

## 🚫 Short Answer:

> ❌ **Static methods cannot be overridden in Java.**

But they **can be hidden** (a concept called *method hiding*).

---

## ☕ Why static methods **can’t be overridden**

1. **Static methods belong to the class**, not to an instance (object).

   * When you declare a static method, it is loaded into memory **once** for the class.
   * Objects don’t get their own copy of static methods.

2. **Overriding** in Java is a runtime concept — it depends on the **object** that calls the method.

   * Example:

     ```java
     Parent p = new Child();
     p.show();
     ```

     Here, at **runtime**, the `Child`’s method runs (dynamic binding).

3. But **static methods** are **resolved at compile time**, based on the **class reference**, not the object.
   So they can’t be truly overridden.

---

## 🧩 Example:

```java
class Parent {
    static void show() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child static method");
    }
}

public class Demo {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show(); // What do you think this prints?
    }
}
```

### Output:

```
Parent static method
```

Even though `p` refers to a `Child` object,
the **compiler** checks the **type of reference** (`Parent`) and calls `Parent.show()` — not `Child.show()`.

That’s **method hiding**, not overriding.

---

## 🔍 Method Hiding vs Method Overriding

| Feature         | Static (Method Hiding) | Non-Static (Overriding)      |
| --------------- | ---------------------- | ---------------------------- |
| Belongs to      | Class                  | Object                       |
| Binding         | Compile-time           | Runtime                      |
| Keyword used    | `static`               | (no static)                  |
| Example call    | `Parent.show()`        | `p.show()` depends on object |
| Can use `super` | No need                | Yes, to call parent version  |

---

## ✅ In short:

> Static methods **cannot be overridden**, because overriding is based on **runtime polymorphism**, and static methods are resolved **at compile time**.
> When you declare a static method with the same signature in a subclass, you are **hiding** the parent method — not overriding it.

---
