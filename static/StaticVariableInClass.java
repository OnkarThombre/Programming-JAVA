
### 1. **`static int x = 10;`**

* **Default access modifier** is **package-private** (also called default access).
* Rules:

  1. Accessible by **any class in the same package**.
  2. Not accessible from **other packages** unless you use getter/setter or make it public.
* Example:

```java
class Demo {
    static int x = 10; // default access
}

public class Test {
    public static void main(String[] args) {
        System.out.println(Demo.x); // Works if Test is in same package
    }
}
```

---

### 2. **`static private int x = 10;`**

* **Private access modifier**
* Rules:

  1. Accessible **only within the same class**.
  2. Not accessible by other classes—even in the same package.
* Example:

```java
class Demo {
    private static int x = 10; // private access

    public static int getX() {
        return x; // can access inside class
    }
}

public class Test {
    public static void main(String[] args) {
        // System.out.println(Demo.x); // ❌ Error: x has private access
        System.out.println(Demo.getX()); // ✅ Access via method
    }
}
```

---

### ✅ Key Difference

| Modifier                | Access Scope    | Notes                                   |
| ----------------------- | --------------- | --------------------------------------- |
| `default` (no modifier) | Same package    | Accessible by any class in same package |
| `private`               | Same class only | Need getters/setters for outside access |

---

### 🔹 Important:

* Both are **static**, so memory is **shared across all objects**.
* The **difference is only about visibility/accessibility**, not memory behavior.

---

