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
	
			Base b = new Derived();
	//		b.name; //Compile time error
			String s = b.name;
			System.out.println(s);
		}
		
	}

//Explanation

```java
Base b = new Derived();
b.name;
```

---

### **Problem**

1. **Reference type matters for fields**

   * `b` is of type **`Base`**
   * In Java, **field access is determined by the reference type**, not the object type.
   * So `b.name` refers to the **`name` field in Base**, not Derived.

2. **`b.name;` is incomplete**

   * You just wrote `b.name;` by itself → this is **not a valid statement**.
   * Java expects you to **use the field** (e.g., assign it or print it).

✅ Correct ways:

```java
System.out.println(b.name); // accesses Base's name
String n = b.name;           // assigns Base's name to n
```

---

### **Important Points**

* `Base b = new Derived();`

  * Method calls → **runtime object decides** (overridden method called)
  * Field access → **reference type decides** (Base field accessed)

* So even if `Derived` has a field `name = "Thombre";`, `b.name` → `" Onkar"` because reference type is `Base`.

---

### **Corrected example:**

```java
Base b = new Derived();
System.out.println(b.name); // Output: " Onkar"
System.out.println(((Derived)b).name); // Output: "Thombre"
```

* Using **casting**, you can access `Derived`’s hidden field.

---

💡 **Summary:**

* Fields → **compile-time, reference type matters**
* Methods → **runtime, object type matters**

---

