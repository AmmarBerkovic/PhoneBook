package bildIt.DTO;

public class Contact {
	private int prim;
	private int fore;

	public Contact(int prim, int fore) {
		this.fore = fore;
		this.prim = prim;

	}

	public int getPrim() {
		return prim;
	}

	public void setPrim(int prim) {
		this.prim = prim;
	}

	public int getFore() {
		return fore;
	}

	public void setFore(int fore) {
		this.fore = fore;
	}

}
