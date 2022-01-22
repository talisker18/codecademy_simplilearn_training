package AAJ_design_patterns.builder_pattern.nonstatic_builder_demo;

public class RunApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Task task = new TaskBuilder(5).setDescription("Hello").setSummary("Test").build();
        System.out.println(task);

	}

}
