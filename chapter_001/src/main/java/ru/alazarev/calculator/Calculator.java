package ru.alazarev.calculator;

/**
 *Class Calculator решение задачи части 001. Урок 3.1. Элементарный калькулятор. [#185].
 *@author Aleksey Lazarev
 *@since 09.11.2018
 */

public class Calculator {
	private double result;
	/**
	 * Method add .
	 * @param first First number for add.
	 * @param second Second number for add.
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	 * Method substract .
	 * @param first First number for substract.
	 * @param second Second number for substract.
	 */
	public void substract(double first, double second) {
		this.result = first - second;
	}
	/**
	 * Method divide.
	 * @param first First number for divide.
	 * @param second Second number for divide.
	 */
	public void divide(double first, double second) {
		this.result = first / second;
	}
	/**
	 * Method multiple .
	 * @param first First number for multiple.
	 * @param second Second number for multiple.
	 */
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	/**
	 * Method get result.
	 * @return result of previous operation
	 */
	public double getResult() {
		return this.result;
	}
	/**
	 * Main, output string to console.
	 * @param args - args.
	 */
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

}