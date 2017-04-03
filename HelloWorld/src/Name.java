public class Name {
	private String first, last;

	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

    @Override
	public boolean equals(Object o) {
		if (!(o instanceof Name)) 
			return false;
		Name n = (Name) o;
		System.out.println(n.first+" "+n.last+" "+first+" "+last+"\n");
		return n.first.equals(first) && n.last.equals(last);
	}

	public static void main(String[] args) {
		java.util.Set s = new java.util.HashSet();
		Name brad = new Name("Brad", "Pitt");
		s.add(brad);
		System.out.println(s.contains(new Name("Brad", "Pitt")));
	}
}
