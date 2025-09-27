package com.example.myapplication
// VERY CASE SENSITIVE LANGUAGE
/*main function ,fun is the keyword for creating the function
variables ----->  var name:data_types = data
explicitly mentioning data type is not required kotlin has  type inference , it knows what data type
is the given to variable.
val -----> constant,value cannot be changed
*/
fun main () {
    var username:String = "Krrish"
    username = "Khowal"
    val name = "Krrish Khowal"
    val age:Int = 18
    print("Hello $name your age is $age \n")// doesn't add new line at the end automatically
    println(age)//can print like this also it adds new line at the end automatically
    println("Hello $username your age is $age")
    val maxIntegerValue: Int = Int.MAX_VALUE
    val minIntegerValue: Int = Int.MIN_VALUE
    println("Max value of integer in kotlin is $maxIntegerValue and min value is $minIntegerValue")
    val maxByteValue: Byte = Byte.MAX_VALUE
    val minByteValue: Byte = Byte.MIN_VALUE
    println("Max value of Byte integer in kotlin is $maxByteValue and min value is $minByteValue")
    val maxShortValue: Short = Short.MAX_VALUE
    val minShortValue: Short = Short.MIN_VALUE
    println("Max value of Short integer in kotlin is $maxShortValue and min value is $minShortValue")
    val maxLongValue: Long = Long.MAX_VALUE
    val minLongValue: Long = Long.MIN_VALUE
    println("Max value of Long integer in kotlin is $maxLongValue and min value is $minLongValue")
    /*   default inferred type of any number is int   int occupies 32bits
        to use byte type var number:Byte=x   byte occupies 8bits
        to use short type var number:Short=x short occupies 16bits
        to use long type var number:Long=x
        or use var number=xL (only capital L with no space btw the number and L)
        or if the number exceeds the int limit it will be automatically converted to long
         */

    /*    for decimal number the default inferred type is double
    val Double_Number = 10.1 (no other ways around)
    to use float we need to type val Floating_number= xf or xF

    for character we can use char and boolean
    val ch:Char = 'K'
    val bool:Boolean= true or false
    writing Char and Boolean is optional
    all operators(relational,assignment,logical) work same as C
*/
}
/*  if(){
    }
    else if(){
    }
    else{
    }

    something new - a number or text can be assigned to a variable using if else
    the last line is assigned to the variable based on which condition is true the variable will
    be automatically inferred to that type
    so try not to explicitly tell the variable type ----->  val num:String
    val num= if(expression){
        println("") ----->optional
        "Text"
    }
    else{
        println("") ----->optional
        67
    }
    println("$num")
*/
/*  when----->(similar to switch case)
when the value of the given object
inside the parenthesis is equal to the left side of the branch the code after -> is executed
if none of the branches matches then if a else branch is given it will be executed.
only 1 branch is executed
val num=12
when(num){
expression ->  what to do  , this is a branch
11-> println("")
12,9,8 -> println("")   can be also used to evaluate multiple values
in 1..10 -> println("") can be used to check in range
!in 1..10 -> println("") can be used to check not in range
1 -> {                     can be used to run multiple lines of code
    println("")
   println("")
   }
else -> println("")   if no branch matches it is executed
}

not only integer , we can evaluate boolean also
when{
num>10 -> println("   ")
num<10 || num >15 -> println("  ")
else -> println("")
}

val num = when(){    - same working as if else
}
println($num)
*/
/*  kotlin try's to not allow any variable to have null value
val text:String=null  --- cannot do this
val text:String? =null  --- adding ? we can assign null

a variable have null type cannot be easily printed

var text:String?="NAME"
println(text?.length) --  ? is a safe call operator
println(text?.length)   -----> 4
text = null
println(text?.length) -----> null
or
var text:String?=null
println(text!!.length) --  !! throws null exception error if text is null unless it
println(text!!.length)   -----> exception error
text = "TEXT"
println(text!!.length) ----> 4
or
alias operator
val text2= text?:"Not NULL" -- if the text is null it assigns the object given after ?:
and if the text is not null it is assigned to text2
or
if(text!=null){
  println(text.length)
}
else{
 println("It is null")
}
*/
/*  functions----->
    //local variables name should not be capital
    // parameter variables are declared as val and cannot be changed/reassigned
    // parameter variables and variables declared inside the function have only function block scope
        fun _name_(variable_name:Datatype):Int{
                return if (a>b) a else b
        }
        or
        if there is only a single line of code or single expression and return type need not
        to be mentioned as it can be inferred
        fun _name_(variable_name:Datatype)= if (a>b) a else b

    other working's is same as C

fun name(name:String,age:Int) {
    println("Hi $name , $age")
}

fun num(name:String,age:Int):Int{
    println("Hi $name , $age")
    return age
}

function overloading-used when we need same task with different parameter number or data type
 based on the given parameter different functions can be called with same name
 getmax(3,4)    getmax(5.6,6.5)   getmax(8.9,8)   getmax(1,2,3)
fun getmax(a:Int,b:Int) = if (a>b) a else b
fun getmax(a:Double ,b:Double) = if (a>b) a else b
fun getmax(a:Double,b:Int) = if (a>b) a else b
fun getmax(a:Int,b:Int,c:Int) = if (a>b) a else b

fun printf(name:String="Krrish",message:String=""){ }
-----> this is done so that if the second parameter is not passed we do not get any errors
printf(message="Hi")
-----> this is done to pass value of any parameter in any specific order
*/
/*
println(sum(1,2,3,4,5,6,7,8,9))
vararg----->   fun sum(vararg num:Int):Int{
                var result=0
                for(number in num){
                    result+=num
                }
                return result
            }
*/
/*Loops----->
    for loop---->
    counting up-
    for(i in 1..20){        last element(20) is included
        println(i)
    }

    for(i in 1 until 20){   last element (20) is excluded
        println(i)
    }

    counting down-
    for(i in 10 downTo 1){
        println(i)
    }

    incrementing counter as required -
    for(i in 1 until 10 step 2){
        println(i)
    }-->1,3,5,7,9

    while loop-----> different types of conditions can be used
    while(condition){
        code
    }

    do while loop -----> at least one time working while loop
    do{
     code
    }while(condition)

    continue-----> used to skip code below it
    in for loop the iterator just increments and a new iteration starts if possible
    in do while and while control moves to check for the condition

    break----->prematurely ending loops in which they are used
    we can also use break to target outer loops form inner loops
    but we cannot target inner loops from outer loops
    outer@ for(i in 1..10){
            println(i)
            while(i<10){
                if(i==5){
                    break @outer
                }
            }
        }
*/
/*
 val array_name:Array<data_type>=arrayOf(element1,element2) --->fixed size array
 *** we can have different type of elements in the array when array's data type  is not explicitly mentioned
 arrayOf is a function call inside which we give elements
 data type is optional
 println(array_name[0])
 array_name[0]=element3
 println(array_name.size)----> to get the size of the array
 for( i in array_name){
    println(i)
    if (i is Int){   -----> to print only a certain type of elements from the array containing
        println(i)              multiple data type elements
    }
 }
*/