//Given an array of distinct integers, print all the pairs having positive value and negative value of a number that exists in the array.

//NOTE: If there is no such pair in the array , print "0".

//Input:
//The first line consists of an integer T i.e number of test cases. The first line of each test case consists of an integer n.The next line of each test case consists of n spaced integers.
//
//Output:
//Print all the required pairs in the increasing order of their absolute numbers.
//
//Constraints: 
//1<=T<=100
//1<=n<=1000
//-1000<=a[i]<=1000
//
//Example:
//Input:
//2
//6
//1 -3 2 3 6 -1
//8
//4 8 9 -4 1 -1 -8 -9
//
//Output:
//-1 1 -3 3 
//-1 1 -4 4 -8 8 -9 9
#include <stdio.h>
#include <unordered_map>
#include <vector>
#include <algorithm>
struct entry {
int positive;
int negative;
};
int main() {
    FILE* input, *output;
    std::unordered_map<int, entry> mapper;
    std::vector<int> v;
    input = fopen("input.txt", "r");
    output = fopen("output.txt", "w");
    int num_cases, num_elements;
    fscanf(input,"%d", &num_cases);
    while(num_cases >0){
        num_cases--;
        fscanf(input, "%d", &num_elements);
        mapper.clear();
        v.clear();
        int i;
        int val;
        for( i = 0; i < num_elements; i++){
            fscanf(input, "%d", &val);
            if (val > 0){
                if (mapper.find(val) ==mapper.end()){
                    printf("Adding Value %d", val);
                    entry e = {val, NULL};
                    mapper[val] = e;
                }else{
                    mapper[val].positive = val;
                }
            }else{
                if (mapper.find(-val) ==mapper.end()){
                    printf("Adding Value %d", val);
                    entry e = {NULL, val};
                    mapper[-val] =e; 
                }else{
                    mapper[-val].negative = val;
                }
            }
        }
        printf("Mapper Size %d\n",mapper.size());
        for (auto iter = mapper.begin(); iter!=mapper.end(); iter++){
            if ((iter->second.positive != NULL ) and (iter->second.negative !=NULL)){
                v.push_back(iter->first);
            }
        }
        std::sort(v.begin(), v.end());
        printf("Vector Size %d\n", v.size());
        auto iter = v.begin();
        fprintf(output, "%d %d", -*iter, *iter);
        for (iter = ++v.begin(); iter!= v.end(); iter++){
            fprintf(output, " %d %d", -*iter, *iter);
            
        }
        fprintf(output,"\n");
        printf("\n");
    }
	return 0;
}
