package AAB_inheritance_and_polymorphism.inheritance_example;

public class Language{
	  protected String name;
	  protected int numSpeakers;
	  protected String regionsSpoken;
	  protected String wordOrder;

	  public Language(String name, int numSpeakers, String regionsSpoken, String wordOrder){
	    this.name=name;
	    this.numSpeakers=numSpeakers;
	    this.regionsSpoken=regionsSpoken;
	    this.wordOrder=wordOrder;
	  }

	  public void getInfo(){
	    System.out.println(this.name+" is spoken by "+this.numSpeakers+" people mainly in "+this.regionsSpoken+".\nThe language follows the word order: "+this.wordOrder);
	  }

	  public static void main(String[] args){
	    Language lang1=new Language("Deutsch",150000,"several","noun before verb");
	    lang1.getInfo();
	    /*Language mayan = new Mayan("kiche",233000);
	    mayan.getInfo();*/

	    Language mayan2=new Mayan("kiche2",0,"none","no order");
	    mayan2.getInfo();
	    
	  }
}
