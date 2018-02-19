//Given an array of n integers(duplicates allowed). Print “Yes” if it is a set of contiguous integers else print “No”.

//INPUT: The first line consists of an integer T i.e. the number of test cases. First line of each test case consists of an integer n, denoting the size of array. Next line consists of n spaced integers, denoting elements of array.

//OUTPUT:  Print “Yes” if it is a set of contiguous integers else print “No”.

//CONSTRAINTS:
//1<=T<=100
//1<=n<100000
//a[i]<=105

//Example:

//2
//8
//5  2  3  6  4  4  6  6
//7
//10  14  10  12  12  13  15

//Output :
// Yes
// No

//Explanation:
//Test Case 1 : The elements  of array form a contiguous set of integers which is {2, 3, 4, 5, 6} so the output is Yes.
//Test Case 2: We are unable to form contiguous set of integers using elements of array.
#include <stdio.h>
struct set{

}
int grow(range* r, int num){
    if (r->left==NULL){
        r->left = num;
        return 1;
    }else if (r->right ==NULL){
            if (num == r->left -1){
             
                r->right = r->left;
                r->left = num;
                return 1;
             } 
             else if (num == r->left+1){
                 r->right = num;
                return 1;
            }
            else {
                return 0
            }
        }
    else if (num == r->left-1){
        r->left = num;
        return 1;
    }
    else if (num == r->right +1){
        r->right =num;
        return 1;
    }else if((num >= r->left) & (num <= r->right)){
        return 1;
    }else  {
        return 0;
    }
}
int main() {
    
    FILE * input;
    input = fopen("input.txt", "r");
    FILE * output;
    output = fopen("output.txt", "w");
    int num_cases;
    fscanf(input, "%d", &num_cases);
    for(; num_cases>0; num_cases--){
        int num_elements;
        fscanf(input, "%d", &num_elements);
    }

	return 0;
}
