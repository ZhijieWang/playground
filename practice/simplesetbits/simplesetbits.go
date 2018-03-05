package main

import (
	"fmt"
)

func main() {
	//fmt.Println("Please enter some value\n")
	//reader := bufio.NewReader(os.Stdin)
	//result, err := reader.ReadString('\n')
	//if err != nil {
	//	fmt.Println("Something wrong %s", err)
	//}
	//fmt.Println(result)
	//fmt.Println("End of program \n")
	fmt.Println(setBit(4))
}
func setBit(a int) int {
	fmt.Println(a >> 1)
	b := a >> 1
	fmt.Println(b)
	fmt.Println(b >> 1)
	return 0

}
