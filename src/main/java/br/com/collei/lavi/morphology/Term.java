package br.com.collei.lavi.morphology;

import br.com.collei.lavi.morphology.enums.EnumHarmony;
import br.com.collei.lavi.morphology.enums.EnumPartsOfSpeech;

/**
 * <p>Holds the basic attributes of any word in the Lavi language.</p>
 * 
 * @author sjunio
 *
 */
public class Term {
	
	/**
	 * <p>Fix 'bad class file' issues</p>
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 98274998904169L;
	
	/**
	 * <p>The String representation of the Term.</p>
	 */
	private String term;
	
	/**
	 * <p>The part of speech the term belongs to.</p>
	 */
	private EnumPartsOfSpeech partOfSpeech;
	
	/**
	 * <p>The harmony attribute of the term.</p>
	 */
	private EnumHarmony harmony;
	
	/**
	 * <p>Indicates the term vocalicy, e.g., whether it ends with a vowel or not.</p>
	 */
	private boolean vocalic;
	
	/**
	 * <p>Performs harmony detection based upon the internal String representation.</p>
	 */
	private void defineHarmony() {
		for (int pos = this.term.length()-1; pos >= 0; pos--) {
			String ch = "" + this.term.charAt(pos);
			switch (ch) {
				case "a":
				case "o":
				case "u":
					this.harmony = EnumHarmony.BACK;
					return;
				case "e":
				case "ö":
				case "ü":
					this.harmony = EnumHarmony.FRONT;
					return;
			}
		}
	}
	
	/**
	 * <p>Performs vocalicy detection upon the internal String representation.</p>
	 */
	private void defineVocalicy() {
		this.vocalic = this.endsWith("a","i","u","e","o","ü","ö");
	}
	
	/**
	 * <p>Creates a new instance of a term with an UNDEFINED part of speech.</p>
	 * @param term the String representation and detects their inner attributes
	 */
	public Term(String term) {
		this.term = term;
		this.defineHarmony();
		this.defineVocalicy();
		this.partOfSpeech = EnumPartsOfSpeech.UNDEFINED;
	}
	
	/**
	 * <p>Creates a new instance of a term and sets its part of speech.</p>
	 * @param term The String representation of this term
	 * @param partOfSpeech the part of speech the term belongs to
	 */
	public Term(String term, EnumPartsOfSpeech partOfSpeech) {
		this(term);
		this.partOfSpeech = partOfSpeech;
	}

	/**
	 * <p>Checks whether a term ends with a given String suffix.</p>
	 * @param suffix the suffix to test with
	 * @return true if it ends with the given suffix, false otherwise
	 */
	public boolean endsWith(String suffix) {
		return this.term.endsWith(suffix);
	}

	/**
	 * <p>Checks whether a term ends with one of the listed suffixes.</p>
	 * @param suffixes A list of suffixes to be tested against
	 * @return true if the term ends with one of the suffixes, false otherwise
	 */
	public boolean endsWith(String...suffixes) {
		for (String suffix : suffixes) {
			if (this.term.endsWith(suffix)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <p>Returns the String representation of the term.</p>
	 * @return the String representation of it
	 */
	public String get() {
		return "" + this.term;
	}
	
	/**
	 * <p>Gets the part of speech value of the term.</p>
	 * @return The part of speech to which the term belongs
	 */
	public EnumPartsOfSpeech getPartOfSpeech() {
		return this.partOfSpeech;
	}
	
	/**
	 * <p>Attaches the given suffix to the term and redefines vocalicy.</p>
	 * @param suffix The suffix to be attached to the end
	 */
	public void appendSuffix(String suffix) {
		this.term += suffix;
		this.defineVocalicy();
	}
	
	/**
	 * <p>Returns whether the term ends with a vowel or not.</p>
	 * @return true if the term ends with a vowel, false otherwise
	 */
	public boolean isVocalic() {
		return this.vocalic;
	}
	
	/**
	 * <p>Returns the harmony type of the term.</p>
	 * @return The harmony type of the term
	 */
	public EnumHarmony getHarmony() {
		return this.harmony;
	}
	
	/**
	 * <p>Clone the term.</p>
	 * @return a copy of the term
	 */
	@Override
	public Term clone() {
		return new Term(this.get());
	}
	
	/**
	 * <p>Returns its internal representation.</p>
	 * @return the internal representation
	 */
	@Override
	public String toString() {
		return this.get();
	}
	
	/**
	 * <p>Check for equality with another Term.</p>
	 * @param term The term to be checked against
	 * @return true if they have the same internal representation, false otherwise
	 */
	public boolean equals(Term term) {
		return this.get().equals(term.get());
	}

}
