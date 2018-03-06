package main

import (
	"fmt"
	"log"
	"time"
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
func timeTrack(start time.Time, name string) {
	elapsed := time.Since(start)
	log.Printf("%s took %s", name, elapsed)
}
func main() {
	fmt.Println(setBitWrapper(10) == 17)
	fmt.Println(setBitFastWrapper(10) == 17)
}

func setBitFastWrapper(a int) int {
	defer timeTrack(time.Now(), "setBitFast")
	return setBitFast(a)
}
func setBitFast(a int) int {
	switch a {
	case 0:
		return 0
	case 1:
		return 1
	case 2:
		return 2
	default:
		m := uint(leftMostBit(a))
		if a-(1<<m) == 0 {
			//			fmt.Println("stack cakk %i, %i\n", a-1, 1)
			return setBitFast(a-1) + 1
		}
		//		fmt.Printf("stack call %i, %i\n", 1<<m, a-(1<<m))
		return setBitFast(1<<m) + setBit(a-(1<<m)) + a - (1 << m)
	}
	// get result for num bits
	return 0
}
func leftMostBit(a int) int {
	var highestBit int
	for ; a > 1; a = a >> 1 {
		highestBit++
	}
	return highestBit
}
func setBitWrapper(a int) int {
	defer timeTrack(time.Now(), "setBit")
	return setBit(a)
}
func setBit(a int) int {
	start := 1
	counter := 0
	for ; start <= a; start++ {
		if start == 1 {
			counter = counter + 1
		} else {
			counter += countBit(start)
		}
		//fmt.Printf("start is %i, counter is %i \n", start, counter)
	}
	return counter
}
func countBit(a int) int {
	counter := 0
	for a > 0 {
		counter += a & 1
		a = a >> 1
	}
	return counter
}
