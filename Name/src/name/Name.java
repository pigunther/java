/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.first);
        hash = 23 * hash + Objects.hashCode(this.last);
        return hash;
    }

	public static void main(String[] args) {
		java.util.Set s = new java.util.HashSet();
		s.add(new Name("Brad", "Pitt"));
                boolean ans = s.contains(new Name("Brad", "Pitt"));
                System.out.println(ans);
	}
}
