//commented part is for synchronization it shows race condition
package multithreading;

class TestSync
{
	int count = 0;
	
	public void increment()
	{
		count ++;
	}
	
}

class TestSyncMethod
{
	int count = 0;
	
	synchronized public void  increment()
	{
		count ++;
	}
	
}

class MyThread extends Thread
{
//	TestSync c1;
	TestSyncMethod c2;
	
//	public MyThread(TestSync c1)
//	{
//		this.c1 = c1;
//	}
	
	public MyThread(TestSyncMethod c2)
	{
		this.c2 = c2;
	}
	
	
	public void run()
	{
		for(int i = 0 ; i < 10 ; i ++)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			c1.increment();
//			System.out.println( Thread.currentThread().getName() + " : " + c1.count);
			c2.increment();
			System.out.println( Thread.currentThread().getName() + " : " + c2.count);
		}
	}
	
	
}

public class RaceCondition {
	public static void main(String[] args) {
		
		TestSync obj = new TestSync();
		
		TestSyncMethod obj2 = new TestSyncMethod();
		
//		MyThread t1 = new MyThread(obj);
//		MyThread t2 = new MyThread(obj);
		
		MyThread ts1 = new MyThread(obj2);
		MyThread ts2 = new MyThread(obj2);
		
		ts1.start();
		ts2.start();
		
		try {
			ts1.join();
			ts2.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("1. actual 100 expected because in for we have given => " + obj2.count);
		System.out.println("2. actual 100 expected because in for we have given 100 => " + obj2.count);
	}
}

/*

Thread-0 : 2
Thread-1 : 1
Thread-1 : 3
Thread-0 : 4
Thread-1 : 5
Thread-0 : 6
Thread-1 : 7
Thread-0 : 8
Thread-0 : 9
Thread-1 : 10
Thread-1 : 11
Thread-0 : 12
Thread-0 : 13
Thread-1 : 14
Thread-1 : 15
Thread-0 : 16
Thread-1 : 18
Thread-0 : 18
Thread-1 : 20
Thread-0 : 20
1. actual 100 expected because in for we have given 100 => 20
2. actual 100 expected because in for we have given 100 => 20

*/

// by using ace condition code it gives some uncertain ouput 



// ouput explanation 

/*
This is an **excellent confusion**, and once you understand this, **race condition will be crystal clear forever** 👍
Let’s clear it **step by step**, no assumptions.

---

## 🔴 First, restate your doubt (in simple words)

You are saying:

* Loop inside `run()` is **10**
* You have **2 threads**
* Output prints values till **20**
* You are confused:

  > “If loop is 10, how did final value become 20?”

---

## ✅ SHORT ANSWER (core idea)

> **Each thread runs its own loop independently.**

So:

```
Thread-0 → 10 increments
Thread-1 → 10 increments
Total increments attempted = 10 + 10 = 20
```

That’s why you see values up to **20**.

---

## 🔍 Now let’s explain slowly with your output

### Your output (important lines)

```
Thread-0 : 2
Thread-1 : 1
Thread-1 : 3
Thread-0 : 4
...
Thread-1 : 20
Thread-0 : 20
```

This shows:

* Both threads are incrementing **the same shared variable**
* Both threads together push the value forward

---

## 🧠 VERY IMPORTANT RULE (MEMORIZE THIS)

> **The loop count is per thread, not per program.**

So if:

* Loop = 10
* Threads = 2

👉 Total increments attempted = **20**

---

## 📌 Visual explanation

### Code (simplified)

```java
for (int i = 0; i < 10; i++) {
    count++;
}
```

### Execution:

| Thread    | Increments |
| --------- | ---------- |
| Thread-0  | 10         |
| Thread-1  | 10         |
| **Total** | **20**     |

---

## ❓ Then where is the race condition?

Good question.

### In your printed output:

```
Thread-1 : 18
Thread-0 : 18   ❌ duplicate
```

This shows:

* One increment was lost
* Two threads printed the same value

That is the **race condition**

---

## ❗ Why printing inside loop is confusing you

Because:

```java
System.out.println(...)
```

* Is internally synchronized
* Slows down threads
* Alters thread timing
* Makes race condition look random

So:

* You may see **all numbers**
* But duplicates and ordering prove the race

---

## 🔥 Correct interpretation of your result

| Thing you saw                 | Meaning                      |
| ----------------------------- | ---------------------------- |
| Final value ≈ 20              | Because 2 threads × 10 loops |
| Mixed order                   | Thread scheduling            |
| Duplicate numbers             | Race condition               |
| Sometimes correct final value | Non-deterministic behavior   |

---

## ✅ Why you expected 100 (and why it’s wrong here)

You said:

> “Actual 100 expected because loop is 100 => 20”

This expectation is incorrect **for this code**.

### Because:

* Loop is **10**, not 100
* Threads are **2**
* So expected = **20**, not 100

If loop were **100**:

```
Expected = 100 × 2 = 200
```

---

## 🧠 FINAL GOLDEN FORMULA (WRITE THIS DOWN)

```
Expected value = loop count × number of threads
```

✔ Single thread → loop count
✔ Multiple threads → loop count × threads

---

## 🎯 One-line interview explanation

> Each thread executes its own loop independently, so with two threads and a loop of 10, the shared counter is incremented 20 times in total.

---

## 🚀 If you want next, I can show you:

* Same code with `synchronized` → clean output
* Same code with `AtomicInteger`
* Diagram of thread interleaving
* Why `volatile` alone fails

Just say 👍

*/

/*
another explanation
Good questions 👍
You’re thinking in the **right direction**, you just need a small correction in **how threads start and how `synchronized` works**.
Let me explain **slowly, clearly, with rules**.

---

## 1️⃣ Your statement (corrected)

You said:

> “One thread does increment and decrement and due to synchronized method it gives allowance for that method one thread at a time”

### ✅ Correct idea (small correction)

* **`synchronized` allows only ONE thread at a time to enter that method**
* Other threads **wait** until the lock is released
* This prevents **race condition**

### Important correction:

👉 In your code you are **only incrementing**, not decrementing.

So the correct statement is:

> With a synchronized method, only one thread can execute the increment operation at a time, so updates to `count` are safe.

---

## 2️⃣ Main confusion:

> “At start it shows output like 2, but count is 0 at that time — how?”

This is the **core misunderstanding**, and once this clicks, everything will be clear.

---

## 🔴 Key rule you are missing (VERY IMPORTANT)

> **Thread scheduling is NOT sequential and NOT visible to us.**

When you see output on the console, **many operations have already happened internally**.

---

## 🔍 What you THINK is happening

You think execution is like this:

```
count = 0
Thread starts
prints value
then increments
```

❌ This is **not true**.

---

## 🔍 What ACTUALLY happens (step by step)

Let’s take this code inside `run()`:

```java
c1.increment();
System.out.println(c1.count);
```

### Initial state:

```
count = 0
```

---

### Possible real execution timeline (hidden from you)

#### Thread-0

```
count = 0
increment() → count becomes 1
(context switch)
```

#### Thread-1

```
increment() → count becomes 2
(context switch)
```

#### Now printing happens

```
Thread-0 prints 2
Thread-1 prints 2
```

### 🧠 That’s why you see:

```
Thread-0 : 2
Thread-1 : 2
```

Even though **count started at 0**, by the time printing happens:
👉 count is already **2**

---

## 🔥 Important takeaway

> **Printing does NOT show the moment a thread started.
> It shows the value at the moment printing happened.**

---

## 3️⃣ Why you NEVER see `0` printed

Because:

* `count` is incremented **before printing**
* So minimum printed value is `1`

```java
increment();   // count becomes 1
print(count); // prints 1 or more
```

✔ That’s why `0` is never printed

---

## 4️⃣ What `synchronized` actually guarantees (and what it does NOT)

### ✅ What it guarantees

* Only one thread executes the method at a time
* No lost updates
* Final count is correct

### ❌ What it does NOT guarantee

* Execution order
* Which thread runs first
* When printing happens

---

## 5️⃣ Simple real-life analogy 🚦

Think of `synchronized` like a **single washroom** 🚻

* Only one person can enter
* Others wait outside
* Order of entry is unpredictable
* But nobody overlaps inside

---

## 6️⃣ Final mental model (MEMORIZE THIS)

* Threads may run **before you see any output**
* Console output is **delayed**
* Context switching can happen **anywhere**
* `synchronized` = safety, not order

---

## 🎯 One-line interview-ready explanation

> Even though the counter starts at zero, multiple increments may already have occurred before a thread prints the value, because thread scheduling and context switching are controlled by the JVM and OS.

---

If you want next, I can explain:

* Why sometimes both threads print same value
* Difference between **atomicity and visibility**
* `synchronized` vs `volatile`
* Why printing changes thread behavior

Just tell me 👍

*/
