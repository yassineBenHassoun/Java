public class App {
    public static void main(String[] args) throws Exception {

        

    }
} 



















































/* 

class Animal {
	private boolean alive = true;
	private String name;

	public void meet(Animal other) {
		if (canEat(other))
			other.eaten();
		else if (other.canEat(this))
			eaten();
	}

	public void eaten() {
		alive = false;
	}

	public boolean canEat(Animal other) {
		return false;
	}

	public boolean isAlive() {
		return alive;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
}

class Mouse extends Animal {
	public Mouse(String name) {
		setName(name);
	}
}


class Cat extends Animal {
	public Cat(String name) {
		setName(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && animal instanceof Mouse;
	}
}

class Tiger extends Cat {
	public Tiger(String name) {
		super(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && (super.canEat(animal) || !(animal instanceof Tiger));
	}
}

/*
class Animal {
	private boolean alive = true;
	private String name;

	public void meet(Animal other) {
		if (canEat(other))
			other.eaten();
		else if (other.canEat(this))
			eaten();
	}

	public void eaten() {
		alive = false;
	}

	public boolean canEat(Animal other) {
		return false;
	}

	public boolean isAlive() {
		return alive;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
}

class Mouse extends Animal {
	public Mouse(String name) {
		setName(name);
	}
}

class Cat extends Animal {
	public Cat(String name) {
		setName(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && animal instanceof Mouse;
	}
}

class Tiger extends Cat {
	public Tiger(String name) {
		super(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && (super.canEat(animal) || !(animal instanceof Tiger));
	}
}
/* 


class A {}
class B extends A {}
class C extends B {}
class D extends A {}


class ClassA {
	protected int number;

	public ClassA() {
		number = 10;
	}

	public void print() {
		System.out.println(getPrefix() + ": " + number);
	}
	
	protected String getPrefix() {
		return "A";
	}
}

class ClassB extends ClassA {
	protected int number = 20;
	
	protected String getPrefix() {
		return "B";
	}
}

class ClassC extends ClassB {
	public ClassC() {
		super();
	}
	
	protected String getPrefix(){
		return "C";
	}
}

/*
class A {
	private double attr;
	public A(double d) {
		attr = d;
	}
  }

class B extends A {
	private int c;
  	public B(int c, double d) {
	   super(d);	
	   this.c = c;
	}	
	public B() {
	   this(1, 2.0);	
	}
}
/* 
class Animal {
	private boolean alive = true;
	private String name;

	public void meet(Animal other) {
		if (canEat(other))
			other.eaten();
		else if (other.canEat(this))
			eaten();
	}

	public void eaten() {
		alive = false;
	}

	public boolean canEat(Animal other) {
		return false;
	}

	public boolean isAlive() {
		return alive;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
}

class Mouse extends Animal {
	public Mouse(String name) {
		setName(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive();
	}
}



class Cat extends Animal {
	public Cat(String name) {
		setName(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && animal instanceof Mouse;
	}
}

class Tiger extends Cat {
	public Tiger(String name) {
		super(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && (super.canEat(animal) || !(animal instanceof Tiger));
	}
}

/*
class Animal {
	private boolean alive = true;
	private String name;

	public void meet(Animal other) {
		if (canEat(other))
			other.eaten();
		else if (other.canEat(this))
			eaten();
	}

	public void eaten() {
		alive = false;
	}

	public boolean canEat(Animal other) {
		return false;
	}

	public boolean isAlive() {
		return alive;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
}

class Mouse extends Animal {
	public Mouse(String name) {
		setName(name);
	}
}

class Cat extends Animal {
	public Cat(String name) {
		setName(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && animal instanceof Mouse;
	}
}

class Tiger extends Cat {
	public Tiger(String name) {
		super(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && (super.canEat(animal) || !(animal instanceof Tiger));
	}
}
/* 
class A {}
class B extends A {}
class C extends B {}
class D extends A {}

/*
class ClassA {
	protected int number;

	public ClassA() {
		number = 20;
	}

	public void print() {
		System.out.println(getPrefix() + ": " + number);
	}
	
	protected String getPrefix() {
		return "A";
	}
}

class ClassB extends ClassA {
	protected int number = 10;
	
	protected String getPrefix() {
		return "B";
	}
}

class ClassC extends ClassB {
	public ClassC() {
		super();
	}
	
	protected String getPrefix(){
		return "C";
	}
}

/* 
class Animal {
	private boolean alive = true;
	private String name;

	public void meet(Animal other) {
		if (canEat(other))
			other.eaten();
		else if (other.canEat(this))
			eaten();
	}

	public void eaten() {
		alive = false;
	}

	public boolean canEat(Animal other) {
		return false;
	}

	public boolean isAlive() {
		return alive;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
}


class Mouse extends Animal {
	public Mouse(String name) {
		setName(name);
	}
}
class Cat extends Animal {
	public Cat(String name) {
		setName(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && animal instanceof Mouse;
	}
}


class Tiger extends Cat {
	public Tiger(String name) {
		super(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && (super.canEat(animal) || !(animal instanceof Tiger));
	}
}


/*
 

class Animal {
	private boolean alive = true;
	private String name;

	public void meet(Animal other) {
		if (canEat(other))
			other.eaten();
		else if (other.canEat(this))
			eaten();
	}

	public void eaten() {
		alive = false;
	}

	public boolean canEat(Animal other) {
		return false;
	}

	public boolean isAlive() {
		return alive;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
}

class Mouse extends Animal {
	public Mouse(String name) {
		setName(name);
	}
}

class Cat extends Animal {
	public Cat(String name) {
		setName(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && animal instanceof Mouse;
	}
}

class Tiger extends Cat {
	public Tiger(String name) {
		super(name);
	}

	public boolean canEat(Animal animal) {
		return isAlive() && (super.canEat(animal) || !(animal instanceof Tiger));
	}
}

/*
class ClassA {
	protected int number;

	public ClassA() {
		number = 20;
	}

	public void print() {
		System.out.println(getPrefix() + ": " + number);
	}
	
	protected String getPrefix() {
		return "A";
	}
}

class ClassB extends ClassA {
	protected int number = 10;
	
	protected String getPrefix() {
		return "B";
	}
}

class ClassC extends ClassB {
	public ClassC() {
		super();
	}
	
	protected String getPrefix(){
		return "C";
	}
}
*/
