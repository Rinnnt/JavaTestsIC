package videogame;

public class GameReport {

	public static void main(String[] args) {

		// TODO: complete this method as part of Section A Question 5
		TransportUnit t1 = new TransportUnit("Falkor", 2500);
		TransportUnit t2 = new TransportUnit("Shadowfax", 350);
		Magician m1 = new Magician("Ged", 300);
		Magician m2 = new Magician("Dumbledore", 200);
		Magician m3 = new Magician("Saruman", 600);
		Magician m4 = new Magician("Harry", 18);
		Magician m5 = new Magician("Gandalf", 950);
		Magician m6 = new Magician("Gargamel", 200);

		t2.add(m4);
		t2.add(m5);

		t1.add(m1);
		t1.add(m2);
		t1.add(m3);
		t1.add(t2);

		System.out.println(t1);
		t1.applySpell(m6);
		System.out.println(t1);

		Magician m7 = new Magician("Houdini", t1.minimumStrikeToDestroy() / 2);
		t1.applySpell(m7);
		System.out.println(t1);

		assert !t1.isAlive();
		assert !t2.isAlive();
		assert !m1.isAlive();
		assert !m2.isAlive();
		assert !m3.isAlive();
		assert !m4.isAlive();
		assert !m5.isAlive();
		assert m6.isAlive();
		assert m7.isAlive();
	}

}
