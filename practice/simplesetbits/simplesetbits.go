package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	fmt.Println("Please enter some value\n")
	reader := bufio.NewReader(os.Stdin)
	result, err := reader.ReadString('\n')
	if err != nil {
		fmt.Println("Something wrong %s", err)
	}
	fmt.Println(result)
	fmt.Println("End of program \n")
}
