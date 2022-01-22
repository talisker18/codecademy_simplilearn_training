package AAJ_design_patterns.builder_pattern.nonstatic_builder_demo;

public class TaskBuilder {

    private final long id;
    private String summary = "";
    private String description = "";
    private boolean done = false;

    public TaskBuilder(long id) { //same as with static Builder: return TaskBuilder instance, keeping set id on this instance
        this.id = id;
    }


    public TaskBuilder setSummary(String summary) { //return TaskBuilder instance, keeping set summary an all other params that were already set in the chain
        this.summary = summary;
        return this;
    }

    public TaskBuilder setDescription(String description) { //...
        this.description = description;
        return this;
    }

    public TaskBuilder setDone(boolean done) { //...
        this.done = done;
        return this;
    }
    
    public Task build() {
        return new Task(this.id,this.summary, this.description,this.done);
    }
}
