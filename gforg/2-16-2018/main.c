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
        int holder[num_elements];
        int i, min, max;
        fscanf(input, "%d", &holder[0]);
        min = holder[0];
        max = holder[0];
        
        for (i = 1; i < num_elements;i++){
            fscanf(input, "%d", &holder[i]);
            if (holder[i]> max){
                max=holder[i];
            }
            if (holder[i]< min){
                min = holder[i];
            }
        }
        int length = max - min+1;
        if (length > num_elements){
            printf("Elements too short");
            fprintf(output,"No\n");
        }
        else{
            int checker_array[length];
            while(num_elements > 0){
                num_elements--;
                printf("%d",holder[num_elements]);
                checker_array[holder[num_elements]-min]=1;
            }
            printf("\n");
            int checked = 1;
            while (length > 0){
                length --;
                checked &= checker_array[length];
                printf("%d",checker_array[length]);
            }
            printf("\n");
            if (checked){
                fprintf(output, "Yes\n");
            }else{
                fprintf(output, "No\n");
            }
        }

    }
    fclose(input);
    fclose(output);
	return 0;
}
