package br.com.ftt;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LSystemPlant {
	ReadFile rf = new ReadFile("inputFile.txt");

	public static String startChar;
	private static List<Double> eixoX = new ArrayList<Double>();
	private static List<Double> eixoY = new ArrayList<Double>();
	private static double PI = Math.PI;
	public Map<Character, String> rules = new HashMap<Character, String>();
	public static double stickLength = 20;
	private static double translacaoEixoX = 0;
	private static double translacaoEixoY = 0;
	public static double angle;
	public static int end_X;
	public static int end_Y;
	public static int begin_X = 500;
	public static int begin_Y = 500;

	// variables: A B	
	//var angle;
	//var axiom = 'F';	
	//var sentence = axiom;
	//var len = 100;
	// axiom: A


	LSystemPlant(){
		rules.put('F', "F+X++X-F--FF-X+");
		rules.put('X', "-F+XX++X+F--F-X");
	}

	//F+[[X]-X]-F[-FX]+X

	public String generate(String startChar,Graphics g) {
		int j = rf.etapas;

		while (j>0) {

			//startChar=startChar.replaceAll("X", "F-[[X]+X]+F[+FX]-X");

			//startChar=startChar.replaceAll("F", "F[+F]F[-F][F]");

			startChar += rf.axioma;
			startChar=startChar.replaceAll(rf.axioma, rf.regraMod);			
			//startChar = rf.regraMod;

			System.out.println(startChar);
			draw(g, startChar);
			j--;

		}
		return startChar;
	}
	//F[+F]F[-F]F
	//F[+F]F[-F][F]
	//FF-[-F+F+F]+[+F-F-F]

	//F[+X]F[-X]+X
	//FF

	public class turtlePos {
		public int x;
		public int y;
		public double angle;
		public double length;

		turtlePos(int x, int y, double angle){
			this.x = x;
			this.y = y;
			this.angle = angle;
		}
	}
	Stack<turtlePos> obj = new Stack<>();

	public void draw(Graphics g, String stringToParse) {

		StringBuffer svg = new StringBuffer();
		svg.append("<?xml version=\"1.0\" standalone=\"no\"?> \n");
		svg.append("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\"> \n");


		translacaoEixoX = 300;
		translacaoEixoY = 300;


		this.angle = rf.angulo;
		g.setColor(Color.PINK);
		for (int i = 0;i<=stringToParse.length()-1;i++) {
			switch(stringToParse.charAt(i)) {			
			case 'F':
				end_X = begin_X+(int)(Math.cos(Math.toRadians(angle)*(Math.PI/2))*stickLength);
				end_Y = begin_Y-(int)(Math.sin(Math.toRadians(angle)*(Math.PI/2))*stickLength);
				g.drawLine(begin_X, begin_Y, end_X, end_Y);
				svg.append("\t  <line x1 = \""+ begin_X +"\" y1 = \""+ begin_Y +"\" x2 = \""+ end_X +"\" y2 = \""+ end_Y +"\" stroke = \"black\" stroke-width = \"1\"/> \n");
				begin_X = end_X;
				begin_Y = end_Y;
				translacaoEixoX = end_X;
				translacaoEixoY = end_Y;
				break;
			case 'G':
				end_X = (int)(-(Math.cos(Math.toRadians(angle)*(Math.PI/3))*stickLength))+begin_X;
				end_Y = begin_Y-(int)(-(Math.sin(Math.toRadians(angle)*(Math.PI/3))*stickLength)+ begin_Y);
				g.drawLine(begin_X, begin_Y, end_X, end_Y);
				svg.append("\t  <line x1 = \""+ begin_X +"\" y1 = \""+ begin_Y +"\" x2 = \""+ end_X +"\" y2 = \""+ end_Y +"\" stroke = \"black\" stroke-width = \"1\"/> \n");
				begin_X = end_X;
				begin_Y = end_Y;				
				break;
			case '-': 
				angle = angle-25;
				break;
			case '+': 
				angle = angle+25;
				break;
			case '[': 
				obj.push(new turtlePos(begin_X, begin_Y, angle));
				break;
			case ']': 
				angle = obj.lastElement().angle;
				begin_X = obj.lastElement().x;
				begin_Y = obj.lastElement().y;
				obj.pop();
				break;
			default:
				break;
			}

		}
		svg.append("<\\svg> \n");
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());

		String data = "Data Teste";
		FileOutputStream out;
		try 
		{
			out = new FileOutputStream("FractalGerado@" + timeStamp + ".svg");
			out.write(svg.toString().getBytes());
			out.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public static void push() 
	{
		eixoX.add(translacaoEixoX);
		eixoY.add(translacaoEixoY);
	}

	public static void pop()
	{
		translacaoEixoX = eixoX.remove(eixoX.size()-1);
		translacaoEixoY = eixoY.remove(eixoY.size()-1);
	}
}