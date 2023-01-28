package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
	
	@FXML private Label Entry;
	@FXML private Label outcome;
	
	@FXML
	public void KeyBoard(KeyEvent e) throws Exception{
		KeyCode input = e.getCode();
		
		if(input == KeyCode.DIGIT0) 
			Entry.setText(Entry.getText()+"0");
		if(input == KeyCode.DIGIT1)
			Entry.setText(Entry.getText()+"1");
		if(input == KeyCode.DIGIT2)
			Entry.setText(Entry.getText()+"2");
		if(input == KeyCode.DIGIT3)
			Entry.setText(Entry.getText()+"3");
		if(input == KeyCode.DIGIT4)
			Entry.setText(Entry.getText()+"4");
		if(input == KeyCode.DIGIT5)
			Entry.setText(Entry.getText()+"5");
		if(input == KeyCode.DIGIT6)
			Entry.setText(Entry.getText()+"6");
		if(input == KeyCode.DIGIT7)
			Entry.setText(Entry.getText()+"7");
		if(input == KeyCode.DIGIT8) {
			if(e.isShiftDown()) {
				Entry.setText(Entry.getText()+"*");
			}else
				Entry.setText(Entry.getText()+"8");
		}
		if(input == KeyCode.DIGIT9)
			Entry.setText(Entry.getText()+"9");
		if(input == KeyCode.PERIOD)
			Entry.setText(Entry.getText()+".");
		if(input == KeyCode.EQUALS) {
			if(e.isShiftDown()) {
				Entry.setText(Entry.getText()+"+");
			}else
				Equal();
		}	
		if(input == KeyCode.MINUS)
			Entry.setText(Entry.getText()+"-");
		if(input == KeyCode.SLASH)
			Entry.setText(Entry.getText()+"/");
		
		if(input == KeyCode.A) {
			AC();
		}if(input == KeyCode.C) {
			CE();
		}if(input == KeyCode.ENTER) {
			Equal();
		}if(input == KeyCode.BACK_SPACE) {
			back();
		}
		
	}
	
	@FXML
	public void Numbers(ActionEvent e) {
		String value = ((Button)e.getSource()).getText();
		Entry.setText(Entry.getText()+value);
	}
	
	public void Operators(ActionEvent e) {
		String value = ((Button)e.getSource()).getText();
		Entry.setText(Entry.getText()+value);
	}
	
	public void Equal() {
		String s = Entry.getText();
		String ans = calculator(s);
		outcome.setText(ans);
	}
	
	public void AC() {
		String s = "";
		Entry.setText(s);
		outcome.setText(s);
	}
	
	public void CE() {
		String out = "";
		String s = Entry.getText();
		
		for(int i = s.length()-1; i>=0; i--) {
			if((s.charAt(i)=='+' || s.charAt(i)=='-')||(s.charAt(i)=='*' || s.charAt(i)=='/')) {
				
				for(int j = 0; j<=i; j++) {
					out+=s.charAt(j);
				}
				
				Entry.setText(out);
				break;
			}
		}
	}
	
	public void back() {
		String out = "";
		String s = Entry.getText();
		
		for(int j = 0; j <s.length()-1; j++) {
			out += s.charAt(j);
		}
		Entry.setText(out);
		
	}
	
	
	
	private  String calculator(String string) {
		String[] split = string.split("(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])");
		
		int length = split.length;
		boolean error = false;
		String ans="";
		
		for(int i = 0; i < length; i++) {
			if(split[i].equals("*")) {
				float num = Float.parseFloat(split[i-1])*Float.parseFloat(split[i+1]);
				split[i-1] = Float.toString(num);
				
				for(int j = i; j < split.length-2; j++) {
					split[j] = split[j+2];
				}
				split[length-1]=null;
				split[length-2]=null;
				length-=2;
				i = 0;
			}
			else if(split[i].equals("/")) {
				if(split[i+1].equals("0")) {
					error = true;
					break;
				}
				float num = Float.parseFloat(split[i-1])/Float.parseFloat(split[i+1]);
				split[i-1] = Float.toString(num);
				
				for(int j = i; j < split.length-2; j++) {
					split[j] = split[j+2];
				}
				split[length-1]=null;
				split[length-2]=null;
				length-=2;
				i = 0;
			}
		}for(int i = 0; i < length; i++) {
			if(split[i].equals("+")) {
				float num = Float.parseFloat(split[i-1])+Float.parseFloat(split[i+1]);
				split[i-1] = Float.toString(num);
				
				for(int j = i; j < split.length-2; j++) {
					split[j] = split[j+2];
				}
				split[length-1]=null;
				split[length-2]=null;
				length-=2;
				i = 0;
			}
			else if(split[i].equals("-")) {
				float num = Float.parseFloat(split[i-1])-Float.parseFloat(split[i+1]);
				split[i-1] = Float.toString(num);
				
				for(int j = i; j < split.length-2; j++) {
					split[j] = split[j+2];
				}
				split[length-1]=null;
				split[length-2]=null;
				length-=2;
				i = 0;
			}
		}
		
		if(error ==true) {
			ans = "Error";
		}else {
			float ans1 = Float.parseFloat(split[0]);
			float ans2 = (float) (Math.round(ans1*10.0)/10.0);
			ans = Float.toString(ans2);
		}
		
		return ans;
	}

}
