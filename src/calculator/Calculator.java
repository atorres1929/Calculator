/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Adam
 */
public class Calculator extends JFrame{
    
    public final int FRAME_HEIGHT = 300;
    public final int FRAME_WIDTH = 300;
    public final Dimension prefferedSize = new Dimension(FRAME_HEIGHT,FRAME_WIDTH);
    private JTextField text;
    private JTextField answerField;
<<<<<<< HEAD
    private String defaultText = "2^2^2";
=======
    private String defaultText = "-2-2";
>>>>>>> 9b8e4feae5ecb38bec146a6ac3a6117dfe13a4c1
    ArrayList<JButton> numbers;
    JButton bPoint,bEnter,bMult,bDiv,bSub,bAdd,bBack,bC,bCE;
    
    public Calculator(){
        init();
        addButtonFunction();
    }
    private boolean isNumber(String param){
        try{
            Double.valueOf(param);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    private String calculate(String param){
<<<<<<< HEAD
=======
        System.out.println(param);
        System.out.println(isNumber(param) + " || " + (numOperands(param) == 1));
>>>>>>> 9b8e4feae5ecb38bec146a6ac3a6117dfe13a4c1
        if (isNumber(param) || (isNumber(param) && numOperands(param) == 1)){
            return param;
        }
        else if (param.contains("^")){
            return parseModule(param, "^");
        }
        else if (param.contains("(")){
            int previous = param.indexOf("(");
            int end = param.indexOf(")");
            String part = calculate(param.substring(previous+1, end));
            return calculate(param.substring(0,previous) + part + param.substring((end+1), param.length()));
        }
        else if (param.contains("*"))
            return parseModule(param, "*");
        else if (param.contains("/"))
            return parseModule(param, "/");
        else if (param.contains("+"))
            return parseModule(param, "+");
        else if (param.contains("-"))
            return parseModule(param, "-");
        
        return "Error while calculating";
    }
    /*Parses a given parameter with the given operation in minnd.
    A module is defined as two numbers seperated by an operator
    Ex: 5+7 or 5*2 or 3-1 or 3/2
    This methods returns a String representation of the given module once it has been carried out
    Ex: parseModule("5+7-18*2/4*2/2", "*") returns 
    
    */
    private String parseModule(String module, String operator) {
        BigDecimal ans = BigDecimal.ZERO;
        try{
            System.out.println("Module to parse: "+module);
            System.out.println("Operator used: "+operator);
            
            int index;
            if ("^".equals(operator)){
                index = module.indexOf(operator, module.lastIndexOf(operator));
            }
            else{
                index = module.indexOf(operator);
            }
            
            if (index == 0)
                index = module.substring(1).indexOf(operator);
<<<<<<< HEAD
            int previous = getIndexOfPreviousOperator(module.substring(0, index));
            int next = getIndexOfNextOperator(module.substring(index+1));
            BigDecimal part1,part2;

            if(module.startsWith("-")){
                part1 = new BigDecimal(module.substring(previous, index+1));
            }
            else if (operator.equals("^")){
                part1 = new BigDecimal(module.substring(previous+1, module.lastIndexOf(operator)));
            }
            else{
                part1 = new BigDecimal(module.substring(previous+1, index));
            }
            System.out.print("part1: "+part1);
            if (operator == "^")
                part2 = new BigDecimal(module.substring(index+1, module.length()));
            else if (next == -1)
                part2 = new BigDecimal(module.substring((index+1),module.length()));
            else
                part2 = new BigDecimal(module.substring(index+1, index+next+1));

            System.out.println(" || part2: "+part2);


            switch(operator){
                case "^":
                    ans = part1.pow(part2.intValue());
                    break;
                case "*":
                    ans = part1.multiply(part2);
                    break;
                case "/":
                    ans = part1.divide(part2);
                    break;
                case "+":
                    ans = part1.add(part2);
                    break;
                case "-":
                    if (module.startsWith("-"))
                        ans = part1.add(part2);
                    else
                        ans = part1.subtract(part2);
                    break;
                default:
                    ans = new BigDecimal(0);
            }
            
            System.out.println("Answer: "+ans);
            if (next == -1 && (previous == -1 || ans.toString().startsWith("-")))
                return calculate(String.valueOf(ans));
            else if (next == -1 && previous != -1)
                return calculate(module.substring(0, previous+1)+String.valueOf(ans));
            else if (next != -1 && previous == -1)
                return calculate(String.valueOf(ans)+module.substring(index+next+1));
            else if (next != -1 && previous != -1)
                return calculate(module.substring(0, previous+1)+String.valueOf(ans)+module.substring(index+next+1));

            System.out.println("Error when parsing module: "+module);
        }catch(Exception e){
            e.printStackTrace();
        }
=======
        int previous = getIndexOfPreviousOperator(module.substring(0, index));
        int next = getIndexOfNextOperator(module.substring(index+1));
        
//        try{
            if(module.startsWith("-")){
                part1 = new BigDecimal(module.substring(previous, index+1));
            }else{
                part1 = new BigDecimal(module.substring(previous+1, index));
            }
//        }catch(Exception e){
//            return module;
//        }finally{
//            part1 = new BigDecimal(0);
//        }
        
        if (numOperators(module) == 2 && previous == '-')
            part2 = new BigDecimal('-'+module.substring(index+2));
        else if (next == -1)
            part2 = new BigDecimal(module.substring((index+1),module.length()));
        else
            part2 = new BigDecimal(module.substring(index+1, index+next+1));
        
        System.out.println("part1: "+part1+" || part2: "+part2);
        BigDecimal ans;
        switch(operator){
            case "*":
                ans = part1.multiply(part2);
                break;
            case "/":
                ans = part1.divide(part2);
                break;
            case "+":
                ans = part1.add(part2);
                break;
            case "-":
                if (module.startsWith("-"))
                    ans = part1.add(part2);
                else
                    ans = part1.subtract(part2);
                break;
            default:
                ans = new BigDecimal(0);
        }
        System.out.println("Answer: "+ans);
        if (next == -1 && (previous == -1 || ans.toString().startsWith("-")))
            return calculate(String.valueOf(ans));
        else if (next == -1 && previous != -1)
            return calculate(module.substring(0, previous+1)+String.valueOf(ans));
        else if (next != -1 && previous == -1)
            return calculate(String.valueOf(ans)+module.substring(index+next+1));
        else if (next != -1 && previous != -1)
            return calculate(module.substring(0, previous+1)+String.valueOf(ans)+module.substring(index+next+1));
        
        System.out.println("Error when parsing module: "+module);
>>>>>>> 9b8e4feae5ecb38bec146a6ac3a6117dfe13a4c1
        return "Error";
    }
    /*Gets the index of the first operator in the specified string.
        If there is no operator in the string, it returns -1;
    */
    private int getIndexOfPreviousOperator(String param){
        for (int i = param.length()-1; i >= 0; i--){
            if (param.charAt(i) == '/' || param.charAt(i) == '*' || param.charAt(i) == '-' || param.charAt(i) == '+' || param.charAt(i) == '^'){
//                System.out.println("IndexOfPreviousOperator: " + i);
                return i;
            }    
        }
        return -1;
    }
    /*Gets the index of the next operator in the specified string. 
        If there is no operator, it returns -1.
    */
    private int getIndexOfNextOperator(String param){
        for (int i = 1; i < param.length(); i++){
            if (param.charAt(i) == '/' || param.charAt(i) == '*' || param.charAt(i) == '-' || param.charAt(i) == '+'){
//                System.out.println("IndexOfNextOperator: " + i);
                return i;
            }
        }
        return -1;
    }
    
    //Gets number of operators for special cases
    private int numOperands(String module){
        int numOperands = 0;
        for(int i = 0; i < module.length(); i++){
            if (module.charAt(i) == '+' || module.charAt(i) == '-' || module.charAt(i) == '/' || module.charAt(i) == '*')
                numOperands++;
        }
        return numOperands;
    }
    private int numOperators(String module){
        int numOps = 0;
        for (int i = 0; i < module.length(); i++){
            if (!isNumber((Character.toString(module.charAt(i)))))
                numOps++;
        }
        return numOps;
    }

    private void addButtonFunction(){
        bPoint.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText(".");
            }
        });
        numbers.get(0).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText("0");
            }
            
        });
        numbers.get(1).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText("1");
            }
            
        });
        numbers.get(2).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText("2");
            }
            
        });
        numbers.get(3).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText("3");
            }
            
        });
        numbers.get(4).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText("4");
            }
            
        });
        numbers.get(5).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText("5");
            }
            
        });
        numbers.get(6).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText("6");
            }
            
        });
        numbers.get(7).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText("7");
            }
            
        });
        numbers.get(8).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText("8");
            }
            
        });
        numbers.get(9).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addText("9");
            }
            
        });
        bMult.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                addText("*");
            }
            
        });
        bAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                addText("+");
            }
            
        });
        bSub.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                addText("-");
            }
            
        });
        bDiv.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                addText("/");
            }
            
        });
        
        bBack.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(text.getText().substring(0,text.getText().length()-1));
            }
            
        });
        
        bEnter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText(calculate(text.getText()));
            }
            
        });
    }
    private void addText(String t) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                text.setText(text.getText()+t);
            }
            
        });
    }
    
    private void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(prefferedSize);
        setSize(prefferedSize);
        setLocationRelativeTo(null);
        setTitle("Calculator");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        String[] menuNames = {"Mode", "Tools"};
        JMenuBar menuBar = new JMenuBar();
        
        ArrayList<JMenu> menus = new ArrayList<>();
        for (int i = 0; i < menuNames.length; i++){
            JMenu jmenu;
            menus.add(new JMenu(menuNames[i]));
            menuBar.add(menus.get(i));
        }
        menuBar.setEnabled(true);
        menuBar.setVisible(true);
        
        setJMenuBar(menuBar);
        
        text = new JTextField("");
        text.setText(defaultText);
        text.setFont(new Font("Arial", Font.PLAIN, 40));
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        add(text, c);
        
        numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            numbers.add(new JButton(String.valueOf(i)));
        }
        
        bPoint = new JButton(".");
        bEnter = new JButton("=");
        bMult = new JButton("X");
        bDiv = new JButton("/");
        bAdd = new JButton("+");
        bSub = new JButton("-");
        bBack = new JButton("Del");
        bC = new JButton("C");
        bCE = new JButton("CE");
        
        JPanel buttons1 = new JPanel(new GridLayout(4,4));
        
        buttons1.add(bCE);
        buttons1.add(bC);
        buttons1.add(bBack);
        buttons1.add(bDiv);
        buttons1.add(numbers.get(9));
        buttons1.add(numbers.get(8));
        buttons1.add(numbers.get(7));
        buttons1.add(bMult);
        buttons1.add(numbers.get(6));
        buttons1.add(numbers.get(5));
        buttons1.add(numbers.get(4));
        buttons1.add(bAdd);
        buttons1.add(numbers.get(3));
        buttons1.add(numbers.get(2));
        buttons1.add(numbers.get(1));
        buttons1.add(bSub);
        
        c.gridy = 2;
        c.weighty = 8;
        add(buttons1,c);
        JPanel buttons2 = new JPanel(new GridLayout(0,2));
        buttons2.add(numbers.get(0));
        JPanel buttons3 = new JPanel(new GridLayout(0,2));
        buttons3.add(bPoint);
        buttons3.add(bEnter);
        buttons2.add(buttons3);
        
        c.gridy = 3;
        c.weighty = 2;
        add(buttons2,c);
        
        JPanel answer = new JPanel(new GridLayout(0,1));
        answerField = new JTextField("");
        answerField.setFont(new Font("Arial", Font.BOLD, 40));
        answer.add(answerField);
        c.gridy = 4;
        c.weighty = 8;
        
        add(answer, c);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new Calculator();
    }
    
}
