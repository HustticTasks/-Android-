package Android组任务;

        import javax.swing.filechooser.FileSystemView;
        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.Scanner;
        import java.lang.String;

public class Test
{
    public static void main(String[] args)
    {
        int length=0;
        String str="     学号     "+"     姓名     "+"     语文     "+"     数学     "+"     英语     ";
        Scanner in = new Scanner(System.in);

        System.out.println("\t\t\t\t\t\t欢迎使用假HUB成绩查询系统");

        System.out.println("\t\t\t\t\t\t   *** 请先输入学生信息（一次性输入，再次选择时将会覆写） ***");
        System.out.println("\t\t\t\t\t\t   你想输入几个学生的信息？");
        length = in.nextInt();

        Student[] arr = new Student[length];
        String[] s = new String[length];
        for(int i=0;i<length;i++)
        {
            s[i] = new String("");
        }
        String number,x;
        double ch,ma,en;
        for(int i=0;i<length;i++)
        {
            System.out.println("请在此处输入各项信息");
            System.out.println("学号：");
            number = in.next();

            System.out.println("姓名：");
            x = in.next();

            System.out.println("语文成绩：");
            ch = in.nextDouble();

            System.out.println("数学成绩：");
            ma = in.nextDouble();

            System.out.println("英语成绩：");
            en = in.nextDouble();

            arr[i] = new Student(number,x,ch,ma,en);
            s[i] = "\n  "+number+"  "+"     "+x+"     "+"     "+ch+"     "+"     "+ma+"     "+"     "+en+"     ";
        }

        finish:
        while(true)
        {
            System.out.println("\t\t\t\t\t\t*******************\n");
            System.out.println("\t\t\t\t\t\t   目前共有 " + length +" 个学生的信息");
            System.out.println("\t\t\t\t\t\t   1.查询成绩");
            System.out.println("\t\t\t\t\t\t   2.修改信息");
            System.out.println("\t\t\t\t\t\t   3.保存全部学生信息到文件");
            System.out.println("\t\t\t\t\t\t   4.退出系统");
            System.out.println("\t\t\t\t\t\t*******************\n");

            int n = in.nextInt();

            switch(n)
            {
                case 1:
                    String t;
                    int test1;
                    System.out.println("\t\t\t\t\t\t*******************\n");
                    System.out.println("\t\t\t\t\t\t   输入学号或姓名查询成绩");
                    System.out.println("\t\t\t\t\t\t   1.我要输入学号");
                    System.out.println("\t\t\t\t\t\t   2.我要输入姓名");
                    System.out.println("\t\t\t\t\t\t*******************\n");
                    test1 = in.nextInt();
                    if(test1 == 1)
                    {
                        System.out.println("\t\t\t\t\t\t   学号：");
                        t = in.next();
                        boolean notFound = true;
                        for(int i=0;i<length;i++)
                        {
                            if(arr[i].getNumber().equals(t))
                            {
                                notFound = false;
                                arr[i].getScore();
                                break;
                            }
                        }
                        if(notFound) System.out.println("查无此人");
                    }

                    else if(test1 == 2)
                    {
                        System.out.println("\t\t\t\t\t\t   姓名：");
                        t = in.next();
                        boolean notFound = true;
                        for(int i=0;i<length;i++)
                        {
                            if(arr[i].getName().equals(t))
                            {
                                notFound = false;
                                arr[i].getScore();
                                break;
                            }
                        }
                        if(notFound) System.out.println("查无此人");
                    }

                    else System.out.println("输入错了，你是来找茬的吧？");
                    break;
                case 2:
                    String _t;
                    int _test1;
                    System.out.println("\t\t\t\t\t\t*******************\n");
                    System.out.println("\t\t\t\t\t\t   输入学号或姓名修改信息");
                    System.out.println("\t\t\t\t\t\t   1.我要输入学号");
                    System.out.println("\t\t\t\t\t\t   2.我要输入姓名");
                    System.out.println("\t\t\t\t\t\t*******************\n");
                    _test1 = in.nextInt();
                    if(_test1 == 1)
                    {
                        System.out.println("\t\t\t\t\t\t   学号：");
                        _t = in.next();
                        boolean notFound = true;
                        for(int i=0;i<length;i++)
                        {
                            String temp = arr[i].getNumber();
                            if(temp.equals(_t))
                            {
                                notFound = false;
                                arr[i].rewrite();
                                s[i] = "\n  "+arr[i].getNumber()+"  "+"     "+arr[i].getName()+"     "+"     "+arr[i].getChinese()+"     "+"     "+arr[i].getMath()+"     "+"     "+arr[i].getEnglish()+"     ";
                                break;
                            }
                        }
                        if(notFound) System.out.println("查无此人");
                    }

                    else if(_test1 == 2)
                    {
                        System.out.println("\t\t\t\t\t\t   姓名：");
                        _t = in.next();
                        boolean notFound = true;
                        for(int i=0;i<length;i++)
                        {
                            String temp = arr[i].getName();
                            if(temp.equals(_t))
                            {
                                notFound = false;
                                arr[i].rewrite();
                                s[i] = "\n  "+arr[i].getNumber()+"  "+"     "+arr[i].getName()+"     "+"     "+arr[i].getChinese()+"     "+"     "+arr[i].getMath()+"     "+"     "+arr[i].getEnglish()+"     ";
                                break;
                            }
                        }
                        if(notFound) System.out.println("查无此人");
                    }

                    else System.out.println("输入错了，你是来找茬的吧？");
                    break;
                case 3:
                    for(int i=0;i<length;i++)
                    {
                        str += s[i];
                    }
                    Student A = new Student();
                    A.store(str);
                    break;
                case 4:
                    break finish;
                default:
                    System.out.println("无效输入，请重试.");
            }
        }
    }
}

class Student
{
    private String studentNumber;
    private String name;
    private double chinese;
    private double math;
    private double english;
    Scanner in = new Scanner(System.in);

    public Student(String number,String x,double ch,double ma,double en)
    {
        studentNumber = number;
        name = x;
        chinese = ch;
        math = ma;
        english = en;
    }

    public Student()
    {
        this("N/A","N/A",0,0,0);
    }

    public String getNumber()
    {
        return studentNumber;
    }

    public String getName()
    {
        return name;
    }

    public double getChinese()
    {
        return chinese;
    }

    public double getMath()
    {
        return math;
    }

    public double getEnglish()
    {
        return english;
    }

    public void reNumber(String n){ studentNumber = n; }

    public void reName(String n){ name = n; }

    public void reChinese(double n){ chinese = n; }

    public void reMath(double n){ math = n; }

    public void reEnglish(double n){ english = n; }

    public void getScore()
    {
        int test2;
        System.out.println("\t\t\t\t\t\t*******************\n");
        System.out.println("\t\t\t\t\t\t   你想查询哪门成绩？");
        System.out.println("\t\t\t\t\t\t   1.语文");
        System.out.println("\t\t\t\t\t\t   2.数学");
        System.out.println("\t\t\t\t\t\t   3.英语");
        System.out.println("\t\t\t\t\t\t   4.全部");
        System.out.println("\t\t\t\t\t\t*******************\n");
        test2 = in.nextInt();

        switch(test2)
        {
            case 1:
                System.out.println(getName() + "，你好，你的语文成绩是：" + getChinese());break;
            case 2:
                System.out.println(getName() + "，你好，你的数学成绩是：" + getMath());break;
            case 3:
                System.out.println(getName() + "，你好，你的英语成绩是：" + getEnglish());break;
            case 4:
                System.out.println("\t\t\t"+getName()+"，你好，你的全部成绩如下：");
                System.out.println("\t\t\t"+"语文："+getChinese()+"分");
                System.out.println("\t\t\t"+"数学："+getMath()+"分");
                System.out.println("\t\t\t"+"英语："+getEnglish()+"分");
                break;
            default:
                System.out.println("输入错了，你是来找茬的吧？");
        }
    }

    public void rewrite()
    {
        int test2;
        System.out.println("\t\t\t\t\t\t*******************\n");
        System.out.println("\t\t\t\t\t\t   你想改写哪个条目？");
        System.out.println("\t\t\t\t\t\t   1.语文成绩");
        System.out.println("\t\t\t\t\t\t   2.数学成绩");
        System.out.println("\t\t\t\t\t\t   3.英语成绩");
        System.out.println("\t\t\t\t\t\t   4.学号");
        System.out.println("\t\t\t\t\t\t   5.姓名");
        System.out.println("\t\t\t\t\t\t*******************\n");

        test2 = in.nextInt();
        switch(test2)
        {
            case 1:
                System.out.println(getName() + "，你好，修改后的语文成绩是？");
                double re1 = in.nextDouble();
                reChinese(re1);
                break;
            case 2:
                System.out.println(getName() + "，你好，修改后的数学成绩是？");
                double re2 = in.nextDouble();
                reMath(re2);
                break;
            case 3:
                System.out.println(getName() + "，你好，修改后的英语成绩是？");
                double re3 = in.nextDouble();
                reEnglish(re3);
                break;
            case 4:
                System.out.println(getName() + "，你好，修改后的学号是？");
                String re4 = in.next();
                reNumber(re4);
                break;
            case 5:
                System.out.println(getName() + "，你好，修改后的姓名是？");
                String re5 = in.next();
                reName(re5);
                break;
            default:
                System.out.println("输入错了，你是来找茬的吧？");
        }
    }

    public void store(String str)
    {
        File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
        String desktopPath = desktop.getAbsolutePath();

        File scoreList = new File(desktopPath+"\\list.txt");
        if(scoreList.exists())
        {
            System.out.println("已存在一个成绩单，旧成绩单已被新成绩单覆写");
        }
        else
        {
            System.out.println("初次保存一个成绩单，记得备份哦");
            try
            {
                scoreList.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            FileWriter fileWriter = new FileWriter(scoreList);

            fileWriter.write(str);
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
