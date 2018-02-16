//Given N leaves numbered from 0 to N . A caterpillar at leaf 0, jumps from leaf to leaf in multiples of j(j,2j,3j like this) ,j is specific to the caterpillar,until it reaches the end . On whichever leaf it jumps it eats a little bit . You have to find out how many leaves ,from 1 to N, are left uneaten after K caterpillars have reached the end,each with their own jump factor (j).All the caterpillars begin at leaf 0.
//
//Input:The first line consists of a integer T denoting the number of testcases.Each test case consists of two lines first line consists of two integers N which denotes the number of leaves and K denotes the number of caterpillars.Second line of each test case consists of K space seperated integers denoting the jumping factor of caterpillars.
//
//
//Output:The output of each test case contains a single integer denoting the number of uneaten leaves in new line.
//Constraints:
//
//1<=T<=100
//
//1<=N,K,jumping factors of caterpillars<=1000
//Example:
//
//Input:
//
//1
//
//10 3
//
//2 3 5
//
//Output:
//
//2
//
//Explanation:
//
//those  leaves eaten by the first caterpillar are (2,4,6,8,10)
//those eaten by the second one are (3,6,9)
//those by the 3rd one (5,10)
//
//so the uneaten leaves are 1,7 and their number is 2
#include <stdio.h>
int main() {
    FILE* input;
    input = fopen("input.txt","r");
    FILE* output;
    output = fopen("output.txt", "w");
    int num_cases;
    fscanf(input, "%d", &num_cases);
    int num_leaves, num_caterpillars;
    while(num_cases>0){
        num_cases--;
        fscanf(input, "%d", &num_leaves);
        fscanf(input, "%d", &num_caterpillars);
        int caterpillars[num_caterpillars];
        for (int counter=0; counter <num_caterpillars; counter++){
            fscanf(input, "%d", &caterpillars[counter]);
        }
        int leaves = 0;
        for (int index =0; index < num_leaves; index++){
            int eaten = 0;
            for (int counter =0; counter < num_caterpillars; counter++){
                if (index%caterpillars[counter] ==0){
                    eaten = 1;
                    break;
                }
            }
            if (!eaten){
                leaves++;
            }

        }
            fprintf(output,"%d\n", leaves);
    }
    return 0;

}
