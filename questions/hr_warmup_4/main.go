//Colleen is having a birthday! She will have a cake with one candle for each year of her age. When she blows out the candles, she’ll only be able to blow out the tallest ones.
//
//Find and print the number of candles she can successfully blow out.
//
//Input Format
//
//integer
//
//Colleen's age
// space-separated integers
//
//candle heights
//Output Format
//
//Print the number of candles Colleen blows out.
//
//Sample Input 0
//
//4
//3 2 1 3
//Sample Output 0
//
//2
//Explanation 0
//
//The maximum candle height is 3 and there are two candles of that height.package main

package main

import "fmt"

func main() {
	var n int
	fmt.Scanf("%v\n", &n)
	var hold int
	var max int
	m := make(map[int]int)
	for i := 0; i < n; i++ {
		fmt.Scanf("%v", &hold)
		if hold > max {
			max = hold
		}
		if val, ok := m[hold]; ok {
			m[hold] = val + 1
		} else {
			m[hold] = 1
		}
	}
	fmt.Println(m[max])
}
