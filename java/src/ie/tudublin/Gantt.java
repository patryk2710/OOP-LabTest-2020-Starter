package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet {	
	
	ArrayList<Task> tasks = new ArrayList<Task>();

	float border;
	float leftBorder;
	float xGap;

	public void settings() {
		size(800, 600);

		border = width * 0.05f;
		leftBorder = width * 0.18f;

		xGap = (width - (leftBorder + border)) / 30f;
	}

	public void loadTasks() {
		Table table = loadTable("tasks.csv", "header");
		for(TableRow row:table.rows()) {
			Task t = new Task(row);
			tasks.add(t);
		}
	}

	public void printTasks() {
		for(Task t:tasks) {
			System.out.println(t);
		}
	}

	public void mousePressed() {
		println("Mouse pressed");
	}

	public void mouseDragged() {
		println("Mouse dragged");
	}

	void displayTasks() {
		float x = leftBorder;
		stroke(255);
		for(int i = 1; i < 31; i ++) {
			line(x, border, x, height - border);
			text(i, x - 4, border - 10);
			x += xGap;
		}
	}
	
	public void setup() {
		loadTasks();
		printTasks();
		colorMode(HSB);
	}
	
	public void draw() {			
		background(0);
		displayTasks();
	}
}
