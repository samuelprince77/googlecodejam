# googlecodejam
These are solutions to some of the googlecodejam problems i have attempted to solve. The all pass the google judge system.

## How they work
# Pancake Flipper Solution:

In order to solve this problem, I read the input strings from the input file line by line and split each input string by space. The split creates an array with two elements, the first one being the string S and the second being K. A condition is also set to prevent the first string input from being cosidered in the test cases as it specifies the number of test cases.

Taking the string S, I check each character of the string starting from the left moving right. Each time a “-” is encountered, I flip the next K characters including the character currently read. To perform the flip I check what the character is and change it to what it is not i.e. if it is a “-”, I change it to a “+” and viceversa. Each time a flip happens, a counter is incremented to keep track of how many flips are needed to solve the problem. This counter is later printed by the program as the number of flips needed to solve the problem. 

The loop keeps on going until the entire output consists of only “t” i.e. all the pancakes have been flipped happy side up. This solution works well if flips are able to happen on the output or if all the input characters are already flipped I.e. all characters are “+”. There is still one scenario that needs to be accounted for, one where flipping all the characters happy side up is not possible. In order to handle this I added a condition check. This condition checks that if a “-” is encountered at position S[i], position S[i+k] is not greater than the length of the input string. This condition makes sure that there are always K pancakes that can be flipped if flipping is to happen and if there are less than K pancakes left and a flipping has to happen, the conclusion is that the problem is impossible to solve and impossible is the output of that test case. 

I found that the same solution could be applied to both the small and large data sets without much effect to the computation time.

# Tidy numbers solution:

For this problem, I developed two programs. One to handle the small data set and another to handle the big data set.

1) Small data set solution (SmallTidyNumbers.java):
The solution for the small data set was fairly simple and straight forward. I read the input from the input file line by line and pass each input except the first which specifies the number of test cases, into a method called tidyChecker. This method compares each character in the string input to the next character in the input and checks if that value c[i] is greater than the next c[i +1]. If any such character is found that satisfies this condition, the number is untidy. Once the untidy number is found, the input changes by 1 i.e. I subtract 1 from the input and pass this new input to the tidyChecker method. This is repeated as long as the number is untidy. Once a tidy number has been found whereby c[i] is less than or equal to c[i+1] for all the characters of the input, the loop is terminated and this final value is printed by the program.
This approach to solving the problem works fine if the input numbers are small. But once the input numbers are huge as is the case with the big data set, this solution takes too much computational time to be feasible. In order to solve the problem for the big data set I had to read the analysis for the problem on the Google code jam page (A greedy approach).

2) Big data set solution (LargeTidyNumbers.java):
According to the analysis, the best way to solve the problem was to compare all the values within the input and find the point where the current character is greater than the next character in the input string. Take the character that is greater, subtract one from it then change the remaining characters of the input into 9’s. This maximizes the value of the number while still keeping it tidy. This was the same approach I took in my solution. I read each input line by line and pass each input except the first which specifies the number of test cases to a method called tidyChecker as before in the small data set solution. I then compare each character, c[i] in the input to the next, c[i+1]. If c[i] is greater than c[i+1], I take c[i], subtract one from it and change the rest of the characters in the input to 9. This maximizes the value of the tidy number. This value is then printed out buy the program
