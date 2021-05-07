package br.net.heaven.lavi.morphology.core;

import br.net.heaven.lavi.morphology.enums.HarmonyEnum;

public class Term {
	
	private String term;
	private HarmonyEnum harmony;
	private boolean vocalic;
	
	private void defineHarmony() {
		for (int pos = this.term.length()-1; pos >= 0; pos--) {
			switch (this.term.charAt(pos)) {
				case 'a':
				case 'o':
				case 'u':
					this.harmony = HarmonyEnum.BACK;
					return;
				case 'e':
				case 'ö':
				case 'ü':
					this.harmony = HarmonyEnum.FRONT;
					return;
			}
		}
	}
	
	private void defineVocalicy() {
		this.vocalic = this.endsWith("a","i","u","e","o","ü","ö");
	}
	
	public Term(String term) {
		this.term = term;
		this.defineHarmony();
		this.defineVocalicy();
	}

	public boolean endsWith(String suffix) {
		return this.term.endsWith(suffix);
	}

	public boolean endsWith(String...suffixes) {
		for (String suffix : suffixes) {
			if (this.term.endsWith(suffix)) {
				return true;
			}
		}
		return false;
	}
	
	public String get() {
		return "" + this.term;
	}
	
	public void appendSuffix(String suffix) {
		this.term += suffix;
		this.defineVocalicy();
	}
	
	public boolean isVocalic() {
		return this.vocalic;
	}
	
	public HarmonyEnum getHarmony() {
		return this.harmony;
	}
	
	@Override
	public Term clone() {
		return new Term(this.get());
	}
	
	@Override
	public String toString() {
		return this.get();
	}
	
	public boolean equals(Term term) {
		return this.get().equals(term.get());
	}

}
