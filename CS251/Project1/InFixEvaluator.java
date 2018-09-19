import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Utkarsh on 8/30/18.
 * Revised by Geoerge Adams on 09/02/18.
 */


public class InFixEvaluator
{
    
    public double evaluator(String str) throws Exception
    {
        
        if(str == null||str.length()==0){
            throw new IllegalArgumentException();
        }
        char[] test = str.toCharArray();
        for(int o = 2;o<test.length;o++){
            
            if(test[o]=='-'){
                if(test[o+1]==' '){
                if(test[o-2]=='(' ||test[o-2]=='{'||test[o-2]=='['){
                    throw new IllegalArgumentException("Invalid expression");
                } else {
                    
                }
                }
            }
        }
        String repStr = str.replaceAll("\\s+", "");
        int helperbr1 = 0;
        int helperbr2 = 0;
        int helperbr3 = 0;
        int helperbr4 = 0;
        int helperbr5 = 0;
        int helperbr6 = 0;
        char[] check = repStr.toCharArray();
        if(check[0] =='(' || check[0] == '{' || check[0] == '['){
            
            
            for(int i = 0; i < check.length; i++){
                if(check[i] == '0' ||
               check[i] == '9' ||
               check[i] == '8' ||
               check[i] == '7' ||
               check[i] == '6' ||
               check[i] == '5' ||
               check[i] == '4' ||
               check[i] == '3' ||
               check[i] == '2' ||
               check[i] == '1' ||
               check[i] == '+' ||
               check[i] == '/' ||
               check[i] == '*' ||
               check[i] == '-' ||
               check[i] == '}' ||
               check[i] == ')' ||
               check[i] == ']' ||
               check[i] == '^' ||
               check[i] == '.' 
                   ){
                    
                    
              
                } else if(check[i] == 's'){
                
                     if(check[i+1] == 'i'){
                         
                        if(check[i+2] == 'n'){
                            i++;
                            i++;
                            continue;
                        } else {
                            throw new IllegalArgumentException("Invalid expression");
                        }
                           
                     } else {
                         throw new IllegalArgumentException("Invalid expression");
                     }
                     
                }else if(check[i] == 'c'){
                     if(check[i+1] == 'o'){
                        if(check[i+2] == 's'){
                            i++;
                            i++;
                            continue;
                        } else {
                            throw new IllegalArgumentException("Invalid expression");
                        }
                           
                     } else {
                         throw new IllegalArgumentException("Invalid expression");
                     }
                     
                }else if(check[i] == 'l'){
                     if(check[i+1] == 'o'){
                        if(check[i+2] == 'g'){
                            i++;
                            i++;
                            continue;
                        } else {
                            throw new IllegalArgumentException("Invalid expression");
                        }
                           
                     } else {
                         throw new IllegalArgumentException("Invalid expression");
                     
                     }
                
                        
            
            
            
                } else if(check[i] =='('){
                    
                    if(i==check.length-1){
                        throw new IllegalArgumentException("Invalid expression");
                    }
                    if(check[i+1] == ')'){
                        
                    throw new IllegalArgumentException("Invalid expression");
                    } 
               
                } else if(check[i] =='{'){
                    if(i==check.length-1){
                        throw new IllegalArgumentException("Invalid expression");
                    }
                    if(check[i+1] == '}'){
                    throw new IllegalArgumentException("Invalid expression");
                    }
                
                } else if(check[i] =='['){
                    if(i==check.length-1){
                        throw new IllegalArgumentException("Invalid expression");
                    }
                    if(check[i+1] == ']'){
                    throw new IllegalArgumentException("Invalid expression");
                    }
                
                }  else {
                
                    throw new IllegalArgumentException("Invalid expression");
                }
                
            }
            
        } else {
            throw new IllegalArgumentException("Invalid expression");
        }
        
        for(int j = 0;j<check.length;j++){
            if(check[j] =='('){
                
                helperbr1 ++;
            } else if (check[j] ==')'){
                helperbr2 ++;
            } else if (check[j] =='{'){
                helperbr3 ++;
            } else if (check[j] =='}'){
                helperbr4 ++;
            } else if (check[j] =='['){
                helperbr5 ++;
            } else if (check[j] ==']'){
                helperbr6 ++;
            }
        }
        
        if(helperbr1 != helperbr2 || helperbr3 != helperbr4 || helperbr5 != helperbr6)
        { throw new IllegalArgumentException("Invalid expression");
        }
        int order = 0;
        for(int k = 0 ; k < check.length;k++){
            if(check[k] =='('){
                for(int p = k; p<check.length;p++){
                    if(check[p] == ')'){
                        break;
                    } else if(check[p] == '{'){
                        break;
                    } else if(check[p] == '['){
                        break;
                    
                    
                    } else if(check[p] == '}'){
                        order = 1;
                        break;
                    } else if(check[p] == ']'){
                        order = 1;
                        break;
                    }
                    
                }
            } else if(check[k] =='{'){
                for(int p = k; p<check.length;p++){
                    if(check[p] == '}'){
                        break;
                    } else if(check[p] == '('){
                        break;
                    } else if(check[p] == '['){
                        break;
                    
                    
                    } else if(check[p] == ')'){
                        order = 1;
                        break;
                    } else if(check[p] == ']'){
                        order = 1;
                        break;
                    }
                    
                }
            }if(check[k] =='['){
                for(int p = k; p<check.length;p++){
                    if(check[p] == ']'){
                        break;
                    } else if(check[p] == '{'){
                        break;
                    } else if(check[p] == '('){
                        break;
                    
                    
                    } else if(check[p] == ')'){
                        order = 1;
                        break;
                    } else if(check[p] == ']'){
                        order = 1;
                        break;
                    }
                    
                }
            }
        }
        if (order == 1){
            throw new IllegalArgumentException("Invalid expression");
        }
             
        
        Stack<String> stack = new Stack<String>(repStr.length());
        
        StringTokenizer tokens = new StringTokenizer(repStr,"[]{}()*/+-^ngs",true);
        
        
        
        
        while(tokens.hasMoreTokens()){
            String token = tokens.nextToken();
            
            
            if(token.equals("(")
                   || token.equals("{")
                   || token.matches("[0.0-99]+")
                   || token.equals("*")
                   || token.equals("/")
                   || token.equals("+")
                   || token.equals("-") 
                   || token.equals("[")
                   || token.equals("^")
                   
               ){
                stack.push(token);
               } else if(token.equals("s")){
                stack.push("sin");
                tokens.nextToken();
                tokens.nextToken();
                
                    
                } else if(token.equals("lo")){
                stack.push("log");
                tokens.nextToken();
                } else if(token.equals("co")){
                stack.push("cos");
                tokens.nextToken();
                
            }
                    
            else if(token.equals("}") || token.equals(")")||token.equals("]")){
                
                    double result = 0;
                    
                    if(stack.peek().equals("-")){
                        throw new IllegalArgumentException();
                    }
                    if(stack.peek().matches("[-999.0-999]+")){
                        
                        double op2 = Double.parseDouble(stack.pop()); 
                        
                        
                        if(stack.peek().equals("(")||stack.peek().equals("[")||stack.peek().equals("{")){
                            result = op2;
                            
                            stack.pop();
                        } else if(stack.peek().equals("-")){
                            stack.pop();
                            double op3 = 0;
                            if(stack.peek().equals("(")||stack.peek().equals("{")||stack.peek().equals("[")){
                                result = -op2;
                                stack.pop();
                            } else if(stack.peek().matches("[-999.0-999]+")){
                                op3 = Double.parseDouble(stack.pop());
                                result = op3-op2;
                                stack.pop();
                            }
                        } else if(stack.peek().equals("sin")){
                            result = Math.sin(op2);
                            stack.pop();
                            stack.pop();
                        } else if(stack.peek().equals("cos")){
                            result = Math.cos(op2);
                            stack.pop();
                            stack.pop();
                        } else if(stack.peek().equals("log")){
                            if(op2 <= 0){
                                result = Double.NaN;
                            }
                            result = Math.log(op2);
                            stack.pop();
                            stack.pop();
                        
                            
                        }else {
                            
                            String oprnd = stack.pop();
                            
                            if(!stack.peek().matches("[-999.0-999]+")){
                                throw new IllegalArgumentException("Invalid expression");
                            }
                            double op1 = Double.parseDouble(stack.pop());
                            if(stack.peek().equals("-")){
                                op1 = -op1;
                                stack.pop();
                            }
                            if(stack.peek().equals("+") || stack.peek().equals("-") ||stack.peek().equals("*")||stack.peek().equals("/")||stack.peek().equals("^")){
                                throw new IllegalArgumentException("Invalid expression");
                            }
                            
                            if(!stack.IsEmpty()){
                                stack.pop();
                            }
                        
                            if(oprnd.equals("*")){
                                result = op1*op2;
                            }else if(oprnd.equals("/")){
                                result = op1/op2;
                            }else if(oprnd.equals("+")){
                                result = op1+op2;
                            }else if(oprnd.equals("-")){
                                result = op1-op2;
                            }else if(oprnd.equals("^")){
                                result = Math.pow(op1,op2);
                                
                            }  
                        }
                    
                    stack.push(result+"");
                       
                    
                    } else if(stack.peek().equals("NaN")){
                        
                    }
                            
                    else {
                        
                        throw new IllegalArgumentException("Invalid expression");
                    } 
                
            }
        }
        
        String finalResult = "";
        
        finalResult = stack.pop();
        
        double output = Double.parseDouble(finalResult);
        return output;
    }
        
                    
                    
                
    

    public static void main(String[] args)throws IOException
    {
        InFixEvaluator i = new InFixEvaluator();
        try{
            System.out.println(i.evaluator(args[0]));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
