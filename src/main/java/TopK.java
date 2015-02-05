/**
 * @author A0108165J
 *
 */

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopK {

  private ArrayList<Integer> _salaries = null;
  private Integer _m = 0, _k = 0;

  public TopK() {
  }

  /**
   * Configures and sets up TopK instance.
   * @param m the population of random numbers to generate
   * @param k the top highest salaries to retrieve
   */
  public void configure(Integer m, Integer k) {
    this._m = m;
    this._k = k;
    _salaries = generateSalaries();
  }

  /**
   * Gets tops k salaries, in descending order.
   * @return An ArrayList of salaries in descending order.
   */
  public ArrayList<Integer> getTopSalaries() {
    // has to be generated at every call since there is no clone function.
    PriorityQueue<Integer> salaryPriorityQueue = new PriorityQueue<Integer>(
        normalizeSalaries(_salaries));
    ArrayList<Integer> retVaList = new ArrayList<Integer>();
    Integer lowestSalariesNum = _k;

    for (Integer i = 0; i < lowestSalariesNum; i++) {
      retVaList.add(new Integer(salaryPriorityQueue.poll()));
    }

    return reverseList(normalizeSalaries(retVaList));
  }

  /**
   * Reverses a list
   * @param list the reference list to reverse
   * @return the reversed list
   */
  private ArrayList<Integer> reverseList(ArrayList<Integer> list) {
    ArrayList<Integer> output = new ArrayList<Integer>();
    for (int i = 0; i < list.size(); i++) {
      output.add(list.get(i));
    }
    return output;
  }

  /**
   * Generate m random salaries
   * @return Generate m random salaries
   */
  private ArrayList<Integer> generateSalaries() {
    ArrayList<Integer> salariesList = new ArrayList<Integer>();
    Random rndRandom = new Random(1237129872);
    for (Integer i = 0; i < _m; i++) {
      salariesList.add(rndRandom.nextInt(500000000));
    }
    return salariesList;
  }

  /**
   * Normslize salaries, such that existing functions can be used to retrieve top values.
   * @param input The list of salaries to normalize
   * @return The list of normalized salaries
   */
  private ArrayList<Integer> normalizeSalaries(ArrayList<Integer> input) {
    @SuppressWarnings("unchecked")
    ArrayList<Integer> temp = (ArrayList<Integer>) input.clone();
    for (Integer i = 0; i < temp.size(); i++) {
      temp.set(i, normalizeSalary(temp.get(i)));
    }
    return temp;
  }

  /**
   * denormslize salaries, such that existing functions can be used to retrieve top values.
   * @param input The list of salaries to denormalize
   * @return The list of denormalized salaries
   */
  private ArrayList<Integer> denormalizeSalaries(ArrayList<Integer> input) {
    @SuppressWarnings("unchecked")
    ArrayList<Integer> temp = (ArrayList<Integer>) input.clone();
    for (Integer i = 0; i < temp.size(); i++) {
      temp.set(i, denormalizeSalary(temp.get(i)));
    }
    return temp;
  }

  private Integer normalizeSalary(Integer in) {
    return 500000000 - in;
  }

  private Integer denormalizeSalary(Integer in) {
    return 500000000 - in;
  }

  public void printSalaries() {
    System.out.println("Total Salaries: " + _salaries.toString());
  }

  public ArrayList<Integer> get_salaries() {
    return _salaries;
  }

  public void set_salaries(ArrayList<Integer> _salaries) {
    this._salaries = _salaries;
  }
  
  
  static private Integer getUserInput(String prompt) {
    Scanner input = new Scanner(System.in);
    System.out.println(prompt);
    Integer result = input.nextInt();
    return result;
  }

  /**
   * Main function
   * @param args
   */
  public static void main(String[] args) {
    TopK topK = new TopK();
    Integer m = 0, k = 0;
    m = TopK.getUserInput("Please enter total number of salary earners m: ");
    k = TopK.getUserInput("Please enter number top salary owners k: ");
    if (m < k) {
      throw new Error("m < k.  Please try again.  System exiting.");
    }
    topK.configure(m, k);
    topK.printSalaries();
    System.out.println("TOP " + k.toString() + " SALARIES, DESCENDING ORDER: " + topK.getTopSalaries().toString());
  }

}