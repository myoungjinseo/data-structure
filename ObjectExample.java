class Person {
	String name;
	int money;
	
	public Person(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public void takeBus(Bus bus) {
		bus.addPerson();
		this.money -= bus.getCost();
	}
	
	public void untakeBus(Bus bus) {
		bus.subtractPerson();		
	}
	
	public void printMoney() {
		System.out.println(name + " has " + this.money);
	}
}

class Bus {
	int id;
	int cost;
	int money;
	int passengerCount;
	int seat =30;		//������ ������ ���� ��κ��� ������ �ڸ� ���� ���Ƽ� ���Ͻ� �Ͽ���, 30�̶�� �����Ͽ����ϴ�. 

	
	public Bus(int id, int cost) {
		this.id = id;
		this.cost = cost;
	}
	
	public void addPerson() {
		this.money += cost;
		passengerCount++;
	}
	
	public void subtractPerson() {
		passengerCount--;
	}
	
	public int getCost() {
		return this.cost;
	}
	

	public void remainingSeat() {		// ���� �ڸ����� ��Ÿ��
		this.seat -= passengerCount;
	}
	
	public void printSeat() {			// ���� �ڸ��� ���� �ڸ� ��Ȱ���� ������
		if(this.seat >7) {		
			System.out.println("��Ȱ");		
		} else if(this.seat > 1) {
			System.out.println("����");
		}  else if(this.seat == 0) {
			System.out.println("����");
		}
	}

	public void printMoney() {
		System.out.println(id + " bus has " + this.money);
	}
	
	public void printPassengerCount() {
		System.out.println(this.passengerCount + " passengers are in this bus");
	}
	
}

class ObjectExample {
	public static void main(String[] args) {
		Person personA = new Person("David", 10000);
		Person personB = new Person("Louis", 3500);
		
		Bus busA = new Bus(9500, 1100);
		
		personA.takeBus(busA);
		personB.takeBus(busA);
		
		personA.printMoney();
		personB.printMoney();
		busA.printMoney();
		busA.printPassengerCount();
		
		personA.untakeBus(busA);
		busA.printPassengerCount();

		busA.remainingSeat();
		busA.printSeat();
		
		
	}
}



