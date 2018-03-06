package main

import (
	"fmt"
)

//Given a positive integer n, count the total number of set bits in binary representation of all numbers from 1 to n.
//
//Examples:
//
//Input: n = 3
//Output:  4
//
//Input: n = 6
//Output: 9
//
//Input: n = 7
//Output: 12
//
//Input: n = 8
//Output: 13
func main() {
	//fmt.Println("Please enter some value\n")
	//reader := bufio.NewReader(os.Stdin)
	//result, err := reader.ReadString('\n')
	//if err != nil {
	//	fmt.Println("Something wrong %s", err)
	//}
	//fmt.Println(result)
	//fmt.Println("End of program \n")
	fmt.Println(setBit(3))
}
func setBit(a int) int {
	switch a {
	case 0:
		return 0
	case 1:
		return 1
	case 2:
		return 2
	default:
		return setBit(a-1) + countBit(a)
	}
}
func countBit(a int) int {
	counter := 0
	for a > 0 {
		counter += a & 1
		a = a >> 1
	}
	return counter
}
