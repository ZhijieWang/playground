//Chunky gets happy by eating Melody.
//Given an array of N elements each element represent happiness chunky get by eating melody.
//Chunky knows why melody is so chocolaty but will only tell you once you tell him the Max happiness he can get by eating two adjacent melodies.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an integer N and the second line contains N space separated array elements.
//
//Output:
//For each test case, print the Maximum Happiness in new line.
//
//Constraints:
//1 <= T <= 100
//1 <= N <= 100000
//-100000 <= A[i] <= 100000
// 
//
//Example:

// Input:
// 2
// 5
// 1 2 3 4 5
// 4
// 5 2 3 4

// Output:
// 9
// 7

#include <stdio.h>
int main() {
    FILE *file;
    file = fopen("input.txt", "r");
    if (!file){
        return -1;
    }

    FILE *output;
    output = fopen("output.txt", "w"); 
    int num_cases;
    fscanf(file, "%d", &num_cases);
    printf("Number of test cases %d \n", num_cases);
    int case_iterator = 0;
    int num_elements;

    for (case_iterator; case_iterator<num_cases; case_iterator ++){
        fscanf(file, "%d", &num_elements);
        printf("%d elements in case %d \n", num_elements, case_iterator);
        int component;
        fscanf(file, "%d", &component);
        printf("%d", component);
        int sum = component;
        int element_iterator = 1;
        int hold;
        for (element_iterator; element_iterator<num_elements; element_iterator++){
            fscanf(file, "%d", &hold);
            printf("%d", hold);
             if (hold +component > sum) {
                 sum = component + hold;
                 component =hold;
             }
        }
        printf("\n");
        fprintf(output, "%d\n", sum);
    }
    fclose(file);
    fclose(output);
	return 0;
}
