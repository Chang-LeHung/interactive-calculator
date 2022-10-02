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
/home/huchang/interactive-calculator
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

