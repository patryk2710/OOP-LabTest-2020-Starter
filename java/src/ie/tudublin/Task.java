package ie.tudublin;

import processing.data.TableRow;

public class Task {
    private String taskName;
    private int start;
    private int end;

    public Task(String taskName, int start, int end) {
        this.taskName = taskName;
        this.start = start;
        this.end = end;
    }

    public Task(TableRow tr) {
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Task [end=" + end + ", start=" + start + ", taskName=" + taskName + "]";
    }

}