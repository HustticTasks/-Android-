package demo;

import java.io.*;
import java.util.Scanner;

public class _2hw3 {
    public static void main(String[] args)throws IOException{
        Scanner input=new Scanner(System.in);
        boolean judge=true;
        String name,id,result,SubjectChecking="";
        int i=-1;
        int SubjectNumber;

        while (judge) {
            System.out.println("请问您要：");
            System.out.println("1.查询成绩  or    2.写入成绩");
            System.out.println("请输入1或2");
            i=input.nextInt();
            if (i==1||i==2)
                judge=false;
            else System.out.println("输入错误！请重新输入！");
        }
        if (i==1){
            System.out.println("请输入待查询学生姓名：");
            name=input.next();
            System.out.println("请问要查询哪科成绩：");
            System.out.println("1.语文  2.数学   3.英语");
            SubjectNumber=input.nextInt();
            switch (SubjectNumber){
                case 1:SubjectChecking="Chinese";break;
                case 2:SubjectChecking="Math";break;
                case 3:SubjectChecking="English";break;
                default:break;
            }
        //    System.out.println(name);
            result=getScore(name,SubjectChecking);
            System.out.println(name+"的"+SubjectChecking+"成绩是"+result);

        }
        if (i==2){
            System.out.println("请输入待录入学生姓名：");
            name=input.next();
            System.out.println("请输入待录入学生的学号：");
            id=input.next();
            Student student=new Student(name,id);
            System.out.println("请输入该学生的语文成绩：");
            student.setChineseScore(input.nextInt());
            System.out.println("请输入该学生的数学成绩：");
            student.setMathscore(input.nextInt());
            System.out.println("请输入该学生的英语成绩：");
            student.setEinglishScore(input.nextInt());
            setScore(student.getStudentName(),student.getStudentID(),student.getChineseScore(),student.getMathScore(),student.getEnglishScore());
        }
    }
    public static String getScore(String NameGet,String SubjectChecking) throws IOException{
        BufferedReader in=new BufferedReader(new FileReader("src/demo/ScoreChecking.txt"));
        String line=in.readLine();

//        System.out.println(line);
        NameGet=NameGet.trim();
 //       System.out.println(NameGet);
        while (line!=null){
            int OrderNumber=line.indexOf(";");
            String TheLineName=line.substring(5,OrderNumber);
      //      System.out.println(TheLineName);
            if (TheLineName.equals(NameGet)){
       //         System.out.println("111enenenene");
                int SubjectOrderNumberBegin=line.indexOf(':',line.indexOf(SubjectChecking));
                int SubjectOrderNumberEnd=line.indexOf(';',SubjectOrderNumberBegin);
                return line.substring(SubjectOrderNumberBegin+1,SubjectOrderNumberEnd);
            }
            line=in.readLine();
        }

        in.close();
        return "查无此人";

    }
    public static void setScore(String tname,String tID,int tChineseScore,int tMathScore,int tEnglishScore)throws IOException{
        BufferedWriter out=new BufferedWriter(new FileWriter("src/demo/ScoreChecking.txt",true));

        out.write("name:"+tname+";ID:"+tID+";Chinese:"+tChineseScore+";Math:"+tMathScore+";English:"+tEnglishScore+";");
        out.newLine();

        out.close();
    }



}
class Student{
    private String StudentName;
    private int Mathscore=0,ChineseScore=0,EnglishScore=0;
    private String StudentID;
    public Student(String Name,String ID){
        StudentName=Name;
        StudentID=ID;
    }

    public String getStudentName(){
        return StudentName;
    }

    public String getStudentID(){
        return StudentID;
    }
    public int getChineseScore(){
        return ChineseScore;
    }
    public int getMathScore(){
        return Mathscore;
    }
    public int getEnglishScore(){
        return EnglishScore;
    }

    public void printStudengScore(int i){
        switch (i) {
            case 1:
                System.out.print("Chinese:" + ChineseScore);
                break;
            case 2:
                System.out.println("Math:" + Mathscore);
                break;
            case 3:
                System.out.println("English:" + EnglishScore);
                break;
            default:
                break;
        }
    }

    public void setChineseScore(int i){
        ChineseScore=i;
    }
    public void setMathscore(int i){
        Mathscore=i;
    }
    public void setEinglishScore(int i){
        EnglishScore=i;
    }
}
