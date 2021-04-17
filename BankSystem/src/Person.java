
public abstract class Person {
	private static int counter = 0;
	protected int id;
	protected String name;
	protected double age;

	public Person() {
		this.id = ++counter;
		this.name = BenziUtils.generateName();
		this.age = BenziUtils.randIntBetween(16, 120);

	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Person.counter = counter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
