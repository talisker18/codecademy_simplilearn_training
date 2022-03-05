package AAU_ioc.di_demo;

/*
 * DI manually, without any framework (pure java)
 * 
 * */

public class DependencyInjection {
	
	static class Dependency{
		String doWork() {
			return "work was done";
		}
	}
	
	static class Injected{
		private Dependency dependency;
		
		public Injected(Dependency dependency) {
			this.dependency = dependency;
		}
		
		void delegate() {
			System.out.println(this.dependency.doWork());
		}
	}
	
	public static void main(String[] args) {
		Injected injected = new Injected(new Dependency());
		injected.delegate();
	}

}
