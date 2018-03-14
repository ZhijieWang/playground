//Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

//Input Format
//
//A single line of five space-separated integers.
//
//Constraints
//
//Each integer is in the inclusive range .
//Output Format
//
//Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)
//
//Sample Input
//
//1 2 3 4 5
//Sample Output
//
//10 14
package main

import "fmt"

func main() {
	var min, max, hold, sum uint64
	min, max, hold, sum = 0, 0, 0, 0
	fmt.Scanf("%v", &min)
	max = min
	sum += min
	for i := 1; i < 5; i++ {
		fmt.Scanf("%v", &hold)
		if hold < min {
			min = hold
		}
		if hold > max {
			max = hold
		}
		sum += hold
	}
	fmt.Println(sum-max, sum-min)
}
