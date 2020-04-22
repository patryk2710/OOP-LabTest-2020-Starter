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
	float yGap;

	public void settings() {
		size(800, 600);

		border = width * 0.05f;
		leftBorder = width * 0.18f;

		xGap = (width - (leftBorder + border)) / 30f;
		yGap = height * 0.06f;
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
		//variables required
		float x = leftBorder;
		float y = border + 20;

		//Drawing grid
		stroke(255);
		for(int i = 1; i < 31; i ++) {
			line(x, border, x, height - border);
			fill(255);
			text(i, x - 4, border - 10);
			x += xGap;
		}
		
		//Drawing rectangles
		noStroke();
		for(int i = 0; i < tasks.size(); i++) {
			Task t = tasks.get(i);

			float colour = map(i, 0, tasks.size(), 0, 255);
			float startx = map(t.getStart(),1,31,leftBorder, width - border);
			float endx = map(t.getEnd(),1,31,leftBorder, width - border);
			float w = endx - startx;
			fill(colour, 255, 255);
			rect(startx, y, w, yGap, 5);
			fill(255);
			text(t.getTaskName(), border, y + (yGap / 2));
			y += yGap + 5;
		}
	}
	
	public void setup() {
		loadTasks();
		printTasks();
		colorMode(HSB, 255, 255, 255);
	}
	
	public void draw() {			
		background(0);
		displayTasks();
	}
}
