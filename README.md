# interactive-calculator

A interactive calculator based on self-defined bytecode implemented in java.This is a self-learning project, if you are learning compile princinple, this project is pretty suitable for you!

## Introduction

- Interactive calculator is calculator with some basic function, such as plus, minus, multiply and div.Besides, the calculator supports some useful math function : tanh, tan, sin, cos, cot.
- The most important funciton of this calculator is variable supporting, you can define variable in it and use it after defining.
- You also can use system command in the calculator.

## Download & Usage

```bash
git clone https://github.com/Chang-LeHung/interactive-calculator.git
cd interactive-calculator/
java -jar target/calculator-1.0-SNAPSHOT.jar execturo.Terminal
```

### Basic calculation

```bash
$java -jar target/calculator-1.0-SNAPSHOT.jar executor.Terminal
>1+2;
ICInt{val=3}
>2+5-1+6
ICInt{val=12}
>2*(1+2)-5
ICInt{val=1}
```

### System command execution

```bash
>pwd
/home/$HOME/interactive-calculator
>ls
dependency-reduced-pom.xml
pom.xml
README.md
src
target
>echo hello world
hello world
```

### Variable and function Usage

```bash
>a=1
>b=2
>c=3
>d=1+2+3+4+5*7-(2-3)*6
>a
ICInt{val=1}
>d
ICInt{val=51}
>tan(a+b)
ICDouble{val=-0.1425465430742778}
>sin(d)
ICDouble{val=0.6702291758433747}
>cos(d)
ICDouble{val=0.7421541968137826}
>cot(d)
ICDouble{val=1.1073140704146487}
```

### Dump your expression AST(Abstract Syntax Tree)

```bash
>a=1+2*(6-2)*8/4+5-6;
>tanh(1+2+3);
ICDouble{val=0.9999877116507956}
>tanh(1+2+3+4*8/2 - 5  + a);
ICDouble{val=1.0}
>dump
digraph AST {
1[label="="];
2[label="a"];
3[label="-"];
4[label="+"];
5[label="+"];
6[label="1"];
7[label="/"];
8[label="*"];
9[label="*"];
10[label="2"];
11[label="-"];
12[label="6"];
13[label="2"];
14[label="8"];
15[label="4"];
16[label="5"];
17[label="6"];
18[label="tanh"];
19[label="+"];
20[label="+"];
21[label="1"];
22[label="2"];
23[label="3"];
24[label="tanh"];
25[label="+"];
26[label="-"];
27[label="+"];
28[label="+"];
29[label="+"];
30[label="1"];
31[label="2"];
32[label="3"];
33[label="/"];
34[label="*"];
35[label="4"];
36[label="8"];
37[label="2"];
38[label="5"];
39[label="a"];

1->2;
2->1;
5->6;
6->5;
9->10;
10->9;
11->12;
12->11;
11->13;
13->11;
9->11;
11->9;
8->9;
9->8;
8->14;
14->8;
7->8;
8->7;
7->15;
15->7;
5->7;
7->5;
4->5;
5->4;
4->16;
16->4;
3->4;
4->3;
3->17;
17->3;
1->3;
3->1;
20->21;
21->20;
20->22;
22->20;
19->20;
20->19;
19->23;
23->19;
18->19;
19->18;
29->30;
30->29;
29->31;
31->29;
28->29;
29->28;
28->32;
32->28;
27->28;
28->27;
34->35;
35->34;
34->36;
36->34;
33->34;
34->33;
33->37;
37->33;
27->33;
33->27;
26->27;
27->26;
26->38;
38->26;
25->26;
26->25;
25->39;
39->25;
24->25;
25->24;

}
>
```

you can use the output to generate a graph of expression AST with `graphiz`.



