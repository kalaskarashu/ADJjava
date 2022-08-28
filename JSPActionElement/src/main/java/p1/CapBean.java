package p1;

import java.io.Serializable;

public class CapBean implements Serializable {
     	protected String word;
     	public CapBean()
     	{
     		
     	}
		public String getWord() {
			return word;
		}
		public void setWord(String word) {
			this.word = word;
		}
     	public String getCap()
     	{
     		return this.word.toUpperCase();
     	}
     	public String getLow()
     	{
     		return this.word.toLowerCase();
     	}

}
