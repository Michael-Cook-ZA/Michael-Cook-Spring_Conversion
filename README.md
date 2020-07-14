# Michael-Cook-Spring_Conversion
basic Java app with endpoints to do conversions

 Accepts JSON for all input data for the endpoints in following format
 {
     Value: double
     Unit: String
 }
  all data is returned in the same JSON format

to run the part1 
./mvnw spring-boot:run

testing as excluded due to timelimit

The program was done in simple as possible way due to time limit.

part 2 was believed to not include the in the time and thus done before hand and added to the program afterwards in its part2 folder in one .java file.



Java Developer Expertise Test (60 min)
Part 1
Create a Github account on github https://github.com/ or use your existing account if you
already have one.
Create a public repository for this project.
Create an initial commit with the expertise test outline (this document) in the readme.md
Create frequent commits of your code. (at least 1 commit every 15 min)
Create a service capable of serving the following endpoints:
For all of the below endpoints a log entry needs to be created for their execution duration.
/conversions/ktoc
The ktoc endpoint should produce an output amount in celsius when given an input amount
in kelvin.
/conversions/ctok
The ctok endpoint should produce an output amount in kelvin when given an input amount in
celsius.
/conversions/mtok
The mtok endpoint should produce, when given an input amount in miles, an output amount
in kilometers.
/conversions/ktom
The ktom endpoint should produce, when given an input amount in kilometers, an output
amount in miles.
Part 2 – Console Roulette
See the attached pdf file.