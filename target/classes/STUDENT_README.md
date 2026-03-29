**Overview**
This project is a Java implementation of a C-style string class. A CString stores a string like "hello" as an array of characters, e.g. ['h', 'e', 'l', 'l', 'o']. A CString object can be reversed or sorted alphabetically. In the Main class, we manipulate a set of CStrings to decrypt a secret message. To do this, the CStringUtil class was written with several static helper functions, including isPalindrome(), toNumerical(), maxMirror(), memeifyArray(), nestedSequence(), and decrypt(). Of these, the only methods that were used decrypt() were toNumerical() and reverse() (in the CString class).

**Logic**
The logic for some of these functions was a bit tricky. isPalindrome() could have been about 3 lines of code, except that spaces and letter case had to be ignored. To do this, I had to count the number of spaces, create a new array that didn't contain them, and then copy over the original, skipping spaces. This resulted in a cleaned array, which was compared to its reverse.

toNumerical() was straightforward. A char type can be converted to its ASCII equivalent by simply type-casting it to an int. A single for-loop was needed.

maxMirror() gave me some problems at first. I finally settled on an implementation that looped through the given array and stored indexes for the start and end of the check. These variables began at the extremes, and as the loop progressed, start and end would get closer to each other until every possible permutation of values was checked.

memeifyArray() also had to be modified. Two ArrayLists were used to store the 7s and non-6-7s. In order to keep the 6s in the right index, I looped through a new result array twice. The first pass only inserted 6s and 7s, while the second pass searched for any 0s in the array (default values) and replaced them with the proper number.

nestedSequence() began by sorting each CString and converting them to numerical arrays. To check every single spot in the outer array for matching numbers, I iterated over it, and if there was a match between the current number and the first number of the inner array, a second loop would be initated to check if the full sequence existed.

**Challenges**
There were definitely many challenges in this assignment, mainly with debugging. I had initally written code for memeifyArray() and maxMirror() that later had to revised. One version of memeifyArray() moved around the 7s correctly, but changed the index of a few 6s as a result. I also had an issue remembering that the main method had to throw IOException, so when first creating my Scanner object it kept throwing a FileNotFoundException, which really confused me.